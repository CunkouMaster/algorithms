package com.hua.algorithms.systemZcy.class08;

import java.util.Arrays;

public class Code03 {

	// only for no-negative value
	public static void radixSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		radixSort(arr,  maxbits(arr));
	}

	public static int maxbits(int[] arr) {
		int max = Integer.MIN_VALUE;
		for(int val : arr){
			max = Math.max(max,val);
		}
		int res = 0;
		while (max != 0){
			max /= 10;
			res ++;
		}
		return res;
	}

	// arr[L..R]排序  ,  最大值的十进制位数digit
	public static void radixSort(int[] arr, int digit) {

		// 有多少个数准备多少个辅助空间
		int [] help = new int[arr.length];

		for(int count = 0;count < digit;count++){
			// 10个空间
			// count[0] 当前位(d位)是0的数字有多少个
			// count[1] 当前位(d位)是(0和1)的数字有多少个
			// count[2] 当前位(d位)是(0、1和2)的数字有多少个
			// count[i] 当前位(d位)是(0~i)的数字有多少个
			int [] countArr = new int[10];// countArr[0..9]
			for(int i = 0 ;i < arr.length; i++){
				// 103  1   3
				// 209  1   9
				int j = getDigit(arr[i],count);
				countArr[j]++;
			}
			//前缀和
			for(int i = 1; i < 10; i++){
				countArr[i] = countArr[i] + countArr[i - 1];
			}

			for (int i = arr.length - 1; i >= 0; i--) {
				int j = getDigit(arr[i],count);
				help[--countArr[j]] = arr[i];
			}

			for(int i = 0; i < arr.length;i++){
				arr[i] = help[i];
			}
		}
	}

	public static int getDigit(int x, int d) {
		return (x / (int) Math.pow(10,d)) % 10;
	}

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100000;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			radixSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		radixSort(arr);
		printArray(arr);

	}

}
