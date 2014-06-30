package botz.parser;

import japa.parser.ast.body.BodyDeclaration;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.ModifierSet;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;
import java.util.List;


import botz.cstree.ClassNode;
import botz.cstree.CodeNode;
import botz.cstree.CoffeScriptRoot;
import botz.cstree.MethodNode;
import botz.cstree.ParameterNode;

public class BotzListener extends VoidVisitorAdapter{
	
	CoffeScriptRoot root = new CoffeScriptRoot();

	public CoffeScriptRoot getRoot() {
		return root;
	}
	
	@Override
	public void visit(MethodDeclaration method, Object args){
		String name = method.getName();
		String returnType = (String)method.getType().getData();
		int modifier = method.getModifiers();
		boolean isPrivate = ModifierSet.isPrivate(modifier);
		boolean isStatic = ModifierSet.isStatic(modifier);
		ArrayList<ParameterNode> paramsNodes = new ArrayList<ParameterNode>();
		ArrayList<CodeNode> bodyNodes = new ArrayList<CodeNode>();
		MethodNode methodNode = new MethodNode(root, name, returnType, paramsNodes, bodyNodes);
		
		// handle params
		List<Parameter> params = method.getParameters();
		for(Parameter param : params){
			String type = (String)param.getType().getData();
			String id = param.getId().getName();
			
			ParameterNode paramNode = new ParameterNode(methodNode, type, id);
			paramsNodes.add(paramNode);
		}
	}
	
	@Override
	public void visit(ClassOrInterfaceDeclaration declaration, Object args){
		String className = declaration.getName();
		String parentClass  = null;
		ArrayList<String> interfaces = null;
		ArrayList<ParameterNode> members = null;
		
		if(declaration.getExtends() != null){
			parentClass = declaration.getExtends().get(0).getName();
		}
		
		if (declaration.getImplements() != null){
			interfaces = new ArrayList<String>();
			for (ClassOrInterfaceType curr : declaration.getImplements()){
				interfaces.add(curr.getName());
			}
		}
		
		// todo: get members
		if (declaration.getMembers() != null){
			members = new ArrayList<ParameterNode>();
			for(BodyDeclaration bodyDeclaration :declaration.getMembers()){
				
			}
			
		}
		
		if (declaration.isInterface()){
			
		} else {
			
			ClassNode classNode = 
					new ClassNode(className, root, null, parentClass, interfaces, members);
		}
		
		
		
	}
	
	

}
