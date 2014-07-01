package botz.cstree.flow;

import botz.cstree.AssignNode;
import botz.cstree.BlockNode;
import botz.cstree.CodeNode;
import botz.cstree.Node;
import botz.cstree.expression.SimpleExpression;
import junit.framework.TestCase;

import java.util.ArrayList;

public class IfNodeTest extends TestCase {
    public void testInlineIfs() throws Exception {
    	IfNode oneLinedIfNode = new IfNode(null, new SimpleExpression("myBool"));
    	Node oneLineBody = new AssignNode(oneLinedIfNode, "a", new SimpleExpression("b"));
    	oneLinedIfNode.setSon(oneLineBody);
      
        assertEquals("a = b if myBool", oneLinedIfNode.render());
    }

    public void testMultipleLineIfs() throws Exception {
    	IfNode multiLinedIfNode = new IfNode(null, new SimpleExpression("myBool"));
    	BlockNode multiLine = new BlockNode(multiLinedIfNode);
      
        multiLinedIfNode.setSon(multiLine);
        multiLine.addNode(new AssignNode(multiLinedIfNode, "a", new SimpleExpression("b")));
        multiLine.addNode(new AssignNode(multiLinedIfNode, "x", new SimpleExpression("z")));

        assertEquals("if myBool\n  a = b\n  x = z", multiLinedIfNode.render());
    }

    public void testMultipleLineElse() throws Exception {
    	IfNode multiLinedIfNode = new IfNode(null, null);
    	BlockNode multiLine = new BlockNode(multiLinedIfNode);
      
        multiLinedIfNode.setSon(multiLine);
        multiLine.addNode(new AssignNode(multiLinedIfNode, "a", new SimpleExpression("b")));
        multiLine.addNode(new AssignNode(multiLinedIfNode, "x", new SimpleExpression("z")));

        assertEquals("else\n  a = b\n  x = z", multiLinedIfNode.render());
    }
}