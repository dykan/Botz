package botz.cstree;

import java.util.ArrayList;

import botz.cstree.expression.ExpressionNode;

public class MethodNode extends Node{

	String methodName;
	String returnType;
	ArrayList<ParameterNode> params;
	ArrayList<Node> body = new ArrayList<Node>();
	
	
	public MethodNode(Node parent, String methodName, String returnType,
			ArrayList<ParameterNode> params) {
		super(parent);
		this.methodName = methodName;
		this.returnType = returnType;
		this.params = params;
	}
	
	public void addCodeNode(CodeNode code){
		body.add(code);
	}


	@Override
	public String render() {
		StringBuilder stdb = new StringBuilder();
		stdb.append(this.indent(methodName + " = (" ));
	
		for (int i=0;i<params.size();i++) {
			stdb.append(params.get(i).name);
			if(i!=params.size()-1){
				stdb.append(",");
			}
		}

		stdb.append(") -> \n");
		for(int i=0;i<body.size();i++){
			stdb.append(body.get(i).render());
		}	
		
		
		return stdb.toString();
	}


	@Override
	public boolean indents() {
		return true;
	}
}
