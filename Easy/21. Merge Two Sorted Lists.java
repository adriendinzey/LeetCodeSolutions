/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
* Here we essentially examine two nodes at once from each list and always take the smaller one to go into the new list.
* This is done in-place and so the space complexity is O(1) while the time complexity is O(N).
*/

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr=list1;
            if(list1!=null){
                ListNode next;
            if(list2!=null&&list2.val<list1.val){
                curr=list2;
                list2=list2.next;   
                curr.next=list1;
                next=list1;
                list1=curr;
            }
            else{
                next=list1.next;
            }
            while(next!=null&&list2!=null){
                if(list2.val<next.val){     
                    ListNode temp=list2;
                    list2=list2.next;   
                    temp.next=next;  
                    curr.next=temp;
                    curr=temp;
                }
                else{
                    curr=next;
                    next=next.next;
                }
            }
            if(list2!=null){
                curr.next=list2;
            }
            return list1;
        }
        else{
            return list2;
        }
    }
}
