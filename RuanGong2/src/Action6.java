import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Action6 extends HttpServlet {

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
           String NO = request.getParameter("submit");
           String UserId = request.getParameter("UserId");
           int id = Integer.parseInt(UserId);
           String UserName = MJ.us[id].UserName;
      		//System.out.println(UserId);
           request.setAttribute("UserName", UserName);
           request.setAttribute("UserId",UserId);
           if(NO.equals("refresh"))
           {
        	 
               
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
           else
           {
           int no = Integer.parseInt(NO);                    //序号;
           String text = request.getParameter(NO);           //评价;
           if(text.length()>0)
           {
        	   text=new String(text.getBytes("ISO-8859-1"),"UTF-8" );
               MJ.orders[no][0]=2;
               String comments = "<p>"+MJ.us[id].Name+"："+text+"</p>";
   		       System.out.println(comments);
   		       int no1 = MJ.orders[no][1];
   		       int no2 = MJ.orders[no][2];
   		       String menuid = Integer.toString(no1)+"#"+Integer.toString(no2);
   		       System.out.println(menuid);
   		       try {
				MJ.db.add_comment(menuid, comments);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
   		      request.setAttribute("UserName", UserName);
           }
           
           
           
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

}
