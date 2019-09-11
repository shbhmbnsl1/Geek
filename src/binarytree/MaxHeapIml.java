package binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxHeapIml {
    public List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));
    int heapSize = list.size();

    public void maxHeapify(int index) {
        int left = (2*index)+1;
        int right = 2*(index+1);
        int size = heapSize;
        int largest;
        if (left<size && list.get(left)>list.get(index))
            largest = left;
        else
            largest = index;
        if (right<size && list.get(largest)<list.get(right))
            largest = right;
        if (largest!=index) {
            int temp = list.get(index);
            list.set(index, list.get(largest));
            list.set(largest, temp);
            maxHeapify(largest);
        }
    }

    public void buildMaxHeap() {
        int size = list.size();
        heapSize = size;
        //System.out.print(size/2);
        for (int i=(size/2)-1; i>=0; i--) {
            maxHeapify(i);
        }
    }

    public int getMaxElement() {
        return list.get(0);
    }

    public int deleteMaxElement() {
        int size = list.size();
        int maxEle = list.get(0);
        list.set(0, list.get(size-1));
        list.remove(size-1);
        heapSize--;
        maxHeapify(0);
        return maxEle;
    }

    public void insertElement(int value) {
        list.add(value);
        heapSize++;
        int size = list.size();
        int parentOfInsertedElement = (size-2)/2;
        for (int i=parentOfInsertedElement; i>=0; i--)
            maxHeapify(i);
    }

    public void heapSort() {
        buildMaxHeap();
        for (int i = list.size()-1; i>0; i--) {
            int temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i, temp);
            heapSize--;
            maxHeapify(0);
        }
    }
}
