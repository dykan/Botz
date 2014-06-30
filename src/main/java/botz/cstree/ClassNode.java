package botz.cstree;

import java.util.ArrayList;

public class ClassNode extends Node{

	private ArrayList<MethodNode> methods; 
	private String parentClass;
	private ArrayList<String> interfaces;
	private ArrayList<ParameterNode> privateMembers;
	
	
	
	
	public ClassNode(Node parent, ArrayList<MethodNode> methods,
			String parentClass, ArrayList<String> interfaces,
			ArrayList<ParameterNode> privateMembers) {
		super(parent);
		this.methods = methods;
		this.parentClass = parentClass;
		this.interfaces = interfaces;
		this.privateMembers = privateMembers;
	}

	@Override
	public boolean indents() {
		return true;
	}

	@Override
	public String render() {
		// TODO Auto-generated method stub
		return null;
	}

}
