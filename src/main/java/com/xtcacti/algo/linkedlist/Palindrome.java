package com.xtcacti.algo.linkedlist;

/**
 * @ClassName Palindrome
 * @Description TODO
 * @Author 15735
 * @Date 2021/3/27 11:52
 * @Version 1.0
 */
public class Palindrome {
    public static void main(String[] args) {
        Node a = new Node('a', null);
        Node b = new Node('b', null);
        Node c = new Node('c', null);
        Node d = new Node('d', null);
        Node sc = new Node('c', null);
        Node sb = new Node('b', null);
        Node sa = new Node('a', null);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = sc;
        sc.next = sb;
        sb.next = sa;
        sa.next = null;
        System.out.println(rome(a));
    }

    /*
     * 1 - 判断改链表结构的字符串是否是回文字符串？
     * 2 - 给两个指针，i指针一次跳一格，j指针一次跳两格
     * 3 - 分情况考虑，如果是奇数个什么情况？如果是偶数个什么情况？
     * 4 - 奇数：j最后会跳到最后一个，i正好跳在了中间
     * 5 - 偶数：j跳到了最后一个的下一个，i正好跳到了对称的后半部分的第一个
     * 6 - 不论是奇数还是偶数,情况都是一样的
     * 7 - 反转前半部分链表，依次遍历前半部分的情况和后半部分的情况
     * 8 - 反转链表，需要先标记头结点的下一个节点x，然后将头节点指向新建的result节点，result节点指向头节点，然后头节点指向x，依次遍历
     * */

    public static boolean rome(Node head) {
        if (head == null) {
            return true;
        }
        Node i = head;
        Node j = head;
        Node x = head;
        Node result = null;
        int y = 0;
        int count = 0;
        while (j != null && j.next != null) {
            j = j.next.next;
            i = i.next;
            count++;
        }
        while (y < count) {
            x = head.next;
            head.next = result;
            result = head;
            head = x;
            y++;
        }
        while (x.data == i.data) {
            x = x.next;
            i = i.next;
            count--;
            if (count == 0) {
                return true;
            }
        }
        return false;
    }

    public static class Node {
        private char data;
        private Node next;

        public Node(char data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
