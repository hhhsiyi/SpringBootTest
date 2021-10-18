package com.hewen.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 2021/10/7
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class Sort {
    //排序算法
    @Test
    public void testSort() {
        int N = 20000;
        int[] a = SortTestHelper.generateRandomArray1(N, 0, 10000);
//        int[] a = new int[]{1, 5, 8, 2, 3, 9, 4};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        long start = System.currentTimeMillis();
        //mergeSort(a);
        quickSort(a);
//        Arrays.sort(a);
        long end = System.currentTimeMillis();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println((end - start) + "ms");
    }

    //冒泡排序-两位相比，大的后移 O(n方)
    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    //选择排序 O(n方)
    public void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //相当于遍历一遍去找一个最小值！
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    //插入排序InsertionSort O(n方)
    public void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    //希尔排序(缩小增量排序)相当于增加了步长提高了效率的插入排序
    //希尔排序时间复杂度是 O(n^(1.3-2))接近O(nlogn)
    public void shellSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int step;
        for (step = arr.length / 2; step > 0; step /= 2) {
            for (int i = 0; i < step; i++) {
                for (int j = i; j > 0; j--) {
                    if (arr[j - 1] > arr[j]) {
                        swap(arr, j - 1, j);
                    }
                }
            }
        }
    }

    //归并排序
    //分治法 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    public void mergeSort(int[] arr) {
        mSort(arr);
    }

    public void mSort(int[] arr) {
        int n = arr.length;
        //int[] temp = new int[n];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        mSort(arr, 0, n - 1);

    }

    private void mSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mSort(arr, l, mid);
        mSort(arr, mid + 1, r);
        // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if (arr[mid] > arr[mid + 1])
            merge(arr, l, mid, r);
    }

    private void merge(int[] arr, int l, int mid, int r) {
        int[] aux = Arrays.copyOfRange(arr, l, r + 1);
        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < (aux[j - l])) {  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    // 快速排序
    // 时间复杂度和空间复杂度都是O(nlogn)
    public void quickSort(int[] arr) {
        qSort(arr);
    }

    private void qSort(int[] arr) {
        int n = arr.length;
        qSort(arr, 0, n - 1);
    }

    private void qSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        qSort(arr, l, p - 1);
        qSort(arr, p + 1, r);
    }

    // 如何和把选定的基点数据挪到正确位置上，这是快速排序的核心，我们称为 Partition。
    private int partition(int[] arr, int l, int r) {
        // 随机化快速排序
// 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        int v = arr[l];
        // arr[l+1...j] < v ; arr[j+1...i) > v
        int j = l;
        for (int i = l + 1; i <= r; i++)
            if (arr[i] < v) {
                j++;
                swap(arr, j, i);
            }
        swap(arr, l, j);
        return j;
    }

    //基数排序！
    public void radixSort(int[] arr) {
        int[] T = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] a = {99, 3, 419, 5210};
        int[][] b = new int[10][a.length];
        for (int num : a) {
            //if (num)
        }

    }

    //桶排序
    public void bucketSort(int[] arr) {
        //复杂度分析时间复杂度：O(N + C) 额外空间复杂度：O(N + M)
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
            min = Math.min(min,num);
        }
        //求最大值最小值，接下来算桶的数量
        int bucketNum = (max - min) / arr.length + 1;
        List<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<Integer>());
        }
        // 将每个元素放入桶
        for(int i = 0; i < arr.length; i++){
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }
        // 对每个桶进行排序
        for(int i = 0; i < bucketArr.size(); i++){
            Collections.sort(bucketArr.get(i));
        }
        // 将桶中的元素赋值到原序列
        int index = 0;
        for(int i = 0; i < bucketArr.size(); i++){
            for(int j = 0; j < bucketArr.get(i).size(); j++){
                arr[index++] = bucketArr.get(i).get(j);
            }
        }
    }

    //交换方法
    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
