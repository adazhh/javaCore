package algorithmBuck.recursionAndDynamic;

public class R02Hanoi {
    public static void hanoi(int N){
        if (N < 1) return;
        process(N, "左", "右", "中");
    }
    public static void process(int rest, String from, String to, String help){
        if (rest == 1){
            System.out.println("把1从" + from + "移动到" + to);
            return;
        }
        process(rest-1, from, help, to);
        System.out.println("把" + rest + "从" + from + "移动到" + to);
        process(rest - 1, help, to, from);
    }

    public static void main(String[] args) {
        hanoi(3);
    }
}
