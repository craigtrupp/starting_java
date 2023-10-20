/* Day 15 - Linked List
A Node class is provided for you in the editor. A Node object has an integer data field, data, and a Node 
instance pointer, next, pointing to another node (i.e.: the next node in the list).

A Node insert function is also declared in your editor. It has two parameters: a pointer, head, pointing to the first node of a linked list, 
and an integer, data, that must be added to the end of the list as a new Node object.

Task
Complete the insert function in your editor so that it creates a new Node (pass data as the Node constructor argument) 
and inserts it at the tail of the linked list referenced by the  parameter. Once the new node is added, 
return the reference to the head node.
*/
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node next;
	Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {

    public static  Node insert(Node head,int data) {
        //Complete this method
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        } else {
            Node tmp = head;
            while(tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = newNode;
        }
        return head;
        
    }

	public static void display(Node head) {
        Node start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }
}