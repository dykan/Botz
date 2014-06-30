package botz.cstree;

import java.util.ArrayList;

public class MethodNode extends Node{

	String methodName;
	String returnType;
	ArrayList<ParameterNode> params;
	ArrayList<CodeNode> body;
	
	
	public MethodNode(Node parent, String methodName, String returnType,
			ArrayList<ParameterNode> params, ArrayList<CodeNode> body) {
		super(parent);
		this.methodName = methodName;
		this.returnType = returnType;
		this.params = params;
		this.body = body;
	}


	@Override
	public String render() {
		return null;// TODO Auto-generated method stub
		
	}
	
	

}
