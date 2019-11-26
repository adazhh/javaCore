package lin;

public class LinkedList {
	private Variable head; // 头结点

	private Variable last; // 尾结点
	private int size; // 结点长度
	/**	 * 构造方法：初始化头结点和尾结点	 */
	LinkedList() {
		head = new Variable();
		last = head; // 初始状态头结点与尾结点指向同一个结点
	}

	/**	 * 增加操作	 * 	 * @param obj 要添加的结点数据	 */
	public void add(Object obj) {		// 先创建一个结点
		Variable node = new Variable(obj);		// 把新建的结点加入到链表中
		last.setNext(node);		// 更改last的指向
		last = node;		// 更改结点长度
		size++;
	}
	/**	 * 插入操作	 * 	 * @param desIndex 插入的目标位置下标	 * @param obj      插入的结点数据	 */
	public void add(int desIndex, Object obj) {		// 判断下标是否合法
		if (desIndex < 0 || desIndex > size+1) { //(+1是因为，允许插入到尾部)
			try {
				throw new Exception("下标越界");
			}
			catch (Exception e) {				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {			// 其他地方可以正常插入，先创建一个结点
			Variable node = new Variable(obj);			// 插入到头结点后一个位置
			if (desIndex == 0) {				// 先把新结点的next指向原本头结点指向的位置
				node.setNext(head.getNext());				// 使头结点的next指向新建立的结点
				head.setNext(node);
				// size增加
				size++;			}
			// 其他位置
			else {				// 首先需要从头遍历找到要插入位置的前一个结点
				Variable before = head;
				for (int i = 0; i < desIndex; i++) {
					before = before.getNext();
				}				// 循环结束，找到了before的位置
				// 先把新建的结点的next指向before的next结点
				node.setNext(before.getNext());
				// 将before的next指向新创建的结点
				before.setNext(node);
				// 若创建的结点是最后一个，需要重新设置last
				if (desIndex == size) {
					last = node;
				}
			}
		}
	}
	/**	 * 查找操作	 * 	 * @param obj 需要查找的结点数据	 * @return 返回结点位置下标。若没有找到，返回-1	 */
	public int search(Object obj) {
		int index = -1; // 记录下标
		Variable node = head;		// 遍历链表进行查找
		for (int i = 0; i < size; i++) {
			node = node.getNext();			// 判断
			if (node.getData() == obj) {
				index = i;
				break; // 退出循环
			}
		}
		return index;
	}
	/**	 * 更改操作	 * @param desIndex 需要更改的结点位置下标	 * @param obj 需要更改的结点新数据	 */
	public void set(int desIndex, Object obj) {		// 判断位置下标是否合法
		if (desIndex < 0 || desIndex > size) {
			try {
				throw new Exception("下标越界");
			} catch (Exception e) {				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			Variable node=head; //获得要删除的结点
			//遍历获得
			for(int i=0;i<=desIndex;i++) {
				node=node.getNext();
			}			//更改数据
			node.setData(obj);		}
	}

}





                      

