package botz.cstree;

import java.util.ArrayList;

public class CoffeScriptRoot extends Node {
	ArrayList<ImportNode> imports = new ArrayList<ImportNode>();
	ClassNode classNode;

	public ClassNode getClassNode() {
		return classNode;
	}

	public void setClassNode(ClassNode classNode) {
		this.classNode = classNode;
	}


	@Override
	public String render() {
		StringBuilder stdb = new StringBuilder();
		for(ImportNode impor : imports){
			stdb.append(impor.render()).append("\n");
		}
		stdb.append("\n");
		
		stdb.append(classNode.render());
		
		stdb.append("\n");
		return stdb.toString();
	}

	@Override
	public boolean indents() {
		return false;
	}

	public void addImport(ImportNode importNode) {
		imports.add(importNode);		
	}
}
