package designPatterns.D01singleton;

public class Main {
    public static void main(String[] args) {
        // 方法一
        S01 S01instance1 = S01.getInstance();
        S01 S01instance2 = S01.getInstance();
        System.out.println(S01instance1 == S01instance2);
        // 方法二
        S02 S02instance1 = S02.getInstance();
        S02 S02instance2 = S02.getInstance();
        System.out.println(S02instance1 == S02instance2);
    }
}
// 单例模式一：静态常量，初始化时执行构造方法进行赋值
class S01{
    private S01(){}
    private static S01 instance = new S01();
    public static S01 getInstance(){ return instance; }
}
// 单例模式二：与一类似，使用一个静态变量，然后静态赋值，区别在方法二是在静态代码块中赋值
class S02{
    private S02(){}
    private static S02 instance;
    static {instance = new S02();}
    public static S02 getInstance(){ return instance; }
}

