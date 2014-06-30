package botz.cstree.flow;

import java.util.ArrayList;

import botz.cstree.CodeNode;
import botz.cstree.Node;
import botz.cstree.expression.ExpressionNode;

public class WhileNode extends CodeNode{

	
	public WhileNode(Node parent, ExpressionNode whileExpression, ArrayList<CodeNode> code) {
		super();
		this.setParent(parent);
		this.whileExpression = whileExpression;
		this.code = code;
	}

	ExpressionNode whileExpression;
	ArrayList<CodeNode> code;
	
	@Override
	public String render() {
		StringBuilder stbd = new StringBuilder();
		stbd.append(this.indent("while("));
		stbd.append(whileExpression.render());
		stbd.append(")\n");
		for(CodeNode codeLine:code){
			stbd.append(codeLine.render());
		}
		stbd.append("\n");
		return stbd.toString();
	}

	@Override
	public boolean indents() {
		return true;
	}
	


}
