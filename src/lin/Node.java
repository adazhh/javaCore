package lin;

public class Node {
	private Object data; //数据域
	private Node next; //引用，指向下一个结点
	//构造方法
	public Node() {		// TODO Auto-generated constructor stub
	}
	//构造方法：传入数据，置空next
	public Node(Object data) {
		this.data = data;
		this.next = null;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}


