package practice.prac4;

import java.util.*;

class PCCE10 {

    boolean canPlace(String[][] park, int x, int y, int size) {
        int rows = park.length;
        int cols = park[0].length;

        if (x + size > rows || y + size > cols) return false;

        for (int r = x; r < x + size; r++) {
            for (int c = y; c < y + size; c++) {
                if (!park[r][c].equals("-1")) return false;
            }
        }
        return true;
    }

    public int solution(int[] mats, String[][] park) {
        Integer[] sorted = Arrays.stream(mats)
                .boxed()
                .sorted(Collections.reverseOrder())
                .toArray(Integer[]::new);

        int rows = park.length;
        int cols = park[0].length;

        for (int size : sorted) {
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (canPlace(park, r, c, size)) {
                        return size;
                    }
                }
            }
        }

        return -1;
    }
}
