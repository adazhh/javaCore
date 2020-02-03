package algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class S01sortGrade {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            int count = Integer.valueOf(reader.readLine());
            Stu[] stuArr = new Stu[count];
            for (int i = 0; i < count; i++) {
                String line = reader.readLine();
                String[] split = line.split(" ");
                stuArr[i] = new Stu(split[0], Integer.valueOf(split[1]));
            }
            Arrays.sort(stuArr, new Comparator<Stu>() {
                @Override
                public int compare(Stu o1, Stu o2) {
                    return o2.score - o1.score;
                }
            });
            System.out.println(Arrays.toString(stuArr));
        }catch (IOException e){

        }
    }
   static class Stu{
        int score;
        String name;
        public Stu(String name, int score){
            this.score = score;
            this.name = name;
        }
       @Override
       public String toString() {
           return name + " " + score;
       }
   }
}
