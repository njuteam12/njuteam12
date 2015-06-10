import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Action1 extends HttpServlet {

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
      String action = request.getParameter("submit");
      int No = -1;
      for(int i = 0;i<MJ.NumRes;i++)
      {
    	  String resNo = "n"+Integer.toString(i);
    	  if(action.equals(resNo))
    	  {
    		  No = i;
    		  break;
    	  }
      }
      ////////////////根据No在数据库中获取餐厅名称及其菜式名称价格////////////////
	}

}
