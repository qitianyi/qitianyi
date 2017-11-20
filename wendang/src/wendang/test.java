package wendang;
import java.sql.SQLException;
import java.util.*;
public class test {
	
		public static void main(String[] args){
			Scanner in=new Scanner (System.in);
			User user1 = null;
			boolean test=false;
			
			while(!test){
				boolean test1=true;
				System.out.println("请输入用户名：");
				String name1=in.next();
				System.out.println("请输入密码：");
				String password1=in.next();
			try {
			
				user1=DataProcessing.searchUser(name1, password1);
				if(user1==null){
					System.out.println("账号或密码错误");
					test1=false;
				}
			} catch (IllegalStateException e) {
				// TODO 自动生成的 catch 块
				System.out.println(e.getMessage());
				System.out.println("登陆错误");
				DataProcessing.Init();
				test=false;
				continue;
				
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				System.out.println(e.getMessage());
				System.out.println("登陆错误");
				test=false;
				continue;
				
			}
			while(test1){user1.showmenu();}
				
			
			
		}
		}
}
