package wendang;
import java.sql.SQLException;
import java.util.*;
class User{
	private String name;
	private String password;
	private String role;
	void showmenu(){
		
	}
	String getName(){
		return name;
	}
	String getPassword(){
		return password;
	}
	String getRole(){
		return role;
	}
	void setName(String name1){
		name=name1;
	}
	void setPassword(String password1){
		password=password1;
	}
	void setRole(String role1){
		role=role1;
	}
	void showFileList(){}
	void downloadFile(){
		System.out.println("������Ҫ���ص�id");
		Scanner in = new Scanner (System.in);
		String ID = in.next();
		try {
			Doc doc1=DataProcessing.searchDoc(ID);
		} catch (IllegalStateException e) {
			// TODO �Զ����ɵ� catch ��
			System.out.println(e.getMessage());
			System.out.println("������");
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			System.out.println(e.getMessage());
			System.out.println("������");
		}
	}
	void changeFileSelfInfo(){}
}




