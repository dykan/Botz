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
		
		ArrayList<MethodNode> methods = new ArrayList<MethodNode>();
		ArrayList<ParameterNode> params = new ArrayList<ParameterNode>();
		root.classNode = new ClassNode("Pagi", root, methods, null, null, params);
		ArrayList<CodeNode> body = new ArrayList<CodeNode>();
		
		WhileNode whileNode = null;
		AssignNode assNode = new AssignNode(whileNode, "i", 
				new DoubleExpressionNode(
						new SimpleExpression("i"),"+",new SimpleExpression("1")));
		ArrayList<CodeNode> arrAssign =  new ArrayList();
		arrAssign.add(assNode);
		 whileNode = new WhileNode(root.classNode,
				new DoubleExpressionNode(
				new SimpleExpression("i"),"==",new SimpleExpression("8"))
		, arrAssign);
		
		 ArrayList<ExpressionNode> params2 = new ArrayList<>();
		 params2.add(new SimpleExpression("kkk"));
		 params2.add(new SimpleExpression("kkk2"));
		 MethodCall methodCall = new MethodCall(root.classNode,"bulbulFunc", params2);
		 
		
		body.add(whileNode);
		body.add(methodCall);
		MethodNode method = new MethodNode(root.classNode, "setHamin", "int", params, body);
		params.add(new ParameterNode(method, "int", "hamin"));
		body.add(new AssignNode(method, "this.hamin", new SimpleExpression("hamin")));
		methods.add(method);
		
		System.out.println(root.render());
	}

}
