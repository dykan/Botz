package botz.cstree.flow;

import botz.cstree.BlockNode;
import botz.cstree.Node;
import botz.cstree.NodeContainer;
import botz.cstree.expression.ExpressionNode;

public class IfNode extends NodeContainer{

	ExpressionNode expression = null;
	
	public IfNode(Node parent, ExpressionNode experssion) {
		super();
        this.setParent(parent);
		this.expression = experssion;
	}

	@Override
	public String render() {
        String body = getBody();


        if (getSon().canBeShotren()) {
            return new StringBuilder(body.trim()).append(" ").append(this.getWordWithExpression()).toString();
        }

        return this.indent(new StringBuilder(this.getWordWithExpression()).append("\n").append(body).toString());
	}

    private String getBody() {
        StringBuilder strb = new StringBuilder();
        getSon().write(strb);
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
	
	@Override
	public boolean canBeShotren(){
		return false;
	}
}
