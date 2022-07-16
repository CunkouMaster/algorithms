package com.hua.algorithms.systemZcy.class02;

import java.util.HashMap;

/**
 * created By haohua on {{date}}
 */
public class Code03 {
    /**
     * 一个数组中有一种数出现K次，其他数都出现了M次
     */

    public static void main(String[] args) {

        for(int i = 0; i < 32; i++){
            System.out.println((277 >> i) );
            System.out.println((277 >> i) & 1);
            System.out.println("==========");
        }

    }

    public static int km(int[] arr, int k, int m) throws Exception {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
           if(map.containsKey(i)){
               map.put(i,map.get(i) + 1);
           } else {
               map.put(i,1);
           }
        }
        for(Integer key : map.keySet()){
            if(map.get(key) == k){
                return key;
            }
        }
        throw new Exception();
    }

    public static int km2(int[] arr, int k, int m) {
        int[] temp = new int[32];
        for(int num : arr){
            for (int i = 0; i < 32; i++) {
                temp[i] += (num >> i) & 1;
            }
        }
        int ans = 0;
        for(int i=0 ; i<temp.length; i++){
            if(temp[i] % m != 0){
                //则为k
                ans += (1 << i);
            }
        }
        return ans;
    }


}
