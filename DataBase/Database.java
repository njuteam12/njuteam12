import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
public class DataBase {
	
		private String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //加载JDBC驱动
		private String dbURL = "jdbc:sqlserver://localhost;databaseName=lab1"; //连接服务器和数据库test
		private String userName = "zxc08ok"; //默认用户名
		private String userPwd = "12122"; //安装sql server 2005时的密码
		private Connection dbConn=null;
		private Statement stmt;
		public DataBase(){
			try{
				Class.forName(driverName);
				this.dbConn= DriverManager.getConnection(dbURL, userName, userPwd);
				stmt=dbConn.createStatement();
			}
			catch(Exception e){
				System.out.println("找不到驱动程序类 ，加载驱动失败 ");
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
				System.out.println(str);
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
						else return 3;//已经等录
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
						else return 3;//已经等录
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
					 *发送给该用户所有用户的在线情况,,并把该用户发送给所有在线用户 
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
		//返回ID
		public int add_order(String buyer_name,String  seller_name,String menuid) throws SQLException{
			Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
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
			 *发送给该用户所有用户的在线情况,,并把该用户发送给所有在线用户 
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
			db.addseller("Koe","234","2131","asdad","00",0);
			db.addbuyer("qqq", "qd", "1231", "131231", 0);
			db.seller_login("Koe", "232");
			db.buyer_login("qqq", "qd");
			db.add_menu("0000", "qqwwd", (float)32.2, "qdqwddqd");
			db.add_order("qdq", "qdqdq", "1210");
			db.add_comment("0000", "qdqdqwd");
			db.change_orderstate(0, 1);
			System.out.println(db.search_menu("dq"));
			db.changebuyer("qqq", "qwer", "10", null);
			db.getmenu("qqwwd");
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