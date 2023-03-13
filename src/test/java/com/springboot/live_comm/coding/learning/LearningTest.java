package com.springboot.live_comm.coding.learning;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LearningTest {

    //    插入排序、希尔排序、选择排序、冒泡排序、
    //    归并排序、快速排序、堆排序、基数排序
    @Test
    public void testInsertSort() {
        int[] ints = {6, 8, 3, 5, 67, 7, 7, 54, 4, 32, 8, 5, 6, 7, 5, 2, 3, 2, 2, 0, 2, 69};
        System.out.println(Arrays.toString(insertSort4(new int[]{6, 8, 3, 5, 67, 7, 7, 54, 4, 32, 8, 5, 6, 7, 5, 2, 3, 2, 2, 0, 2, 69})));

        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
//        [0, 2, 2, 2, 3, 3, 4, 5, 5, 5, 6, 6, 7, 7, 8, 8, 32, 32, 54, 54, 67, 69]
    }

    //    插入排序
    public int[] insertSort(int[] req) {
        int[] res = {req[0]};
        for (int i = 1; i < req.length; i++) {
            int num = req[i];
            int[] util = new int[res.length + 1];
            int i2 = 0;
            for (; i2 < res.length; i2++) {
                if (res[i2] < num) {
                    util[i2] = res[i2];
                } else {
                    util[i2] = num;
                    System.arraycopy(res, i2, util, i2 + 1, res.length - i2);
                    break;
                }
            }
            if (i2 == res.length) {
                util[i2] = num;
            }
            res = util;
        }
        return res;
    }

    public int[] insertSort2(int[] req) {
        int[] res = {req[0]};
        for (int i = 1; i < req.length; i++) {

            int[] util = new int[res.length + 1];
            int j = 0;
            for (; j < res.length; j++) {


                if (res[j] >= req[i]) {
                    util[j] = req[i];
                    System.arraycopy(res, j, util, j + 1, res.length - j);
                    break;
                } else {
                    util[j] = res[j];
                }

            }
            if (j == res.length) {
                util[j] = req[i];
            }
            res = util;

        }
        return res;
    }

    public int[] insertSort3(int[] req) {

        for (int i = 1; i < req.length; i++) {
            if (req[i] < req[i - 1]) {
                int num = req[i];
                for (int j = i - 1; j >= 0; j--) {

                    if (num < req[j]) {
                        req[j + 1] = req[j];
                        req[j] = num;
                    } else {
                        break;
                    }

                }

            }

        }
        return req;
    }

    //    插入排序
    public int[] insertSort4(int[] req) {

        for (int i = 1; i < req.length; i++) {
            if (req[i] < req[i - 1]) {
                int num = req[i];
                for (int j = i - 1; j >= 0; j--) {
                    if (num < req[j]) {
                        req[j + 1] = req[j];
                        req[j] = num;
                    } else {
                        break;
                    }
                }

            }
        }

        return req;
    }

    @Test
    public void testShellSort() {
        int[] array = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        int[] array2 = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        int[] ints = shellSort(array);

        System.out.println(Arrays.toString(ints));

        Arrays.sort(array2);
        System.out.println(Arrays.toString(shellSort(array2)));

    }

    //    希尔排序
    public int[] shellSort(int[] array) {
        int q = array.length;
        while (q > 1) {
            q /= 2;
            for (int i = 0; i < q; i++) {
                for (int j = i + q; j < array.length; j = j + q) {
                    if (array[j] < array[j - q]) {
                        int num = array[j];
                        for (int k = j - q; k >= 0; k = k - q) {
                            if (num < array[k]) {
                                array[k + q] = array[k];
                                array[k] = num;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return array;
    }


    //    希尔排序
    public static void main(String[] args) {
        int[] array = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        System.out.println("排序之前：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        //希尔排序
        int gap = array.length;
        while (true) {
            gap /= 2;   //增量每次减半
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < array.length; j += gap) {//这个循环里其实就是一个插入排序
                    int k = j - gap;
                    while (k >= 0 && array[k] > array[k + gap]) {
                        int temp = array[k];
                        array[k] = array[k + gap];
                        array[k + gap] = temp;
                        k -= gap;
                    }
                }
            }
            if (gap == 1)
                break;
        }

        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    @Test
    public void testSelectionSort() {
        int[] array = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        int[] array2 = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        int[] ints = selectionSort(array);
        System.out.println(Arrays.toString(ints));

        Arrays.sort(array2);
        System.out.println(Arrays.toString(array2));
    }

    //    选择排序
    public int[] selectionSort(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            int min = arrays[i];
            int p = i;
            for (int j = i + 1; j < arrays.length; j++) {
                if (arrays[j] < min) {
                    p = j;
                    min = arrays[j];
                }
            }
            if (p != i) {
                arrays[p] = arrays[i];
                arrays[i] = min;
            }

        }
        return arrays;
    }


    @Test
    public void testBubbleSort() {
        int[] array = {2, 38, 1, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        int[] array2 = {2, 38, 1, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        int[] ints = bubbleSort(array);
        System.out.println(Arrays.toString(ints));

        Arrays.sort(array2);
        System.out.println(Arrays.toString(array2));
    }


    //    假冒泡排序
    public int[] bedBubbleSort(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = i + 1; j < arrays.length; j++) {
                if (arrays[i] > arrays[j]) {
                    int num = arrays[i];
                    arrays[i] = arrays[j];
                    arrays[j] = num;
                }
            }
        }
        return arrays;
    }

    //    冒泡排序
    public int[] bubbleSort(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length - i - 1; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    int num = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = num;
                }
            }
        }
        return arrays;
    }


    //    归并排序
//    public int[] margeSort(int[] arrays) {
//        margeSortUtil(0, arrays.length - 1, arrays, arrays.length);
//        return arrays;
//    }
//
//    public void margeSortUtil(int l, int r, int[] arrays, int mid) {
//        mid = mid / 2;
//        if (l >= r) {
//        } else {
//            margeSortUtil(l, l + mid, arrays, mid);
//            margeSortUtil(l + mid + 1, r, arrays, mid);
//            margeSortUtilx(l, r, arrays, mid);
//        }
//    }
//
//    public void margeSortUtilx(int l, int r, int[] arrays, int mid) {
//        int left = l;
//        int right = r;
//        while (true) {
//            if (arrays[l])
//        }
//    }
    @Test
    public void testQuickSort() {
        int[] array = {2, 38, 1, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        int[] array2 = {2, 38, 1, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        int[] ints = quickSort(array);
        System.out.println(Arrays.toString(ints));

        Arrays.sort(array2);
        System.out.println(Arrays.toString(array2));
    }

    //    快排
    public int[] quickSort(int[] arrays) {
        quickSortUtil(arrays, 0, arrays.length - 1);
        return arrays;
    }

    public void quickSortUtil(int[] arrays, int l, int r) {
        if (l < r) {
            int  num = arrays[l];
            for (int i = l; i < arrays.length; i++) {

            }
        }
    }

}