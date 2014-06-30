package botz.cstree.flow;

import java.util.ArrayList;

import botz.cstree.BlockContainerNode;
import botz.cstree.Node;

public class IfElseNode extends BlockContainerNode {

	public IfElseNode(Node parent, ArrayList<IfNode> ifs, IfNode elseNode) {

		super();
		this.setParent(parent);
		this.ifs = ifs;
		this.elseNode = elseNode;
	}

	ArrayList<IfNode> ifs;
	IfNode elseNode;

	@Override
	public String render() {
		StringBuilder strb = new StringBuilder();

		for (int i = 0; i < this.ifs.size(); i++) {
			if (i != 0) {
				strb.append("\nelse ");
			}

			strb.append(this.ifs.get(i).render());
		}

		if (this.elseNode != null) {
			strb.append("\n").append(this.elseNode.render());
		}

		return strb.toString();
	}

	@Override
	public boolean indents() {
		return false;
	}
}
