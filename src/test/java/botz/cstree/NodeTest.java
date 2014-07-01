package botz.cstree;

import junit.framework.TestCase;

public class NodeTest extends TestCase {
    public void testIndent() throws Exception {
        assertEquals(Node.indent("abc", 0), "abc");
        assertEquals(Node.indent("abc", 1), " abc");
        assertEquals(Node.indent("abc", 2), "  abc");
    }
}