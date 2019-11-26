package lin;

import java.util.ArrayList;
import java.util.Scanner;
//启动和运行程序
public class Main {
	static{
		System.out.println("欢迎来到航班购票系统！");
		System.out.println("1.列出所有航班,2.按起飞时间查询,3.按目的地查询,4.删除航班,5.更新航班,6.购票系统,7.退票系统,8.退出系统");
		System.out.print("请选择要操作的序号：");
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		Method airInfoManager=new Method();//用Arraylist表示航班信息
		ArrayList<Variable> flight=new ArrayList<>();//为数组增加记录
		flight.add(new Variable(1,"k112","广州","成都","2019-11-15",600,20,580,"经济舱",10));

		flight.add(new Variable(2,"k113","深圳","上海","2019-11-15",700,30,670,"商务舱",15));

		flight.add(new Variable(3,"k114","新疆","上海","2019-11-16",800,50,750,"经济舱",50));

		Scanner in=new Scanner(System.in);

		while(true){

			switch(in.nextInt()){
				case 1:
					airInfoManager.all_flight(flight);
					break;
				case 2:
					airInfoManager.inquiry_date(flight);
					break;
				case 3:
					airInfoManager.inquiry_destination(flight);
					break;
				case 4:
					airInfoManager.delete_flight(flight);
					break;
				case 5:
					airInfoManager.update_flight(flight);
					break;
				case 6:
					airInfoManager.buy(flight);
					break;
				case 7:
					airInfoManager.not(flight);
					break;
				case 8:
					airInfoManager.exit();
				default:System.out.println("对不起，您输入的数字无效。请输入1~8之间的数字：");

			}

			System.out.println();

		}

	}


}
