package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D19sortGrade {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.valueOf(reader.readLine());
        Stu[] stus = new Stu[count];
        String line;
        for (int i = 0; i < count; i++) {
            line = reader.readLine();
            String[] split = line.split(" ");
            stus[i].name = split[0];
            stus[i].score = Integer.valueOf(split[1]);
        }
        Arrays.sort(stus, (o1, o2) -> o2.score - o1.score);
        System.out.println(Arrays.toString(stus));
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
