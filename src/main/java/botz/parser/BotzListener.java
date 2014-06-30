package botz.parser;

import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.ModifierSet;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.visitor.VoidVisitor;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.misc.NotNull;

import botz.antlr.JavaBaseListener;
import botz.antlr.JavaParser;
import botz.antlr.JavaParser.BlockContext;
import botz.antlr.JavaParser.BlockStatementContext;
import botz.antlr.JavaParser.ExpressionContext;
import botz.antlr.JavaParser.FormalParameterContext;
import botz.antlr.JavaParser.FormalParameterListContext;
import botz.antlr.JavaParser.FormalParametersContext;
import botz.antlr.JavaParser.MethodBodyContext;
import botz.antlr.JavaParser.StatementContext;
import botz.cstree.CodeNode;
import botz.cstree.CoffeScriptRoot;
import botz.cstree.MethodNode;
import botz.cstree.ParameterNode;
import botz.util.VerboseListener;

public class BotzListener extends VoidVisitorAdapter{
	
	CoffeScriptRoot root = new CoffeScriptRoot();

	public CoffeScriptRoot getRoot() {
		return root;
	}
	
	public void visit(MethodDeclaration method){
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
	
	

}
