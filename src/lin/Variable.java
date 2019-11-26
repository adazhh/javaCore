package lin;

public class Variable {


	public int id; //创建整型变量储存航班编号；

	private String flight_number;//创建字符串变量航班号；

	private String destination;//创建字符型变量终点站；

	private String start;//创建字符型变量存储；

	private String flight_date;//记录航班起飞日期；

	private int number;//创建整型变量乘员定额(number)？？

	private int surplus;//创建整型变量记录余票额；

	private int customer;//记录已经定票的客户名单

	private String grade;//记录舱位等级

	private int list;//记录等候替补客户名单；

	private Variable next;

	public Variable getNext() {
		return next;
	}

	public void setNext(Variable next) {
		this.next = next;
	}

	public Variable(int id, String flight_number, String start, String destination, String flight_date, int number, int surplus, int customer, String grade, int list){

		this.id = id;

		this.flight_number = flight_number;

		this.start = start;

		this.destination = destination;

		this.flight_date = flight_date;

		this.number = number;

		this.surplus = surplus;

		this.customer = customer;

		this.grade = grade;

		this.list = list;

	}
	// 构造方法
	public Variable(){}

	//Id

	public int getId() {

		return id;

	}

	public void setId(int id) {

		this.id = id;

	}

	//start

	public String getStart() {

		return start;

	}

	public void setStart(String start) {

		this.start = start;

	}

	//Flight_number

	public String getFlight_number() {

		return flight_number;

	}

	public void setFlight_number(String flight_number) {

		this.flight_number = flight_number;

	}

	//Destination

	public String getDestination() {

		return destination;

	}

	public void setDestination(String destination) {

		this.destination = destination;

	}

	//Flight_data

	public String getFlight_date() {

		return flight_date;

	}

	public void setFlight_date(String flight_date) {

		this.flight_date = flight_date;

	}

	//Number

	public int getNumber() {

		return number;

	}

	public void setNumber(int number) {

		this.number = number;

	}

	//Surplus

	public int getSurplus() {

		return surplus;

	}

	public void setSurplus(int surplus) {

		this.surplus = surplus;

	}

	//Customer

	public int getCustomer() {

		return customer;

	}

	public void setCustomer(int customer) {

		this.customer = customer;

	}

	//Grade

	public String getGrade() {

		return grade;

	}

	public void setGrade(String grade) {

		this.grade = grade;

	}

	//List

	public int getList() {

		return list;

	}

	public void setList(int list) {

		this.list = list;

	}

}
