package botz.cstree;

import java.util.ArrayList;

public class ClassNode extends Node {
    private String name;
	private ArrayList<MethodNode> methods; 
	private String parentClass;
	private ArrayList<String> interfaces;
	private ArrayList<ParameterNode> privateMembers;

	public ClassNode(String name, Node parent, ArrayList<MethodNode> methods,
			String parentClass, ArrayList<String> interfaces,
			ArrayList<ParameterNode> members) {
		super(parent);
        this.name = name;
		this.methods = methods;
		this.parentClass = parentClass;
		this.interfaces = interfaces;
		this.privateMembers = members;
	}

	@Override
	public boolean indents() {
		return true;
	}

	@Override
	public String render() {
        StringBuilder classBuilder = new StringBuilder();
        classBuilder.append(getDeclerationString()).append("\n");
        classBuilder.append(getMethodsDeclerations()).append("\n");

        return classBuilder.toString();
	}

    private String getMethodsDeclerations() {
        StringBuilder strb = new StringBuilder();

        for (MethodNode method : methods) {
            strb.append(method.render()).append("\n\n");
        }

        return strb.toString();
    }

    private String getDeclerationString() {
        StringBuilder lineBuilder = new StringBuilder();
        lineBuilder.append("class ").append(name);

        if (parentClass != null) {
            lineBuilder.append(" extends ").append(parentClass);
        }

        return this.indent(lineBuilder.toString());
    }
}
