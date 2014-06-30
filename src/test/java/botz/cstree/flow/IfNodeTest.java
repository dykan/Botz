package botz.cstree.flow;

import botz.cstree.AssignNode;
import botz.cstree.CodeNode;
import botz.cstree.Node;
import botz.cstree.expression.SimpleExpression;
import junit.framework.TestCase;

import java.util.ArrayList;

public class IfNodeTest extends TestCase {
    public void testInlineIfs() throws Exception {
        ArrayList<CodeNode> oneLined = new ArrayList<CodeNode>();
        IfNode oneLinedIfNode = new IfNode(null, new SimpleExpression("myBool"), oneLined);
        oneLined.add(new AssignNode(oneLinedIfNode, "a", new SimpleExpression("b")));
        assertEquals("a = b if myBool", oneLinedIfNode.render());
    }

    public void testMultipleLineIfs() throws Exception {
        ArrayList<CodeNode> multiLine = new ArrayList<CodeNode>();
        IfNode multiLinedIfNode = new IfNode(null, new SimpleExpression("myBool"), multiLine);
        multiLine.add(new AssignNode(multiLinedIfNode, "a", new SimpleExpression("b")));
        multiLine.add(new AssignNode(multiLinedIfNode, "x", new SimpleExpression("z")));

        assertEquals("if myBool\n  a = b\n  x = z", multiLinedIfNode.render());
    }
}