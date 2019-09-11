package binarytree;

import java.util.Arrays;
import java.util.List;

public class MinHeapIml {
    List<Integer> list = Arrays.asList(4,5,2,3,6,8,1);

    public void minHeapify(int index) {
        int size = list.size();
        int left = (2*index)+1;
        int right = 2*(index+1);
        int smallest = index;
        if (left<size && list.get(left)<list.get(index))
            smallest = left;
        else
            smallest = index;
        if (right<size && list.get(right)<list.get(smallest))
            smallest = right;
        if (smallest!=index) {
            int temp = list.get(index);
            list.set(index, list.get(smallest));
            list.set(smallest, temp);
            minHeapify(smallest);
        }
    }

    public void buildMinHeap() {
        int size = list.size();
        for (int i = (size/2)-1; i>=0; i--) {
            minHeapify(i);
        }
    }
}
