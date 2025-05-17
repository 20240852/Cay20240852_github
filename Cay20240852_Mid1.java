import java.util.Scanner;
import java.util.Random;

public class Cay20240852_Mid1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] choices = {"가위", "바위", "보"};

        System.out.println("가위바위보 게임을 시작합니다!");

        while (true) {
            // 사용자 입력 받기
            System.out.print("\n가위, 바위, 보 중 하나를 입력하세요: ");
            String player = scanner.nextLine();

            // 입력 검증
            if (!player.equals("가위") && !player.equals("바위") && !player.equals("보")) {
                System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                continue;
            }

            // 컴퓨터 선택
            String computer = choices[random.nextInt(3)];
            System.out.println("컴퓨터의 선택: " + computer);

            // 승부 결과 변수: 0 = 비김, 1 = 플레이어 승, -1 = 컴퓨터 승
            int result = 0;

            // switch/case로 승부 판단
            switch (player) {
                case "가위":
                    switch (computer) {
                        case "가위":
                            result = 0; break;
                        case "바위":
                            result = -1; break;
                        case "보":
                            result = 1; break;
                    }
                    break;
                case "바위":
                    switch (computer) {
                        case "가위":
                            result = 1; break;
                        case "바위":
                            result = 0; break;
                        case "보":
                            result = -1; break;
                    }
                    break;
                case "보":
                    switch (computer) {
                        case "가위":
                            result = -1; break;
                        case "바위":
                            result = 1; break;
                        case "보":
                            result = 0; break;
                    }
                    break;
            }

            // 결과 출력 (if문 사용)
            if (result == 0) {
                System.out.println("비겼습니다.");
            } else if (result == 1) {
                System.out.println("당신이 이겼습니다!");
            } else {
                System.out.println("컴퓨터가 이겼습니다.");
            }

            // 게임 계속 여부
            System.out.print("\n계속 하시겠습니까? (예/아니오): ");
            String answer = scanner.nextLine();
            if (!answer.equals("예")) {
                System.out.println("게임을 종료합니다. 감사합니다!");
                break;
            }
        }

        scanner.close();
    }
}
