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
		
		ArrayList<ParameterNode> params = new ArrayList<ParameterNode>();
		root.classNode = new ClassNode(root,"Pagi", null, null, params);
		MethodNode method = new MethodNode(root.classNode, "setHamin", "int", params);
		params.add(new ParameterNode(method, "int", "hamin"));
		method.addCodeNode(new AssignNode(method, "this.hamin", new SimpleExpression("hamin")));
		root.classNode.addMethod(method);
		
		System.out.println(root.render());
	}

}
