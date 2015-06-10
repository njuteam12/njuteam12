import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Action2 extends HttpServlet {

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
        String action = request.getParameter("submit");//获取餐厅号;
        int no = Integer.parseInt(action)-1;
        int dishNum = 9;
        ///////////////////////
       /* String ResName = "老友记黄焖鸡米饭";
        String []Names = new String[dishNum];
        String []Prices = new String[dishNum];
        for(int i = 0;i<dishNum;i++)
        {
        	Names[i] = "干锅牛蛙";
        	Prices[i] = "15";
        }*/
        
        String ResName = MJ.ResName[no];
        String []Names = MJ.DishName[no];
        String []Prices = new String[6];
        for(int i = 0;i<6;i++)
        	Prices[i] = Integer.toString(MJ.Price[no][i]);
        
        
        String UserId = request.getParameter("UserId");
        //System.out.println(UserId);
		int id = Integer.parseInt(UserId);
	    
		
		
		
		
		String UserName = MJ.us[id].UserName;
		MJ.us[id].CurrentRes = no;
		/////////////////////////////
		request.setAttribute("UserId", UserId);
		request.setAttribute("UserName",UserName);
		request.setAttribute("MesNum", Integer.toString(MJ.us[id].numOrder));
		MJ.us[id].getMesNum();
		request.setAttribute("MesNum2", Integer.toString(MJ.us[id].MesNum));
		
		//发送评论;
		String []Comments = new String[6];
		for(int i = 0;i<6;i++)
			Comments[i] = "";
		try {
			Comments=MJ.db.returncomment(MJ.ResName[no]);
			System.out.println(MJ.ResName[no]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Comments[0]);
		///////////
		request.setAttribute("Comments", Comments);
		
		
        request.setAttribute("ResName", ResName);
        request.setAttribute("Names", Names);
        request.setAttribute("Prices", Prices);
        request.setAttribute("no", Integer.toString(no+1));
        RequestDispatcher dispatcher = request.getRequestDispatcher("Dishes.jsp");
	    dispatcher.forward(request, response);
        	
		
	}

}
