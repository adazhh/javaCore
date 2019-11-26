package lin;
import java.util.*;
import java.util.Vector;/* * Vector容器存放购票的客户*/
import java.util.ArrayList;
//创建一个全局Vector容器，供各个方法之间相互访问使用
public class Method {

	static Vector<String> KH = new Vector<String>();

	//列出所有航班的方法

	public void all_flight(ArrayList<Variable> flight){

		System.out.println("编号\t 航班号\t起始地\t目的地\t" +
				"起飞日期\t\t成员定额\t\t余票量\t已订票票的客户人数" +
				"\t舱位等级\t\t等候替补客户人数");

		for(Variable e:flight)  //增强for循环，遍历

			System.out.println(e.getId()+"\t"+e.getFlight_number()+"\t"+
					e.getStart()+"\t"+e.getDestination()+"\t"+e.getFlight_date()+
					"\t"+e.getNumber()+"\t"+"\t"+e.getSurplus()+"\t"+"\t"+
					e.getCustomer()+"\t"+"\t"+e.getGrade()+"\t"+"\t"+"\t"+e.getList());

	}

	//按起飞时间查询的方法

	public void inquiry_date(ArrayList<Variable> flight){

		System.out.print("请输入日期：");

		Scanner in=new Scanner(System.in);

		String date=in.next();

		for(Variable e:flight)

		{

			if(e.getFlight_date().equals(date)){

				System.out.println("编号\t 航班号\t起始地\t目的地\t" +
						"起飞日期\t\t成员定额\t\t余票量\t已订票票的客户人数\t" +
						"舱位等级\t\t等候替补客户人数");

				System.out.println(e.getId()+"\t"+e.getFlight_number()
						+"\t"+e.getStart()+"\t"+e.getDestination()+"\t"+
						e.getFlight_date()+"\t"+e.getNumber()+"\t"+"\t"+
						e.getSurplus()+"\t"+"\t"+e.getCustomer()+"\t"+"\t"+e.getGrade()
						+"\t"+"\t"+"\t"+e.getList());

			}

		}

	}

	//按目的地查询的方法

	public void inquiry_destination(ArrayList<Variable> flight){

		System.out.print("请输入目的地：");

		Scanner in=new Scanner(System.in);

		String destination=in.next();

		for(Variable e:flight)

		{

			if(e.getDestination().equals(destination)){

				System.out.println("编号\t 航班号\t起始地\t目的地\t起飞日期\t\t" +
						"成员定额\t\t余票量\t已订票票的客户人数\t舱位等级\t\t等候替补客户人数");

				System.out.println(e.getId()+"\t"+e.getFlight_number()+"\t"+e.getStart()+"\t"+
						e.getDestination()+"\t"+e.getFlight_date()+"\t"+e.getNumber()+"\t"+
						"\t"+e.getSurplus()+"\t"+"\t"+e.getCustomer()+"\t"+"\t"+e.getGrade()+
						"\t"+"\t"+"\t"+e.getList());

			}

		}
	}


	//删除航班的方法

	/*

	* 方法一：用remove(index)方式删除记录，此处需要注意的是调用Iterator方法，

	* 避免产生ConcurrentModificationException异常

	*

	public void delete_flight(ArrayList<AirInfo> flight){

	System.out.print("请输入需要删除的航班编号：");

	Scanner in=new Scanner(System.in);

	int id=in.nextInt();

	Iterator<AirInfo> iterator = flight.iterator();

	while(iterator.hasNext()){

	AirInfo e = iterator.next();

	if(e.getId()==id){

	iterator.remove();

	System.out.println("删除成功！");

	}

	}

	}

	*/

	/*

	 * 方法二：将需要删除的记录用一个ArrayList()类包装起来，

	 * 用removeAll(Collection<?> c)方法将其删除

	 */



	//更新航班的方法

	public void update_flight(ArrayList<Variable> flight){

		Scanner in=new Scanner(System.in);

		int id;

		String flight_number;

		String destination;

		String start;

		String flight_date;

		int number;

		int surplus;

		int customer;

		String grade;

		int list;

		//id

		System.out.print("请输入需要更新的航班编码：");

		id = in.nextInt();

		//flight_number

		System.out.print("请输入新的航班号：");

		flight_number = in.next();

		//destination

		System.out.print("请输入新的目的地：");

		destination = in.next();

		//flight_data

		System.out.print("请输入新的起飞日期：");

		flight_date = in.next();

		//number

		System.out.print("请输入新的成员定额：");

		number = in.nextInt();

		//surplus

		System.out.print("请输入新的余票量：");

		surplus = in.nextInt();

		//customer

		System.out.print("请输入新的已订票的客户名单：");

		customer = in.nextInt();

		//grade

		System.out.print("请输入新的舱位等级：");

		grade = in.nextLine();

		//list

		System.out.print("请输入新的等候替补客户名单：");

		list = in.nextInt();

		flight.add(new Variable(id,flight_number,destination,flight_date,grade, number,surplus,customer,grade,list));

		System.out.println("更新成功！");

	}

	public void delete_flight(ArrayList<Variable> flight){

		System.out.print("请输入需要删除的航班编号：");

		Scanner in=new Scanner(System.in);

		List delList = new ArrayList();

		int id=in.nextInt();

		for(Variable e:flight)

		{

			if(e.getId()==(id))

				delList.add(e);

		}

		flight.removeAll(delList);

		System.out.println("删除成功！");

	}
	//买票

	public void buy(ArrayList<Variable> flight) {

		// TODO 自动生成的方法存根

		System.out.println("请输入要购买的航班号：");

		Scanner in=new Scanner(System.in);

		String hbh = in.next();

		KH.addElement(hbh);

		System.out.println("请稍后，正在购票中...");

		System.out.println("购票成功！");

		System.out.println("您的航班号为"+hbh+"\n"+"相关信息如下：");

		for(Variable e:flight)

		{

			if(e.getFlight_number().equals(hbh)){

				System.out.println("编号\t 航班号\t起始地\t目的地\t起飞日期\t\t成员定额\t\t余票量\t已订票票的客户人数\t舱位等级\t\t等候替补客户人数");

				System.out.println(e.getId()+"\t"+e.getFlight_number()+"\t"+e.getStart()+"\t"+e.getDestination()+"\t"+e.getFlight_date()+"\t"+e.getNumber()+"\t"+"\t"+e.getSurplus()+"\t"+"\t"+e.getCustomer()+"\t"+"\t"+e.getGrade()+"\t"+"\t"+"\t"+e.getList());

			}

		}
	}


	//退票

	public void not(ArrayList<Variable> flight) {

		// TODO 自动生成的方法存根

		System.out.println("请输入需要退票的航班号：");

		Scanner in=new Scanner(System.in);

		String hbh = in.next();

		System.out.println("请稍后，正在退票中...");

		for(Variable e:flight)

		{

			if(e.getFlight_number().equals(hbh)){

				KH.clear(); //清空KH容器集合

			}

		}

		System.out.println("退票成功！");





	}
	//退出系统的方法

	public void exit(){

		System.out.println("成功退出系统！");

		System.exit(0);

	}


}
