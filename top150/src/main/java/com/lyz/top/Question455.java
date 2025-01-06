package com.lyz.top;

import java.util.Arrays;

public class Question455 {
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int glen = g.length;
            int slen = s.length;
            int len = glen >= slen ? slen : glen;
            int childrenNum = 0;
            for (int i = 0, j = 0; i < glen && j < slen; i++, j++) {
                while (j < slen && g[i] > s[j]) {
                    j++;
                }
                if (j < slen) {
                    childrenNum++;
                }
            }
            return childrenNum;
        }
    }
}
