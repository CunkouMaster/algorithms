package com.hua.algorithms.systemZcy.class01;

/**
 * created By haohua on
 */
public class Code02 {
    /**
     * 在一个有序数组中，找>=某个数最左侧的位置
     */
    public static int nearestIndex(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int index = 0;
        while (left < right){
            int mid = left + ((right - left)>>1);
            if(arr[mid] >= value){
                index = mid;
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }
}
