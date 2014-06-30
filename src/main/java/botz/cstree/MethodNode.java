package botz.cstree;

import java.util.ArrayList;

import botz.cstree.expression.ExpressionNode;

public class MethodNode extends BlockContainerNode{

    final boolean isStatic;
    String methodName;
	String returnType;
	ArrayList<ParameterNode> params;
	

    public MethodNode(Node parent, String methodName, String returnType, ArrayList<ParameterNode> params) {
        this(parent, methodName, returnType, params, false);
    }

	public MethodNode(Node parent, String methodName, String returnType,
			ArrayList<ParameterNode> params, boolean isStatic) {
		super(parent);
        this.isStatic = isStatic;
		this.methodName = methodName;
		this.returnType = returnType;
		this.params = params;
	}
	

	@Override
	public String render() {
		StringBuilder stdb = new StringBuilder();
		stdb.append(this.indent(getDecleration()));

        stdb.append(appendParameters());

        stdb.append("-> ").append(getMethodBody());

		return stdb.toString();
	}

    private String getDecleration() {
        if (!isStatic) {
            return new StringBuilder(methodName).append(": ").toString();
        } else {
            return new StringBuilder(((ClassNode)getParent()).getName()).append(".").append(this.methodName).append(" = ").toString();
        }
    }

    private String getMethodBody() {
        StringBuilder strb = new StringBuilder();

        for (int i=0; i<getBlock().size(); i++) {
String body = this.getBlock().get(i).render();

strb.append("\n").append(body);
}


        String methodBody = strb.toString();
        if (methodBody.trim().split("\n").length == 1) {
            methodBody = methodBody.trim();
        }
        return methodBody;
    }

    private String appendParameters() {
        StringBuilder stdb = new StringBuilder();

        if (params.size() > 0) {
            stdb.append('(');

            for (int i = 0; i < params.size(); i++) {
                stdb.append(params.get(i).name);

                if (i != params.size() - 1) {
                    stdb.append(", ");
                }
            }

            stdb.append(") ");
        }


        return stdb.toString();
    }


    @Override
	public boolean indents() {
		return true;
	}
}
