package botz.cstree;

import java.util.ArrayList;

import botz.cstree.expression.ExpressionNode;

public class MethodNode extends Node{

	String methodName;
	String returnType;
	ArrayList<ParameterNode> params;
	ArrayList<Node> body = new ArrayList<Node>();
	
	
	public MethodNode(Node parent, String methodName, String returnType,
			ArrayList<ParameterNode> params) {
		super(parent);
		this.methodName = methodName;
		this.returnType = returnType;
		this.params = params;
	}
	
	public void addCodeNode(CodeNode code){
		body.add(code);
	}


	@Override
	public String render() {
		StringBuilder stdb = new StringBuilder();
		stdb.append(this.indent(methodName)).append(" = ");

        stdb.append(appendParameters());

        stdb.append(" -> ");
		for (int i=0; i<body.size(); i++){
            String body = this.body.get(i).render();

            if (i == 0 && body.split("\n").length == 1) {
                body = body.trim();
            } else if (i == 0) {
                stdb.append("\n");
            }

            stdb.append(body);
		}	
		
		
		return stdb.toString();
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

            stdb.append(')');
        }


        return stdb.toString();
    }


    @Override
	public boolean indents() {
		return true;
	}
}
