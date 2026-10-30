# Week 02 - Assignment 2：骰子模擬器 2（觸發事件練習）

## 題目與參考來源

本次依使用者說明，練習「觸發事件」，並參考同學提供的 `a1133342_hw1_2.java`：按下按鈕後更新數字、統計、顏色與自行繪製的骰子圖案。程式由原本的骰子作業延伸，主類別使用 `DiceSimulator2`。

- 原始骰子規格：[GUI.pdf 第 32 頁的渲染圖](evidence/assignment/gui-page-32.png)。
- 新增功能的依據：使用者的說明及同學參考程式；這張投影片本身只有原版規格。
- 同學的原始檔保留在下載資料夾，沒有當成自己的程式放入本次交件。

## 功能

- 視窗標題「骰子模擬器」，大小 400 × 320，開啟置中，關閉結束程式。
- 上方顯示「已擲 N 次，總和 M，平均 X.XX」。
- 中央保留 60 pt 的點數數字，並顯示同樣點數的骰子圖案。
- 下方「擲骰子」按鈕每次產生 1～6。
- 1 的數字和圓點為紅色，6 為綠色，其餘為黑色。
- 尚未擲骰時顯示「—」，骰子只有外框，累計資料皆為 0。

## 觸發事件的流程

```text
按下 rollButton（事件來源）
  → Swing 產生 ActionEvent
  → 呼叫已註冊的傾聽者 actionPerformed(event)
  → 確認 event.getSource() 是 rollButton
  → rollDice() 產生點數並更新文字、統計、顏色
  → dicePanel.setPoint(point) 更新圖案的狀態並呼叫 repaint()
  → Swing 安排 paintComponent() 重畫骰子
```

`DiceSimulator2` 實作 `ActionListener`，並透過 `rollButton.addActionListener(this)` 註冊自己為事件傾聽者。擲骰子的計算只發生在按鈕事件中；`paintComponent()` 只依目前點數繪圖，視窗重畫時不會再擲一次。

`DicePanel` 先呼叫 `super.paintComponent()` 清除舊圖，再畫白底、外框及圓點。數字和圖案共用這次產生的點數與顏色，因此不會各自亂數產生不同結果。

## 編譯與執行

使用 Java 標準的 Swing/AWT，沒有外部套件。本機以 JDK 25.0.2 驗證。

在 PowerShell 執行：

```powershell
Set-Location 'C:\Users\User\Desktop\OOP II\week-02\assignment-2'
javac -encoding UTF-8 -d out src\*.java
java -cp out DiceSimulator2
```

兩個 `.java` 檔需一起編譯，`out/` 為本機編譯輸出，已由課程根目錄的 `.gitignore` 排除。

## 檔案結構

```text
assignment-2/
|-- src/
|   |-- DiceSimulator2.java          視窗、按鈕事件、亂數與統計
|   `-- DicePanel.java               骰子外框與圓點繪製
|-- evidence/
|   |-- assignment/gui-page-32.png   原版題目頁面
|   |-- run/                        真實執行截圖與驗證紀錄
|   `-- ai-dialogue/README.md        待使用者補上本次真實對話截圖
|-- README.md
`-- Reflection.md                   待本人改寫的反思草稿
```

## 驗證狀態

- 已通過 UTF-8 編譯及 `javac -Xlint:all` 檢查，沒有警告。
- 已驗證初始畫面資料、標題、大小、置中、60 pt 字體與關閉設定。
- 已用 300 次 `JButton.doClick(0)` 觸發實際註冊的 `ActionListener`，逐次驗證範圍、次數、總和、平均及顏色。
- 已逐次檢查 `DicePanel` 實際繪製結果中的圓點數量，六面皆有測到，且沒有前一個點數的圓點殘留。
- [測試紀錄](evidence/run/verification.md)。
- [真實視窗截圖](evidence/run/01-dice-window.jpg)。

## AI 使用與待完成事項

本次使用 AI 協助讀取參考資料、整理事件流程、撰寫程式、執行測試與建立作業文件。

- 程式碼與執行證據已備妥。
- 本次 AI 對話截圖尚未提供，請補入 `evidence/ai-dialogue/`。
- `Reflection.md` 是依實際過程整理的草稿，須由本人操作、確認與改寫後再繳交。
- GitHub 儲存庫保存作業版本；課程平台繳交仍由使用者完成。
