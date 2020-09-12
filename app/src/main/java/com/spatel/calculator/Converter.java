package com.spatel.calculator;

import android.util.Log;

public class Converter {
    public String binaryToDesimal(String binary){
        if(binary.matches("[0|1]+"))
        {
            int len=binary.length()-1,temp;
            long sum=0;
            temp = len;
            while(len >= 0){
                int val = Integer.parseInt(String.valueOf(binary.charAt(len)));
                sum = (long) (sum+(Math.pow(2,temp-len) * val));
                len--;
            }
            Log.d("tg", "binarytodesimal"+String.valueOf(sum));
            return String.valueOf(sum);
        }
        else{
            return "";
        }
    }
    public String hexaToDesimal(String hexa){
        if(hexa.matches("[0-9A-Fa-f]+"))
        {
            int val,ascii_sub;
            int len = hexa.length()-1,temp;
            long sum=0;
            temp = len;
            while(len >= 0){
                char nch = hexa.charAt(len);
                if(nch == 'A' || nch == 'a')val=10;
                else if(nch == 'B' || nch == 'b')val=11;
                else if(nch == 'C' || nch == 'c')val=12;
                else if(nch == 'D' || nch == 'd')val=13;
                else if(nch == 'E' || nch == 'e')val=14;
                else if(nch == 'F' || nch == 'f')val=15;
                else val = Integer.parseInt(Character.toString(nch));
                sum = (sum + ((long)Math.pow(16,temp-len))*val);
                len--;
            }
            Log.d("tg", "hextodesimal"+String.valueOf(sum));
            return String.valueOf(sum);
        }
        else{
            return "";
        }
    }
    public String octelToDesimal(String octel){
        if(octel.matches("[0-7]+"))
        {
            int len=octel.length()-1,temp;
            long sum=0;
            temp = len;
            while(len >= 0){
                int val = Integer.parseInt(String.valueOf(octel.charAt(len)));
                sum = (long) (sum+((Math.pow(8,temp-len) * val)));
                len--;
            }
            Log.d("tg", "octelToDesimal"+String.valueOf(sum));
            return String.valueOf(sum);
        }
        else{
            return "";
        }
    }
    public String desimalToBinary(String desimal){
        if(desimal.matches("[0-9]+"))
        {
            long des = Integer.parseInt(desimal),m;
            long sum=0;
            while(des > 0){
                m = des%2;
                sum =  sum*10 + m;
                des/=2;
            }
            return reverseString(String.valueOf(sum));
        }
        else {
            return "";
        }
    }
    public String desimalToHexa(String desimal){
        if(desimal.matches("[0-9]+"))
        {
            long des = Integer.parseInt(desimal),m;
            int i=0;
            char[] arr = new char[100];
            while(des > 0){
                m = des%16;
                if(m>=10){
                    arr[i] = (char) (m + 55);
                }
                else{
                    arr[i] = (char) (m + 48);
                }
                i++;
                des/=16;
            }
            String hex = String.valueOf(arr);
            return reverseString(hex);
        }
        else {
            return "";
        }
    }
    public String desimalToOctel(String desimal){

        if(desimal.matches("[0-9]+"))
        {
            long des = Integer.parseInt(desimal),m;
            long sum=0;
            while(des > 0){
                m = des%8;
                sum = sum*10 + m;
                des/=8;
            }
            return reverseString(String.valueOf(sum));
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
