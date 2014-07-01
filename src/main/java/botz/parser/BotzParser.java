package botz.parser;

import japa.parser.ast.CompilationUnit;

import java.io.FileInputStream;
import java.io.IOException;

public class BotzParser {

	String className;
	BotzVisitor visitor = new BotzVisitor();

	public BotzParser(String className) {
		this.className = className;
	}

	public void parse() {

		FileInputStream in = null;
		CompilationUnit cu = null;
		try {
			in = new FileInputStream(className);
			cu = japa.parser.JavaParser.parse(in);
			visitor.visit(cu, null);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public String render() {
		return visitor.getRoot().render();
	}
}
