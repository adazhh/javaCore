package lin;

public class Test {


	public static void main(String[] args) {		// TODO Auto-generated method stub
		//创建链表
		LinkedList myInt =new LinkedList();
		myInt.add(7);
		myInt.add(8);
		myInt.add(8);
		myInt.add("a");
		System.out.println(myInt.toString());
		myInt.add(7,"add1");
		myInt.add(8,"add2");
		myInt.add(8,"add3");
		System.out.println(myInt.toString());
		System.out.println(myInt.search(8));
		System.out.println(myInt.search(7));
	}
}



