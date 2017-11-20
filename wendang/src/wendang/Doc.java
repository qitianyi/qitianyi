package wendang;

import java.sql.Timestamp;

public class Doc {
	String Id;
	String creator;
	Timestamp time;
	String description;
	String filename;
	String type;
	
	public Doc(String string, String string2, Timestamp timestamp,
			String string3, String string4) {
		// TODO 自动生成的构造函数存根
		Id=string;
		creator=string2;
		time=timestamp;
		description=string3;
		filename=string4;
		
	}
	public Doc(String string, String string2, Timestamp timestamp,
			String string3, String string4,String type1) {
		// TODO 自动生成的构造函数存根
		Id=string;
		creator=string2;
		time=timestamp;
		description=string3;
		filename=string4;
		type=type1;
	}
}
