

public class DepthFirstSearchExampleNeighbourList
{ 
 
	public static class Node
	{
		int data;
		boolean visited;
		List<Node> nodes;
 
		public Node(int data)
		{
			this.data=data;
			this.nodes=new List<>();
 
		}
		public void addNode(Node nNode)
		{
			this.nodes.add(nNode);
		}
		public List<Node> getNode() {
			return nodes;
		}
		public void setNodes(List<Node> nodes) {
			this.nodes = nodes;
		}
	}
 
	// Recursive DFS
	public  void dfs(Node node)
	{
		System.out.print(node.data + " ");
		List<Node> nodes=node.getNodes();
        node.visited=true;
		for (int i = 0; i < nodes.size(); i++) {
			Node n=nodes.get(i);
			if(n!=null && !n.visited)
			{
				dfs(n);
			}
		}
	}