package botz;
import org.antlr.v4.runtime.misc.NotNull;

import botz.antlr.JavaBaseListener;
import botz.antlr.JavaParser;
import botz.antlr.JavaParser.FormalParametersContext;



public class MyListener extends JavaBaseListener{

	public void enterMethodDeclaration(@NotNull JavaParser.MethodDeclarationContext ctx){

		System.out.println("method name: " + ctx.Identifier().getText());
		
		FormalParametersContext params = ctx.formalParameters();
		System.out.println("params: " + params.getText());
		
		System.out.println("body: " + ctx.methodBody().getText());
	}
	
	public void enterImportDeclaration(@NotNull JavaParser.ImportDeclarationContext ctx){
		System.out.println(ctx.qualifiedName().getText());
	}
	

}
