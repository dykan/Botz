package botz.parser;

import java.io.*;
import java.util.ArrayList;

import botz.util.MochaTest;
import org.junit.Assert;
import org.junit.Test;

import botz.cstree.MethodNode;

public class ParseTest {
	
	String fileName = "src/test/java/botz/Pojo.java";
	String coffeeFile = "src/test/coffee/botz/resources/pojo-result.coffee";
    String coffeeTestFile = "src/test/coffee/botz/pojo-spec.coffee";

	@Test
	public void testClass() throws IOException {
		BotzParser parser = new BotzParser(fileName);
    	parser.parse();
    	String parsedFile = parser.render();

        try (PrintWriter pw = new PrintWriter(coffeeFile, "UTF-8")) {
            pw.println(parsedFile);
            pw.close();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }

        new MochaTest(coffeeTestFile).run();
    }

}
