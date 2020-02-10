package algorithm.recursionAndDynamic;

public class R06Knpsack {
    public static int maxValue(int[] weight, int[] value, int bag){
        return process(weight, value, 0, 0, bag);
    }

    private static int process(int[] weight, int[] value, int index,
                               int alreadyWeight, int bag) {
        if (bag <= 0) return 0;
        if (index == weight.length){
            return 0;
        }
        return Math.max(
                process(weight, value, index+1, alreadyWeight, bag), // 不加入该物品
                value[index] + process(weight, value, index+1, // 加入该物品
                        alreadyWeight+weight[index] ,bag)
        );
    }
}
