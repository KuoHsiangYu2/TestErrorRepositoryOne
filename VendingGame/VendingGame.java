// https://forum.gamer.com.tw/C.php?bsn=60292&snA=8879

import java.util.Scanner;

public class VendingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String currentLocation = "街角"; // 中文輸出
        System.out.print("scanner test: ");
        String input01 = scanner.next();
        System.out.println("[" + input01 + "]");
        // 確保CMD環境的UTF-8輸出
        try {
            // 嘗試設定Console輸出編碼，如果不行也無妨
            // System.setProperty("file.encoding", "UTF-8");
            // Field charset = Charset.class.getDeclaredField("defaultCharset");
            // charset.setAccessible(true);
            // charset.set(null, null);
        } catch (Exception e) {
            // pass
            System.out.println("pass");
        }
        System.out.println("歡迎來到【販賣車創業模擬器】！你現在在 " + currentLocation + "。");
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n----------------------------------------");
            // 提示用戶輸入英文指令
            System.out.println("你可以做：[MOVE] 移動、[LOOK] 觀察、[TALK] 對話、[EXIT] 離開");
            System.out.print("請輸入你的指令 (英文) > ");
            String command = scanner.nextLine().trim();
            if (command.equalsIgnoreCase("MOVE")) {
                // 只認英文指令
                currentLocation = "人潮中心";
                System.out.println("你移動到了 " + currentLocation + "，這裡有你的智慧販賣車！");
            } else if (command.equalsIgnoreCase("LOOK")) {
                // 只認英文指令
                System.out.println("你仔細觀察，發現一名【NPC 路人甲】在附近徘徊。");
            } else if (command.equalsIgnoreCase("TALK")) {
                // 只認英文指令
                handleNPCInteraction(scanner);
            } else if (command.equalsIgnoreCase("EXIT")) {
                // 只認英文指令
                isRunning = false;
                System.out.println("遊戲結束，期待下次創業！");
            } else {
                System.out.println("指令無效，請重新輸入。");
            }
        }
        scanner.close();
    }

    public static void handleNPCInteraction(Scanner scanner) {
        System.out.println("\n你走向路人甲，準備開始推銷你的販賣車廣告位。");
        int npcTrustLevel = 0;
        System.out.println("NPC 路人甲: 「你好，你是賣飲料的嗎？」");
        boolean isTalking = true;
        while (isTalking) {
            // 提示用戶輸入英文選項
            System.out.println("\n選擇對話選項：[A] 推銷飲料 [B] 推銷廣告 [C] 結束對話");
            System.out.print("你的選擇 (A/B/C) > ");
            String choice = scanner.nextLine().trim().toUpperCase();
            if (choice.equals("A")) {
                System.out.println("你: 「是的！我們的車可以賣飲料，而且我們的 AI 路徑最佳化...」");
                System.out.println("路人甲: 「我不渴。」");
            } else if (choice.equals("B")) {
                System.out.println("你: 「我們的車是移動式媒體平台！AI 精準掃街！」");
                npcTrustLevel += 20;
                System.out.println("路人甲: 「移動式廣告？聽起來有點意思...」 (信任度增加 20)");
                if (npcTrustLevel >= 50) {
                    System.out.println("路人甲: 「好吧，我就是某廣告公司的經理。我們來談談合作細節吧！」");
                    isTalking = false;
                }
            } else if (choice.equals("C")) {
                isTalking = false;
                System.out.println("你: 「好的，再見。」");
            } else {
                System.out.println("無效的選擇。");
            }
        }
        System.out.println("\n你結束了與路人甲的互動。");

    }

}
