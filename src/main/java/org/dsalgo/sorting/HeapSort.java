package org.dsalgo.sorting;

import java.util.Scanner;

public class HeapSort {
    public static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void shiftDown(int[] arr, int i,int n){
        while(2*i+1 <n){
            int j = 2*i+1;
            //find the index of greatest child
            if(2*i+2 < n && arr[2*i+2]>arr[j]){
                j=2*i+2;
            }
            if(arr[j]<=arr[i]){
                break;
            }
            swap(arr,i,j);
            i=j;
        }
    }
    public static void heapSort(int[] arr,int n){
        //shift down first half of elements forming a max heap
        for(int i=n/2-1;i>=0;i--){
            shiftDown(arr,i,n);
        }
        
//        for(int i=0;i<n;i++){
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();

        //remove max element which is at index 0 and heapify
        for(int i=n-1;i>=0;i--){
            swap(arr,0,i);
            shiftDown(arr,0,i);

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
        heapSort(arr,n);
        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
