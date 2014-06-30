package botz.parser;

import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import botz.antlr.JavaBaseListener;
import botz.antlr.JavaParser;
import botz.antlr.JavaParser.BlockStatementContext;
import botz.antlr.JavaParser.ExpressionContext;
import botz.antlr.JavaParser.FormalParameterContext;
import botz.antlr.JavaParser.FormalParameterListContext;
import botz.antlr.JavaParser.FormalParametersContext;
import botz.antlr.JavaParser.MethodBodyContext;
import botz.cstree.CoffeScriptRoot;
import botz.cstree.MethodNode;

public class BotzListener extends JavaBaseListener{
	
	CoffeScriptRoot root = new CoffeScriptRoot();

	public CoffeScriptRoot getRoot() {
		return root;
	}
	
	public void enterMethodDeclaration(@NotNull JavaParser.MethodDeclarationContext ctx){

		String methodName =  ctx.Identifier().getText();
		System.out.println(("methodName: " + methodName));
		
		FormalParametersContext paramsCtx = ctx.formalParameters();
		FormalParameterListContext tempList = paramsCtx.formalParameterList();
		if (tempList!=null){
			List<FormalParameterContext> params = tempList.formalParameter();
			for(FormalParameterContext param : params){
				String type = param.type().getText();
				String name = param.variableDeclaratorId().getText();
			}
		}
		MethodBodyContext body = ctx.methodBody();
		List<BlockStatementContext> blocks = body.block().blockStatement();
		for(BlockStatementContext block : blocks){
			List<ExpressionContext> expList =  block.statement().expression();
			for(ExpressionContext exp : expList){
				System.out.println("exp:: " + exp.getText() + "::" );
			}
		}

		
		MethodNode method = new MethodNode(root, methodName, null, null, null);
		root.addMethod(method);
	}

}
