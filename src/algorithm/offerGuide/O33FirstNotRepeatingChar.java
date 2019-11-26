package algorithm.offerGuide;

public class O33FirstNotRepeatingChar {
    public static void main(String[] args) {
        O33FirstNotRepeatingChar ach = new O33FirstNotRepeatingChar();
        System.out.println(ach.FirstNotRepeatingChar("absadabd"));
    }
    public int FirstNotRepeatingChar(String str) {
        // A-Z:65-90, a-z:97-122, 122-65+1=58故需要58个位置
        int[] words = new int[58];
        for (int i = 0; i < str.length(); i++) {
            words[(int)str.charAt(i) - 65] += 1;
        }
        for (int i = 0; i < str.length(); i++) {
            if (words[(int)str.charAt(i) - 65] == 1){
                return i;
            }
        }
        return -1;
    }
}
