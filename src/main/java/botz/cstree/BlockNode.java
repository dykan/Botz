package botz.cstree;


import java.util.ArrayList;
import java.util.List;

public class BlockNode extends CodeNode {

	List<Node> block = new ArrayList<Node>();
	
	public BlockNode(Node parent) {
		super(parent);
	}

	@Override
	public boolean indents() {
		return false;
	}
	
	public void addNode(Node node){
		block.add(node);
	}

	@Override
	public String render() {
		StringBuilder stb = new StringBuilder();
		
		for(int i=0; i<block.size(); i++){
			block.get(i).write(stb);
			if (i == block.size() -1){
				stb.append("\n");
			}
		}
		
		return stb.toString();
	}



}
