package botz.cstree;

public class ParameterNode extends Node{

	String type;
	String name;
	boolean isPrivate;
	boolean isStatic;
	

	public ParameterNode(Node parent, String type, String name) {
		super(parent);
		this.type = type;
		this.name = name;
	}
	
	public ParameterNode(Node parent, String type, String name, boolean isPrivate, boolean isStatic) {
		super(parent);
		this.type = type;
		this.name = name;
		this.isPrivate = isPrivate;
		this.isStatic = isStatic;
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
