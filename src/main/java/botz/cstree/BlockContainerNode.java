package botz.cstree;

import java.util.ArrayList;
import java.util.List;

public abstract class BlockContainerNode extends Node {

	List<Node> block;
	
	public BlockContainerNode(Node parent){
		super(parent);
	}

	public BlockContainerNode() {
		// TODO Auto-generated constructor stub
	}

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
