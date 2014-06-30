package botz.cstree;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import botz.cstree.expression.SimpleExpression;

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
		MethodNode method = new MethodNode(root.classNode, "setHamin", "int", params, body);
		params.add(new ParameterNode(method, "int", "hamin"));
		body.add(new AssignNode(method, "this.hamin", new SimpleExpression("hamin")));
		methods.add(method);
		
		System.out.println(root.render());
	}

}
