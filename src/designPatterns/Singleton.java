package designPatterns;

public class Singleton {
    public static void main(String[] args) {

    }
    // 饿汉式，类初始化的时候就赋值
    private static class Single1{
        private static final Single1 instance = new Single1();
        private Single1(){}
        public static Single1 getInstance(){
            return instance;
        }
    }
    // 静态内部类
    private static class Single2{
        private Single2(){}
        private static class Inner{
            private static final Single2 instance = new Single2();
        }
        public static Single2 getInstance(){
            return Inner.instance;
        }
    }
    // 双重检查法
    private static class Single3{
        private volatile static Single3 instance;
        private Single3(){}
        public static Single3 getInstance(){
            if (instance == null){
                synchronized (Single3.class){
                    if (instance == null){
                        instance = new Single3();
                    }
                }
            }
            return instance;
        }
    }
    private static class Single4{
        private enum Single4Generator{
            INSTANCE;
            private Single4 instance = new Single4();
            private Single4 getInstance(){
                return instance;
            }
        }
        public Single4 getSingle4(){
            return Single4Generator.INSTANCE.getInstance();
        }
    }
    // 防止Java反射， 重写构造方法，判断一个字段是否已经赋值了
    // public class Singleton {
    //     private static Singleton instance;
    //     private static boolean isInstance = false;
    //
    //     private Singleton() {
    //         synchronized (Singleton.class) {
    //             if (!isInstance) {
    //                 isInstance = true;
    //             } else {
    //                 throw new RuntimeException("单例模式受到反射攻击！已成功阻止！");
    //             }
    //         }
    //     }
    //
    //     public static Singleton getInstance() {
    //         if (instance == null) {
    //             instance = new Singleton();
    //         }
    //         return instance;
    //     }
    // }

    // 防止反序列化，重写readResolve
    // public class Singleton implements Serializable {
    //     private static Singleton instance;
    //
    //     private Singleton() {}
    //
    //     public static Singleton getInstance() {
    //         if (instance == null) {
    //             instance = new Singleton();
    //         }
    //         return instance;
    //     }
    //
    //     private Object readResolve() {
    //         return instance;
    //     }
    // }
}
