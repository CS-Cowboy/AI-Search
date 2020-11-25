

public class BreadthFirstSearchExampleNeighbourList
{
	private Queue<Node> queue;
	static ArrayList<Node> nodes=new ArrayList<Node>();
	static class Node
	{
		//lETS NOT CREATE OUR OWN DATASTRUCTURES FOR SIMPLICITY!!
		int data;
		boolean visited;
		List<Node> nodes;
 
		public Node(int data)
		{
			this.data=data;
			this.nodes=new ArrayList<>();
 
		}
		public void addNodes(Node Node)
		{
			this.nodes.add(Node);
		}
		public List<Node> getNodes() {
			return nodes;
		}
		public void setNodes(List<Node> nodes) {
			this.nodes = nodes;
		}
	}
 
	public BreadthFirstSearch()
	{
		queue = new LinkedList<Node>();
	}
 
	public void bfs(Node node)
	{
		queue.add(node);
		node.visited=true;
		while (!queue.isEmpty())
		{
 
			Node element=queue.remove();
			System.out.print(element.data + "t");
			List<Node> nodes=element.getNodes();
			for (int i = 0; i < nodes.size(); i++) {
				Node n=nodes.get(i);
				if(n!=null && !n.visited)
				{
					queue.add(n);
					n.visited=true;
 
				}
			}
 
		}
	}