package substringwithconcatenationofallwords30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @projectName: javaDemo
 * @package: substringwithconcatenationofallwords30
 * @className: SubstringWithConcatenationOfAllWords
 * @author: tzk
 * @description: TODO
 * @date: 2024/9/12 10:57
 * @version: 1.0
 */
public class SubstringWithConcatenationOfAllWords {
    public static void launch() {
        SubstringWithConcatenationOfAllWords solution = new SubstringWithConcatenationOfAllWords();
        List<Integer> list1 = solution.findSubstringOfficial("barfoothefoobarman", new String[]{"foo", "bar"});
//        List<Integer> list2 = solution.findSubstringOfficial("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"});
//        List<Integer> list3 = solution.findSubstringOfficial("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"});
        list1.forEach(System.out::println);
//        list2.forEach(System.out::println);
//        list3.forEach(System.out::println);
    }

    /**
     * 看不懂官解
     * <a href="https://leetcode.cn/problems/substring-with-concatenation-of-all-words/solutions/1616997/chuan-lian-suo-you-dan-ci-de-zi-chuan-by-244a" />
     * @param s
     * @param words
     * @return java.util.List<java.lang.Integer>
     * @author tzk
     * @date 2024/9/12 13:41
     * @description
     */
    public List<Integer> findSubstringOfficial(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        // 长度
        int m = words.length, n = words[0].length(), ls = s.length();
        for (int i = 0; i < n; i++) {
            // 超出匹配串长度
            if (i + m * n > ls) {
                break;
            }
            Map<String, Integer> differ = new HashMap<>();
            for (int j = 0; j < m; j++) {
                String word = s.substring(i + j * n, i + (j + 1) * n);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
            }
            for (int start = i; start < ls - m * n + 1; start += n) {
                if (start != i) {
                    String word = s.substring(start + (m - 1) * n, start + m * n);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    word = s.substring(start - n, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }
                if (differ.isEmpty()) {
                    res.add(start);
                }
            }
        }
        return res;
    }
}
