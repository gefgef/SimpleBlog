package com.gef.simpleblog;

import java.util.ArrayList;
import java.util.List;


public class Parser {
    
    /**
     * This method returns sum of numbers in String separated with ","
     * If String is empty it returns 0, if no commas - just a number
     * @param numbers String
     * @return sum integer
     */
    public static int parseAndSum(String numbers) {
        if (numbers.isEmpty())
            return 0;
        if (!numbers.contains(","))
            return Integer.valueOf(numbers);
        return sumOf(numbers);
    }
    
    private static int sumOf(String str) {
        int sum = 0;
        List<String> list = new ArrayList<>();
        for (int i=0; i<str.length(); i++) {
            int startIndex = i;
            int endIndex = i;
            for (int j = i; j < str.length(); j++) {
                String s = Character.toString(str.charAt(j));
                if (s.equals(","))
                    break;
                endIndex = j+1;
                i++;
            }
            list.add(str.substring(startIndex, endIndex));
        }
        for (String s : list)
            sum = sum + Integer.parseInt(s);
        return sum;
    }
}
