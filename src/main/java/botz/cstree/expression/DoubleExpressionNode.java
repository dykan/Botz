package botz.cstree.expression;


public class DoubleExpressionNode extends ExpressionNode{

	
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
	@Override
	public boolean indents() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String render() {
		// TODO Auto-generated method stub
		return null;
	}
}
