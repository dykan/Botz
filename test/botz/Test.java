package botz;
import java.io.IOException;


import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import botz.antlr.JavaLexer;
import botz.antlr.JavaParser;



public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String fileName = "test\\botz\\Test.java";
		org.antlr.v4.runtime.Lexer lexer = new JavaLexer(new ANTLRFileStream(fileName));
		TokenStream tokenStream = new BufferedTokenStream((TokenSource)lexer);
		JavaParser javaParser = new JavaParser(tokenStream);
		
		// entry point
		ParseTree tree = javaParser.compilationUnit();
		
		// walker
		ParseTreeWalker walker = new ParseTreeWalker();
		MyListener listener = new MyListener();
		walker.walk(listener, tree);
		
		
		
	}

}
