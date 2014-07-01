package botz.cstree.expression;

import botz.cstree.Node;

public class DoubleExpressionNode extends ExpressionNode {
    ExpressionNode firstExpression;
    String action;
    ExpressionNode secondExpression;

	public DoubleExpressionNode(Node parent, ExpressionNode firstExpression, String action, ExpressionNode secondExpression) {
		super();
		this.firstExpression = firstExpression;
		this.action = action;
		this.secondExpression = secondExpression;
	}

    @Override
    public boolean indents() {
        return false;
    }

    @Override
    public String render() {
        return new StringBuilder("(").append(this.firstExpression.render())
                .append(" ").append(this.action).append(" ")
                .append(this.secondExpression.render()).append(")").toString();
    }
}
