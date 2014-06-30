package botz.cstree;

import botz.cstree.expression.ExpressionNode;

public class AssignNode extends CodeNode {
	public AssignNode(String variableName, ExpressionNode value) {
		super();
		this.variableName = variableName;
		this.value = value;
	}

	String variableName;
	ExpressionNode value;

	@Override
	public String render() {
		StringBuilder stdb = new StringBuilder();
		stdb.append(getAssignSentence());
		return stdb.toString();
	}

    private String getAssignSentence() {
        return getComplexVariableName() + " = " + value.render();
    }

    private String getComplexVariableName() {
        return variableName.replace("this.", "@");
    }

    @Override
	public boolean indents() {
		return false;
	}
}
