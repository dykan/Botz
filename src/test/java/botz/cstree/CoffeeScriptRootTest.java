package botz.cstree;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import botz.cstree.expression.DoubleExpressionNode;
import botz.cstree.expression.ExpressionNode;
import botz.cstree.expression.MethodCall;
import botz.cstree.expression.SimpleExpression;
import botz.cstree.flow.WhileNode;

public class CoffeeScriptRootTest {

	@Test
	public void test() {
		botz.cstree.CoffeScriptRoot root = new CoffeScriptRoot();
		root.imports.add(new ImportNode(root, "java.lang.String"));
		root.imports.add(new ImportNode(root, "java.lang.Haminados"));
		
		ArrayList<ParameterNode> params = new ArrayList<ParameterNode>();
		root.classNode = new ClassNode(root,"Pagi", null, null, params);
		MethodNode method = new MethodNode(root.classNode, "setHamin", "int", params);
		params.add(new ParameterNode(method, "int", "hamin"));
		BlockNode methodBody = new BlockNode(method);
		methodBody.addNode(new AssignNode(method, "this.hamin", new SimpleExpression("hamin")));
		method.setSon(methodBody);
		root.classNode.addMethod(method);
		
		// another method
		method = new MethodNode(root.classNode, "setHamina", "int", params);
		methodBody = new BlockNode(method);
		
		WhileNode whileNode = null;
		
        whileNode = new WhileNode(methodBody,
                new DoubleExpressionNode(null,
                        new SimpleExpression("i"), "==", new SimpleExpression("8")));
        BlockNode whileBody =  new BlockNode(whileNode);
        AssignNode assNode = new AssignNode(whileBody, "i", 
				new DoubleExpressionNode(
						null, new SimpleExpression("i"), "+", new SimpleExpression("1")));

        whileBody.addNode(assNode);
        whileNode.setSon(whileBody);

		 ArrayList<ExpressionNode> params2 = new ArrayList<>();
		 params2.add(new SimpleExpression("kkk"));
		 params2.add(new SimpleExpression("kkk2"));
		 MethodCall methodCall = new MethodCall(methodBody,"bulbulFunc", params2);
		 
		
		methodBody.addNode(whileNode);
		methodBody.addNode(methodCall);


		//params.add(new ParameterNode(method, "int", "hamin"));
		methodBody.addNode(new AssignNode(method, "this.hamin", new SimpleExpression("hamin")));
		method.setSon(methodBody);
		root.classNode.addMethod(method);

		
		System.out.println(root.render());
	}

}
