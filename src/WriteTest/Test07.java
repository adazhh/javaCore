package WriteTest;

import java.util.LinkedList;
import java.util.Scanner;

public class Test07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int group = Integer.valueOf(scanner.nextLine());
        LinkedList<Long>[] lists = new LinkedList[group];
        for (int i = 0; i < group; i++) {
            lists[i] = new LinkedList<>();
            int n = Integer.valueOf(scanner.nextLine());
            String[] str = scanner.nextLine().split(" ");
            for (String s : str) {
                Long temp = Long.valueOf(s);
                if (lists[i].contains(temp)){
                    lists[i].remove(temp);
                }
                lists[i].addFirst(temp);
            }
        }
        for (int i = 0; i < group; i++) {
            while (!lists[i].isEmpty()){
                System.out.print(lists[i].pollFirst() + " ");
            }
            System.out.println();
        }
    }

    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    //     while(sc.hasNext()) {
    //         int n = sc.nextInt();
    //         for(int i = 0; i < n; i++) {
    //             ArrayList<Integer> list1 = new ArrayList<Integer>();
    //             list.add(list1);
    //             int len = sc.nextInt();
    //             int[] arr = new int[len];
    //             for(int j = 0; j < len; j++) {
    //                 arr[j] = sc.nextInt();
    //             }
    //             for(int k = len-1; k >= 0; k--) {
    //                 if(!list1.contains(arr[k])) {
    //                     list1.add(arr[k]);
    //                 }
    //             }
    //         }
    //
    //         for(int i = 0; i < list.size(); i++) {
    //             for(int j = 0; j < list.get(i).size()-1; j++) {
    //                 System.out.print(list.get(i).get(j) + " ");
    //             }
    //             System.out.println(list.get(i).get(list.get(i).size()-1));
    //         }
    //     }
    // }
}
