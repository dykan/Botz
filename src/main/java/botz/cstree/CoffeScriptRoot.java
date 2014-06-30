package botz.cstree;

import java.util.ArrayList;

public class CoffeScriptRoot extends Node{

	
	ArrayList<MethodNode> methods = new ArrayList<MethodNode>();
	
	public void addMethod(MethodNode method){
		methods.add(method);
	}
	
	public ArrayList<MethodNode> getMethods(){
		return methods;
	}

	@Override
	public String render() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean indents() {
		return false;
	}
	


	

}
