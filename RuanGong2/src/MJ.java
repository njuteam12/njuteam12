
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
   public static int[][] orders;                 //店号#菜式号#订购人id;
   public static String [] Time;
   public static int NumOrders;
   public static int first = 0;
   public static DataBase db;
   public MJ()                      //通过数据库获取;
   {
	   if(first != 1)
	   {
		  db=new DataBase();
	       first = 1;
	       ResName = new String[NumRes];
	       for(int i = 0;i<NumRes;i++)
		   ResName[0] = "黄焖鸡米饭";
	       ResName[1] = "家常小炒";
	       ResName[2] = "饭点甜品外卖";
	       ResName[3] = "甜丫丫甜品店";
	       ResName[4] = "咖喱馆";
	       ResName[5] = "木子味中仙";
	       ResName[6] = "仕克德";
	       ResName[7] = "校点点";
	       ResName[8] = "郭家大院";
	       DishName = new String[9][6];
	       Price = new int[9][6];
	       for(int i = 0;i<9;i++)
	       {
	    	   DishName[i][0] ="黄焖鸡米饭";
		       Price[i][0] = 10;
		       DishName[i][1] ="鸡排咖喱饭";
		       Price[i][1] = 10;
		       DishName[i][2] ="金针菇";
		       Price[i][2] = 4;
		       DishName[i][3] ="米香鸡块咖喱饭";
		       Price[i][3] = 10;
		       DishName[i][4] ="千张结";
		       Price[i][4] = 3;
		       DishName[i][5] ="青菜";
		       Price[i][5] = 2;
	        }
	       orders = new int[1000][6];
	       Time = new String[1000];
	       for(int i = 0;i<1000;i++)
	    	   Time[i] = "18:00";
	   }
   } 
   public static int get_Num()                 //获取id信息;
   {
	    N++;
		if(N>MAXUSERS)
		   N = 0;
		us[N] = new Users();
		return N;
   }
   public static void addOrder(int ResNo,int DishNo,int id)       //总控制系统添加订单;
   {
	   orders[NumOrders][0] = 0;          //0未经处理;1处理中;2完成
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
