package com.hua.algorithms.systemZcy.class09;

import com.hua.example.class09.Code04_CopyListWithRandom;

import java.util.HashMap;
import java.util.Map;

// 测试链接 : https://leetcode.com/problems/copy-list-with-random-pointer/
public class Code04 {

	public static class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public static Node copyRandomList1(Node head) {
		// key 老节点
		// value 新节点
		Map<Node,Node> map = new HashMap<>();
		Node cur = head;
		while (cur != null){
			map.put(cur,new Node(cur.val));
			cur = cur.next;
		}
		cur = head;
		while (cur != null){
			map.get(cur).next = map.get(cur.next);
			map.get(cur).random = map.get(cur.random);
			cur = cur.next;
		}
		return map.get(head);
	}

	public static Node copyRandomList2(Node head) {
		if (head == null) {
			return null;
		}
		Node cur = head;
		Node  next = null;
		// 复制node
		while (cur != null){
			next = cur.next;
			cur.next = new Node(cur.val);
			cur.next.next = next;
			cur = next;
		}
		cur = head;
		while (cur != null){
			if(cur.random != null){
				cur.next.random = cur.random.next;
			}
			cur = cur.next.next;
		}
		//
		cur = head;
		// 老 新 混在一起，next方向上，random正确
		// next方向上，把新老链表分离
		Node copy = null;
		Node res = head.next;
		while (cur != null) {
			next = cur.next.next;
			copy = cur.next;
			cur.next = next;
			if(next != null){
				copy.next = next.next;
			}
			cur = next;
		}
		return res;
	}
}
