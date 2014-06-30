package botz.cstree;

import java.util.ArrayList;

public class CoffeScriptRoot extends Node {
	ArrayList<MethodNode> methods = new ArrayList<MethodNode>();
	ArrayList<ImportNode> imports = new ArrayList<ImportNode>();
	ClassNode classNode;
	
	public void addMethod(MethodNode method){
		methods.add(method);
	}
	
	public ArrayList<MethodNode> getMethods(){
		return methods;
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
}
