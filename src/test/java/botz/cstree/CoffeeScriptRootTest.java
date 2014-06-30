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
		ArrayList<Node> methodBody = new ArrayList<Node>();
		methodBody.add(new AssignNode(method, "this.hamin", new SimpleExpression("hamin")));
		method.setBlock(methodBody);
		root.classNode.addMethod(method);
		methodBody = new ArrayList<Node>();
		
		WhileNode whileNode = null;
		AssignNode assNode = new AssignNode(whileNode, "i", 
				new DoubleExpressionNode(
						null, new SimpleExpression("i"), "+", new SimpleExpression("1")));
		ArrayList<Node> arrAssign =  new ArrayList();
        whileNode = new WhileNode(root.classNode,
                new DoubleExpressionNode(null,
                        new SimpleExpression("i"), "==", new SimpleExpression("8")));
        assNode.setParent(whileNode);
        arrAssign.add(assNode);
        whileNode.setBlock(arrAssign);

		 ArrayList<ExpressionNode> params2 = new ArrayList<>();
		 params2.add(new SimpleExpression("kkk"));
		 params2.add(new SimpleExpression("kkk2"));
		 MethodCall methodCall = new MethodCall(root.classNode,"bulbulFunc", params2);
		 
		
		methodBody.add(whileNode);
		methodBody.add(methodCall);

		method = new MethodNode(root.classNode, "setHamina", "int", params);

        whileNode.setParent(method);
        methodCall.setParent(method);

		//params.add(new ParameterNode(method, "int", "hamin"));
		methodBody.add(new AssignNode(method, "this.hamin", new SimpleExpression("hamin")));
		method.setBlock(methodBody);
		root.classNode.addMethod(method);

		
		System.out.println(root.render());
	}

}
