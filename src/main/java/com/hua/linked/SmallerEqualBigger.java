package com.hua.linked;

/**
 * @author huazai
 * @date 2021/5/8 16:12
 */
public class SmallerEqualBigger {

    //将单向链表按某值划分成左边小、中间相等、右边大的形式

    //【简单形式】leetcode【86】
    //给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
    //
    // 你应当 保留 两个分区中每个节点的初始相对位置。
    // 示例 1：
    //输入：head = [1,4,3,2,5,2], x = 3
    //输出：[1,2,2,4,3,5]
    //
    // 示例 2：
    //输入：head = [2,1], x = 2
    //输出：[1,2]

    public static void main(String[] args) {
        ListNode head = new ListNode(7);
        head.next = new ListNode(9);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(5);
        printLinkedList(head);
//        head = listPartitionTwo(head, 5);
        head = listPartition(head, 5);
        printLinkedList(head);

    }

    /**
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前
     * @param head
     * @param pivot
     * @return
     */
    public static ListNode listPartitionTwo(ListNode head, int pivot){
        ListNode sH = null;
        // small head
        ListNode sT = null;
        // small tail
        ListNode mH = null;
        // big head
        ListNode mT = null;
        // big tail

        ListNode next = null;
        // save next node

        //分区链表生成
        while (head != null){
            next = head.next;
            head.next = null;

            if(head.value < pivot){

                if(sH == null){
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }

            } else {

                if(mH == null){
                    mH = head;
                    mT = head;
                } else {
                    mT.next = head;
                    mT = head;
                }

            }
            head = next;
        }

        //拼接三个区域
        // small and equal reconnect
        if (sT != null) {
            // 如果有小于区域
            sT.next = mH;

        }

        return sH != null ? sH : mH;

    }


    /**
     * 将单向链表按某值划分成左边小、中间相等、右边大的形式
     * @param head
     * @param pivot
     * @return
     */
    public static ListNode listPartition(ListNode head, int pivot){
        ListNode sH = null;
        // small head
        ListNode sT = null;
        // small tail
        ListNode eH = null;
        // equal head
        ListNode eT = null;
        // equal tail
        ListNode mH = null;
        // big head
        ListNode mT = null;
        // big tail

        ListNode next = null;
        // save next node

        //分区链表生成
        while (head != null){
            next = head.next;
            head.next = null;

            if(head.value < pivot){

                if(sH == null){
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }

            } else if(head.value == pivot){

                if(eH == null){
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }

            } else {

                if(mH == null){
                    mH = head;
                    mT = head;
                } else {
                    mT.next = head;
                    mT = head;
                }

            }
            head = next;
        }

        //拼接三个区域
        // small and equal reconnect
        if (sT != null) {
            // 如果有小于区域
            sT.next = eH;
            // 下一步，谁去连大于区域的头，谁就变成eT
            eT = (eT == null ? sT : eT);
        }
        // 上面的if，不管跑了没有，et
        // all reconnect
        if (eT != null) {
            // 如果小于区域和等于区域，不是都没有
            eT.next = mH;
        }
        return sH != null ? sH : (eH != null ? eH : mH);

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
