package com.lyz.algorithm;

/**
 * KMP算法
 *
 * @author liuyunze.lyz
 * @version Kmp.java, v 0.1 2024年08月08日 10:16 liuyunze.lyz
 */
public class Kmp {


    /**
     * 计算模式串的子串的最长前缀后缀匹配长度
     *
     * @param pattern
     * @return
     */
    public int[] computePi(String pattern) {
        int len = pattern.length();
        int[] pi = new int[len];
        pi[0] = 0; // 第一个字符的前缀函数值为0

        int j = 0;
        for (int i = 1; i < len; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        return pi;
    }


    /**
     * KMP算法
     *
     * @param text
     * @param pattern
     */
    public void KMPSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        int[] pi = computePi(pattern); // 预处理模式串，构建部分匹配表

        int j = 0; // 模式串指针
        for (int i = 0; i < n; i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1]; // 通过部分匹配表跳转
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == m) {
                System.out.println("Pattern found at index " + (i - j + 1));
                j = pi[j - 1]; // 继续寻找下一个匹配
            }
        }
    }


    public static void main(String[] args) {
        Kmp kmp = new Kmp();
        String demo1 = "ABCDABD";
        String text = "BBC ABCDAB ABCDABCDABDE";
        kmp.KMPSearch(text, demo1);
//        Arrays.stream(index).forEach(item -> System.out.println("index:" + item));
    }
}
