package com.erp.utils;

import org.springframework.util.StringUtils;

public class DataUtils extends StringUtils {

    public static String nvl(String str, String defaultStr) {
        if (isEmpty(str)) {
            return defaultStr;
        }
        return str;
    }

    public static int parseInt(Object str){
        return parseInt(str,0);
    }
    public static int parseInt(Object str, int defaultNo) {
        int result = 0;
        try {
            result = Integer.parseInt(String.valueOf(str));
        } catch (NumberFormatException e) {
            result = defaultNo;
        }
        return result;
    }
    public static long parseLong(Object str){
        return parseLong(str,0);
    }
    public static long parseLong(Object str, long defaultNo) {
        long result = 0;
        try {
            result = Long.parseLong(String.valueOf(str));
        } catch (NumberFormatException e) {
            result = defaultNo;
        }
        return result;
    }

    /**
     *   xss필터
     */
    public static String xssFilter(String value){
        StringBuffer strBuff = new StringBuffer();
        if(isEmpty(value))return "";

        for (int j = 0; j < value.length(); j++) {
            char c = value.charAt(j);
            switch (c) {
            case '<':
                strBuff.append("&lt;");
                break;
            case '>':
                strBuff.append("&gt;");
                break;
            case '&':
                //strBuff.append("&amp;");
                //break;
            case '"':
                strBuff.append("&quot;");
                break;
            case '\'':
                strBuff.append("&apos;");
                break;
            default:
                strBuff.append(c);
                break;
            }
        }
        return strBuff.toString();
    }

    public static String convertCamelCase(String value){
        StringBuilder result = new StringBuilder();
        if(!isEmpty(value)){
            for(String token : value.toLowerCase().split("_")){
                result.append(capitalize(token));
            }
        }

        return uncapitalize(result.toString());
    }
    private static String padding(int repeat, char padChar)
            throws IndexOutOfBoundsException {
        if (repeat < 0) {
            throw new IndexOutOfBoundsException(
                    "Cannot pad a negative amount: " + repeat);
        }
        char[] buf = new char[repeat];
        for (int i = 0; i < buf.length; ++i) {
            buf[i] = padChar;
        }
        return new String(buf);
    }

    public static String rightPad(String str, int size) {
        return rightPad(str, size, ' ');
    }

    public static String rightPad(String str, int size, char padChar) {
        if (str == null) {
            return null;
        }
        int pads = size - str.length();
        if (pads <= 0) {
            return str;
        }
        if (pads > 8192) {
            return rightPad(str, size, String.valueOf(padChar));
        }
        return str.concat(padding(pads, padChar));
    }

    public static String rightPad(String str, int size, String padStr) {
        if (str == null) {
            return null;
        }
        if (isEmpty(padStr)) {
            padStr = " ";
        }
        int padLen = padStr.length();
        int strLen = str.length();
        int pads = size - strLen;
        if (pads <= 0) {
            return str;
        }
        if ((padLen == 1) && (pads <= 8192)) {
            return rightPad(str, size, padStr.charAt(0));
        }

        if (pads == padLen)
            return str.concat(padStr);
        if (pads < padLen) {
            return str.concat(padStr.substring(0, pads));
        }
        char[] padding = new char[pads];
        char[] padChars = padStr.toCharArray();
        for (int i = 0; i < pads; ++i) {
            padding[i] = padChars[(i % padLen)];
        }
        return str.concat(new String(padding));
    }

    public static String leftPad(String str, int size) {
        return leftPad(str, size, ' ');
    }

    public static String leftPad(String str, int size, char padChar) {
        if (str == null) {
            return null;
        }
        int pads = size - str.length();
        if (pads <= 0) {
            return str;
        }
        if (pads > 8192) {
            return leftPad(str, size, String.valueOf(padChar));
        }
        return padding(pads, padChar).concat(str);
    }

    public static String leftPad(String str, int size, String padStr) {
        if (str == null) {
            return null;
        }
        if (isEmpty(padStr)) {
            padStr = " ";
        }
        int padLen = padStr.length();
        int strLen = str.length();
        int pads = size - strLen;
        if (pads <= 0) {
            return str;
        }
        if ((padLen == 1) && (pads <= 8192)) {
            return leftPad(str, size, padStr.charAt(0));
        }

        if (pads == padLen)
            return padStr.concat(str);
        if (pads < padLen) {
            return padStr.substring(0, pads).concat(str);
        }
        char[] padding = new char[pads];
        char[] padChars = padStr.toCharArray();
        for (int i = 0; i < pads; ++i) {
            padding[i] = padChars[(i % padLen)];
        }
        return new String(padding).concat(str);
    }

    public static String substrCd(String cdNo){
        String swapCdNo ="";
        String tempCdNo ="";
        if(cdNo == null || cdNo.length()<10){
            return tempCdNo;
        }
        else{
            swapCdNo = (Integer.parseInt(cdNo.substring(10,cdNo.length())))*(Integer.parseInt(cdNo.substring(10,cdNo.length())))+"123";
            tempCdNo = swapCdNo.substring(0,3);

            return tempCdNo;
        }
    }
}
