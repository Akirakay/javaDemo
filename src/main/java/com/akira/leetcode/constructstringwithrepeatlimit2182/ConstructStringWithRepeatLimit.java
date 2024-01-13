package com.akira.leetcode.constructstringwithrepeatlimit2182;

public class ConstructStringWithRepeatLimit {
    public static void launch() {
        ConstructStringWithRepeatLimit solution = new ConstructStringWithRepeatLimit();
        String s = solution.repeatLimitedStringOfficial("aababab", 2);
        System.out.println(s);
    }

    public String repeatLimitedString(String s, int repeatLimit) {
        char[] charArr = s.toCharArray();
        int[] cntArr = new int[26];
        for (char c : charArr) {
            cntArr[c - 'a']++;
        }
        StringBuilder strBuilder = new StringBuilder();
        for (int i = cntArr.length - 1; i >= 0; i--) {
            int cnt = 0;
            if (cntArr[i] > 0) {
                while (cntArr[i] > 0) {
                    if (cnt < repeatLimit) {
                        strBuilder.append((char) ('a' + i));
                        cnt++;
                        cntArr[i]--;
                    } else {
                        Character c = findNextChar(cntArr, i);
                        if (c == null) {
                            break;
                        } else {
                            strBuilder.append(c);
                            cnt = 0;
                            cntArr[c - 'a']--;
                        }
                    }
                }
            }
        }
        return strBuilder.toString();
    }

    private Character findNextChar(int[] cntArr, int i) {
        for (int j = i - 1; j >= 0; j--) {
            if (cntArr[j] > 0) {
                return (char) ('a' + j);
            }
        }
        return null;
    }

    public String repeatLimitedStringUsingTwoPointer(String s, int repeatLimit) {
        int[] counts = new int[26];
        int n = s.length();
        // 录入各字母的频次
        for (int i = 0; i < n; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        StringBuilder res = new StringBuilder();// 用与储存结果
        int maxIndex = 25;
        while(counts[maxIndex] == 0)maxIndex--;
        int secondMaxIndex = maxIndex - 1;
        while(secondMaxIndex >= 0 && counts[secondMaxIndex] == 0)secondMaxIndex--;
        while (maxIndex >= 0) {
            int repeat = Math.min(repeatLimit, counts[maxIndex]);
            counts[maxIndex]-=repeat;
            while(repeat>0){
                res.append((char)('a' + maxIndex));
                repeat--;
            }
            if(secondMaxIndex<0)break;
            if(counts[maxIndex]==0){
                maxIndex=secondMaxIndex;
                secondMaxIndex--;
            }else{
                res.append((char)('a'+secondMaxIndex));
                counts[secondMaxIndex]--;
            }
            while(secondMaxIndex >= 0 && counts[secondMaxIndex] == 0)secondMaxIndex--;

        }
        return res.toString();
    }

    public String repeatLimitedStringOfficial(String s, int repeatLimit) {
        int N = 26;
        int[] count = new int[N];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder ret = new StringBuilder();
        int m = 0;
        for (int i = N - 1, j = N - 2; i >= 0 && j >= 0;) {
            if (count[i] == 0) { // 当前字符已经填完，填入后面的字符，重置 m
                m = 0;
                i--;
            } else if (m < repeatLimit) { // 当前字符未超过限制
                count[i]--;
                ret.append((char)('a' + i));
                m++;
            } else if (j >= i || count[j] == 0) { // 当前字符已经超过限制，查找可填入的其他字符
                j--;
            } else { // 当前字符已经超过限制，填入其他字符，并且重置 m
                count[j]--;
                ret.append((char)('a' + j));
                m = 0;
            }
        }
        return ret.toString();
    }

}
