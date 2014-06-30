package botz.cstree;

import botz.cstree.expression.ExpressionNode;
import botz.cstree.expression.SimpleExpression;
import junit.framework.TestCase;

public class AssignNodeTest extends TestCase {
    public void testComplexVariable() throws Exception {
        assertEquals(new AssignNode("this.hamin", new SimpleExpression("123")).render(), "@hamin = 123");
        assertEquals(new AssignNode("this.hamin", new SimpleExpression("\"string\"")).render(), "@hamin = \"string\"");
    }

    public void testSimpleVariable() throws Exception {
        assertEquals(new AssignNode("hamin", new SimpleExpression("123")).render(), "hamin = 123");
        assertEquals(new AssignNode("hamin", new SimpleExpression("\"string\"")).render(), "hamin = \"string\"");
    }
}