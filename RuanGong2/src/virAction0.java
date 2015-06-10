import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class virAction0 extends HttpServlet {

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
		String UserName = MJ.us[id].UserName;
		//System.out.println(UserId);
		request.setAttribute("UserName", UserName);
		request.setAttribute("UserId", UserId);
		int module = Integer.parseInt(request.getParameter("module"));
		if(module == 0)                                 //查看待付订单;
		{
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
		else if(module == 1)                            //修改个人资料;
		{ 
			String []Info = new String[3];
			Info[0] = MJ.us[id].Name;
			Info[1] = MJ.us[id].Telephone;
			Info[2] = MJ.us[id].Address;
			request.setAttribute("Info", Info);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Personal.jsp");
		    dispatcher.forward(request, response);
		}
		else if(module == 2)                           //查看消息;
		{
			
			//MJ.output();
			 MJ.us[id].MesNum = 0;
			if(MJ.us[id].Saler)                            //卖家;
			{
				int count = 0;
				//System.out.println("Saler");
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
			    	  orders[cm][4] = MJ.us[MJ.orders[i][3]].Name;          
			    	  orders[cm][5] = MJ.us[MJ.orders[i][3]].Telephone;
			    	  orders[cm][6] = MJ.us[MJ.orders[i][3]].Address;
			    	  cm++;
 			       }
			    }
			    request.setAttribute("Orders", orders);
			    RequestDispatcher dispatcher = request.getRequestDispatcher("Message1.jsp");
			    dispatcher.forward(request, response);
			}
			else                                                           //买家;
			{
				//System.out.println("NotSaler");
				int count = 0;
			    
			    for(int i = 0;i<MJ.NumOrders;i++)
			    {
			       if(MJ.orders[i][3] == id&&MJ.orders[i][0]==1)              //检测到未处理订单;
			       {
			    	  count++;  
			       }
			    }
			   // System.out.println(count);
			    String [][]orders = new String[count][6];
			    int cm = 0;
			    for(int i = 0;i<MJ.NumOrders;i++)
			    {
			       if(MJ.orders[i][3] == id&&MJ.orders[i][0]==1)                       //检测到订单;
			       {
			    	  orders[cm][0] = Integer.toString(i);          //订单号，作为按钮value;
			    	  orders[cm][1] = Integer.toString(MJ.orders[i][0]);        //订单状态;
			    	  orders[cm][2] = MJ.ResName[MJ.orders[i][1]];         //餐厅名;
			    	  orders[cm][3] = MJ.DishName[MJ.orders[i][1]][MJ.orders[i][2]];         //菜名;
			    	  orders[cm][4] = Integer.toString(MJ.Price[MJ.orders[i][1]][MJ.orders[i][2]]);  //价格
			    	  orders[cm][5] = MJ.Time[i];
			    	  cm++;
 			       }
			    }
			    request.setAttribute("Orders", orders);
			    RequestDispatcher dispatcher = request.getRequestDispatcher("Message2.jsp");
			    dispatcher.forward(request, response);
				
			}
		}
		else if(module == 3)                                   //订餐记录;
		{
			int count = 0;
		    for(int i = 0;i<MJ.NumOrders;i++)
		    {
		       if(MJ.orders[i][3] == id)              //检测到与自己相关的订单;
		       {
		    	  count++;  
		       }
		       
		    }
		    System.out.println("count="+count);
		    String [][]orders = new String[count][5];
		    int cm = 0;
		    for(int i = 0;i<MJ.NumOrders;i++)
		    {
		       if(MJ.orders[i][3] == id)                       //检测到订单;
		       {
		    	  orders[cm][0] = Integer.toString(MJ.orders[i][0]);        //订单状态;
		    	  orders[cm][1] = MJ.ResName[MJ.orders[i][1]];         //餐厅名;
		    	  orders[cm][2] = MJ.DishName[MJ.orders[i][1]][MJ.orders[i][2]];         //菜名;
		    	  orders[cm][3] = Integer.toString(MJ.Price[MJ.orders[i][1]][MJ.orders[i][2]]);  //价格
		    	  orders[cm][4] = MJ.Time[i];
		    	  cm++;
			    }
		    }
		    request.setAttribute("Orders", orders);
		    RequestDispatcher dispatcher = request.getRequestDispatcher("History.jsp");
		    dispatcher.forward(request, response);
		    
		}
			 
	}

}
