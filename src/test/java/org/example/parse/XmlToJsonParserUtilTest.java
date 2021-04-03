package org.example.parse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class XmlToJsonParserUtilTest {

    private XmlToJsonParser xmlToJsonParserUtil;

    private static final String EXPECTED_JSON =
        "{\"root\":{\"nodeA\":\"Node 1\"}}";

    private static final String ACTUAL_XML =
            "<root>\n" +
            " <nodeA>Node 1</nodeA>\n" +
            "</root>";

    @Before
    public void init() {
        xmlToJsonParserUtil = new XmlToJsonParser();
    }

    @Test
    public void testParser() {
        String actualJSON = xmlToJsonParserUtil.parse(ACTUAL_XML);
        System.out.println(actualJSON);
        Assert.assertEquals(EXPECTED_JSON, actualJSON);
    }
}