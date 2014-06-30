package botz.cstree;

import botz.cstree.expression.ExpressionNode;
import botz.cstree.expression.SimpleExpression;
import junit.framework.TestCase;

public class AssignNodeTest extends TestCase {
    public void testComplexVariable() throws Exception {
        assertEquals(new AssignNode(null, "this.hamin", new SimpleExpression("123")).render(), "@hamin = 123");
        assertEquals(new AssignNode(null, "this.hamin", new SimpleExpression("\"string\"")).render(), "@hamin = \"string\"");
    }

    public void testSimpleVariable() throws Exception {
        assertEquals(new AssignNode(null, "hamin", new SimpleExpression("123")).render(), "hamin = 123");
        assertEquals(new AssignNode(null, "hamin", new SimpleExpression("\"string\"")).render(), "hamin = \"string\"");
    }
}