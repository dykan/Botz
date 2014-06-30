package botz.parser;

import java.util.ArrayList;

import org.junit.Test;

import botz.cstree.MethodNode;

public class ParseTest {
	
	String pojo = "src/test/java/botz/Pojo.java";
	String simple = "src/test/java/botz/SimpleClass.java";

	//@Test
  public void testMethods(){
    	BotzParser parser = new BotzParser(pojo);
    	parser.parse();
    	ArrayList<MethodNode> methods  = parser.visitor.root.getClassNode().getMethods();
    	
    	for(MethodNode method : methods){
    		System.out.println(method.render());
    	}
    }

	private void testClass(String fileName){
		BotzParser parser = new BotzParser(fileName);
    	parser.parse();
    	System.out.println(parser.render());
	}
	
	@Test
	public void testPojo(){
		testClass(pojo);
	}
	
	@Test
	public void testSimple(){
		testClass(simple);
	}

}
