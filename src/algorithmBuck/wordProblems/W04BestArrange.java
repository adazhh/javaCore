package algorithmBuck.wordProblems;

import java.util.Arrays;
import java.util.Comparator;

public class W04BestArrange {
    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static int bestArray(Program[] programs){
        if (programs.length < 1) return 0;
        Arrays.sort(programs, new Comparator<Program>() {
            @Override
            public int compare(Program o1, Program o2) {
                return o1.end - o2.end;
            }
        });
        int result = 1;
        int start = programs[0].end;
        for (int i = 1; i < programs.length; i++) {
            if (start <= programs[i].start){
                result++;
                start = programs[i].end;
            }
        }
        return result;
    }
}
