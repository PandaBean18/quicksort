package com.example.quicksort;
import java.util.Arrays;
public class Quicksort {
    public static void main(String[] args) {
        int[] arr = {20, 7, 14, 6, 19, 2, 5, 8, 3, 10, 17, 13, 12, 9, 11, 15, 16, 4, 1, 18};
        for(int i = 0; i < arr.length; i++) {
            System.out.print(Quicksort.sort(arr)[i] + " ");
        }

    }

    static int[] sort(int[] arr) {
        if(arr.length <= 1) {
            return arr;
        }
        int pivot = arr[0];
        int[] pivotarr = {pivot};
        int i = 0;
        int[] left_side = new int[0];
        int[] right_side = new int[0];
        while(i < arr.length) {
            if(arr[i] < pivot) {
                left_side = Arrays.copyOf(left_side, left_side.length + 1);
                left_side[left_side.length - 1] = arr[i];
            } else if(arr[i] > pivot) {
                right_side = Arrays.copyOf(right_side, right_side.length + 1);
                right_side[right_side.length - 1] = arr[i];
            }
            i++;
        }
        int[] sorted_left = Quicksort.sort(left_side);
        int[] sorted_right = Quicksort.sort(right_side);
        int[] array1 = Quicksort.merge((sorted_left), pivotarr);
        int[] array2 = Quicksort.merge(array1, sorted_right);
        return array2;

    }

    static int[] merge(int[] arr1, int[] arr2) {
        int[] array = new int[arr1.length + arr2.length];
        for(int i = 0; i < arr1.length; i++) {
            array[i] = arr1[i];
        }
        for(int j = 0; j < arr2.length; j++) {
            array[arr1.length + j] = arr2[j];
        }
        return array;
    }
}
