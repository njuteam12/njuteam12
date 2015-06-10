import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Action0 extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	//	String hz=request.getParameter("Username");
	//	hz=new String(hz.getBytes("ISO-8859-1"),"UTF-8" );
	
        String action = request.getParameter("submit");
       // request.setAttribute("UserName", "kobe");
        MJ jordan = new MJ();
        if(action.equals("SignIn"))
        {
        	String UserName = request.getParameter("userName");
        	UserName=new String(UserName.getBytes("ISO-8859-1"),"UTF-8" );
        	String PassWd = request.getParameter("pwd");
        	if(UserName.length()==0||PassWd.length()==0)
        	{
        	   RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
 		       dispatcher.forward(request, response);
        	}
        	else{
        		int succed = 0;
        		System.out.println(UserName+":"+PassWd);
         	   try {
 				succed=MJ.db.buyer_login(UserName, PassWd);
 				/*
 				 * 0 成功
 				 * 1 错误ID
 				 * 2 错误密码
 				 * 3 已经登陆
 				 */
 			} catch (SQLException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
 			System.out.println(succed);
 			if(succed==0||succed==3){
         	   int ID = MJ.get_Num();                           //获取该用户的ID;
         	   MJ.us[ID].setName(UserName,ID);
         	   request.setAttribute("UserName", UserName);
         	   request.setAttribute("UserId", Integer.toString(ID));
         	   MJ.us[ID].getMesNum();
         	   request.setAttribute("MesNum", Integer.toString(MJ.us[ID].MesNum));
         	   RequestDispatcher dispatcher = request.getRequestDispatcher("MainPage.jsp");
 		       dispatcher.forward(request, response);
         	}
 			else
 			{
 				//...弹框
 				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
 	 		      dispatcher.forward(request, response);
 			}
        	}
        }
        else if(action.equals("SignUp"))
        {
        	String name  = request.getParameter("InputName");
            String passwd=request.getParameter("InputPasswd");
            String phone=request.getParameter("InputPhone");
            String address=request.getParameter("InputAddress");
            name=new String(name.getBytes("ISO-8859-1"),"UTF-8" );
            address=new String(address.getBytes("ISO-8859-1"),"UTF-8" );
           // System.out.println(name+":"+passwd);
            boolean sucess=false;
        	try {
				sucess=MJ.db.addbuyer(name, passwd, phone, address, 0);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(sucess)
			    System.out.println("sucess");
			else
				System.out.println("unsucess");		
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	 		dispatcher.forward(request, response);
        }
		
	}

}
