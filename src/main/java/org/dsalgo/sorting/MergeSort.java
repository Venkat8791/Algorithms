package org.dsalgo.sorting;

import java.util.Scanner;

public class MergeSort {

    public static void merge(int[] arr,int low,int mid,int high){
//        System.out.println(low + " " + mid + " " + high);
        int n = high-low+1;
        int[] temp = new int[n];

        int i=low,j=mid+1,k=0;
        while(i<=mid && j<=high){
            if(arr[i]<arr[j]){
                temp[k] = arr[i];
                k+=1;
                i+=1;
            }
            else{
                temp[k] = arr[j];
                k+=1;
                j+=1;
            }
        }
        while(i<=mid){
            temp[k] = arr[i];
            k+=1;
            i+=1;
        }
        while(j<=high){
            temp[k] = arr[j];
            k+=1;
            j+=1;
        }
        k=0;
        for(int p=low;p<=high;p++){
            arr[p] = temp[k];
            k+=1;
        }
    }

    public static void mergeSort(int[] arr, int low, int high){
        if(low>=high){
            return;
        }
        int mid = (low+high)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
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
        mergeSort(arr,0,n-1);
        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
//ms(0,3)                 ms(4,7) (low=0, mid=3,high=7)
//ms(0,1) ms(2,3)         ms(4,5) ms(6,7)
