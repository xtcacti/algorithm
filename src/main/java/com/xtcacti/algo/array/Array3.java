package com.xtcacti.algo.array;

/**
 * @ClassName MyTwoArray
 * @Description TODO:2 - 实现一个动态扩容数组 | 类型为int
 * @Author 15735
 * @Date 2021/3/25 22:15
 * @Version 1.0
 */
public class Array3 {
    private int[] data;
    private int capacity;
    private int count;

    public Array3(int capacity) {
        this.data = new int[capacity];
        this.capacity = capacity;
    }

    public boolean insert(int index, int value) {
        if (index < 0) {
            return false;
        }
        if (index == count) {
            resize(capacity * 2);
        }
        for (int i = count - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = value;
        count++;
        return true;
    }

    public boolean delete(int index) {
        if (index < 0 || index >= count) {
            return false;
        }
        for (int i = index + 1; i < count; i++) {
            data[i - 1] = data[i];
        }
        count--;
        return true;
    }

    public int find(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }
        return data[index];
    }

    private void resize(int capacity) {
        int[] newData = new int[capacity];
        for (int i = 0; i < count; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void printAll(){
        for(int i=0;i<count;i++){
            System.out.print(data[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array3 arr = new Array3(2);
        arr.insert(0, 1);
        arr.insert(1, 2);
        arr.insert(2, 3);
        arr.printAll();
    }
}
