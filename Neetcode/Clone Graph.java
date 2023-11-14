/*
// Definition for a Node.
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

class Solution {

    public Node dfs(Node curr, Map<Node, Node> map){

        Node cloned = new Node(curr.val);
        List<Node> neighbours = new ArrayList<>();
        map.put(curr, cloned);

        for(Node it: curr.neighbors){

            if(map.containsKey(it)){
                neighbours.add(map.get(it));
            }

            else{
                neighbours.add(dfs(it, map));
            }
        }

        cloned.neighbors = neighbours;
        return cloned;
    }

    public Node cloneGraph(Node node) {
        
        Map<Node, Node> map = new HashMap<>();

        if(node == null) return null;

        return dfs(node, map);
    }
}
