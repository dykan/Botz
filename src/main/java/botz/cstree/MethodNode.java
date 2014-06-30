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
		StringBuilder stdb = new StringBuilder();
		stdb.append(this.indent(methodName + " = (" ));
	
		for (int i=0;i<params.size();i++) {
			stdb.append(params.get(i).name);
			if(i!=params.size()-1){
				stdb.append(",");
			}
		}
		for(ParameterNode param : params){
			stdb.append(param.render());
		}
		return stdb.toString();
	}


	@Override
	public boolean indents() {
		return true;
	}
}
