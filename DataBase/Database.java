import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Database {
	
		private String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //加载JDBC驱动
		private String dbURL = "jdbc:sqlserver://localhost;databaseName=lab1"; //连接服务器和数据库test
		private String userName = "zxc08ok"; //默认用户名
		private String userPwd = "12122"; //安装sql server 2005时的密码
		private Connection dbConn=null;
		private Statement stmt;
		public Database(){
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
				String str="select NAME from seller where NAME='"+name+"'";
				ResultSet rset=stmt.executeQuery(str);
				System.out.println("qqqq");
				try {
					if(!rset.next()){
						String queryString="insert into seller values('"+name+"','"+psw+"','"+phone+"','"+address+"','"+id+"','"+on+")";
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
		public static void main(String[] args){
		Database db=null;
		try{
			db=new Database();
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		if(db!=null){
			System.out.println("qqq2");
			try {
			db.addseller("Koe","234","2131","asdad","00",0);
			//db.addword("me",1,2,1);
			//db.zan(2,"me");
			//int []ra=new int[3];
			//ra=db.rank("me");
			//System.out.print(ra[0]+" "+ra[1]+" "+ra[2]);
			//db.user_offline("Koe");
			//System.out.println(db.user_login("Koe","234")); 
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