import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Action4 extends HttpServlet {

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
		String UserId = request.getParameter("UserId");
		int id = Integer.parseInt(UserId);
		String action = request.getParameter("submit");
		int no = Integer.parseInt(action);               //订单序号;
		MJ.orders[no][0] = 1;                            //已处理;
		
		String Time = request.getParameter(Integer.toString(no));        //处理时间;
		if(Time!=null)
		{
			MJ.Time[no] = Time;
		}
		int count = 0;
		System.out.println("Saler");
	    int No = Integer.parseInt(MJ.us[id].UserName.substring(5));
	    for(int i = 0;i<MJ.NumOrders;i++)
	    {
	       if(MJ.orders[i][1] == No&&MJ.orders[i][0]==0)              //检测到未处理订单;
	       {
	    	  count++;  
	       }
	    }
	    String [][]orders = new String[count][7];
	    int cm = 0;
	    for(int i = 0;i<MJ.NumOrders;i++)
	    {
	       if(MJ.orders[i][1] == No&&MJ.orders[i][0]==0)                       //检测到订单;
	       {
	    	  orders[cm][0] = Integer.toString(i);          //订单号，作为按钮value;
	    	  orders[cm][1] = Integer.toString(MJ.orders[i][0]);        //订单状态;
	    	  orders[cm][2] = MJ.DishName[No][MJ.orders[i][2]];         //菜名
	    	  orders[cm][3] = Integer.toString(MJ.Price[No][MJ.orders[i][2]]);  //价格
	    	  orders[cm][4] = MJ.us[MJ.orders[i][3]].UserName;          
	    	  orders[cm][5] = MJ.us[MJ.orders[i][3]].Telephone;
	    	  orders[cm][6] = MJ.us[MJ.orders[i][3]].Address;
	    	  cm++;
		   }
	    }
	    MJ.us[id].getMesNum();
		request.setAttribute("MesNum2", Integer.toString(MJ.us[id].MesNum));
        String UserName = MJ.us[id].UserName;
		request.setAttribute("UserId", UserId);
		request.setAttribute("UserName",UserName);
	    request.setAttribute("Orders", orders);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("Message1.jsp");
	    dispatcher.forward(request, response);
	}

}
