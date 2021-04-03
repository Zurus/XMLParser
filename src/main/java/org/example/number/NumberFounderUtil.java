package org.example.number;

public class NumberFounderUtil {

    public static int findNumberInJsonValue(String jsonValue) {
        int sum = 0;
        String[] data = jsonValue.split(" ");
        for (int i = 0; i < data.length ; i++ ) {
            try {
                int num = Integer.parseInt(data[i]);
                sum += num;
            } catch (NumberFormatException e){

            }
        }
        return sum;
    }
}
