package org.dsalgo.sorting;

import java.util.Scanner;

public class QuickSort {
    public static int partition(int[] arr,int l, int r){
        int x = arr[l];
        int k = l;
        for(int i=l;i<=r;i++){
            if(arr[i]<x){
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
                k+=1;
            }
        }
        return k;
    }
    public static void quickSort(int[] arr, int l, int r){
        if(r-l<=1){
            return;
        }
        int p = partition(arr,l,r);
//        System.out.println(p);
        quickSort(arr,l,p);
        quickSort(arr,p+1,r);
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
        quickSort(arr,0,n-1);
        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
