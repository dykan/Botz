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
	public String render() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean indents() {
		// TODO Auto-generated method stub
		return true;
	}



}
