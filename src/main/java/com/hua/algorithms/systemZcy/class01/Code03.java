package com.hua.algorithms.systemZcy.class01;

/**
 * created By haohua on
 */
public class Code03 {

    /**
     * 在一个无序数组中, 值有可能正, 负, 或者零, 数组中任由两个相邻的数一定不相等.
     * 定义局部最小:
     * 1.长度为1，arr[0]就是局部最小；
     * 2.数组的开头，如果arr[0] < arr[1] ，arr[0]被定义为局部最小。
     * 3.数组的结尾，如果arr[N-1] < arr[N-2] ，arr[N-1]被定义为局部最小。
     * 任何一个中间位置i, 即数组下标1~N-2之间, 必须满足arr[i-1] < arr[i] <arr[i+1] ,叫找到一个局部最小。
     * 请找到任意一个局部最小并返回。
     */

    public static Integer getLessIndex(int[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }
        if (arr.length == 1 || arr[0] < arr[1]){
            return arr[0];
        }
        if(arr[arr.length-1] < arr[arr.length-2]){
            return arr[arr.length-1];
        }
        int left = 1;
        int right = arr.length - 2;
        while (left < right){
            int mid = left + ((right - left) >> 1 );
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }

        }
        return left;

    }
}
