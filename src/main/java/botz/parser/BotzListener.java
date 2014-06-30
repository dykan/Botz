package botz.parser;

import org.antlr.v4.runtime.misc.NotNull;

import botz.antlr.JavaBaseListener;
import botz.antlr.JavaParser;
import botz.antlr.JavaParser.FormalParametersContext;
import botz.cstree.CoffeScriptRoot;

public class BotzListener extends JavaBaseListener{
	
	CoffeScriptRoot root = new CoffeScriptRoot();

	public CoffeScriptRoot getRoot() {
		return root;
	}
	
	public void enterMethodDeclaration(@NotNull JavaParser.MethodDeclarationContext ctx){

		String methodName =  ctx.Identifier().getText();
		
		FormalParametersContext params = ctx.formalParameters();
		System.out.println("params: " + params.getText());
		
		System.out.println("body: " + ctx.methodBody().getText());
	}

}
