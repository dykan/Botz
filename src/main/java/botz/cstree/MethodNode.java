package botz.cstree;

import java.util.ArrayList;

public class MethodNode extends Node{

	String methodName;
	String returnType;
	ArrayList<ParameterNode> params;
	ArrayList<CodeNode> body;
	
	
	public MethodNode(Node parent, String methodName, String returnType,
			ArrayList<ParameterNode> params, ArrayList<CodeNode> body) {
		super(parent);
		this.methodName = methodName;
		this.returnType = returnType;
		this.params = params;
		this.body = body;
	}


	@Override
	public String render() {
		StringBuilder stdb = new StringBuilder();
		stdb.append(this.indent(methodName)).append(" = ");

        stdb.append(appendParameters());

        stdb.append(" -> ");
		for (int i=0; i<body.size(); i++){
            String render = body.get(i).render();

            if (i == 0 && render.split("\n").length == 1) {
                render = render.trim();
            } else if (i == 0) {
                stdb.append("\n");
            }

            stdb.append(render);
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
