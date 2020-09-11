package com.example.demo;

import java.util.*;

public class WhichAreIN {
    public static String inArray(String[] array1, String[] array2) {
        ArrayList<String> res = new ArrayList<>();
        for(int i=0;i<array1.length;i++){
            if(isContain(array2, array1[i])){
                res.add(array1[i]);
            }
        }
        return Arrays.toString(res.toArray(new String[res.size()]));
    }

    public static boolean isContain(String[] arr, String wrd){
        for (int i=0; i<arr.length; i++){
            if(arr[i].contains(wrd)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]){
        String[] a1={"arp", "live", "strong"};
        String[] a2={"lively", "alive", "harp", "sharp", "armstrong"};

        //String[] a1={"tarp", "mice", "bull"};
        //String[] a2={"lively", "alive", "harp", "sharp", "armstrong"};

        String a3 = inArray(a1,a2);
        System.out.println(a3);
    }
}
