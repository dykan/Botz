package botz.cstree.flow;

import java.util.ArrayList;

import botz.cstree.AssignNode;
import botz.cstree.BlockContainerNode;
import botz.cstree.CodeNode;
import botz.cstree.DeclerationNode;
import botz.cstree.expression.ExpressionNode;

public class ForNode extends BlockContainerNode{
	
	public ForNode(DeclerationNode firstDeclare, ExpressionNode expression,
			AssignNode step) {
		super();
		this.firstDeclare = firstDeclare;
		this.expression = expression;
		this.step = step;
	}
	
	DeclerationNode firstDeclare;
	ExpressionNode expression;
	AssignNode step;
	
	@Override
	public String render() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean indents() {
		
		return true;
	}
	


}
