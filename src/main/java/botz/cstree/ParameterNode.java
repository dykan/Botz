package botz.cstree;

public class ParameterNode extends Node{

	String type;
	String name;
	
	@Override
	public void render(StringBuilder stb) {
		// TODO Auto-generated method stub
		
	}

	public ParameterNode(Node parent, String type, String name) {
		super(parent);
		this.type = type;
		this.name = name;
	}

}
