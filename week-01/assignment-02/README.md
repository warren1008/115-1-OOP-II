# Week 01 - Assignment 02：骰子模擬器

## 題目來源

- [作業_2.png](evidence/assignment/作業_2.png)

## 規格

- 視窗標題為「骰子模擬器」。
- 視窗尺寸為 400 × 320，開啟時置中。
- 關閉視窗時結束程式。
- 中央使用一個 `JLabel` 顯示目前點數，字體大小 60 pt。
- 下方放置「擲骰子」按鈕。
- 每次按下按鈕，隨機產生 1 到 6 並更新顯示。
- 視窗上方顯示「已擲 N 次，總和 M，平均 X.XX」。
- 點數為 6 時文字為綠色；為 1 時為紅色；其餘為黑色。

## 目前狀態

- 程式碼：已完成，主類別為 `DiceSimulator`。
- 編譯／執行：已使用 JDK 25.0.2 與 UTF-8 編譯成功。
- 功能測試：已完成 300 次自動擲骰測試，逐次檢查點數範圍、次數、總和、平均與顏色。
- 執行截圖：[dice-simulator.png](evidence/run/dice-simulator.png)。
- AI 對話截圖：待使用者將本次真實對話截圖放入 `evidence/ai-dialogue/`。
- Reflection：已有依本次過程整理的草稿，仍需使用者親自確認並改成自己的文字。

## 檔案結構

```text
assignment-02/
|-- src/
|   `-- DiceSimulator.java
|-- evidence/
|   |-- assignment/作業_2.png
|   |-- run/dice-simulator.png
|   `-- ai-dialogue/              待補真實對話截圖
|-- README.md
`-- Reflection.md
```

## 編譯與執行

在 `week-01/assignment-02` 資料夾中執行：

```powershell
javac -encoding UTF-8 -d out src\*.java
java -cp out DiceSimulator
```

## 已驗證項目

- 視窗標題、400 × 320 尺寸、置中與關閉行為。
- 初始統計為「已擲 0 次，總和 0，平均 0.00」。
- 點數標籤為 60 pt，按鈕文字為「擲骰子」。
- 每次結果都在 1 到 6 之間，次數與總和逐次累計。
- 平均值正確顯示到小數點後兩位。
- 點數 1 為紅色、6 為綠色，其餘為黑色。

## AI 使用聲明

本作業已使用 AI 協助整理規格、撰寫程式、建立測試與交件結構。依課程政策，提交前必須把本次真實 AI 對話截圖放入 `evidence/ai-dialogue/`，並由學生親自完成 `Reflection.md`。
