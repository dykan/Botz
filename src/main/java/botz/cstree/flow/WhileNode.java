package botz.cstree.flow;

import java.util.ArrayList;

import botz.cstree.CodeNode;
import botz.cstree.expression.ExpressionNode;

public class WhileNode extends CodeNode{

	
	public WhileNode(ExpressionNode whileExpression, ArrayList<CodeNode> code) {
		super();
		this.whileExpression = whileExpression;
		this.code = code;
	}

	ExpressionNode whileExpression;
	ArrayList<CodeNode> code;
	
	@Override
	public void render(StringBuilder stb) {
		// TODO Auto-generated method stub
		
	}

}