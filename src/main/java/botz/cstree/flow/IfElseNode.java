package botz.cstree.flow;

import java.util.ArrayList;

import botz.cstree.CodeNode;

public class IfElseNode extends CodeNode{

	
	public IfElseNode(ArrayList<IfNode> ifs, IfNode elseNode) {
		super();
		this.ifs = ifs;
		this.elseNode = elseNode;
	}

	ArrayList<IfNode> ifs;
	IfNode elseNode;
	
	@Override
	public String render() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean indents() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
