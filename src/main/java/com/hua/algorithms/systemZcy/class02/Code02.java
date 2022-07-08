package com.hua.algorithms.systemZcy.class02;

import java.util.HashMap;

/**
 * created By haohua on {{date}}
 */
public class Code02 {
    /**
     * 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这两种数
     */

    public static void main(String[] args) {
        int[] arr = { 1,2,2,3,4,3,3,4 };

        printOddTimesNum(arr);
        System.out.println("======================");
        printOddTimesNum2(arr);

    }

    private static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for(int i : arr){
            eor ^= i;
        }
        // 两个数异或值 eor
        // a 和 b是两种数
        // eor != 0
        // eor最右侧的1，提取出来
        // eor :     00110010110111000
        // rightOne :00000000000001000
        // eor & (~eor + 1) == eor & (-eor)
        int right = eor & (~eor + 1);
        // 所有数分为 该位是1 或者 改位是0
        int one = 0;
        for(int i : arr){
            //  i =       111100011110000
            // rightOne=  000000000010000
            if((i & right) != 0){
                one ^= i;
            }
        }
        System.out.println(one + " " + (eor ^ one));


    }

    private static void printOddTimesNum(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            if(map.containsKey(i)){
                map.put(i,map.get(i) ^ 1);
            } else {
                map.put(i,1);
            }
        }
        for(Integer key : map.keySet()){
            if(map.get(key) == 1){
                System.out.println(key);
            }
        }
    }


}
