package com.akira.leetcode.findallanagramsinastring438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.findallanagramsinastring438
 * @className: FindAllAnagramsInAString
 * @author: tzk
 * @description: TODO
 * @date: 2024/9/17 12:36
 * @version: 1.0
 */
public class FindAllAnagramsInAString {

    public static void launch() {
        FindAllAnagramsInAString solution = new FindAllAnagramsInAString();
        List<Integer> ans = solution.findAnagrams("cbaebabacd", "cba");
        ans.forEach(System.out::println);
    }

    /**
     * 滑动窗口
     * 调整窗口中字符的频次来解决
     * <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string/solutions/1123971/zhao-dao-zi-fu-chuan-zhong-suo-you-zi-mu-xzin/?envType=study-plan-v2&envId=top-100-liked" />
     * @param s
     * @param p
     * @return java.util.List<java.lang.Integer>
     * @author tzk
     * @date 2024/9/17 12:56
     * @description
     */
    public List<Integer> findAnagrams(String s, String p) {
        List ans=new ArrayList();

        int sLen=s.length();
        int pLen=p.length();

        if(sLen<pLen){
            return ans;
        }
        //建立两个数组存放字符串中字母出现的词频，并以此作为标准比较
        int [] scount=new int[26];
        int [] pcount=new int[26];

        //当滑动窗口的首位在s[0]处时 （相当于放置滑动窗口进入数组）
        for(int i=0;i<pLen;i++){
            ++scount[s.charAt(i)-'a']; //记录s中前pLen个字母的词频
            ++pcount[p.charAt(i)-'a']; //记录要寻找的字符串中每个字母的词频(只用进行一次来确定)
        }

        //判断放置处是否有异位词     (在放置时只需判断一次)
        if(Arrays.equals(scount,pcount)){
            ans.add(0);
        }

        //开始让窗口进行滑动
        for(int i=0;i<sLen-pLen;i++){ //i是滑动前的首位
            --scount[s.charAt(i) -'a'];       //将滑动前首位的词频删去
            ++scount[s.charAt(i+pLen) -'a'];  //增加滑动后最后一位的词频（以此达到滑动的效果）

            //判断滑动后处，是否有异位词
            if(Arrays.equals(scount,pcount)){
                ans.add(i+1);
            }
        }

        return ans;
    }
}
