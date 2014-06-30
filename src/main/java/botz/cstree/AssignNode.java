package botz.cstree;

import botz.cstree.expression.ExpressionNode;

public class AssignNode {
	public AssignNode(String variableName, ExpressionNode value) {
		super();
		this.variableName = variableName;
		this.value = value;
	}
	String variableName;
	ExpressionNode value;
}
