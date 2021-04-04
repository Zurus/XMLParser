package org.example.parse;

import org.codehaus.jackson.map.ObjectMapper;
import org.example.anailze.JsonAnalyzer;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class XmlToJsonParser {
    private static final Logger log = LoggerFactory.getLogger(XmlToJsonParser.class);
    private final String ERROR_MSG = "{XML parsing ERROR!}";
    private final JsonAnalyzer jsonAnalyzer = new JsonAnalyzer();

    public XmlToJsonParser() {
    }

    public String parseWithFormatting(byte[] xmlData) {
        log.info("parsing with formatting byte {}",xmlData);
        return parseWithFormatting(new String(xmlData));
    }

    public String parseWithFormatting(String xmlString) {
        log.info("parsing with formatting String {}", xmlString);
        JSONObject jsonObject = parse(xmlString);
        jsonObject = jsonAnalyzer.analyze(jsonObject);
        return formatter(jsonObject.toString());
    }

    public JSONObject parse (String xmlString) {
        log.info("parsing {}", xmlString);
        return XML.toJSONObject(xmlString);
    }

    private String formatter(String unformatJsonString) {
        log.info("formatting {}",unformatJsonString);
        ObjectMapper mapper = new ObjectMapper();
        try {
            Object jsonObject = mapper.readValue(unformatJsonString, Object.class);
            String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
            return prettyJson;
        } catch (IOException e) {
            log.error(e.getMessage());
            return ERROR_MSG;
        }
    }
}
