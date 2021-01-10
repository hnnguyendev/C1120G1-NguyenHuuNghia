package ss04_class_and_object.exercise.ex02_xay_dung_lop_stop_watch;

import java.util.Random;

public class StopWatch {

	private Long startTime = System.currentTimeMillis();
	private Long endTime;

	public StopWatch() {
	}

	public Long start() {
		startTime = System.currentTimeMillis();
		return startTime;
	}

	public Long end() {
		endTime = System.currentTimeMillis();
		return endTime;
	}

	public Long getElapsedTime() {
		return end() - startTime;
	}

	public static int[] selectionSort(int[] arr) {
		int minIndex;
		int temp;
		int len = arr.length;

		for (int i = 0; i < len; i++) {
			minIndex = i;
			for (int j = i + 1; j < len; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}

			temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		return arr;
	}

	public static void main(String[] args) {
		StopWatch stopWatch = new StopWatch();
		System.out.println(stopWatch.startTime);

		int[] array = new int[100000];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt();
		}
		selectionSort(array);

		System.out.println(stopWatch.end());
		System.out.println(stopWatch.getElapsedTime());

	}

}
