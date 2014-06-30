package botz.cstree.flow;

import botz.cstree.AssignNode;
import botz.cstree.CodeNode;
import botz.cstree.Node;
import botz.cstree.expression.SimpleExpression;
import junit.framework.TestCase;

import java.util.ArrayList;

public class IfNodeTest extends TestCase {
    public void testInlineIfs() throws Exception {
        ArrayList<Node> oneLined = new ArrayList<Node>();
        IfNode oneLinedIfNode = new IfNode(null, new SimpleExpression("myBool"));
        oneLinedIfNode.setBlock(oneLined);
        oneLined.add(new AssignNode(oneLinedIfNode, "a", new SimpleExpression("b")));
        assertEquals("a = b if myBool", oneLinedIfNode.render());
    }

    public void testMultipleLineIfs() throws Exception {
        ArrayList<Node> multiLine = new ArrayList<Node>();
        IfNode multiLinedIfNode = new IfNode(null, new SimpleExpression("myBool"));
        multiLinedIfNode.setBlock(multiLine);
        multiLine.add(new AssignNode(multiLinedIfNode, "a", new SimpleExpression("b")));
        multiLine.add(new AssignNode(multiLinedIfNode, "x", new SimpleExpression("z")));

        assertEquals("if myBool\n  a = b\n  x = z", multiLinedIfNode.render());
    }

    public void testMultipleLineElse() throws Exception {
        ArrayList<Node> multiLine = new ArrayList<Node>();
        IfNode multiLinedIfNode = new IfNode(null, null);
        multiLinedIfNode.setBlock(multiLine);
        multiLine.add(new AssignNode(multiLinedIfNode, "a", new SimpleExpression("b")));
        multiLine.add(new AssignNode(multiLinedIfNode, "x", new SimpleExpression("z")));

        assertEquals("else\n  a = b\n  x = z", multiLinedIfNode.render());
    }
}