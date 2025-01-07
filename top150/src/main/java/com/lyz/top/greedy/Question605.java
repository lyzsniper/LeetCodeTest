package com.lyz.top.greedy;

public class Question605 {

//    官方题解
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0; // 用来统计可以种植的花的数量
        int m = flowerbed.length; // 花坛的长度
        int prev = -1; // 上一个已经种植花的位置，初始化为 -1，表示之前没有种花
        for (int i = 0; i < m; i++) { // 遍历花坛中的每个位置
            if (flowerbed[i] == 1) { // 如果当前位置已经种了花
                if (prev < 0) {
                    // 如果之前没有种过花，计算从花坛开始到当前种花位置可以种的花的数量
                    // 因为相邻不能种花，所以可以种的数量是 i/2，这里利用整数除法的向下取整特性
                    count += i / 2;
                } else {
                    // 如果之前种过花，计算从上一个种花位置到当前种花位置可以种的花的数量
                    // 例如，prev 位置种了花，当前 i 位置种了花，它们之间可种花的位置数量是 (i - prev - 2) / 2
                    count += (i - prev - 2) / 2;
                }
                if (count >= n) {
                    // 如果已经统计的可种花数量达到或超过 n，则返回 true
                    return true;
                }
                prev = i; // 更新上一个种花位置
            }
        }
        if (prev < 0) {
            // 如果整个花坛中都没有种过花
            // 计算整个花坛可以种的花的数量，(m + 1) / 2 利用整数除法的向下取整特性
            count += (m + 1) / 2;
        } else {
            // 如果花坛中有种花，但还有空位，计算最后一个种花位置之后可以种的花的数量
            count += (m - prev - 1) / 2;
        }
        return count >= n; // 最终判断可种花数量是否达到或超过 n
    }
//    我的题解
    public boolean canPlaceFlowers_jensen(int[] flowerbed, int n) {
        int len =  flowerbed.length;
        for(int i = 0; i < len ; i++) {
            System.out.println("i:"+i);
            System.out.println("n:"+n);
            System.out.println("flowerbed[i]:"+flowerbed[i]);
            if( flowerbed[i] == 1 ) {
                System.out.println("此处是1，执行i++");
                i++;
            } else if ( i != len - 1 && flowerbed[i] == 0 && flowerbed[i+1] != 1) {
                System.out.println("此处是0，执行i++,N--");
                i++;
                flowerbed[i] = 1;
                n--;
            } else if ( i == len - 1 && flowerbed[i] == 0 ) {
                System.out.println("此处是len - 1，执行,N--");
                flowerbed[i] = 1;
                n--;
            }
        }

        if (len == 1 && flowerbed[len-1] == 0) {
            n--;
        }
        if (n <= 0) {
            return true;
        }
        return false;
    }
}
