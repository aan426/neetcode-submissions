/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node headPt = head.next;
        Node newList = new Node(head.val);
        Node newListPt = newList;

        Map<Node, Node> map = new HashMap<>();
        map.put(head, newListPt); //old to new

        while(headPt != null){
            // System.out.println(newListPt.val + " " + headPt.val);
            Node newNode = new Node(headPt.val);
            newListPt.next = newNode;
            newListPt = newListPt.next;
            map.put(headPt, newListPt);
            headPt = headPt.next;
        }

        Node newHeadPt = head;
        Node newNewListPT = newList;

        while(newHeadPt != null){
            Node newListRand = null;
            if(newHeadPt.random != null){
                newListRand = map.get(newHeadPt.random);
            }
            newNewListPT.random = newListRand;
            newHeadPt = newHeadPt.next;
            newNewListPT = newNewListPT.next;
        }
        return newList;
    }
}
