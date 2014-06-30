package botz.parser;


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
		
		try{
			// antlr stuff
			org.antlr.v4.runtime.Lexer lexer = new JavaLexer(new ANTLRFileStream(className));
	        TokenStream tokenStream = new BufferedTokenStream(lexer);
	        JavaParser javaParser = new JavaParser(tokenStream);

	        // entry point
	        ParseTree tree = javaParser.compilationUnit();

	        // walk through java class, save all in the listener
	        ParseTreeWalker walker = new ParseTreeWalker();
	        listener = new BotzListener();
	        walker.walk(listener, tree);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
		
	public String render(){
	    return listener.getRoot().render();    
	}

}
