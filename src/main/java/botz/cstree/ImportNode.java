package botz.cstree;


public class ImportNode extends Node {
	String importStr;
	
	public ImportNode(Node parent, String importStr) {
		super(parent);
		this.importStatement = importStr.split("\\.");
	}

	private String[] importStatement;

	@Override
	public boolean indents() {
		
		return false;
	}

	@Override
	public String render() {
		StringBuilder stdb = new StringBuilder();
		for(int i=0;i<importStatement.length;i++){
			stdb.append(importStatement[i]);
			if(i!=importStatement.length-1){
				stdb.append("_");
			}
		}
		stdb.append(" = require '");
		
		for(int i=0;i<importStatement.length;i++){
			stdb.append(importStatement[i]);
			if(i!=importStatement.length-1){
				stdb.append("/");
			}
		}
		stdb.append("'");
		return stdb.toString();
	}

}
