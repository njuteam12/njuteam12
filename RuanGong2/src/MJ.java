
public class MJ {
   public static int MAXUSERS=10000;
   public static Users []us = new Users[MAXUSERS];
   public static int have_D = 0;
   public static int N = -1;
   public static int NumRes = 9;
   public static int NumDish = 6;
   public static String[] ResName;
   public static String[][] DishName;
   public static int[][] Price;
   public static int[][] orders;                 //���#��ʽ��#������id;
   public static String [] Time;
   public static int NumOrders;
   public static int first = 0;
   public static DataBase db;
   public MJ()                      //ͨ�����ݿ��ȡ;
   {
	   if(first != 1)
	   {
		  db=new DataBase();
	       first = 1;
	       ResName = new String[NumRes];
	       for(int i = 0;i<NumRes;i++)
		   ResName[0] = "���˼��׷�";
	       ResName[1] = "�ҳ�С��";
	       ResName[2] = "������Ʒ����";
	       ResName[3] = "��ѾѾ��Ʒ��";
	       ResName[4] = "��ହ�";
	       ResName[5] = "ľ��ζ����";
	       ResName[6] = "�˿˵�";
	       ResName[7] = "У���";
	       ResName[8] = "���Ҵ�Ժ";
	       DishName = new String[9][6];
	       Price = new int[9][6];
	       for(int i = 0;i<9;i++)
	       {
	    	   DishName[i][0] ="���˼��׷�";
		       Price[i][0] = 10;
		       DishName[i][1] ="���ſ�ଷ�";
		       Price[i][1] = 10;
		       DishName[i][2] ="���빽";
		       Price[i][2] = 4;
		       DishName[i][3] ="���㼦�鿧ଷ�";
		       Price[i][3] = 10;
		       DishName[i][4] ="ǧ�Ž�";
		       Price[i][4] = 3;
		       DishName[i][5] ="���";
		       Price[i][5] = 2;
	        }
	       orders = new int[1000][6];
	       Time = new String[1000];
	       for(int i = 0;i<1000;i++)
	    	   Time[i] = "18:00";
	   }
   } 
   public static int get_Num()                 //��ȡid��Ϣ;
   {
	    N++;
		if(N>MAXUSERS)
		   N = 0;
		us[N] = new Users();
		return N;
   }
   public static void addOrder(int ResNo,int DishNo,int id)       //�ܿ���ϵͳ��Ӷ���;
   {
	   orders[NumOrders][0] = 0;          //0δ������;1������;2���
	   orders[NumOrders][1] = ResNo;
	   orders[NumOrders][2] = DishNo;
	   orders[NumOrders][3] = id;
	   orders[NumOrders][4] = 0;           //hours;
	   orders[NumOrders][5] = 0;           //minutes;
	 //  System.out.println("ResNo="+ResNo);
	   //MJ.us[ResNo].MesNum++;
	   NumOrders++;   
	  // System.out.println(NumOrders);
   }
   public static void output()
   {
	   /*System.out.println("this"+NumOrders);
	   System.out.println("------------------");
	   for(int i = 0;i<NumOrders;i++)
	   {
		   for(int j = 0;j<6;j++)
		     System.out.print(orders[i][j]);
		   System.out.println("");
	   }
	   System.out.println("------------------");*/
	   System.out.println(first);
   }
}
