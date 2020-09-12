package com.spatel.calculator;

import android.util.Log;

import java.math.BigInteger;

public class Converter {
    public String binaryToDesimal(String binary){
        if(binary.matches("[0|1]+"))
        {
            BigInteger b = new BigInteger(binary,2);
            return  b.toString();
        }
        else{
            return "";
        }
    }
    public String hexaToDesimal(String hexa){
        if(hexa.matches("[0-9A-Fa-f]+"))
        {
            BigInteger b = new BigInteger(hexa,16);
            return  b.toString();
        }
        else{
            return "";
        }
    }
    public String octelToDesimal(String octel){
        if(octel.matches("[0-7]+"))
        {
            BigInteger b = new BigInteger(octel,8);
            return  b.toString();
        }
        else{
            return "";
        }
    }
    public String desimalToBinary(String desimal){
        if(desimal.matches("[0-9]+"))
        {
            BigInteger b = new BigInteger(desimal);
            String s = b.toString();
            return  Long.toBinaryString(Long.parseLong(s));
        }
        else {
            return "";
        }
    }
    public String desimalToHexa(String desimal){
        if(desimal.matches("[0-9]+"))
        {
            BigInteger b = new BigInteger(desimal);
            String s = b.toString();
            return  Long.toHexString(Long.parseLong(s));
        }
        else {
            return "";
        }
    }
    public String desimalToOctel(String desimal){

        if(desimal.matches("[0-9]+"))
        {
            BigInteger b = new BigInteger(desimal);
            String s = b.toString();
            return  Long.toOctalString(Long.parseLong(s));
        }
        else {
            return "";
        }
    }

    private String reverseString(String sum) {
        StringBuilder sb = new StringBuilder();
        sb.append(sum);
        sb = sb.reverse();
        return String.valueOf(sb);
    }
}
