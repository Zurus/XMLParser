package org.example.anailze;

import org.example.number.NumberFounderUtil;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JsonAnalyzer {
    private static final Logger log = LoggerFactory.getLogger(JsonAnalyzer.class);
    private final NumberFounderUtil numberFounderUtil = new NumberFounderUtil();

    //https://thispointer.com/java-how-to-update-the-value-of-an-existing-key-in-hashmap-put-vs-replace/
    private int getSum(Map<String, Object> jsonMap) {
        int sum = 0;
        //Промежуточная мапа, для чисел
        Map<String,Integer> buffMap = new HashMap<>();
        //----------------------------------------------------------
        Iterator iter = jsonMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry pair = (Map.Entry) iter.next();
            if (pair.getValue() instanceof String) {
                int localVal = numberFounderUtil.findNumberInJsonValue((String)pair.getValue());
                buffMap.put((String)pair.getKey(), localVal);
                sum+=localVal;
            } else {
                sum += getSum((Map<String, Object>) pair.getValue());
            }
        }
        //-----------------------------------------------------------
        //Кладем данные с числами в исходную мапу
        for (String key:buffMap.keySet()){
            int value = buffMap.get(key);
            jsonMap.computeIfPresent(key, (a,b)-> b = new HashMap<String, Integer>(){{
                put("value", value);
            }});
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
