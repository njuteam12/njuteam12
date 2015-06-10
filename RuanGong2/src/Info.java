import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Info extends HttpServlet {

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
           //  String action = request.getParameter("inputA");
          //   System.out.println(action);
		String ID = request.getParameter("UserId");
		int id = Integer.parseInt(ID);
		String UserName = request.getParameter("InputU");
		String Name = request.getParameter("InputN");
		String Address = request.getParameter("InputA");
		String Phone = request.getParameter("InputP");
		
		
		
		UserName=new String(UserName.getBytes("ISO-8859-1"),"UTF-8" );
		Name=new String(Name.getBytes("ISO-8859-1"),"UTF-8" );
		Address=new String(Address.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(Address);
		System.out.println(Name);
		
		MJ.us[id].UserName = UserName;
		MJ.us[id].Name = Name;
		MJ.us[id].Address = Address;
		MJ.us[id].Telephone = Phone;
		
		request.setAttribute("UserName", UserName);
 	    request.setAttribute("UserId", ID);
 	    MJ.us[id].getMesNum();
 	    request.setAttribute("DishNum", Integer.toString(MJ.us[id].orders.length));
 	    request.setAttribute("MesNum", Integer.toString(MJ.us[id].MesNum));
 	    RequestDispatcher dispatcher = request.getRequestDispatcher("MainPage.jsp");
	       dispatcher.forward(request, response);
		
	}

}
