package org.dsalgo.searching;

import java.util.Scanner;

public class LowerUpperBound {
    //highest ind which is less than key
    private static int lower_bound(int[] arr, int n, int key){
        int low =-1, high = n;
        while(high>low+1){
            int mid = (low+high)/2;
            if(arr[mid]>key){
                high=mid;
            }
            else{
                low=mid;
            }
        }
        return low;
    }

    //lowest ind which is greater than key
    private static int upper_bound(int[] arr, int n, int key){
        int low =-1, high=n;
        while(high>low+1){
            int mid = (low+high)/2;
            if(arr[mid]>=key){
                high=mid;
            }
            else{
                low=mid;
            }
        }
        return high;
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
        System.out.println("Enter the key: ");
        int key = sc.nextInt();
        int lb = lower_bound(arr,n,key);
        if(lb==-1){
            System.out.println("lower bound not found");
        }else{
            System.out.println("lower bound of " + key + " is " + arr[lb]);
        }
        int ub = upper_bound(arr,n,key);
        if(ub==n){
            System.out.println("upper bound not found");
        }else{
            System.out.println("upper bound of " + key + " is " + arr[ub]);
        }
    }
}
