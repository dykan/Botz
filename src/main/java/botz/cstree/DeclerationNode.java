package botz.cstree;

public class DeclerationNode {
	String type;
	public DeclerationNode(String type, String varName, String expressionNode) {
		super();
		this.type = type;
		this.varName = varName;
		ExpressionNode = expressionNode;
	}
	String varName;
	String ExpressionNode;
}
