package com.hua.algorithms.systemZcy.class02;

import java.util.HashMap;

/**
 * created By haohua on {{date}}
 */
public class Code01 {
    /**
     * 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这两种数
     */

    public static void main(String[] args) {
        int[] arr = { 1,2,2,3,4,1,3 };

        System.out.println(printOddTimesNum(arr));
        System.out.println(printOddTimesNum2(arr));

    }

    private static int printOddTimesNum2(int[] arr) {
        int num = 0;
        for(int i : arr){
            num ^= i;
        }
        return num;
    }

    private static int printOddTimesNum(int[] arr) {
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
                return key;
            }
        }
        return  -1;
    }


}
