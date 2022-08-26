package com.hua.algorithms.systemZcy.class09;

public class Code03 {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node listPartition1(Node head, int pivot) {
		if (head == null) {
			return head;
		}
		Node cur = head;
		int i = 0;
		while (cur != null){
			i++;
			cur = cur.next;
		}
		Node [] arr = new Node[i];
		i = 0;
		cur = head;
		while (cur != null){
			arr[i++] = cur;
			cur = cur.next;
		}
		arrPartition(arr,pivot);
		for (i = 1; i < arr.length; i++) {
			arr[i - 1].next = arr[i];
		}
		arr[i - 1].next = null;
		return arr[0];

	}

	public static void arrPartition(Node[] nodeArr, int pivot) {
		int small = 0;
		int big = nodeArr.length;
		int index = 0;
		while (index != big) {
			if (nodeArr[index].value < pivot) {
				swap(nodeArr, small++, index++);
			} else if (nodeArr[index].value == pivot) {
				index++;
			} else {
				swap(nodeArr, --big, index);
			}
		}
	}

	public static void swap(Node[] nodeArr, int a, int b) {
		Node tmp = nodeArr[a];
		nodeArr[a] = nodeArr[b];
		nodeArr[b] = tmp;
	}

	public static Node listPartition2(Node head, int pivot) {
		Node sH = null; // small head
		Node sT = null; // small tail
		Node eH = null; // equal head
		Node eT = null; // equal tail
		Node mH = null; // big head
		Node mT = null; // big tail
		Node next = head; // save next node

		while (next != null){
			if(next.value < pivot){
				if(sH == null){
					sH = next;
					sT = next;
				} else {
					sT.next = next;
					sT = next;
				}
			}
			if(next.value == pivot){
				if(eH == null){
					eH = next;
					eT = next;
				} else {
					eT.next = next;
					eT = next;
				}
			}
			if(next.value > pivot){
				if(mH == null){
					mH = next;
					mT = next;
				} else {
					mT.next = next;
					mT = next;
				}
			}
			next = next.next;
		}


		if(sH != null){


		}

		if (eH != null){

		}

		return sH != null ? sH : (eH != null ? eH : mH);
	}

	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head1 = new Node(7);
		head1.next = new Node(9);
		head1.next.next = new Node(1);
		head1.next.next.next = new Node(8);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(2);
		head1.next.next.next.next.next.next = new Node(5);
		printLinkedList(head1);
//		 head1 = listPartition1(head1, 5);
		head1 = listPartition2(head1, 5);
		printLinkedList(head1);

	}

}
