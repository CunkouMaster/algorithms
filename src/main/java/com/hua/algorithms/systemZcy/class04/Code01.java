package com.hua.algorithms.systemZcy.class04;

public class Code01 {

	// 递归方法实现
	public static void mergeSort1(int[] arr) {
		if(arr == null || arr.length <= 1){
			return;
		}
		process(arr,0,arr.length-1);

	}

	// 请把arr[L..R]排有序
	// l...r N
	// T(N) = 2 * T(N / 2) + O(N)
	// O(N * logN)
	public static void process(int[] arr, int L, int R) {
		if(L == R){
			return;
		}
		//中点
		int M = L + ((R - L) >> 1 );
		process(arr,L,M);
		process(arr,M + 1,R);
		merge(arr , L , M ,R);
	}

	public static void merge(int[] arr, int L, int M, int R) {
		int[] help = new int[R - L + 1];
		int p1 = L;
		int p2 = M + 1;
		int i = 0;
		while (p1 <= M && p2 <= R) {
			//i++ 返回原来的值，++i 返回加1后的值
			help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= M){
			help[i++] = arr[p1++];
		}
		while (p2 <= R){
			help[i++] = arr[p2++];
		}
		//
		for(int k = 0;k < help.length;k++){
			arr[L + k] = help[k];
		}
	}

	// 非递归方法实现
	public static void mergeSort2(int[] arr) {
		if(arr == null || arr.length <= 1){
			return;
		}
		int N = arr.length;
		// 步长（分组最大数据量）
		int mergeSize = 1;

		//步长小于N
		while (mergeSize < N){
			int L = 0;
			//L < N
			while (L < N){
				int M = L + mergeSize -1;
				if(M >= N -1){
					break;
				}

				int R = M + Math.min(mergeSize,N - M - 1);
				merge(arr,L,M,R);
				L = R + 1;
			}
			mergeSize <<= 1;
		}


	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
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
		int maxValue = 100;
		System.out.println("TEST BEGIN");
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			mergeSort1(arr1);
			mergeSort2(arr2);
			if (!isEqual(arr1, arr2)) {
				System.out.println("ERROR！");
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println("TEST END");
	}

}
