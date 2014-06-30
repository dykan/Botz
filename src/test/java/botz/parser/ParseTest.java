package botz.parser;

import java.util.ArrayList;

import botz.cstree.MethodNode;

public class ParseTest {
	
	String fileName = "src/test/java/botz/AntlrTest.java";

  public void buildMethod(){
    	BotzParser parser = new BotzParser(fileName);
    	ArrayList<MethodNode> methods  = parser.listener.root.getMethods();
    	
    	for(MethodNode method : methods){
    		StringBuilder stb = new StringBuilder();
    		method.render(stb);
    		System.out.println(stb);
    	}
    }

}
