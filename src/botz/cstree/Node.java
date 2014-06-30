package botz.cstree;

import java.util.ArrayList;

public abstract class Node {
	
	private ArrayList<Node> sons = new ArrayList<Node>();
	private Node parent;
	
	public Node(){	}
	
	public Node(Node parent){
		this.parent = parent;
	}
	
	public void addSon(Node node){
		sons.add(node);
	}
	
	public abstract String renderBeforeAll();
	public abstract String renderAfterAll();
	public abstract String renderBeforeSon(Node son);
	public abstract String renderAfterSon(Node son);

	public void render(){
		renderBeforeAll();
		for (Node son : sons){
			renderBeforeSon(son);
			son.render();
			renderAfterSon(son);
		}
		renderAfterAll();
	}

}
