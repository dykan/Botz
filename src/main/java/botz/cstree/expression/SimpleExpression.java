package botz.cstree.expression;

public class SimpleExpression extends ExpressionNode{



	String simpleExpression;
	
	public SimpleExpression(String simpleExpression) {
		super();
		this.simpleExpression = simpleExpression;
	}

	@Override
	public String render() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean indents() {
		return false;
	}



}
