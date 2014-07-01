package botz.cstree.flow;


import botz.cstree.AssignNode;
import botz.cstree.DeclerationNode;
import botz.cstree.NodeContainer;
import botz.cstree.expression.ExpressionNode;

public class ForNode extends NodeContainer{
	
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
