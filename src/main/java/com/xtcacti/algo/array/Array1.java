package com.xtcacti.algo.array;

/**
 * @ClassName MyArray
 * @Description TODO:1 - 实现一个大小固定的有序数组、支持动态增删改操作 | 数组类型是int
 * @Author 15735
 * @Date 2021/3/25 21:21
 * @Version 1.0
 */
public class Array1 {
    private int[] data;
    private int capacity;
    private int count;

    public Array1(int capacity){
        this.data = new int[capacity];
        this.capacity = capacity;
        this.count = 0;
    }

    /*1 - value的索引如果小于0 或者 大于数组最大索引，没法加
    * 2 - 数组已经存满了，没法加
    * 3 - 数组有空间,value的index后面的数值依次往后腾一个位置，然后空出来的index位置存值
    * 4 - 有序数组，不考虑替换所在索引，把被替换的值仍在最后
    * 5 - 时间复杂度: O(n)
    * */

    public boolean insert(int index,int value){
        if(index<0 || index>count){
            return false;
        }
        if(count==capacity){
            return false;
        }
        /*移动数组是从最后一个往后移动*/
        for(int i=count-1;i>=index;--i){
            data[i+1]=data[i];
        }
        data[index]=value;
        ++count;
        return true;
    }

    /*
    * 1 - 时间复杂度: O(n)
    * */

    public boolean dalete(int index){
        if(index<0 || index>=count){
            return false;
        }
        /*删除，就是把索引位置值删除，索引后面的值依次往前挪*/
        for(int i=index+1;i<count;i++){
            data[i-1] = data[i];
        }
        --count;
        return true;
    }

    /*
    * 1 - 时间复杂度: O(1)
    * */

    public int find(int index){
        if(index<0 || index>=count){
            return -1;
        }
        return data[index];
    }

    public void printAll(){
        for(int i=0;i<count;i++){
            System.out.print(data[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array1 arr = new Array1(10);
        arr.insert(0,1);
        arr.insert(1,2);
        arr.insert(2,3);
        int i = arr.find(2);
        System.out.println(i);
        arr.dalete(0);
        arr.printAll();
    }
}
