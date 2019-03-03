package com.Java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//输入[1,2,3,4,5,6]
public class _143_Reorder_List_重排链表 {
    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static class Solution {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null)
                return;

            // Find the middle of the list
            ListNode p1 = head;
            ListNode p2 = head;
            while (p2.next != null && p2.next.next != null) {
                p1 = p1.next;
                p2 = p2.next.next;
            }

            // Reverse the half after middle 1->2->3->4->5->6 to 1->2->3->6->5->4
            ListNode preMiddle = p1;
            System.out.println("preMiddle" + preMiddle.val);
            ListNode preCurrent = p1.next;
            System.out.println("preCurrent" + preCurrent.val);
            System.out.println();
            while (preCurrent.next != null) {
                ListNode current = preCurrent.next;
                System.out.println("current" + current.val);
                preCurrent.next = current.next;
                System.out.println("preCurrent" + preCurrent.val);
                try {
                    System.out.println("preCurrent.next" + preCurrent.next.val);
                } catch (NullPointerException e) {
                    System.out.println("NullPointerException");
                }
                current.next = preMiddle.next;
                System.out.println("current" + current.val);
                System.out.println("current.next" + current.next.val);
                preMiddle.next = current;
                System.out.println("preMiddle" + preMiddle.val);
                System.out.println("preMiddle.next" + preMiddle.next.val);
                System.out.println();
                String out = MainClass.listNodeToString(head);
                System.out.println(out);
                System.out.println();
            }

            // Start reorder one by one 1->2->3->6->5->4 to 1->6->2->5->3->4
            p1 = head;
            p2 = preMiddle.next;
            while (p1 != preMiddle) {
                preMiddle.next = p2.next;
                p2.next = p1.next;
                p1.next = p2;
                p1 = p2.next;
                p2 = preMiddle.next;
            }
        }
    }

    public static class MainClass {
        public static int[] stringToIntegerArray(String input) {
            input = input.trim();
            input = input.substring(1, input.length() - 1);
            if (input.length() == 0) {
                return new int[0];
            }

            String[] parts = input.split(",");
            int[] output = new int[parts.length];
            for (int index = 0; index < parts.length; index++) {
                String part = parts[index].trim();
                output[index] = Integer.parseInt(part);
            }
            return output;
        }

        public static ListNode stringToListNode(String input) {
            // Generate array from the input
            int[] nodeValues = stringToIntegerArray(input);

            // Now convert that list into linked list
            ListNode dummyRoot = new ListNode(0);
            ListNode ptr = dummyRoot;
            for (int item : nodeValues) {
                ptr.next = new ListNode(item);
                ptr = ptr.next;
            }
            return dummyRoot.next;
        }

        public static String listNodeToString(ListNode node) {
            if (node == null) {
                return "[]";
            }

            String result = "";
            while (node != null) {
                result += Integer.toString(node.val) + ", ";
                node = node.next;
            }
            return "[" + result.substring(0, result.length() - 2) + "]";
        }

        public static void main(String[] args) throws Exception {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = in.readLine()) != null) {
                ListNode head = stringToListNode(line);

                new Solution().reorderList(head);
                String out = listNodeToString(head);

                System.out.print(out);
            }
        }
    }
}
