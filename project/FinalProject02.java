package project;


import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class FinalProject02 {

    static HashMap<String, int[]> scoreMap = new HashMap<>();
    static final String SCORE_FILE = "project/score.txt";
    static final String FRIEND_FILE = "project/juso.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menu;

        while (true) {
            System.out.println("\n========= 메인 메뉴 =========");
            System.out.println("1. 자기 소개");
            System.out.println("2. 학생성적 입력");
            System.out.println("3. 학생성적 학점 출력");
            System.out.println("4. 학생 검색");
            System.out.println("5. 계산기 프레임");
            System.out.println("6. 학생 주소록 저장, 출력");
            System.out.println("7. 끝내기");
            System.out.print("메뉴 선택>> ");

            try {
                menu = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력하세요.");
                continue;
            }

            switch (menu) {
                case 1:
                    selfIntroduction();
                    break;
                case 2:
                    inputScores(sc);
                    break;
                case 3:
                    printScoresWithGrade();
                    break;
                case 4:
                    searchStudent(sc);
                    break;
                case 5:
                    openCalculator();
                    break;
                case 6:
                    manageAddressBook(sc);
                    break;
                case 7:
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;
                default:
                    System.out.println("1~7 사이의 메뉴를 선택하세요.");
            }
        }
    }

    static void selfIntroduction() {
        System.out.println("\n안녕하세요! 저는 2025211210 이우현이라고 합니다.");
        System.out.println("전공은 컴퓨터이며, 미래 직업은 소프트웨어 개발자를 목표로 열심히 공부하고 있습니다.");
    }

    static void inputScores(Scanner sc) {
        System.out.println("\n학생 이름과 이산구조과목의 중간성적(40), 기말성적(40), 과제성적(20)을 입력하세요.");
        scoreMap.clear();

        for (int i = 0; i < 5; i++) {
            System.out.print(">> ");
            String line = sc.nextLine().trim();
            String[] parts = line.split(",");
            if (parts.length != 4) {
                System.out.println("형식 오류: 이름,중간,기말,과제 형식으로 입력하세요. 다시 입력합니다.");
                i--;
                continue;
            }
            try {
                String name = parts[0].trim();
                int mid  = Integer.parseInt(parts[1].trim());
                int fin  = Integer.parseInt(parts[2].trim());
                int hw   = Integer.parseInt(parts[3].trim());
                scoreMap.put(name, new int[]{mid, fin, hw});
            } catch (NumberFormatException e) {
                System.out.println("숫자 형식 오류입니다. 다시 입력합니다.");
                i--;
            }
        }

        System.out.println("총 " + scoreMap.size() + "개의 학생정보를 읽었습니다.");
        saveScoresToFile();
    }

    static void saveScoresToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(SCORE_FILE))) {
            for (Map.Entry<String, int[]> entry : scoreMap.entrySet()) {
                int[] s = entry.getValue();
                bw.write(entry.getKey() + "," + s[0] + "," + s[1] + "," + s[2]);
                bw.newLine();
            }
            System.out.println("파일 저장 완료: " + SCORE_FILE);
        } catch (IOException e) {
            System.out.println("파일 저장 오류: " + e.getMessage());
        }
    }

    static void loadScoresFromFile() {
        File f = new File(SCORE_FILE);
        if (!f.exists()) return;

        scoreMap.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(SCORE_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0].trim();
                    int mid = Integer.parseInt(parts[1].trim());
                    int fin = Integer.parseInt(parts[2].trim());
                    int hw  = Integer.parseInt(parts[3].trim());
                    scoreMap.put(name, new int[]{mid, fin, hw});
                }
            }
        } catch (IOException e) {
            System.out.println("파일 읽기 오류: " + e.getMessage());
        }
    }

    static void printScoresWithGrade() {
        if (scoreMap.isEmpty()) {
            loadScoresFromFile();
        }
        if (scoreMap.isEmpty()) {
            System.out.println("저장된 학생 데이터가 없습니다. 먼저 메뉴 2에서 입력하세요.");
            return;
        }

        System.out.println();
        for (Map.Entry<String, int[]> entry : scoreMap.entrySet()) {
            int[] s = entry.getValue();
            double total = s[0] + s[1] + s[2];
            String grade = calcGrade(total);
            System.out.println("이름:" + entry.getKey());
            System.out.println("중간:" + s[0]);
            System.out.println("기말:" + s[1]);
            System.out.println("과제:" + s[2]);
            System.out.println("성적합계:" + total);
            System.out.println("학점:" + grade);
            System.out.println("----------------------");
        }
    }

    static String calcGrade(double total) {
        if      (total >= 95) return "A+";
        else if (total >= 90) return "A0";
        else if (total >= 85) return "B+";
        else if (total >= 80) return "B0";
        else if (total >= 75) return "C+";
        else if (total >= 70) return "C0";
        else if (total >= 65) return "D+";
        else if (total >= 60) return "D0";
        else                  return "F";
    }

    static void searchStudent(Scanner sc) {
        if (scoreMap.isEmpty()) {
            loadScoresFromFile();
        }
        if (scoreMap.isEmpty()) {
            System.out.println("저장된 학생 데이터가 없습니다. 먼저 메뉴 2에서 입력하세요.");
            return;
        }

        while (true) {
            System.out.println("\n검색할 이름을 입력하세요");
            System.out.print("이름>> ");
            String name = sc.nextLine().trim();

            if (name.equals("그만")) break;

            if (scoreMap.containsKey(name)) {
                int[] s = scoreMap.get(name);
                double total = s[0] + s[1] + s[2];
                String grade = calcGrade(total);
                System.out.println("중간성적: " + s[0] + ", 기말성적: " + s[1]
                        + ", 과제성적: " + s[2] + ", 학점: " + grade);
            } else {
                System.out.println("해당 학생을 찾을 수 없습니다.");
            }
        }
    }

    static void openCalculator() {
        JFrame frame = new JFrame("계산기 프레임");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(420, 380);
        frame.setLayout(new BorderLayout(5, 5));

        // 상단: 수식입력 텍스트 필드
        JPanel topPanel = new JPanel(new BorderLayout(5, 5));
        topPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 4, 8));
        JLabel inputLabel = new JLabel("수식입력");
        JTextField inputField = new JTextField();
        inputField.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        topPanel.add(inputLabel, BorderLayout.WEST);
        topPanel.add(inputField, BorderLayout.CENTER);
        frame.add(topPanel, BorderLayout.NORTH);

        // 상태 변수
        final double[] firstNum = {0};
        final String[] operator = {""};
        final boolean[] operatorSet = {false};

        // 결과 필드 (하단에 배치, 여기서 미리 선언)
        JTextField resultField = new JTextField();
        resultField.setEditable(false);
        resultField.setFont(new Font("맑은 고딕", Font.PLAIN, 16));

        // 중앙: 숫자 버튼 그리드 (0~9, CE, 계산)
        JPanel centerPanel = new JPanel(new GridLayout(3, 4, 4, 4));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
        String[] btnLabels = {"0","1","2","3","4","5","6","7","8","9","CE","계산"};

        for (String label : btnLabels) {
            JButton btn = new JButton(label);
            btn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
            btn.addActionListener(e -> {
                String cmd = e.getActionCommand();
                if (cmd.equals("CE")) {
                    inputField.setText("");
                    resultField.setText("");
                    firstNum[0] = 0;
                    operator[0] = "";
                    operatorSet[0] = false;
                } else if (cmd.equals("계산")) {
                    if (operator[0].isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "연산자를 먼저 선택하세요.");
                        return;
                    }
                    String text = inputField.getText().trim();
                    String[] parts = text.split("[+\\-*/]");
                    if (parts.length < 2 || parts[parts.length - 1].trim().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "두 번째 숫자를 입력하세요.");
                        return;
                    }
                    try {
                        double b = Double.parseDouble(parts[parts.length - 1].trim());
                        double result;
                        switch (operator[0]) {
                            case "+": result = firstNum[0] + b; break;
                            case "-": result = firstNum[0] - b; break;
                            case "*": result = firstNum[0] * b; break;
                            case "/":
                                if (b == 0) {
                                    JOptionPane.showMessageDialog(frame, "0으로 나눌 수 없습니다.");
                                    return;
                                }
                                result = firstNum[0] / b; break;
                            default: return;
                        }
                        resultField.setText(String.valueOf(result));
                        firstNum[0] = 0;
                        operator[0] = "";
                        operatorSet[0] = false;
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "숫자 입력 오류");
                    }
                } else {
                    inputField.setText(inputField.getText() + cmd);
                }
            });
            centerPanel.add(btn);
        }
        frame.add(centerPanel, BorderLayout.CENTER);

        // 하단 전체 패널
        JPanel southPanel = new JPanel(new BorderLayout(0, 0));

        // 연산자 버튼 행 (파란색 배경)
        JPanel opPanel = new JPanel(new GridLayout(1, 4, 4, 0));
        opPanel.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
        opPanel.setBackground(new Color(70, 160, 210));
        String[] ops = {"+", "-", "*", "/"};
        for (String op : ops) {
            JButton opBtn = new JButton(op);
            opBtn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
            opBtn.setBackground(new Color(70, 160, 210));
            opBtn.setForeground(Color.WHITE);
            opBtn.setOpaque(true);
            opBtn.setBorderPainted(false);
            opBtn.addActionListener(e -> {
                String currentText = inputField.getText().trim();
                if (currentText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "숫자를 먼저 입력하세요.");
                    return;
                }
                try {
                    firstNum[0] = Double.parseDouble(currentText);
                    operator[0] = e.getActionCommand();
                    operatorSet[0] = true;
                    inputField.setText(currentText + " " + e.getActionCommand() + " ");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "올바른 숫자를 입력하세요.");
                }
            });
            opPanel.add(opBtn);
        }
        southPanel.add(opPanel, BorderLayout.NORTH);

        // 결과 행 (노란색 레이블 + 결과 필드)
        JPanel resultPanel = new JPanel(new BorderLayout(5, 0));
        resultPanel.setBorder(BorderFactory.createEmptyBorder(4, 8, 8, 8));
        JLabel resultLabel = new JLabel("계산 결과");
        resultLabel.setOpaque(true);
        resultLabel.setBackground(new Color(255, 220, 0));
        resultLabel.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
        resultLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
        resultPanel.add(resultLabel, BorderLayout.WEST);
        resultPanel.add(resultField, BorderLayout.CENTER);
        southPanel.add(resultPanel, BorderLayout.SOUTH);

        frame.add(southPanel, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static void manageAddressBook(Scanner sc) {
        java.util.List<String[]> friends = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.print("이름 입력 ==> ");
            String name  = sc.nextLine().trim();
            System.out.print("나이 입력 ==> ");
            String age   = sc.nextLine().trim();
            System.out.print("전화번호 입력 ==> ");
            String phone = sc.nextLine().trim();
            System.out.print("전공 입력 ==> ");
            String major = sc.nextLine().trim();
            System.out.print("주소 입력 ==> ");
            String addr  = sc.nextLine().trim();
            System.out.println();
            friends.add(new String[]{name, age, phone, major, addr});
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FRIEND_FILE))) {
            for (String[] f : friends) {
                bw.write(String.join(",", f));
                bw.newLine();
            }
            System.out.println("파일 저장 완료: " + FRIEND_FILE);
        } catch (IOException e) {
            System.out.println("파일 저장 오류: " + e.getMessage());
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("%-10s %-6s %-15s %-8s %s%n", "학생이름", "나이", "연락처", "전공", "주소");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < friends.size(); i++) {
            String[] f = friends.get(i);
            System.out.printf("%d: %-8s %-6s %-15s %-8s %s%n",
                    i + 1, f[0], f[1], f[2], f[3], f[4]);
        }
    }
}
