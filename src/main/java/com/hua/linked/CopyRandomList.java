package com.hua.linked;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huazai
 * @date 2021/5/9 16:38
 */
public class CopyRandomList {

    //  leetcode【234】
    // 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
    //
    // 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random
    //指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
    //
    // 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random
    //--> y 。
    //
    // 返回复制链表的头节点。

    public static void main(String[] args) {
        Node head = null;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        // 1 -> 6
        head.rand = head.next.next.next.next.next;
        // 2 -> 6
        head.next.rand = head.next.next.next.next.next;
        // 3 -> 5
        head.next.next.rand = head.next.next.next.next;
        // 4 -> 3
        head.next.next.next.rand = head.next.next;
        // 5 -> null
        head.next.next.next.next.rand = null;
        // 6 -> 4
        head.next.next.next.next.next.rand = head.next.next.next;

        printRandLinkedList(head);
        System.out.println("==========");
        //hash copy
        Node res1 = copyListWithRandHash(head);
        printRandLinkedList(res1);
    }

//    public static Node copyListWithRand(Node head){
//
//    }

    public static Node copyListWithRandHash(Node head){
        Map<Node,Node> map = new HashMap<Node, Node>();

        Node cur = head;
        //复制单链表
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            // cur 老
            // map.get(cur) 新
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }


}
