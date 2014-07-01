package botz.cstree.expression;

import junit.framework.TestCase;

public class DoubleExpressionNodeTest extends TestCase {
    public void testExpression() throws Exception {
        DoubleExpressionNode doubleExpression = new DoubleExpressionNode(null, new SimpleExpression("hamin"), "+", new SimpleExpression("this.hamin"));
        assertEquals("(hamin + this.hamin)", doubleExpression.render());
        assertEquals("((hamin + this.hamin) + otherStuff)", new DoubleExpressionNode(null, doubleExpression, "+", new SimpleExpression("otherStuff")).render());
    }
}