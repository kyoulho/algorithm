import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
       int maxW = Arrays.stream(sizes).map(
                it -> new Card(it[0], it[1])
        ).min((o1, o2) -> o2.w - o1.w).get().w;

        int maxH = Arrays.stream(sizes).map(
                it -> new Card(it[0], it[1])
        ).min((o1, o2) -> o2.h - o1.h).get().h;

        return maxW * maxH;
    }
}

class Card {
    int w;
    int h;

    public Card(int w, int h) {
        if (w >= h) {
            this.w = w;
            this.h = h;
        } else {
            this.w = h;
            this.h = w;
        }
    }

}