package botz.cstree.flow;

import java.util.ArrayList;

import botz.cstree.CodeNode;
import botz.cstree.expression.ExpressionNode;

public class IfNode extends CodeNode{

	ExpressionNode experssion;
	ArrayList<CodeNode> body;
	
	public IfNode(ExpressionNode experssion, ArrayList<CodeNode> body) {
		super();
		this.experssion = experssion;
		this.body = body;
	}

	@Override
	public void render(StringBuilder stb) {
		// TODO Auto-generated method stub
		
	}

}
