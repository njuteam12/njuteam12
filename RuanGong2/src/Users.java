
public class Users {

	public String UserName;                               //�û���;
	public String Name;                                    //����;
	public boolean loading;                               //��½״̬;
	public boolean Saler;                                 //false������ң�true��������;
	public int numOrder;                                  //��������;
	public static int s = 0;        
	public static int CurrentRes;                               //��ǰ����
	public int[][] orders;                               //���Ͷ���(orders[0]��¼�Ƿ���orders[1]��¼�����ţ�orders[2]��¼��ʽ��orders[3]��¼�۸�)  
	public int allpills = 0;                             //�ܼ�ֵ;
	public int MesNum;                                    //��Ϣ��Ŀ;
	public String Telephone;
	public String Address;
	public int[][] Recv;                                  //���յ���Ϣ;
	public int id;
	
	public Users()
	{
		MesNum = 0;
		
	}
	public void setName(String s,int ID)
	{
		///////////�������ݿ����;
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
		
		orders[numOrder][0] = 0;                  //δ֧��;
		orders[numOrder][1] = NoRes;              //������;
		orders[numOrder][2] = NoDish;             //��ʽ��;
		orders[numOrder][3] = Pills;              //����;
		allpills+=Pills;
		numOrder++;
		//System.out.println("s"+numOrder);
		//MJ.addOrder(NoRes, NoDish, id);
	}
	public void deleteOne(int index)                                 //ɾ��ĳ��order;
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
	          if(MJ.orders[i][1] == No&&MJ.orders[i][0]==0)              //��⵽δ������;
	          {
	    	     count++;  
	          }
	        }
		}
		for(int i = 0;i<MJ.NumOrders;i++)
	    {
	       if(MJ.orders[i][3] == id&&MJ.orders[i][0]==1)              //��⵽δ������;
	       {
	    	  count++;  
	       }
	    }
		MesNum = count;
	}
}
