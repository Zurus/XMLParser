package org.example.anailze;

import org.example.number.NumberFounderUtil;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class JsonAnalyzer {
    private static final Logger log = LoggerFactory.getLogger(JsonAnalyzer.class);
    private final NumberFounderUtil numberFounderUtil = new NumberFounderUtil();

    public int getSum(Map<String, Object> jsonMap) {
        int sum = 0;
        for (String key : jsonMap.keySet()) {
            System.out.printf(key);
            if (jsonMap.get(key) instanceof String) {
                int resultSum = numberFounderUtil.findNumberInJsonValue((String)jsonMap.get(key));
                System.out.println(resultSum);
                return resultSum;
            } else {
                sum += getSum((Map<String, Object>) jsonMap.get(key));
            }
        }
        return sum;
    }

    public JSONObject analyze(JSONObject json) {
        log.info("analyze json {}", json);
        Map<String, Object> map = json.toMap();
        map.put("value", getSum(map));
        return new JSONObject(map);
    }
}
