package practice.prac4;

class PCCE9 {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        int wMin = Math.min(wallet[0], wallet[1]);
        int wMax = Math.max(wallet[0], wallet[1]);

        while (true) {
            int bMin = Math.min(bill[0], bill[1]);
            int bMax = Math.max(bill[0], bill[1]);

            if (bMin <= wMin && bMax <= wMax) break;

            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer++;
        }

        return answer;
    }
}