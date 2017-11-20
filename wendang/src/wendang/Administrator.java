package wendang;
import java.sql.SQLException;
import java.util.*;
public class Administrator extends User{
		public Administrator(String name1,String password1,String role1){
			setName(name1);
			setPassword(password1);
			setRole(role1);
		}
		void changeUserInfo(String name,String password,String role){
			try {
				if(DataProcessing.updateUser(name, password, role))
				System.out.println("success");
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
		void delUser(String name){
			try {
				if(DataProcessing.deleteUser(name))
				System.out.println("success");
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
		void addUser(String name,String password,String role){
			try {
				if(DataProcessing.insertUser(name,password,role)){
				System.out.println("success");
				}
				else
				{
					System.out.println(false);
				}
			} catch (IllegalStateException e) {
				// TODO �Զ����ɵ� catch ��
				System.out.println(false);
				System.out.println("������");
			
				System.out.println(e.getMessage());
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				System.out.println(false);
				System.out.println(e.getMessage());
				System.out.println("������");
			
			}
		}
		void listUser(){
			Enumeration<User> a = null;
			try {
				a = DataProcessing.getAllUser();
			} catch (IllegalStateException e) {
				// TODO �Զ����ɵ� catch ��
				System.out.println(e.getMessage());
				System.out.println("������");
				
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				System.out.println(e.getMessage());
				System.out.println("������");
				
			}
			if(a!=null){
				User b =a.nextElement();
			while(a.hasMoreElements()){
				System.out.println(b.getName());
				b=a.nextElement();
			
			}
			}
		}
			
		void showmenu(){
			Scanner in=new Scanner (System.in);
			System.out.println("����1���޸��û���Ϣ");
			System.out.println("����2��ɾ���û���Ϣ");
			System.out.println("����3������û���Ϣ");
			System.out.println("����4����ʾȫ���û���Ϣ");
			System.out.println("����5���˳�");
			int num=in.nextInt();
			if(num==1){
				System.out.println("�����û���Ϣ:");
				String name=in.next();
				String password=in.next();
				String role=in.next();
				changeUserInfo(name,password,role);
			}
			else if(num==2){
				System.out.println("�����û���Ϣ:");
				String name=in.next();
				delUser(name);
			}
			else if(num==3){
				System.out.println("�����û���Ϣ:");
				String name=in.next();
				String password=in.next();
				String role=in.next();
				addUser(name,password,role);
			}
			else if(num==4){
				listUser();
			}
			else if(num==5){
				System.exit(0);
			}
			
		}
	}

