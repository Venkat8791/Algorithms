package org.dsalgo.sorting;

import java.util.Scanner;

public class InsertionSort {

    public static void insertionSort(int[] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            int j=i;
            while(j>0 && arr[j]<arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j-=1;
            }
        }
    }

    public static void main(String[] args) {
        int n;
        System.out.println("Enter size of array: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        insertionSort(arr);
        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
