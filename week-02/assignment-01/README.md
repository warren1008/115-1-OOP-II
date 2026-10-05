# Week 02 - Assignment 01：單位換算器

## 題目來源

- [作業_3.png](evidence/assignment/作業_3.png)

## 規格

- 視窗尺寸為 480 × 280，使用 `BorderLayout`。
- `NORTH`：使用 `JComboBox` 選擇換算類型（長度／重量／溫度）。
- `CENTER`：兩列，每列包含一個 `JTextField` 與一個單位 `JComboBox`，分別代表來源與目標。
- 切換換算類型時，兩個單位 `JComboBox` 的選項必須一起更新。
- 長度單位：公尺、公分、英吋、英尺。
- 重量單位：公斤、公克、磅、盎司。
- 溫度單位：攝氏、華氏、克氏。
- `SOUTH`：放置「換算」按鈕，結果顯示於第二個 `JTextField`。

## 目前狀態

- 程式碼：已完成，主類別為 `UnitConverter`。
- 編譯／執行：已使用 JDK 25.0.2 與 UTF-8 編譯成功。
- 功能測試：已驗證介面尺寸與版面、選項同步、三類換算及錯誤輸入處理。
- 執行截圖：已加入 4 張，包含長度、重量、換算類型選單與溫度畫面。
- AI 對話截圖：已加入 3 張本次真實對話紀錄。
- Reflection：尚未完成，依使用者指示暫不上傳。

## 檔案結構

```text
assignment-01/
|-- src/
|   `-- UnitConverter.java
|-- evidence/
|   |-- assignment/作業_3.png
|   |-- run/                    4 張執行與選單截圖
|   `-- ai-dialogue/            3 張真實 AI 對話截圖
`-- README.md
```

## 證據

執行畫面：

- [公尺轉公分](evidence/run/01-length-meter-to-centimeter.png)
- [公斤轉磅](evidence/run/02-weight-kilogram-to-pound.png)
- [換算類型選單](evidence/run/03-category-menu-options.png)
- [攝氏轉華氏](evidence/run/04-temperature-celsius-to-fahrenheit.png)

AI 對話紀錄：

- [選擇完整實作](evidence/ai-dialogue/ai-dialogue-01-menu-selection.png)
- [完成內容與測試摘要](evidence/ai-dialogue/ai-dialogue-02-implementation-summary.png)
- [執行方式與待辦狀態](evidence/ai-dialogue/ai-dialogue-03-run-instructions-and-status.png)

## 編譯與執行

在 `week-02/assignment-01` 資料夾中執行：

```powershell
javac -encoding UTF-8 -d out src\*.java
java -cp out UnitConverter
```

執行內建自我測試：

```powershell
java -cp out UnitConverter --test
```

## 已驗證項目

- 視窗標題為「單位換算器」，尺寸為 480 × 280，使用 `BorderLayout`。
- 換算類型共有長度、重量與溫度三種。
- 切換類型時，來源與目標單位選項會一起更新。
- 長度、重量與溫度的正向及反向代表案例結果正確。
- 第二個 `JTextField` 為唯讀，只顯示換算結果。
- 空白、非數字與非有限數值不會換算，並會顯示提示訊息。

## AI 使用聲明

本作業已使用 AI 協助整理規格、撰寫程式與建立測試，並已附上真實 AI 對話截圖。`Reflection.md` 尚未完成，因此本次依使用者指示不推送該檔案；完成後仍須以自己的文字據實補充並另行上傳。
