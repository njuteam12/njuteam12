import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
public class DataBase {
	
		private String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //����JDBC����
		private String dbURL = "jdbc:sqlserver://localhost;databaseName=master"; //���ӷ����������ݿ�test
		private String userName = "zjc"; //Ĭ���û���
		private String userPwd = "123123"; //��װsql server 2005ʱ������
		private Connection dbConn=null;
		private Statement stmt;
		public DataBase(){
			try{
				Class.forName(driverName);
				this.dbConn= DriverManager.getConnection(dbURL, userName, userPwd);
				stmt=dbConn.createStatement();
			}
			catch(Exception e){
				System.out.println("�Ҳ������������� ����������ʧ�� ");
			}
			
		}
		public Connection getConnection(){
			return this.dbConn;
		}
		public void close(){
			try {
				this.dbConn.close();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			}
		}
		public boolean addseller(String  name,String psw,String phone,String address,String id,int on) throws SQLException{
				String str="select id from seller where id='"+id+"'";
				//System.out.println(str);
				ResultSet rset=stmt.executeQuery(str);
				try {
					if(!rset.next()){
						String queryString="insert into seller values('"+name+"','"+psw+"','"+phone+"','"+address+"','"+id+"',"+on+","+(float)0+","+0+")";
					try {
						System.out.println(queryString);
						stmt.executeUpdate(queryString);
						return true;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
					else System.out.println(name+" is exist!");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
		public boolean addbuyer(String  name,String psw,String phone,String address,int on) throws SQLException{
			String str="select NAME from buyer where NAME='"+name+"'";
			ResultSet rset=stmt.executeQuery(str);
			try {
				if(!rset.next()){
					String queryString="insert into buyer values('"+name+"','"+psw+"','"+phone+"','"+address+"','"+on+"')";
				try {
					stmt.executeUpdate(queryString);
					return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				else System.out.println(name+" is exist!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		public boolean changebuyer(String  name,String psw,String phone,String address) throws SQLException{
			String str="select NAME from buyer where NAME='"+name+"'";
			ResultSet rset=stmt.executeQuery(str);
				if(rset.next()){
					if(psw!=null){
						String queryString="update buyer set psw='"+psw+"' where NAME='"+name+"'";
						stmt.executeUpdate(queryString);
					}
					if(phone!=null){
						String queryString="update buyer set phone='"+phone+"' where NAME='"+name+"'";
						stmt.executeUpdate(queryString);
					}
					if(address!=null){
						String queryString="update buyer set address='"+address+"' where NAME='"+name+"'";
						stmt.executeUpdate(queryString);
					}
					return true;
				}		
			return false;
		}
		
		public boolean changeseller(String ID,String  name,String psw,String phone,String address) throws SQLException{
			String str="select ID from seller where ID='"+ID+"'";
			ResultSet rset=stmt.executeQuery(str);
				if(rset.next()){
					if(name!=null){
						String queryString="update seller set name='"+name+"' where ID='"+ID+"'";
						stmt.executeUpdate(queryString);
					}
					if(psw!=null){
						String queryString="update seller set psw='"+psw+"' where ID='"+ID+"'";
						stmt.executeUpdate(queryString);
					}
					if(phone!=null){
						String queryString="update seller set phone='"+phone+"' where ID='"+ID+"'";
						stmt.executeUpdate(queryString);
					}
					if(address!=null){
						String queryString="update buyer set address='"+address+"' where NAME='"+name+"'";
						stmt.executeUpdate(queryString);
					}
					return true;
				}		
			return false;
		}
		
		public int buyer_login(String user_name,String password) throws SQLException{
			String str1="select PSW from buyer where NAME='"+user_name+"'";
			
			ResultSet rs=stmt.executeQuery(str1);
			if(rs.next()){
				if(password.equals(rs.getString(1))){
					String str4="select ONL from buyer where NAME='"+user_name+"'";
					ResultSet rs3=stmt.executeQuery(str4);
					int is_on=0;
					if(rs3.next()) is_on=rs3.getInt(1);
						if(is_on==0){	
							String str="update buyer set ONL="+1+" where NAME='"+user_name+"'";
							stmt.executeUpdate(str);
							return 0;//suceed
						}
						else return 3;//�Ѿ���¼
					}
				else return 2;//wrong password	
			}
			else return 1;//wrong ID
		}
		
		public int seller_login(String user_name,String password) throws SQLException{
			String str1="select PSW from seller where NAME='"+user_name+"'";
			
			ResultSet rs=stmt.executeQuery(str1);
			if(rs.next()){
				if(password.equals(rs.getString(1))){
					String str4="select ONL from seller where NAME='"+user_name+"'";
					ResultSet rs3=stmt.executeQuery(str4);
					int is_on=0;
					if(rs3.next()) is_on=rs3.getInt(1);
						if(is_on==0){	
							String str="update seller set ONL="+1+" where NAME='"+user_name+"'";
							stmt.executeUpdate(str);
							return 0;//suceed
						}
						else return 3;//�Ѿ���¼
					}
				else return 2;//wrong password	
			}
			else return 1;//wrong ID
		}
		
		public void buyer_offline(String user_name) throws SQLException{
			String str="update buyer set ONL="+0+" where NAME='"+user_name+"'";
			stmt.executeUpdate(str);
		}
		public void seller_offline(String id) throws SQLException{
			String str="update client set ONL="+0+" where ID='"+id+"'";
			stmt.executeUpdate(str);
		}
		
		public boolean add_menu(String ID,String  seller_name,float price,String menu_name) throws SQLException{
			String str="select NAME from menu where NAME='"+menu_name+"'";
			ResultSet rset=stmt.executeQuery(str);
			try {
				if(!rset.next()){
					String queryString="insert into menu values('"+ID+"','"+seller_name+"',"+price+",'"+menu_name+"','"+"empty"+"','"+0+"')";
				try {
					stmt.executeUpdate(queryString);
					/*
					 *���͸����û������û����������,,���Ѹ��û����͸����������û� 
					 */
					return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				else System.out.println(menu_name+" is exist!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		//����ID
		public int add_order(String buyer_name,String  seller_name,String menuid) throws SQLException{
			Calendar c = Calendar.getInstance();//���Զ�ÿ��ʱ���򵥶��޸�
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH)+1;
			int date = c.get(Calendar.DATE);
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int minute = c.get(Calendar.MINUTE);
			String time=(year + "/" + month + "/" + date + " " +hour + ":" +minute);
			String str="select ID from orders ORDER BY ID DESC";
			ResultSet rset=stmt.executeQuery(str);
			int ID;
			if(!rset.next())
				ID=-1;
			else
				ID=rset.getInt(1);
				ID++;
			String queryString="insert into orders values('"+ID+"','"+buyer_name+"','"+seller_name+"','"+menuid+"',"+0+",'"+time+"',"+null+")";
			try {
				stmt.executeUpdate(queryString);
			/*
			 *���͸����û������û����������,,���Ѹ��û����͸����������û� 
			 */
			return ID;
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			return -1;
		}
		
		public void add_comment(String menuid,String comment) throws SQLException{
			String str="select comment from menu where ID='"+menuid+"'";
			ResultSet rset=stmt.executeQuery(str);
			if(!rset.next()){
				return ;
			}
			String temp_comment=rset.getString(1);
			if(temp_comment.equals("empty"))
				temp_comment=comment;
			else 
				temp_comment=temp_comment+"&"+comment;
			String str1="update menu set comment='"+temp_comment+"' where ID='"+menuid+"'";
			stmt.executeUpdate(str1);
		}
		
		public void change_orderstate(int id,int state) throws SQLException{
			String str1="update orders set sta="+state+" where ID="+id;
			stmt.executeUpdate(str1);
		}
		
		public String search_menu(String input) throws SQLException{
			//String str1="select ID from menu where NAME like '%"+input+"%'";
			String str1="select ID from menu where NAME like '%dq%'";
			System.out.println(str1);
			ResultSet rset=stmt.executeQuery(str1);
			String resu = null;
			while(rset.next()){
				if(resu==null){
					resu=rset.getString(1);
				}
				else
					resu=resu+"\t"+rset.getString(1);
			}
			return resu;
		}
		
		public String getmenuname(String id) throws SQLException{
			String resu;
			String str1="select NAME from menu  where ID='"+id+"'";
			ResultSet rset=stmt.executeQuery(str1);
			if(!rset.next()){
				System.out.println("no id :"+id);
				resu="NULL";
			}
			else 
				resu=rset.getString(1);
			return resu;
		}
		
		public String getmenu(String id) throws SQLException{
			String str1="select * from menu  where seller_name='"+id+"'";
			System.out.println(str1);
			
			ResultSet rset1=stmt.executeQuery(str1);
			String resu = null;
			while(rset1.next()){
				if(resu==null){
					resu=rset1.getString(1)+"#"+rset1.getString(2)+"#"+rset1.getString(3)+"#"+rset1.getString(4)+"#"+rset1.getString(5)+"#"+rset1.getString(6);
					System.out.println(resu);
				}
				else
					resu=resu+rset1.getString(1)+"#"+rset1.getString(2)+"#"+rset1.getString(3)+"#"+rset1.getString(4)+"#"+rset1.getString(5)+"#"+rset1.getString(6);
			}
			System.out.println(resu);
			return resu;
		}
		public String getmyorder_buyer(String name) throws SQLException{
			String resu="";
			String str1="select seller_name,menu_id,sta from menu  where buyer_name='"+name+"'";
			ResultSet rset=stmt.executeQuery(str1);
			while(rset.next())
				resu=resu+"\t"+rset.getString(1)+"\t"+getmenuname(rset.getString(2))+"\t"+rset.getInt(3);
			return resu;
		}
		
		
		public static void main(String[] args){
		DataBase db=null;
		try{
			db=new DataBase();
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		if(db!=null){
			try {
			db.addseller("���˼��׷�","users","123","�Ͼ�","Saler0",0);
			db.addseller("�ҳ�С��","users","123","�Ͼ�","Saler1",0);
			db.addseller("������������","users","123","�Ͼ�","Saler2",0);
			db.addseller("��ѾѾ��Ʒ��","users","123","�Ͼ�","Saler3",0);
			db.addseller("��ହ�","users","123","�Ͼ�","Saler4",0);
			db.addseller("ľ��ζ����","users","123","�Ͼ�","Saler5",0);
			db.addseller("�˿˵�","users","123","�Ͼ�","Saler6",0);
			db.addseller("У���","users","123","�Ͼ�","Saler7",0);
			db.addseller("���Ҵ�Ժ","users","123","�Ͼ�","Saler8",0);
			//db.addbuyer("qqq", "qd", "1231", "131231", 0);
			//db.seller_login("Koe", "232");
			//db.buyer_login("qqq", "qd");
			db.add_menu("0#0", "���˼��׷�", (float)10.0, "���˼��׷�");
			db.add_menu("0#1", "���˼��׷�", (float)10.0, "���ſ�ଷ�");
			db.add_menu("0#2", "���˼��׷�", (float)4.0, "���빽");
			db.add_menu("0#3", "���˼��׷�", (float)10.0, "���㼦�鿧ଷ�");
			db.add_menu("0#4", "���˼��׷�", (float)3.0, "ǧ�Ž�");
			db.add_menu("0#5", "���˼��׷�", (float)2.0, "���");
			
			db.add_menu("1#0", "�ҳ�С��", (float)17.0, "����ţ�ⷹ");
			db.add_menu("1#1", "�ҳ�С��", (float)20.0, "��ˮ��+�׷�+��");
			db.add_menu("1#2", "�ҳ�С��", (float)15.0, "ˮ��ţ��+�׷�");
			db.add_menu("1#3", "�ҳ�С��", (float)15.0, "ˮ����Ƭ+�׷�");
			db.add_menu("1#4", "�ҳ�С��", (float)7.0, "���Ƽ�˿����");
			db.add_menu("1#5", "�ҳ�С��", (float)7.0, "���Ƽ�˿��Ƥ");
			
			db.add_menu("2#0", "������������", (float)13.0, "�ع����ײͷ�");
			db.add_menu("2#1", "������������", (float)22.0, "���������ײ�");
			db.add_menu("2#2", "������������", (float)13.0, "���Ƽ��ȷ�");
			db.add_menu("2#3", "������������", (float)13.0, "Ʈ�㿾Ѽ��");
			db.add_menu("2#4", "������������", (float)13.0, "�°¶������ŷ�");
			db.add_menu("2#5", "������������", (float)13.0, "Ѽ�ȷ�");
			
			db.add_menu("3#0", "��ѾѾ��Ʒ��", (float)24.0, "��ѩ����");
			db.add_menu("3#1", "��ѾѾ��Ʒ��", (float)24.0, "��ѩС����");
			db.add_menu("3#2", "��ѾѾ��Ʒ��", (float)25.0, "��âС����");
			db.add_menu("3#3", "��ѾѾ��Ʒ��", (float)16.0, "���ܹ�������");
			db.add_menu("3#4", "��ѾѾ��Ʒ��", (float)12.0, "���ϱ����鱭");
			db.add_menu("3#5", "��ѾѾ��Ʒ��", (float)22.0, "��֦��¶");
			
			db.add_menu("4#0", "��ହ�", (float)17.0, "�ƽ����㿧ଷ�");
			db.add_menu("4#1", "��ହ�", (float)10.0, "���׻���ଷ�");
			db.add_menu("4#2", "��ହ�", (float)16.0, "��଼��ŷ�");
			db.add_menu("4#3", "��ହ�", (float)10.0, "ţ����ଷ�");
			db.add_menu("4#4", "��ହ�", (float)20.0, "��ǹ�ȷ���ଷ�");
			db.add_menu("4#5", "��ହ�", (float)10.0, "���ſ�ଷ�");
			
			db.add_menu("5#0", "ľ��ζ����", (float)9.0, "�����⳴��");
			db.add_menu("5#1", "ľ��ζ����", (float)10.0, "���������ǽ���");
			db.add_menu("5#2", "ľ��ζ����", (float)16.0, "��ʽ�������");
			db.add_menu("5#3", "ľ��ζ����", (float)10.0, "�Ｙ�⵰����");
			db.add_menu("5#4", "ľ��ζ����", (float)10.0, "���ػƹ�");
			db.add_menu("5#5", "ľ��ζ����", (float)11.0, "�人������");
			
			db.add_menu("6#0", "�˿˵�", (float)8.0, "����ţ�Ɽ");
			db.add_menu("6#1", "�˿˵�", (float)10.0, "���ѿ���跹");
			db.add_menu("6#2", "�˿˵�", (float)16.0, "��ţ��ଷ�");
			db.add_menu("6#3", "�˿˵�", (float)16.0, "��ି��ⷹ");
			db.add_menu("6#4", "�˿˵�", (float)15.0, "�����ଷ�");
			db.add_menu("6#5", "�˿˵�", (float)10.0, "��������跹");
			
			db.add_menu("7#0", "У���", (float)10.0, "��ζ�����ײ�");
			db.add_menu("7#1", "У���", (float)20.0, "����ţ���ײͷ�");
			db.add_menu("7#2", "У���", (float)12.0, "����ţ���ײͷ�");
			db.add_menu("7#3", "У���", (float)21.0, "�����");
			db.add_menu("7#4", "У���", (float)8.0, "���ּ��ŷ�");
			db.add_menu("7#5", "У���", (float)8.0, "������˿�ײͷ�");
			
			db.add_menu("8#0", "���Ҵ�Ժ", (float)78.0, "�������Ϻ");
			db.add_menu("8#1", "���Ҵ�Ժ", (float)10.0, "���޷�Ƭ");
			db.add_menu("8#2", "���Ҵ�Ժ", (float)10.0, "�ڽ�ţ�ŷ�");
			db.add_menu("8#3", "���Ҵ�Ժ", (float)3.0, "���ƹ���÷��");
			db.add_menu("8#4", "���Ҵ�Ժ", (float)10.0, "���±ζ��");
			db.add_menu("8#5", "���Ҵ�Ժ", (float)10.0, "������ţ");
			//db.add_order("qdq", "qdqdq", "1210");
			//db.add_comment("0000", "qdqdqwd");
			//db.change_orderstate(0, 1);
			//System.out.println(db.search_menu("dq"));
			//db.changebuyer("qqq", "qwer", "10", null);
			//db.getmenu("qqwwd");
			//db.changeseller("00", "abc", "qwe", null, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db.close();
		}
		else
			System.out.println("cannot get a connection");
	}
}