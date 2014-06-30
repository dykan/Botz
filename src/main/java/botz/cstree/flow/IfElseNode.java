package botz.cstree.flow;

import java.util.ArrayList;

import botz.cstree.CodeNode;
import botz.cstree.Node;

public class IfElseNode extends CodeNode {

	
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
                strb.append("else ");
            }

            strb.append(this.ifs.get(i).render());
        }

        if (this.elseNode != null) {
            strb.append(this.elseNode.render());
        }

		return null;
	}

	@Override
	public boolean indents() {
		return false;
	}
	

}
