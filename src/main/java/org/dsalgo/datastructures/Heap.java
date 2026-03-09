package org.dsalgo.datastructures;

import java.util.ArrayList;
import java.util.List;

//min Heap
public class Heap {
    List<Integer> heap;
    public Heap(){
        heap = new ArrayList<>();
    }

    public int parent(int i){
        return (i - 1) / 2;
    }

    public int leftChild(int i){
        return 2 * i + 1;
    }

    public int rightChild(int i){
        return 2 * i + 2;
    }

    public boolean isEmpty(){
        return heap.isEmpty();
    }

    public int size(){
        return heap.size();
    }

    public void swap(int i,int j){
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public int peek() throws Exception {
        if(heap.isEmpty()){
            throw new Exception("Heap is empty");
        }
        return heap.get(0);
    }

    public void heapifyUp(int index){
        while(index > 0 && heap.get(index) < heap.get(parent(index))){
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public void heapifyDown(int index){
        int n = heap.size();

        while(leftChild(index)<n){
            int j = leftChild(index);
            if(rightChild(index)< n && heap.get(rightChild((index))) < heap.get(j)){
                j = rightChild(index);
            }

            if(heap.get(j) > heap.get(index)){
                break;
            }

            swap(index,j);
            index=j;
        }
    }

    public void insert(int x){
        heap.add(x);
        heapifyUp(heap.size()-1);
    }



    public int extractMin() throws Exception {
        if(heap.isEmpty()){
            throw new Exception("Heap is empty");
        }

        int min = heap.get(0);

        swap(0,heap.size()-1);
        heap.remove(heap.size()-1);

        heapifyDown(0);
        return min;
    }

    public void printHeap() {
        System.out.println(heap);
    }

    public static void main(String[] args) throws Exception{
        Heap minHeap = new Heap();

        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(9);
        minHeap.insert(8);
        minHeap.insert(-1);
        minHeap.insert(2);
        minHeap.insert(20);
        minHeap.insert(-4);
        minHeap.insert(-10);

        minHeap.printHeap(); // Heap structure

        System.out.println("Min: " + minHeap.extractMin()); // -10
        System.out.println("Min: " + minHeap.extractMin()); // -4
        System.out.println("Min: " + minHeap.extractMin()); // -1
        System.out.println("Min: " + minHeap.extractMin()); // 2
        minHeap.printHeap();
    }


}
