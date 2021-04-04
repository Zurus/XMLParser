package org.example.number;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberFounderUtil {

    private static final Logger log = LoggerFactory.getLogger(NumberFounderUtil.class);

    public static int findNumberInJsonValue(String jsonValue) {
        //log.info("find number in jsonValue {}", jsonValue);
        int sum = 0;
        String[] data = jsonValue.split(" ");
        for (int i = 0; i < data.length ; i++ ) {
            try {
                int num = Integer.parseInt(data[i]);
                sum += num;
            } catch (NumberFormatException e){

            }
        }
        log.info("found number in json Node {} = {}", jsonValue, sum);
        return sum;
    }
}
