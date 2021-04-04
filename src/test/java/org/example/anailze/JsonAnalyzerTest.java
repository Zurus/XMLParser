package org.example.anailze;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JsonAnalyzerTest {
    private final static String SOURCE_JSON_STRING =
            "{\"root\":{\"nodeB\":{\"nodeD\":\"Node 3\",\"nodeC\":\"Node 2\"},\"nodeA\":\"Node 1\"}}";

    private final static String EXPECTED_JSON =
            "{\"value\":6,\"root\":{\"nodeA\":{\"value\":1},\"nodeB\":{\"nodeD\":{\"value\":3},\"nodeC\":{\"value\":2}}}}";

    private JsonAnalyzer jsonAnalyzer = null;

    @Before
    public void init(){
        jsonAnalyzer = new JsonAnalyzer();
    }

    @Test
    public void testAnalyzer(){
        JSONObject jsonObject = new JSONObject(SOURCE_JSON_STRING);
        Assert.assertEquals(EXPECTED_JSON, jsonAnalyzer.analyze(jsonObject).toString());
    }
}