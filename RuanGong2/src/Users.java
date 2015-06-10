
public class Users {

	public String UserName;                               //用户名;
	public String Name;                                    //名字;
	public boolean loading;                               //登陆状态;
	public boolean Saler;                                 //false代表买家，true代表卖家;
	public int numOrder;                                  //订单数量;
	public static int s = 0;        
	public static int CurrentRes;                               //当前餐厅
	public int[][] orders;                               //发送订单(orders[0]记录是否处理，orders[1]记录餐厅号，orders[2]记录菜式，orders[3]记录价格)  
	public int allpills = 0;                             //总价值;
	public int MesNum;                                    //消息数目;
	public String Telephone;
	public String Address;
	public int[][] Recv;                                  //接收的消息;
	public int id;
	
	public Users()
	{
		MesNum = 0;
		
	}
	public void setName(String s,int ID)
	{
		///////////根据数据库查找;
		id = ID;
		UserName = s;
		getMesNum();
		
		orders = new int[1000][4];
		numOrder = 0;
		Saler = false;
		if(UserName.length()>5)
		{
			if(UserName.substring(0,5).equals("Saler"))
		    {
			  Saler  = true;
		    }
		}
		/////
		Name = UserName;
		Telephone =MJ.db.getphone(UserName);
		Address = MJ.db.getaddr(UserName);
		System.out.println("NAME:"+UserName+"phone:"+Telephone+" address:"+Address);
	}
	public void addOrder(int NoRes,int NoDish,int Pills)
	{		
		
		orders[numOrder][0] = 0;                  //未支付;
		orders[numOrder][1] = NoRes;              //餐厅号;
		orders[numOrder][2] = NoDish;             //菜式号;
		orders[numOrder][3] = Pills;              //单价;
		allpills+=Pills;
		numOrder++;
		//System.out.println("s"+numOrder);
		//MJ.addOrder(NoRes, NoDish, id);
	}
	public void deleteOne(int index)                                 //删除某条order;
	{
		allpills-=orders[index][3];
		numOrder--;
		for(int i = index;i<numOrder;i++)
		{
			for(int j = 0;j<4;j++)
			{
				orders[i][j]=orders[i+1][j];
			}
		}
	}
	public void submit(int Index)
	{
		MJ.addOrder(orders[Index][1], orders[Index][2], id);
		System.out.println(orders[Index][1]);
	}
	public void getMesNum()
	{
		int count = 0;
		if(Saler)
		{
	        int No = Integer.parseInt(UserName.substring(5));
	        for(int i = 0;i<MJ.NumOrders;i++)
	        {
	          if(MJ.orders[i][1] == No&&MJ.orders[i][0]==0)              //检测到未处理订单;
	          {
	    	     count++;  
	          }
	        }
		}
		for(int i = 0;i<MJ.NumOrders;i++)
	    {
	       if(MJ.orders[i][3] == id&&MJ.orders[i][0]==1)              //检测到未处理订单;
	       {
	    	  count++;  
	       }
	    }
		MesNum = count;
	}
}
