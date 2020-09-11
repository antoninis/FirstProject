package com.example.demo;

import java.util.*;

public class ExpandedForm {

    public static String Expanded(String[] num)
    {
        try {
            int b = Integer.parseInt(num[0]);
        } catch (NumberFormatException e) {
            return "Неправильный формат Ввода!";
        }
        String[] str = num[0].split("");
        String result = "";

        for(int i = 0; i < str.length-1; i++) {
            if(Integer.valueOf(str[i]) > 0) {
                for(int j = i; j < str.length-1; j++) {
                    str[i] += '0';
                }
            }
        }

        result = Arrays.toString(str);
        //System.out.println(result);
        result = result.substring(1, result.length()-1).replace(",", " +").replace(" + 0","");
        //System.out.println(result);
        return result;
    }


    public static void main(String[] args) {
        String[] a1={"70304"};
        //String[] a1={"arp", "live", "strong"};
        //String[] a2={"lively", "alive", "harp", "sharp", "armstrong"};
        Expanded(a1);
    }
}
