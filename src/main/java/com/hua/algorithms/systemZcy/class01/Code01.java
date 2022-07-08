package com.hua.algorithms.systemZcy.class01;

/**
 * created By haohua on {{date}}
 */
public class Code01 {

    /**
    1) 在一个有序数组中，找某个数是否存在,二分法
     */
    public static boolean exist(int[] sortedArr, int num) {
        if(sortedArr == null || sortedArr.length == 0){
            return false;
        }
        int left = 0;
        int right = sortedArr.length - 1;
        while (left < right){
            int mid = left + ((right - left)>>1);
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return num == sortedArr[left];
    }
}
