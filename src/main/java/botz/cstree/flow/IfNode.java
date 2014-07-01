package botz.cstree.flow;

import botz.cstree.BlockNode;
import botz.cstree.Node;
import botz.cstree.NodeContainer;
import botz.cstree.expression.ExpressionNode;

public class IfNode extends NodeContainer{

	ExpressionNode expression = null;
	Node elseNode;
	boolean isElseIf = false;
	


	public IfNode(Node parent, ExpressionNode experssion) {
		super();
        this.setParent(parent);
		this.expression = experssion;
	}
	
	public IfNode(Node parent, ExpressionNode experssion, Node elseNode) {
		super();
        this.setParent(parent);
		this.expression = experssion;
		this.elseNode = elseNode;
	}

	@Override
	public String render() {

        StringBuilder stb = new StringBuilder();
        
        
        if (getSon() != null && getSon().canBeShotren() && elseNode == null && !isElseIf()) {
            return stb.append(getSon().render()).append(" ").append(this.getIfExpression()).toString();
          
        } else {
        	if (getSon() != null){
        		
        	stb.append(this.getIfExpression()).append("\n").append(getSon().render(true));
        	if(elseNode != null) stb.append("\n");
        	
        	} if (elseNode != null){	
        		stb.append("else");
        		// handle 'elseif'
        		if (elseNode instanceof IfNode){
        			stb.append(" ");
        		} else {
        			stb.append("\n");
        		}
        		
        		stb.append(elseNode.render(true));
        	}
        }

        return this.indent(stb.toString());
	}


    private String getIfExpression() {
        StringBuilder stringBuilder = new StringBuilder("if");
        stringBuilder.append(" ").append(this.expression.render());

        return stringBuilder.toString();
    }


	public boolean isElseIf() {
		return isElseIf;
	}

	public void isElseIf(boolean isElseIf) {
		this.isElseIf = isElseIf;
	}

	public void setElseNode(Node elseNode) {
		this.elseNode = elseNode;
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
