package com.xtcacti.algo.linkedlist;

/**
 * @ClassName LinkedList1
 * @Description TODO:1 - 单链表的插入、删除、查找操作 | 存储类型 int
 * @Author 15735
 * @Date 2021/3/26 8:37
 * @Version 1.0
 */
public class LinkedList1 {
    private Node head = null;

    /*
     * 1 - 插入
     * 2 - 插入到头部
     * 3 - 如果头节点为空，则直接把插入节点等于头节点
     * 4 - 如果头节点不为空，则头结点的下一个指向插入节点，再把头节点指向插入节点
     * */

    public void insertToHead(int data) {
        Node newNode = new Node(data, null);
        insertToHead(newNode);
    }

    private void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    /*
     * 1 - 从一个节点的前面插入
     * 2 - 如果插入节点为空，直接返回
     * 3 - 如果插入节点插入到头部，直接调用插入头部的
     * 4 - 如果插入节点插入到中间节点的前面，需要依次往下遍历，直到找到目标节点，再进行插入，若是遍历没找到，则返回
     * 5 - 往下便利的时候，头节点不能动，不然链表就丢失了，所以重新定义一个遍历的节点
     * 6 - 遍历的条件是当前节点不为空，并且它的下一个节点不等于目标节点
     * 7 - 如果遍历完节点，即没有找到目标节点，遍历节点指向为空，返回
     * 8 - 否则的话，就是找到了目标节点，把插入节点的下一个指向目标节点，遍历节点的下一个指向插入节点，就又链起来了
     * */

    public void insertBefore(Node node, int data) {
        Node newNode = new Node(data, null);
        insertBefore(node, newNode);
    }

    private void insertBefore(Node node, Node newNode) {
        if (node == null) {
            return;
        }
        if (head == node) {
            insertToHead(newNode);
            return;
        }
        Node i = head;
        while (i != null && i.next != node) {
            i = i.next;
        }
        if (i == null) {
            return;
        }
        newNode.next = node;
        i.next = newNode;
    }

    /*
     * 1 - 删除 by Node
     * 2 - 如果删除节点为空，或者链表为空也就是头节点为空，则返回，没什么好删除的
     * 3 - 如果删除节点就是头节点，那么头节点指向下一个节点即可
     * 4 - 如果删除节点是头节点后面的节点，则比较后面的节点是否等于删除节点，等于的话，则遍历节点的下一个节点指向下下个节点
     * */

    public void deleteByNode(Node node) {
        if (node == null || head == null) {
            return;
        }
        if (node == head) {
            head = head.next;
        }
        Node i = head;
        while (i != null && i.next != node) {
            i = i.next;
        }
        if (i == null) {
            return;
        }
        i.next = i.next.next;
    }

    /*
     * 1 - 删除 By value
     * 2 - 如果头节点为空，或者说没有该链表，则返回
     * 3 - 否则，新建遍历节点，开始遍历，遍历到下一个节点的值等于给定节点跳出循环，或者遍历节点指向为空跳出循环
     * 4 - 删除节点，即遍历节点的下一个指向下下个节点
     * */

    public void deleteByValue(int value) {
        if (head == null) {
            return;
        }
        Node i = head;
        while (i.next.data != value) {
            i = i.next;
        }
        i.next = i.next.next;
    }

    /*
     * 1 - 查找 By value
     * 2 - 若是head为空，也就是没有该链表，返回
     * 3 - 若是head不为空，则新建遍历节点，遍历到节点的data等于查找节点
     * 4 - 找到，返回遍历节点
     * */

    public Node findByValue(int value){
        Node i = head;
        if(i!=null && i.data!=value){
            i = i.next;
        }
        return  i;
    }

    public Node findByIndex(int index){
        Node i = head;
        int pos = 0;
        while(i!=null && pos!=index){
            pos++;
            i = i.next;
        }
        return i;
    }

    /*
     * 1 - 新建节点
     * */

    public static Node createNode(int data) {
        return new Node(data, null);
    }

    /*
    * 1 - 打印节点
    * 2 - head为空，没有链表，直接返回
    * */

    public void printAll(Node node){
        Node i = head;
        while(i!=null){
            System.out.print(i.data + " ");
            i = i.next;
        }
        System.out.println();
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return this.data;
        }
    }

    public static void main(String[] args) {
        LinkedList1 list = new LinkedList1();
        Node node2 = new Node(2,null);
        Node node4 = new Node(4,null);
        Node node5 = new Node(5,null);
        list.insertToHead(node2);
        list.insertBefore(node2,3);
        list.insertBefore(node2,node4);
        list.insertBefore(node2,node5);
        list.deleteByNode(node5);
        list.deleteByValue(4);
        System.out.println(list.findByValue(2).data);
        list.printAll(list.head);
    }
}
