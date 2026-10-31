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
- 功能測試：2026-11-01 重新完成 300 次自動按鈕事件測試，逐次檢查點數範圍、次數、總和、平均與顏色；六種點數皆有涵蓋，詳見 [驗證紀錄](evidence/run/verification.md)。
- 執行截圖：[dice-simulator.png](evidence/run/dice-simulator.png)。
- AI 對話截圖：已加入 2 張真實對話截圖，依時間順序存放於 `evidence/ai-dialogue/`。
- Reflection：[參考稿全文已整理](Reflection.md)，具體說明 AI 建議、需要查核之處、實際採用的做法與理由；繳交前需本人操作並完成理解檢核。

## 檔案結構

```text
assignment-02/
|-- src/
|   `-- DiceSimulator.java
|-- evidence/
|   |-- assignment/作業_2.png
|   |-- run/                     執行截圖與 verification.md
|   `-- ai-dialogue/             2 張真實 AI 對話截圖
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
- 300 次測試中六種點數皆出現，並涵蓋 65 次從紅色或綠色切回黑色的情況。
- 實際派送視窗關閉事件後，程式正常結束。

## 自己操作時的檢查方向

啟動時應顯示 0 次、總和 0、平均 0.00，中央尚無點數。連續按「擲骰子」，確認次數每次只增加 1、總和增加目前點數，並觀察 1 為紅色、6 為綠色、其他為黑色。平均值的計算與顏色重設原因見 Reflection。

## AI 使用聲明

本作業已使用 AI 協助整理規格、撰寫程式、建立測試與交件結構。真實 AI 對話截圖已保存於 `evidence/ai-dialogue/`；2026-11-01 的驗證屬於 AI 協助的自動測試。Reflection 已依程式與驗證證據整理為完整參考稿，沒有虛構 AI 功能錯誤或本人操作紀錄；繳交前須由本人確認與改寫。
