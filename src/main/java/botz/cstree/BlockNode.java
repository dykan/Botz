package botz.cstree;


import java.util.ArrayList;
import java.util.List;

public class BlockNode extends CodeNode {

	List<Node> block = new ArrayList<Node>();
	
	@Override
	public boolean indents() {
		return false;
	}

	@Override
	public String render() {
		StringBuilder stb = new StringBuilder();
		
		for(Node node : block){
			node.write(stb);
		}
		
		return stb.toString();
	}



}
