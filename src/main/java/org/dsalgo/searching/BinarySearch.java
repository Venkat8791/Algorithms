package org.dsalgo.searching;

import java.util.Scanner;

public class BinarySearch {
    private static int binarySearch(int[] arr,int n,int key){
        int low =0, high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==key){
                return mid;
            }
            else if(key>arr[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
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
        System.out.println("Enter the key you want to search: ");
        int key = sc.nextInt();
        int ind = binarySearch(arr,n,key);
        if(ind==-1){
            System.out.println("element not found");
        }
        else{
            System.out.println("element found at index " + ind);
        }
    }
}
