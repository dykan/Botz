package botz.cstree;

import java.util.ArrayList;

public class ImportNode extends Node {
	
	String importStr;
	private ArrayList<String> importStatement;

	@Override
	public boolean indents() {
		
		return false;
	}

	@Override
	public String render() {
		StringBuilder stdb = new StringBuilder();
		
		for(int i=0;i<importStatement.size();i++){
			stdb.append(importStatement.get(i));
			if(i!=importStatement.size()-1){
				stdb.append("_");
			}
		}
		stdb.append(" = require '");
		
		for(int i=0;i<importStatement.size();i++){
			stdb.append(importStatement.get(i));
			if(i!=importStatement.size()-1){
				stdb.append("/");
			}
		}
		stdb.append("'");
		return stdb.toString();
	}

}
