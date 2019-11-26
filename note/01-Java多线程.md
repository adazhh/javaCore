# Java并发编程

#### 阻塞队列

1. ArrayBlockingQueue 有界队列
2. LinkedBlockingQueue 无界
3. PriorityBlockingQueue 由优先级堆支持的无界优先级队列
4. DelayQueue 由优先级堆支持的，基于时间的调度队列



### condition只能在独占模式使用

#### hashmap并发不安全

hashmap1.7会产生死锁，1.8不会；扩容期间存在节点位置互换指针引用的问题



