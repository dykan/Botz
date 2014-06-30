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
import org.junit.Test;

public class AntlrTest {
    @Test
    public void testSimpleJava() throws Exception {
        String fileName = "src/test/java/botz/AntlrTest.java";
        org.antlr.v4.runtime.Lexer lexer = new JavaLexer(new ANTLRFileStream(fileName));
        TokenStream tokenStream = new BufferedTokenStream(lexer);
        JavaParser javaParser = new JavaParser(tokenStream);

        // entry point
        ParseTree tree = javaParser.compilationUnit();

        // walker
        ParseTreeWalker walker = new ParseTreeWalker();
        MyListener listener = new MyListener();
        walker.walk(listener, tree);
    }

}
