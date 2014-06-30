package botz.cstree.expression;


public class DoubleExpressionNode {

	
	public DoubleExpressionNode(ExpressionNode firstExpression, String action,
			ExpressionNode secondExpression) {
		super();
		FirstExpression = firstExpression;
		this.action = action;
		SecondExpression = secondExpression;
	}
	
	ExpressionNode FirstExpression;
	String action;
	ExpressionNode SecondExpression;
}
