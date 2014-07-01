package botz.cstree.flow;

import botz.cstree.AssignNode;
import botz.cstree.CodeNode;
import botz.cstree.Node;
import botz.cstree.expression.SimpleExpression;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

public class IfElseNodeTest extends IfNodeTest {

    @Test
    public void testTwoIfs() throws Exception {
        IfNode firstIf = multilineIf();
        IfNode secondIf = new IfNode(null, new SimpleExpression("haminados"));
        Node elseif = new AssignNode(secondIf, "a", new SimpleExpression("b"));
        
        secondIf.isElseIf=true;
        firstIf.setElseNode(secondIf);
        secondIf.setSon(elseif);
        
        System.out.println(firstIf.render());
        assertEquals("if myBool\n  a = b\n  x = z\nelse if haminados\n  a = b", firstIf.render());
    }

    @Test
    public void testTwoIfsAndElse() throws Exception {
    	IfNode firstIf = multilineIf();
        IfNode secondIf = new IfNode(null, new SimpleExpression("haminados"));
        Node elseifBody = new AssignNode(secondIf, "a", new SimpleExpression("b"));
        Node haiho = new AssignNode(elseifBody, "hai", new SimpleExpression("ho"));
        
        firstIf.setElseNode(secondIf);
        secondIf.isElseIf=true;
        secondIf.setSon(elseifBody);
        secondIf.setElseNode(haiho);
        
        System.out.println(firstIf.render());

        assertEquals("if myBool\n  a = b\n  x = z\nelse if haminados\n  a = b\nelse\n  hai = ho", firstIf.render());
    }


}