package botz.cstree.flow;

import java.util.ArrayList;

import botz.cstree.BlockContainerNode;
import botz.cstree.CodeNode;
import botz.cstree.Node;
import botz.cstree.expression.ExpressionNode;

public class IfNode extends BlockContainerNode{

	ExpressionNode expression = null;
	
	public IfNode(Node parent, ExpressionNode experssion) {
		super();
        this.setParent(parent);
		this.expression = experssion;
	}

	@Override
	public String render() {
        String body = getBody();

        if (!(this.getParent() instanceof IfElseNode) && body.split("\n").length == 1) {
            return new StringBuilder(body.trim()).append(" ").append(this.getWordWithExpression()).toString();
        }

        return this.indent(new StringBuilder(this.getWordWithExpression()).append("\n").append(this.getBody()).toString());
	}

    private String getBody() {
        StringBuilder strb = new StringBuilder();
        for (int i = 0; i < this.getBlock().size(); i++) {
            strb.append(this.getBlock().get(i).render()).append("\n");
        }
        strb.deleteCharAt(strb.length() - 1);
        return strb.toString();
    }

    private String getWordWithExpression() {
        StringBuilder stringBuilder = new StringBuilder(this.getWord());

        if (this.expression != null) {
            stringBuilder.append(" ").append(this.expression.render());
        }

        return stringBuilder.toString();
    }

    String getWord() {
        if (this.expression == null) {
            return "else";
        } else {
            return "if";
        }
    }

	@Override
	public boolean indents() {
		return true;
	}
}
