## 数组
##### 1.普通的二分查找：B01BinarySearch  

##### 2.寻找左侧边界/右侧边界的二分查找：B02BinarySearchLeft  

## 位运算
##### 1.一个数组中有一个数出现了奇数次，其他数都出现了偶数次，怎么找到这一个数？B01OddTimesNum

因为其他的^异或满足交换律和结合律，任意调整顺序不影响结果，相当于偶数次的数异或完再异或奇数次的数，又因为N^N=0,N^0=N，所以异或的结果就是基数的值

##### 2.一个数组中有两个个数出现了奇数次，其他数都出现了偶数次，怎么找到这两个数

