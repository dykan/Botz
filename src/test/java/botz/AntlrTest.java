package botz;



import botz.util.MochaTest;




public class AntlrTest {
	String fileName = "src/test/java/botz/AntlrTest.java";
    
  

    //@Test
    public void testMochaPojo() throws Exception {
        new MochaTest("src/test/coffee/botz/pojo-spec.coffee").run();
    }



}
