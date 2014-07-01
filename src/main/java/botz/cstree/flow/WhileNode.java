package botz.cstree.flow;

import java.util.ArrayList;

import botz.cstree.CodeNode;
import botz.cstree.Node;
import botz.cstree.NodeContainer;
import botz.cstree.expression.ExpressionNode;


public class WhileNode extends NodeContainer{

	public WhileNode(Node parent, ExpressionNode whileExpression) {
		super();
		this.setParent(parent);
		this.whileExpression = whileExpression;
	}

	ExpressionNode whileExpression;
	
	@Override
	public String render() {
		StringBuilder stbd = new StringBuilder();
		stbd.append(this.indent("while "));
		stbd.append(whileExpression.render());
		stbd.append("\n");
		getSon().write(stbd);
		stbd.append("\n");
		return stbd.toString();
	}

	@Override
	public boolean indents() {
		return true;
	}
}
