package com.hua.linked;

import java.util.Stack;

/**
 * @author huazai
 * @date 2021/5/8 14:14
 */
public class IsPalindrome {

    // leetcode【234】
    // 请判断一个链表是否为回文链表。
    //
    // 示例 1:
    //
    // 输入: 1->2
    //输出: false
    //
    // 示例 2:
    //
    // 输入: 1->2->2->1
    //输出: true
    //
    //
    // 进阶：
    //你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

    public static void main(String[] args) {
        ListNode head = null;
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

//        System.out.print(isPalindromeStack(head) + " | ");
//        System.out.print(isPalindromeHalfStack(head) + " | ");
        System.out.print(isPalindrome(head) + " | ");
    }

    /**
     * 快慢指针 + 右侧逆序  need O(1) extra space
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head){

        if(head == null || head.next == null){
            return true;
        }
        //快慢指针找中点
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //while结束得到中点位置slow【偶数为上中点】
        //right part first node
        fast = slow.next;
        // mid.next -> null
        slow.next = null;
        ListNode temp = null;
        //翻转右侧链表
        while (fast != null){
            temp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = temp;
        }

        //分别指向首尾  slow-->尾  fast-->首
        //save last node
        temp = slow;
        //left first node
        fast = head;

        boolean res = true;
        while (slow != null && fast != null){
            if(slow.value != fast.value){
                res = false;
                break;
            }
            // left to mid
            fast = fast.next;
            // right to mid
            slow = slow.next;
        }
        //还原右侧链表
        slow = temp.next;
        temp.next = null;

        while (slow != null){
            fast = slow.next;
            slow.next = temp;
            temp = slow;
            slow = fast;
        }

        printLinkedList(head);
        return res;
    }

    /**
     * 右侧压栈 need n/2 extra space
     * @param head
     * @return
     */
    public static boolean isPalindromeHalfStack(ListNode head) {

        //获取中点【偶数下中点】 -- 快慢指针
        if(head == null || head.next == null){
            return true;
        }
        //链表长度 >= 2时
        ListNode right = head.next;
        ListNode cur = head;
        while (cur.next != null && cur.next.next != null){
            right = right.next;
            cur = cur.next.next;
        }

        //右侧压栈
        Stack<ListNode> stack = new Stack<ListNode>();
        while (right != null){
            stack.push(right);
            right = right.next;
        }

        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }

        return true;
    }



    /**
     * 全部压栈 -- need n extra space
     * @param head
     * @return
     */
    public static boolean isPalindromeStack(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();

        ListNode cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        while (head != null){
            if(head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }

        return true;
    }

    public static void printLinkedList(ListNode node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    /**
     * Node节点
     */
    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode (int v) {
            value = v;
        }
    }

}
