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
		return render(false);
	}
	
	@Override
	public String render(boolean inline) {
		StringBuilder stb = new StringBuilder();
		
		for(int i=0; i<block.size(); i++){
			block.get(i).write(stb, inline);
			if (i < block.size() -1){
				stb.append("\n");
			}
		}
		/*for (Node node : block){
			stb.append("\n");
			node.write(stb, true);
		}*/
		
		return stb.toString();
	}
	
	@Override
	public boolean canBeShotren(){
		if (block.size() == 0){
			return true;
		} else if (block.size() == 1){
			return block.get(1).canBeShotren();
		} else {
			return false;
		}
	}

	
	
	



}
