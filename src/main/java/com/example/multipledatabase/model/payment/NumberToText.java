package com.example.multipledatabase.model.payment;

public class NumberToText {
    public static String toText(String str) {
        String[] word = {"", " một", " hai", " ba", " bốn", " năm", " sáu", " bẩy", " tám", " chín"};
        String[] million = {"", " mươi", " trăm", ""};
        String[] billion = {"", "", "", " nghìn", "", "", " triệu", "", ""};
        String result = "{0}";
        int count = 0;

        char[] chars = str.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (count > 0 && count % 9 == 0)
                result = String.format(result, "{0} tỷ");
            if (!(count < chars.length - 3 && count > 2 && chars[i] == '0' && chars[i - 1] == '0' && chars[i - 2] == '0'))
                result = String.format(result, "{0}" + billion[count % 9]);
            if (chars[i] == '0')
                result = String.format(result, "{0}" + million[count % 3]);
            else if (count % 3 == 1 && count > 1 && !(chars[i - 1] == '0') && !(chars[i + 1] == '0'))
                result = String.format(result, "{0} lẻ");
            var num = Integer.valueOf(chars[i]);
            result = String.format(result, "{0}" + word[num]);
            count++;
        }
        result = result.replace("{0}", "");
        return result.trim();
    }

    public static void main(String[] args) {
        System.out.printf(toText("250000000000"));
    }
}
