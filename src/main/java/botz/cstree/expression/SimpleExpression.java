package botz.cstree.expression;

public class SimpleExpression extends ExpressionNode{
	String simpleExpression;
	
	public SimpleExpression(String simpleExpression) {
		super();
		this.simpleExpression = simpleExpression;
	}

	@Override
	public String render() {
		return this.indent(simpleExpression.replaceFirst("^this\\.", "@"));
	}

	@Override
	public boolean indents() {
		return false;
	}
}
