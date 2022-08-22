package com.hua.algorithms.systemZcy.class08;

import java.util.Arrays;

public class Code03 {

	// only for no-negative value
	public static void radixSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		radixSort(arr, 0, arr.length - 1, maxbits(arr));
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
	public static void radixSort(int[] arr, int L, int R, int digit) {

		int [] help = new int[R - L + 1];

		for(int count = 0;count < digit;count++){
			int [] countArr = new int[10];
			for(int i = L ;i <= R; i++){
				int j = getDigit(arr[i],count);
				countArr[j]++;
			}
			for(int i = 1; i < 10; i++){
				countArr[i] = countArr[i] + countArr[i - 1];
			}

			for (int i = R; i >= L; i--) {
				int j = getDigit(arr[i],count);
				help[--countArr[j]] = arr[i];
			}

			for(int i = L,j=0;i <= R;i++,j++){
				arr[i] = help[j];
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
