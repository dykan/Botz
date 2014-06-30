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
	public void render(StringBuilder stb) {
		// TODO Auto-generated method stub
		
	}
}
