package org.example.anailze;

import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;

public class JsonAnalyzerTest {
    private final static String jsonString =
            "{\"root\":{\"nodeB\":{\"nodeD\":\"Node 3\",\"nodeC\":\"Node 2\"},\"nodeA\":\"Node 1\"}}";

    @Test
    public void testAnalyzer(){
        JsonAnalyzer analyzer = new JsonAnalyzer();
        System.out.println(analyzer.analyze(new JSONObject(jsonString)).toString());
    }
}