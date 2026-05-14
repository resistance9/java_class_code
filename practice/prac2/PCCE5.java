
class PCCE5 {
    public int[] solution(String[] cpr) {
        int[] answer = {0, 0, 0, 0, 0};
        String[] basic_order = {"check", "call", "pressure", "respiration", "repeat"};

        for(int i=0; i<cpr.length; i++){
            for(int j=0; j<basic_order.length; j++){
                if(cpr[i].equals(basic_order[j])){
                    answer[i] = j + 1;   // 빈칸: j+1 (1-indexed 순서)
                    break;
                }
            }
        }
        return answer;
    }
}