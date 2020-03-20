package algorithmBuck.dataStructure;

public class D09KMP {
    /**
     * 根据next移动，找到匹配串的开端下标
     * @param s1
     * @param s2
     * @return
     */
    public static int getIndexOf(String s1, String s2)
    {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        int[] next = getNextArray(str2);

        int i1 = 0;//主子串下标
        int i2 = 0;//匹配子串下标
        while(i1 < str1.length && i2 < str2.length)
        {
            if(str1[i1] == str2[i2])//如果字符相等，则继续往前匹配
            {
                i1++;
                i2++;
            }
            else if(next[i2] == -1)//如果不相等，且当前字符已经没有最长前缀和最长后缀的匹配
            {
                i1++;//顺序匹配下一个字符
            }
            else {
                i2 = next[i2];//存在最长前缀和最长后缀相等大于0的，则从最长前缀的下一个字符开始匹配，最长前缀那一部分不用匹配是因为
                //一定是相等的
            }
        }
        return i2 == str2.length? i1 - i2:-1;//如果跳出循环的是因为匹配到最后一个字符正确跳出的，则存在子串，否则不存在返回-1
    }
    /**
     * 计算next数组
     * @param str2
     * @return
     */
    private static int[] getNextArray(char[] str2) {

        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;//前面这两个数是认为规定的
        int i = 2;
        int cn = 0;//代表分界指标，这边有一个隐含的条件，最长前缀和最长后缀的长度==最长前缀的最后一个字符下标
        while(i < str2.length)
        {
            if(str2[i - 1] == str2[cn])
            {
                next[i++] = ++cn;
            }
            else if(cn > 0)//前一个字符和最长前缀的下一个字符不相等，则以最长前缀下一个字符为切分点继续切分
            {
                cn = next[cn];
            }
            else {
                next[i++] = 0;//cn来到了没有最长前缀，则i这个位置的next值为0
            }
        }
        return next;
    }
    public static void main(String[] args) {
        String s1 = "BBCABCDABABCDABCDABCDABDE";
        String s2 = "ABCDABD";
        int indexOf = getIndexOf(s1, s2);
        System.out.println(indexOf);
    }
}
