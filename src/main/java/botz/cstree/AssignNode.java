package botz.cstree;

import botz.cstree.expression.ExpressionNode;

public class AssignNode extends Node{
	public AssignNode(String variableName, ExpressionNode value) {
		super();
		this.variableName = variableName;
		this.value = value;
	}
	String variableName;
	ExpressionNode value;
	@Override
	public String render() {
		StringBuilder stdb = new StringBuilder();
	
		return null;
	}
	

}
