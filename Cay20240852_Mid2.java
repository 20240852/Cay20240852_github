import java.util.Scanner;
import java.util.Random;

public class Cay20240852_Mid2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] choices = {"가위", "바위", "보"};

        int playerScore = 0;
        int computerScore = 0;
        int round = 1;

        System.out.println("가위바위보 게임을 시작합니다!");
        System.out.println("총 5판 진행하며, 이기면 +2점, 지면 -1점, 비기면 0점입니다.");

        while (round <= 5) {
            System.out.print("\n[" + round + "판] 가위, 바위, 보 중 하나를 입력하세요: ");
            String player = scanner.nextLine();

            // 입력 검증
            if (!player.equals("가위") && !player.equals("바위") && !player.equals("보")) {
                System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                continue;
            }

            // 컴퓨터 선택
            String computer = choices[random.nextInt(3)];
            System.out.println("컴퓨터의 선택: " + computer);

            // 승부 결과: 0 = 비김, 1 = 사용자 승, -1 = 컴퓨터 승
            int result = 0;

            switch (player) {
                case "가위":
                    switch (computer) {
                        case "가위": result = 0; break;
                        case "바위": result = -1; break;
                        case "보": result = 1; break;
                    }
                    break;
                case "바위":
                    switch (computer) {
                        case "가위": result = 1; break;
                        case "바위": result = 0; break;
                        case "보": result = -1; break;
                    }
                    break;
                case "보":
                    switch (computer) {
                        case "가위": result = -1; break;
                        case "바위": result = 1; break;
                        case "보": result = 0; break;
                    }
                    break;
            }

            // 결과 출력 및 점수 계산
            if (result == 0) {
                System.out.println("비겼습니다! 점수 변동 없음.");
            } else if (result == 1) {
                System.out.println("당신이 이겼습니다! +2점");
                playerScore += 2;
                computerScore -= 1;
            } else {
                System.out.println("컴퓨터가 이겼습니다. 컴퓨터 +2점, 당신 -1점");
                computerScore += 2;
                playerScore -= 1;
            }

            // 현재 점수 출력
            System.out.println("현재 점수 ▶ 당신: " + playerScore + "점 / 컴퓨터: " + computerScore + "점");

            round++;
        }

        // 최종 승자 판단
        System.out.println("\n===== 게임 종료 =====");
        System.out.println("최종 점수 ▶ 당신: " + playerScore + "점 / 컴퓨터: " + computerScore + "점");

        if (playerScore > computerScore) {
            System.out.println("당신이 최종 승자입니다!");
        } else if (playerScore < computerScore) {
            System.out.println("컴퓨터가 최종 승자입니다.");
        } else {
            System.out.println("최종 결과는 무승부입니다.");
        }

        scanner.close();
    }
}
