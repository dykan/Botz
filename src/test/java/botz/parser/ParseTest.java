package botz.parser;

import java.util.ArrayList;

import org.junit.Test;

import botz.cstree.MethodNode;

public class ParseTest {
	
	String fileName = "src/test/java/botz/Pojo.java";

	@Test
  public void testMethods(){
    	BotzParser parser = new BotzParser(fileName);
    	parser.parse();
    	ArrayList<MethodNode> methods  = parser.visitor.root.getClassNode().getMethods();
    	
    	for(MethodNode method : methods){
    		System.out.println(method.render());
    	}
    }
	
	@Test
	public void testClass(){
		BotzParser parser = new BotzParser(fileName);
    	parser.parse();
    	System.out.println(parser.render());
	}

}
