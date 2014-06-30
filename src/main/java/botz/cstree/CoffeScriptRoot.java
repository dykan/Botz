package botz.cstree;

import java.util.ArrayList;

public class CoffeScriptRoot extends Node{
	ArrayList<MethodNode> methods = new ArrayList<MethodNode>();
	ArrayList<ImportNode> imports = new ArrayList<ImportNode>();
	
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
			stdb.append(impor);
		}
		stdb.append("\n");
		for(MethodNode method : methods){
			stdb.append(method);
		}
		stdb.append("\n");
		return stdb.toString();
	}

	@Override
	public boolean indents() {
		return false;
	}
}
