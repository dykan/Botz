package botz.cstree;

public class ParameterNode extends Node{

	String type;
	String name;
	

	public ParameterNode(Node parent, String type, String name) {
		super(parent);
		this.type = type;
		this.name = name;
	}


	@Override
	public String render() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean indents() {
		return false;
	}

}
