package algorithmBuck.dataStructure;

public class D10Manacher {
    /**
     * O(N^3)的时间复杂度
     * @param str
     * @return
     */
    public static String manacher1(String str){
        if (str.length() <= 1) return str;
        for (int i = str.length(); i >= 1; i--) {
            for(int j = 0; j <= str.length() - i; j++) {
                //关键在于这个截取的子串，由长到短，这个是最关键的
                String subStr = str.substring(j, i+j);//从外向内收缩的子串,截取的子串越来越短
                int k = 0;
                for (k = 0; k < subStr.length()/2; k++) {
                    if (subStr.charAt(k) != subStr.charAt(subStr.length() - k -1)){
                        break;
                    }
                }
                if (k == subStr.length()/2){
                    return subStr;
                }
            }
        }
        return "";
    }

    public static int maxLcpsLength(String str) {
        //马拉车算法O(N)的时间复杂度
        if(str == null || str.length()==0)
            return 0;
        StringBuilder builder = new StringBuilder("#");
        for (int i = 0; i < str.length(); i++) {
            builder.append(str.charAt(i));
            builder.append("#");
        }
        char[] charArr = builder.toString().toCharArray();
        int[] pArr = new int[charArr.length]; // pArr[i]记录以i为中心的最大回文半径
        int index = -1; // 最近一次更新
        int pR = -1; // 所有回文半径中，最右即将到达的位置
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < charArr.length; ++i) {
            //关键算法步骤，pR > i表示当前点在右边界内还是外？如果是外，则重新开始扩散也就是等于1，
            //当在右边界里面的时候，则判断对称点i*半径有没有超过左边界，判断两者拿个比较短，就是哪个。
            // index = (i + i’)/2 -> i' = 2*index - i
            // p[2 * index - i]表示没有超过的长度，mx-i表示超出的时候的长度
            pArr[i] = pR > i ? Math.min(pArr[2*index-i], pR-i) : 1;
            // 没有扩出有边界且没有扩出左边界
            while (i+pArr[i]<charArr.length && i-pArr[i] > -1){
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]]){
                    pArr[i]++;
                }else {
                    break;
                }
            }
            if (i + pArr[i] > pR){
                pR = i + pArr[i];
                index = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }
    public static String manacher2(String str){
        if (str == null) return null;
        StringBuilder builder = new StringBuilder("#");
        for (int i = 0; i < str.length(); i++) {
            builder.append(str.charAt(i));
            builder.append("#");
        }
        char[] charArr = builder.toString().toCharArray();
        int[] p = new int[charArr.length];
        int index = -1;
        int max = Integer.MIN_VALUE;
        int pR = -1;
        int pos = -1; //记录中点位置
        for (int i = 0; i < charArr.length; i++) {
            p[i] = (pR > i) ? Math.min(p[2*index-i], pR-i) : 1;
            while (i-p[i] > -1 && i+p[i] < charArr.length){
                if (charArr[i+p[i]] == charArr[i-p[i]]){
                    p[i]++;
                }else {
                    break;
                }
            }
            if (p[i] + i > pR){
                index = i;
                pR = p[i] + i;
            }
            if (p[i] > max){
                max = p[i];
                pos = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = pos - max + 2; j < pos + p[pos] - 1;) {
            sb.append(charArr[j]);
            j += 2;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(manacher1("hello world"));
        System.out.println(maxLcpsLength("kecabbacoot"));
        System.out.println(manacher2("kkcabbacii"));
    }
}
