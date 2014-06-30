package botz.cstree;

import java.lang.annotation.Annotation;



public abstract class Node {
	
	private Node parent;

	public abstract boolean indents();
	
	public Node(Node parent){
		this.parent = parent;
	}
	
	
	
	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Node(){	}

	public void write(StringBuilder stdb){
		stdb.append(this.render());
	}
	
	public abstract String render();

	public int getDepth() {
		Node parent = this.getParent();
		
		if (parent == null) {
			return 0;
		} else if (!parent.indents()) {
			return parent.getDepth();
		} else {
			return parent.getDepth() + 1;
		}
	}

    public String indent(String line) {
        return Node.indent(line, getDepth());
    }

    public static String indent(String line, int indent) {
        StringBuilder strb = new StringBuilder(indent + line.length());
        for (int i = 0; i < indent; i++) {
            strb.append("  ");
        }

        return strb.append(line).toString();
    }
}
