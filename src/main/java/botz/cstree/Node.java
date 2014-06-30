package botz.cstree;



public abstract class Node {
	
	private Node parent;

	public Node(Node parent){
		this.parent = parent;
	}
	
	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Node(){	}

	public void write(StringBuilder stdb){
		stdb.append(render());
	}

	public abstract String render();

}
