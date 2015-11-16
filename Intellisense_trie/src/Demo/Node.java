package Demo;

public class Node {

	int val;
	Node[] children;
	
	public Node()
	{
		val = 0;
		children = new Node[27];
		for(int i = 0; i< 27; i++)
			children[i] = null;
	}
}