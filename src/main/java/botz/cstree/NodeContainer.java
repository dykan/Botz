package botz.cstree;


public abstract class NodeContainer extends Node {

	Node son;
	
	public NodeContainer(Node parent){
		super(parent);
	}

	public NodeContainer() {
		// TODO Auto-generated constructor stub
	}

	public Node getSon() {
		return son;
	}

	public void setSon(Node son) {
		this.son = son;
	}
	

}
