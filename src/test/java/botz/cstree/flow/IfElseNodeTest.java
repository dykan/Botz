//package botz.cstree.flow;
//
//import botz.cstree.AssignNode;
//import botz.cstree.CodeNode;
//import botz.cstree.Node;
//import botz.cstree.expression.SimpleExpression;
//import junit.framework.TestCase;
//import org.junit.Test;
//
//import java.util.ArrayList;
//
//public class IfElseNodeTest extends TestCase {
//    @Test
//    public void testOnlyOneIf() throws Exception {
//        ArrayList<IfNode> ifs = new ArrayList<IfNode>();
//        IfElseNode ien = new IfElseNode(null, ifs, null);
//        IfNode multiLinedIfNode = multilinedIfNode(ien);
//        ifs.add(multiLinedIfNode);
//
//        assertEquals(multiLinedIfNode.render(), ien.render());
//    }
//
//    @Test
//    public void testTwoIfs() throws Exception {
//        ArrayList<IfNode> ifs = new ArrayList<IfNode>();
//        IfElseNode ien = new IfElseNode(null, ifs, null);
//        ifs.add(multilinedIfNode(ien));
//        ifs.add(inlineIf(ien));
//
//
//        assertEquals("if myBool\n  a = b\n  x = z\nelse if haminados\n  a = b", ien.render());
//    }
//
//    @Test
//    public void testTwoIfsAndElse() throws Exception {
//        ArrayList<Node> body = new ArrayList<Node>();
//        IfNode elseNode = new IfNode(null, null);
//        elseNode.setBlock(body);
//        body.add(new AssignNode(elseNode, "hai", new SimpleExpression("ho")));
//        ArrayList<IfNode> ifs = new ArrayList<IfNode>();
//        IfElseNode ien = new IfElseNode(null, ifs, elseNode);
//        elseNode.setParent(ien);
//        ifs.add(multilinedIfNode(ien));
//        ifs.add(inlineIf(ien));
//
//        assertEquals("if myBool\n  a = b\n  x = z\nelse if haminados\n  a = b\nelse\n  hai = ho", ien.render());
//    }
//
//    private IfNode multilinedIfNode(Node parent) {
//        ArrayList<Node> multiLine = new ArrayList<Node>();
//        IfNode multiLinedIfNode = new IfNode(parent, new SimpleExpression("myBool"));
//        multiLinedIfNode.setBlock(multiLine);
//        multiLine.add(new AssignNode(multiLinedIfNode, "a", new SimpleExpression("b")));
//        multiLine.add(new AssignNode(multiLinedIfNode, "x", new SimpleExpression("z")));
//        return multiLinedIfNode;
//    }
//
//    private IfNode inlineIf(Node parent) {
//        ArrayList<Node> oneLined = new ArrayList<Node>();
//        IfNode oneLinedIfNode = new IfNode(parent, new SimpleExpression("haminados"));
//        oneLinedIfNode.setBlock(oneLined);
//        oneLined.add(new AssignNode(oneLinedIfNode, "a", new SimpleExpression("b")));
//        return oneLinedIfNode;
//    }
//}