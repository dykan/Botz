package botz;
import java.io.IOException;


import botz.antlr.JavaBaseListener;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import botz.antlr.JavaLexer;
import botz.antlr.JavaParser;
import org.junit.Test;

public class AntlrTest {
    @Test
    public void testSimpleJava() throws Exception {
        String fileName = "src/test/java/botz/Pojo.java";
        org.antlr.v4.runtime.Lexer lexer = new JavaLexer(new ANTLRFileStream(fileName));
        TokenStream tokenStream = new BufferedTokenStream(lexer);
        JavaParser javaParser = new JavaParser(tokenStream);

        // entry point
        ParseTree tree = javaParser.compilationUnit();

        // walker
        ParseTreeWalker walker = new ParseTreeWalker();
        ParseTreeListener listener = getJavaBaseListener();
        walker.walk(listener, tree);
    }

    private JavaBaseListener getJavaBaseListener() {
        return new JavaBaseListener() {
            public void enterMethodDeclaration(@NotNull JavaParser.MethodDeclarationContext ctx){

                System.out.println("method name: " + ctx.Identifier().getText());

                JavaParser.FormalParametersContext params = ctx.formalParameters();
                System.out.println("params: " + params.getText());

                System.out.println("body: " + ctx.methodBody().getText());
            }

            public void enterImportDeclaration(@NotNull JavaParser.ImportDeclarationContext ctx){
                System.out.println(ctx.qualifiedName().getText());
            }
        };
    }

}
