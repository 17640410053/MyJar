package com.bilibili.yl.util;

/**
 * @author bilibili_jiaozhu
 * <p>
 * 排序算法工具类
 */
public class SortUtils {
    /**
     * 直接插入排序
     *
     * @param integers 需要排序的数组
     */
    public Integer[] insertSort(Integer[] integers) {
        int len = integers.length;//单独把数组长度拿出来，提高效率
        int insertNum;//要插入的数
        for (int i = 1; i < len; i++) {//因为第一次不用，所以从1开始
            insertNum = integers[i];
            int j = i - 1;//序列元素个数
            while (j >= 0 && integers[j] > insertNum) {//从后往前循环，将大于insertNum的数向后移动
                integers[j + 1] = integers[j];//元素向后移动
                j--;
            }
            integers[j + 1] = insertNum;//找到位置，插入当前元素
        }
        return integers;
    }

    /**
     * 希尔排序
     *
     * @param integers 需要排序的数组
     */
    public Integer[] sheelSort(Integer[] integers) {
        int len = integers.length;//单独把数组长度拿出来，提高效率
        while (len != 0) {
            len = len / 2;
            for (int i = 0; i < len; i++) {//分组
                for (int j = i + len; j < integers.length; j += len) {//元素从第二个开始
                    int k = j - len;//k为有序序列最后一位的位数
                    int temp = integers[j];//要插入的元素
                    while (k >= 0 && temp < integers[k]) {//从后往前遍历
                        integers[k + len] = integers[k];
                        k -= len;//向后移动len位
                    }
                    integers[k + len] = temp;
                }
            }
        }
        return integers;
    }

    /**
     * 简单选择排序
     *
     * @param integers 需要排序的数组
     */
    public Integer[] selectSort(Integer[] integers) {
        int len = integers.length;
        for (int i = 0; i < len; i++) {//循环次数
            int value = integers[i];
            int position = i;
            for (int j = i + 1; j < len; j++) {//找到最小的值和位置
                if (integers[j] < value) {
                    value = integers[j];
                    position = j;
                }
            }
            integers[position] = integers[i];//进行交换
            integers[i] = value;
        }
        return integers;
    }

    /**
     * 堆排序
     *
     * @param integers 需要排序的数组
     */
    public Integer[] heapSort(Integer[] integers) {
        int len = integers.length;
        //循环建堆
        for (int i = 0; i < len - 1; i++) {
            //建堆
            buildMaxHeap(integers, len - 1 - i);
            //交换堆顶和最后一个元素
            swap(integers, 0, len - 1 - i);
        }
        return integers;
    }

    //交换方法
    private void swap(Integer[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    //对data数组从0到lastIndex建大顶堆
    private void buildMaxHeap(Integer[] data, int lastIndex) {
        //从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            //k保存正在判断的节点
            int k = i;
            //如果当前k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                //k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    //若果右子节点的值较大
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        //biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                //如果k节点的值小于其较大的子节点的值
                if (data[k] < data[biggerIndex]) {
                    //交换他们
                    swap(data, k, biggerIndex);
                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 冒泡排序
     *
     * @param integers 需要排序的数组
     */
    public Integer[] bubbleSort(Integer[] integers) {
        int len = integers.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {//注意第二重循环的条件
                if (integers[j] > integers[j + 1]) {
                    int temp = integers[j];
                    integers[j] = integers[j + 1];
                    integers[j + 1] = temp;
                }
            }
        }
        return integers;
    }

    /**
     * 快速排序
     *
     * @param integers 需要排序的数组
     */
    public Integer[] quickSort(Integer[] integers, int start, int end) {
        if (start < end) {
            int baseNum = integers[start];//选基准值
            int midNum;//记录中间值
            int i = start;
            int j = end;
            do {
                while ((integers[i] < baseNum) && i < end) {
                    i++;
                }
                while ((integers[j] > baseNum) && j > start) {
                    j--;
                }
                if (i <= j) {
                    midNum = integers[i];
                    integers[i] = integers[j];
                    integers[j] = midNum;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j) {
                quickSort(integers, start, j);
            }
            if (end > i) {
                quickSort(integers, i, end);
            }
        }
        return integers;
    }
}
