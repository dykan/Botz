package botz;


import botz.antlr.JavaBaseListener;
import botz.util.MochaTest;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import botz.antlr.JavaLexer;
import botz.antlr.JavaParser;
import botz.parser.BotzParser;

import org.junit.Test;


public class AntlrTest {
	String fileName = "src/test/java/botz/AntlrTest.java";
	
    @Test
    public void testSimpleJava() throws Exception {
<<<<<<< HEAD
        
=======
        String fileName = "src/test/java/botz/Pojo.java";
>>>>>>> d0540ba43f4488d02da68d8dfd84645f8e743d98
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
    
  

    @Test
    public void testMochaPojo() throws Exception {
        new MochaTest("src/test/coffee/botz/pojo-spec.coffee").run();
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
