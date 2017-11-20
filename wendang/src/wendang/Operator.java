package wendang;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Enumeration;
import java.util.Scanner;

public class Operator extends User {
	int i = 1;

	public Operator(String name1, String password1, String role1) {
		setName(name1);
		setPassword(password1);
		setRole(role1);
	}

	void uploadFile() {
		String id = null;
		String creator = null;
		Timestamp time = null;
		String description = null;
		String filename = null;
		Scanner in=new Scanner (System.in);
		System.out.println("输入:文件id");
		id=in.next();
		creator=this.getName();
		time=new Timestamp(System.currentTimeMillis());  
		System.out.println("输入:描述");
		description=in.next();
		System.out.println("输入:文件名");
		filename=in.next();
		System.out.println("请输入:文件类型");
		String type = in.next();
		boolean test=true;
		try {
			if(DataProcessing.searchDoc(id)!=null){
				System.out.println("id重复");
				System.out.println("请重新输入id");
				id=in.next();
			}
			DataProcessing.insertDoc(id,creator,time,description,filename,type);
		} catch (IllegalStateException e) {
			// TODO 自动生成的 catch 块
			System.out.println(e.getMessage());
			System.out.println("请重试");
			test=false;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println(e.getMessage());
			System.out.println("请重试");
			test=false;
		}
		if(test){
			
			
			 
				try {
					int bytesum = 0; 
					int byteread = 0; 
					String file_path="D:/upload/"+id+"."+type;
					File file =new File(filename);
					File File_path=new File(file_path);
					if(file.exists()){
						InputStream inStream=new FileInputStream(file);
						FileOutputStream fs =new FileOutputStream(File_path);
						byte[] buffer = new byte[1444]; 
						int length; 
						while ( (byteread = inStream.read(buffer)) != -1) { 
							bytesum += byteread; //字节数 文件大小 
							
							fs.write(buffer, 0, byteread); 
							}System.out.println("Scuess");
						inStream.close();
						}
					} catch (Exception e) {
						// TODO 自动生成的 catch 块
						System.out.println(e.getMessage());
					}
				}
				
				
		}
				
	void downloadFile(){
		Scanner in=new Scanner (System.in);
		boolean test=true;
		System.out.println("请输入下载的id");
		String id=in.next();
		Doc wenjian=null;
		try {
			 wenjian=DataProcessing.searchDoc(id);
		} catch (IllegalStateException e) {
			// TODO 自动生成的 catch 块
			System.out.println(e.getMessage());
			test=false;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println(e.getMessage());
			test=false;
		}
		if(test){
			
			try {
				int bytesum = 0; 
				int byteread = 0; 
				String file_path;
				File file =new File(wenjian.filename);
				System.out.println("请输入下载位置");
				file_path=in.next();
				File download=new File(file_path);
				if(file.exists()){
					InputStream inStream=new FileInputStream(file);
					FileOutputStream fs =new FileOutputStream(download);
					byte[] buffer = new byte[1444]; 
					int length; 
					while ( (byteread = inStream.read(buffer)) != -1) { 
						bytesum += byteread; //字节数 文件大小 
						 
						fs.write(buffer, 0, byteread); 
						}
					System.out.println("Scuess");;
					inStream.close();
					}
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					System.out.println(e.getMessage());
				}
		}
		
	}
	
	void showFilelist() {
		Enumeration<Doc> a = null;
		try {
			a = DataProcessing.getAllDocs();
		} catch (IllegalStateException e) {
			// TODO 自动生成的 catch 块
			System.out.println(e.getMessage());
			System.out.println("请重试");

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println(e.getMessage());
			System.out.println("请重试");

		}
		if (a != null) {
			try{
			Doc b = a.nextElement();
			while(b!=null){
				System.out.println(b.Id);
				System.out.println(b.filename);
				b=a.nextElement();
			}
			}catch(Exception e){
				System.out.println("显示完毕");
			}
			
		}
	}

	void showmenu() {
		Scanner in = new Scanner(System.in);
		System.out.println("输入1：上传文件");
		System.out.println("输入2：下载文件");
		System.out.println("输入3：显示全部文件");
		System.out.println("输入4：退出");
		int num = in.nextInt();
		if (num == 1) {
			uploadFile();
		} else if (num == 2) {
			downloadFile();
		} else if (num == 3) {
			showFilelist();
		} else if (num == 4) {
			System.exit(0);
		}
	}
}
