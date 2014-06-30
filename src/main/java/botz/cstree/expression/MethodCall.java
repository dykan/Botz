package botz.cstree.expression;

import java.util.ArrayList;

import botz.cstree.CodeNode;
import botz.cstree.Node;

public class MethodCall extends CodeNode{
	String functionName;
	ArrayList<ExpressionNode> parameters;
	
	public MethodCall(Node parent, String functionName, ArrayList<ExpressionNode> parameters) {
		super();
		this.setParent(parent);
		this.functionName = functionName;
		this.parameters = parameters;
	}

	@Override
	public boolean indents() {
		
		return false;
	}

	@Override
	public String render() {
		StringBuilder stbd = new StringBuilder();
		stbd.append(this.indent(functionName) + "( ");
		for(int i=0; i<parameters.size();i++){
			stbd.append(parameters.get(i).render());
			if(i!=parameters.size()-1){
				stbd.append(",");
			}
		}
		stbd.append(" )\n");
		
		return stbd.toString();
	}
	
	
	
	
}
