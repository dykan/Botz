package botz.cstree.flow;

import java.util.ArrayList;

import botz.cstree.AssignNode;
import botz.cstree.CodeNode;
import botz.cstree.DeclerationNode;
import botz.cstree.expression.ExpressionNode;

public class ForNode extends CodeNode{
	
	public ForNode(DeclerationNode firstDeclare, ExpressionNode expression,
			AssignNode step, ArrayList<CodeNode> code) {
		super();
		this.firstDeclare = firstDeclare;
		this.expression = expression;
		this.step = step;
		this.code = code;
	}
	
	DeclerationNode firstDeclare;
	ExpressionNode expression;
	AssignNode step;
	ArrayList<CodeNode> code;
	
	@Override
	public void render(StringBuilder stb) {
		// TODO Auto-generated method stub
		
	}

}
