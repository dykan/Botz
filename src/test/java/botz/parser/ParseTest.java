package botz.parser;

import java.util.ArrayList;

import org.junit.Test;

import botz.cstree.MethodNode;

public class ParseTest {
	
	String fileName = "src/test/java/botz/AntlrTest.java";

	@Test
  public void renderMethod(){
    	BotzParser parser = new BotzParser(fileName);
    	parser.parse();
    	ArrayList<MethodNode> methods  = parser.listener.root.getMethods();
    	
    	for(MethodNode method : methods){
    		System.out.println(method.render());
    	}
    }

}
