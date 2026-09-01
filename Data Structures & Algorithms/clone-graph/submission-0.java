/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class CloneGraph{
    private Map<Node, Node> oldNodetoNewNode;
    public Node head;
    public CloneGraph(){
        oldNodetoNewNode = new HashMap<>();
        head = new Node();
    }
    public Node dfs(Node ogNode, Node currNode){
        //creating a deep copy of currNode
        //for each node, getting their neighbors
        //add deepcopy of neighbors to currNode arraylist

        if(!deepCopyExists(ogNode)){
            //I have not yet visited this node
            currNode = createDeepCopy(ogNode);
        }
        if(currNode.val == 1){
            head = currNode;
        }
        
        if(ogNodeHasNeighbors(ogNode)){
            for(Node neighbor: ogNode.neighbors){
                if(!deepCopyExists(neighbor)){
                    neighbor = dfs(neighbor, new Node());
                }
                else{
                    neighbor = getDeepCopy(neighbor);
                } 
                currNode.neighbors.add(neighbor);
            }
            //go to each neighbor, create deepy copy if dne
            //add deep copy to currNode
        }

        return currNode;
    }

    //returns true if orignal current node has neighbors
    private boolean ogNodeHasNeighbors(Node ogNode){
        return ogNode.neighbors.size() > 0 ? true : false;
    }

    //returns true if parameter node has a deep copy
    private boolean deepCopyExists(Node node){
        return oldNodetoNewNode.containsKey(node) == true ? true : false;
    }

    //returns the new node created from the old node
    private Node getDeepCopy(Node node){
        return oldNodetoNewNode.get(node);
    }

    //returns a deep copy of the parameter node
    private Node createDeepCopy(Node node){
        Node currNode = new Node(node.val, new ArrayList<>());
        oldNodetoNewNode.put(node, currNode); //nodes are mutable
        return currNode;
    }

    // public Node addNeighbor(Node currNode, Node neighbor){
    //     //
    // }
}

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        CloneGraph deepCopy = new CloneGraph();
        deepCopy.dfs(node, new Node());

        return deepCopy.head;
        // if(node == null){
        //     return node;
        // }
        // Node nodePt = node;
        // Node newHead = dfs(nodePt);

        // System.out.println(node.val);

        // return newHead;
    }

    //public Node dfs(Node currNode){
        // Node deepCopy = new Node(currNode.val);
        // for(Node neighborNode: currNode.neighbors){
        //     deepCopy.neighbors.add(dfs(neighborNode));
        // }

        // return deepCopy;
    //}
}