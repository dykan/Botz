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
	public void render(StringBuilder stb) {
		// TODO Auto-generated method stub
		
	}

	

}
