package WriteTest;

/**
 * 此代码在idea编写，不知道是否允许，打开时间大致为10：55
 */
public class Test02 {
    public static void main(String[] args) {
        continousString("abab");
    }
    private static void continousString(String s){
        String constinous = s + s;
        String sub = "";
        int length = s.length();
        int index = length;
        for (int i = length-1; i >= 1; i--){
            sub = s.substring(i, length);
            if (s.startsWith(sub)){
                index = i;
            }
        }
        if (index != length){
            constinous = s + s.substring(length - index, length);
        }
        System.out.println("最短重复字符串为：" + constinous);
    }
}
