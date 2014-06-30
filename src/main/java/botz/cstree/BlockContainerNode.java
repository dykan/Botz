package botz.cstree;

import java.util.ArrayList;
import java.util.List;

public abstract class BlockContainerNode extends CodeNode {

	List<Node> block;

	public List<Node> getBlock() {
		return block;
	}

	public void setBlock(List<Node> block) {
		this.block = block;
	}
	
	public void addNode(Node node){
		if (block == null){
			block = new ArrayList<Node>();
		}
		block.add(node);
	}

}
