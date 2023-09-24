package com.akira.leetcode.addstrings415;


public class AddStrings {
    public static void launch() {
        AddStrings solution = new AddStrings();
//        String res = solution.addStrings("11", "123");
        String res = solution.addStrings("456", "77");
//        String res = solution.addStrings("0", "0");
        System.out.println(res);
    }


    public String addStrings(String num1, String num2) {
        int progress = 0;
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 < len2) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
            len1 = num1.length();
            len2 = num2.length();
        }
        StringBuilder sBuilder = new StringBuilder();
        while (len2 > 0) {
            int sum = (num1.charAt(len1 - 1) - '0') + (num2.charAt(len2 - 1) - '0') + progress;
            progress = sum / 10;
            sBuilder.append(sum % 10);
            len1--;
            len2--;
        }
        while (len1 > 0) {
            int sum = (num1.charAt(len1 - 1) - '0') + progress;
            progress = sum / 10;
            sBuilder.append(sum % 10);
            len1--;
        }
        if (progress > 0) {
            sBuilder.append(progress);
        }
        return sBuilder.reverse().toString();
    }

    // leetCode official solution
    public String addStringsOfficial(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }
}
