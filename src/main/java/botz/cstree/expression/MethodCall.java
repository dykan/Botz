package botz.cstree.expression;

import java.util.ArrayList;

public class MethodCall {
	String functionName;
	ArrayList<ExpressionNode> parameters;
	
	public MethodCall(String functionName, ArrayList<ExpressionNode> parameters) {
		super();
		this.functionName = functionName;
		this.parameters = parameters;
	}
	
	
}
