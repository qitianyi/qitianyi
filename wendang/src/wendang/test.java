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
				System.out.println("�������û�����");
				String name1=in.next();
				System.out.println("���������룺");
				String password1=in.next();
			try {
			
				user1=DataProcessing.searchUser(name1, password1);
				if(user1==null){
					System.out.println("�˺Ż��������");
					test1=false;
				}
			} catch (IllegalStateException e) {
				// TODO �Զ����ɵ� catch ��
				System.out.println(e.getMessage());
				System.out.println("��½����");
				DataProcessing.Init();
				test=false;
				continue;
				
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				System.out.println(e.getMessage());
				System.out.println("��½����");
				test=false;
				continue;
				
			}
			while(test1){user1.showmenu();}
				
			
			
		}
		}
}
