package com.hua.linked;

/**
 * @author huazai
 * @date 2021/5/8 14:17
 */
public class MiddleNode {

    //
    // 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
    //
    // 如果有两个中间结点，则返回第二个中间结点。
    //
    // 示例 1：
    //
    //输入：[1,2,3,4,5]
    //输出：此列表中的结点 3 (序列化形式：[3,4,5])
    //返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
    //注意，我们返回了一个 ListNode 类型的对象 ans，这样：
    //ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next =
    //NULL.
    //
    //
    // 示例 2：
    //
    //输入：[1,2,3,4,5,6]
    //输出：此列表中的结点 4 (序列化形式：[4,5,6])
    //由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。

    public static void main(String[] args) {
        ListNode test = null;
        test = new ListNode(0);
        test.next = new ListNode(1);
        test.next.next = new ListNode(2);
        test.next.next.next = new ListNode(3);
        test.next.next.next.next = new ListNode(4);
        test.next.next.next.next.next = new ListNode(5);
        test.next.next.next.next.next.next = new ListNode(6);
        test.next.next.next.next.next.next.next = new ListNode(7);
//        test.next.next.next.next.next.next.next.next = new ListNode(8);

        System.out.println("midOrUpMidNode--" + midOrUpMidNode(test).value);
        System.out.println("midOrDownMidNode--" + midOrDownMidNode(test).value);
        System.out.println("midOrUpMidPreNode--" + midOrUpMidPreNode(test).value);
        System.out.println("midOrDownMidPreNode--" + midOrDownMidPreNode(test).value);
    }

    /**
     * 输入链表头节点，奇数长度返回中点前一个，偶数长度返回下中点前一个
     * @param head
     * @return
     */
    public static ListNode midOrDownMidPreNode(ListNode head) {

        if(head == null || head.next == null){
            return null;
        }

        if(head.next.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /**
     * 输入链表头节点，奇数长度返回中点前一个，偶数长度返回上中点前一个
     * @param head
     * @return
     */
    public static ListNode midOrUpMidPreNode(ListNode head) {

        if(head == null || head.next == null || head.next.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    /**
     * leetcode【876】
     * 输入链表头节点，奇数长度返回中点，偶数长度返回下中点
     * @param head
     * @return
     */
    public static ListNode midOrDownMidNode(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode slow = head.next;
        ListNode fast = head.next;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }



    /**
     * 输入链表头节点，奇数长度返回中点，偶数长度返回上中点
     * @param head
     * @return
     */
    public static ListNode midOrUpMidNode(ListNode head) {

        if(head == null || head.next == null || head.next.next == null){
            return head;
        }

        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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
