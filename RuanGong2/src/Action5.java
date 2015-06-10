import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Action5 extends HttpServlet {

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
        String button = request.getParameter("submit");
        String UserId = request.getParameter("UserId");
		int id = Integer.parseInt(UserId);
		String UserName = MJ.us[id].UserName;
		//System.out.println(UserId);
		request.setAttribute("UserName", UserName);
		request.setAttribute("UserId", UserId);
        if(button.equals("changeInfo"))              //修改信息;
        {
        	String []Info = new String[3];
			Info[0] = MJ.us[id].Name;
			Info[1] = MJ.us[id].Telephone;
			Info[2] = MJ.us[id].Address;
			request.setAttribute("Info", Info);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Personal.jsp");
		    dispatcher.forward(request, response);
        }
        else                                       
        {
        	
        	if(button.length()>0)
        	{
        		System.out.println(button);
        		if(button.charAt(0)!='b')                       //删除;
        		{
        			int no = Integer.parseInt(button);
        		    MJ.us[id].deleteOne(no);
        		    String[][] orders = new String[MJ.us[id].numOrder][4];
     		        for(int i = 0;i<MJ.us[id].numOrder;i++)
     		        {
     			      orders[i][0] = Integer.toString(MJ.us[id].orders[i][0]);
     			      orders[i][1] = MJ.ResName[MJ.us[id].orders[i][1]];
     			      orders[i][2] = MJ.DishName[MJ.us[id].orders[i][1]][MJ.us[id].orders[i][2]];
     			      orders[i][3] = Integer.toString(MJ.Price[MJ.us[id].orders[i][1]][MJ.us[id].orders[i][2]]);
     		        }
     		        request.setAttribute("Orders", orders);
     		        request.setAttribute("AllPills", Integer.toString(MJ.us[id].allpills));	
                			
      	            RequestDispatcher dispatcher = request.getRequestDispatcher("Plate.jsp");
     	            dispatcher.forward(request, response);
        		}
        		else                                            //结算;
        		{
        			//System.out.println("结算");
        			int no = Integer.parseInt(button.substring(1));
        			MJ.us[id].submit(no);
        			MJ.us[id].deleteOne(no);
        			String[][] orders = new String[MJ.us[id].numOrder][4];
     		        for(int i = 0;i<MJ.us[id].numOrder;i++)
     		        {
     			      orders[i][0] = Integer.toString(MJ.us[id].orders[i][0]);
     			      orders[i][1] = MJ.ResName[MJ.us[id].orders[i][1]];
     			      orders[i][2] = MJ.DishName[MJ.us[id].orders[i][1]][MJ.us[id].orders[i][2]];
     			      orders[i][3] = Integer.toString(MJ.Price[MJ.us[id].orders[i][1]][MJ.us[id].orders[i][2]]);
     		        }
     		        request.setAttribute("Orders", orders);
     		        request.setAttribute("AllPills", Integer.toString(MJ.us[id].allpills));	
                			
      	            RequestDispatcher dispatcher = request.getRequestDispatcher("Plate.jsp");
     	            dispatcher.forward(request, response);
        		}
        	}
        }
	}

}
