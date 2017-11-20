package wendang;

import java.util.Scanner;

class Browser extends User{
	public Browser(String name1,String password1,String role1){
		setName(name1);
		setPassword(password1);
		setRole(role1);
	}
	void downloadFile(){
		System.out.println("success");
	}
	void showFileList(){
		System.out.println("success");
	}
	void showmenu(){
		Scanner in=new Scanner (System.in);
		System.out.println("输入1：下载文件");
		System.out.println("输入2：显示全部文件");
		System.out.println("输入3：退出");
		int num=in.nextInt();
		if(num==1){
			downloadFile();
		}
		else if(num==2){
			showFileList();
		}
		else if(num==3){
			System.exit(0);
		}
	}
}