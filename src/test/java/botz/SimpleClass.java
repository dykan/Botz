package botz;

import botz.Pojo;

public class SimpleClass {

	public boolean foo(int i, int j){
		if (i > j){
			i++;
		} else i--;
		
		
		if (j>i){
			i = i+1;
		} else if ( i== j){
			i = i -1;
		} else {
			i++;
			i--;
		}
		
		return i > j;
	}
}
