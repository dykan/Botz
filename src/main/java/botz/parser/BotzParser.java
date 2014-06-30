package botz.parser;


import japa.parser.ast.CompilationUnit;

import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


import botz.antlr.JavaLexer;
import botz.antlr.JavaParser;

public class BotzParser {
	
	String className;
	BotzListener listener = null;
	
	public BotzParser(String className){
		this.className=className;
	}
	
	public void parse() {
	
			 FileInputStream in = null;
		      CompilationUnit cu =null;
		      try{
		    	in = new FileInputStream(className);
		    	cu = japa.parser.JavaParser.parse(in);
		}catch (Exception e){
			e.printStackTrace();
		} finally{
			if (in != null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
		
	public String render(){
	    return listener.getRoot().render();    
	}

}
