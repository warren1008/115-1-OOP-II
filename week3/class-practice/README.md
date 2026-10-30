# 課堂練習：畫一個機器人

此題是課堂練習，檔名為 `src/RobotPractice.java`，與回家作業分開存放。

## 題目與做法

- [題目截圖](evidence/assignment/robot-practice.png)
- 參考本機 `GUI_Draw.pdf` 第 17–19 頁，以第 18 頁的座標表與第 19 頁的 `JPanel` 程式骨架實作。
- 畫布大小為 400 × 400。使用 `setPreferredSize` 配合 `pack()`，避免把視窗標題列算進畫布大小。
- 在 `paintComponent(Graphics g)` 中先呼叫 `super.paintComponent(g)`，再畫出圖案，讓視窗重新顯示時能正常重畫。

| 部位 | 座標與方法 |
| --- | --- |
| 天線 | 黑色 `drawLine`，(150,60)→(120,20)、(250,60)→(280,20) |
| 天線頂端 | 紅色 `fillOval`，(110,10)、(270,10)，直徑 20 |
| 頭 | 淺灰色 `fillRoundRect` 與黑色 `drawRoundRect`，(100,60)，200 × 180，圓角 40 × 40 |
| 眼白 | 白色 `fillOval`，(130,100)、(220,100)，50 × 40 |
| 眼珠 | 藍色 `fillOval`，(145,110)、(235,110)，直徑 20 |
| 嘴巴 | 深灰色 `fillRect`，(150,180)，100 × 30 |
| 牙齒分隔線 | 白色 `drawLine`，用迴圈畫 x=170、190、210、230，y=180 到 210 |
| 身體 | `Color.ORANGE` 填色與黑色外框，(130,250)，140 × 120 |

身體顏色依講義座標表的「橘」實作；題目示意圖偏黃。

## 編譯與執行

在 `week3/class-practice` 中執行：

```powershell
javac -encoding UTF-8 -d out src\RobotPractice.java
java -cp out RobotPractice
```

按視窗右上角的關閉按鈕結束程式。視窗固定大小，避免改變畫布尺寸。

## 證據與 AI 使用

- [實際執行截圖](evidence/run/robot-practice.png) 已保存，[驗證紀錄](../verification.md) 包含編譯、畫布尺寸及視窗關閉檢查。
- 使用 AI 協助整理講義、實作與檢查。已附上使用者提供的真實 AI 對話截圖，與小房子作業共用 [同一組 3 張圖片](../ai截圖對話/README.md)，不另複製檔案。

1. [需求與完成摘要](../ai截圖對話/ai-dialogue-01-requirements-and-completion.png)
2. [完成結果與執行預覽](../ai截圖對話/ai-dialogue-02-result-and-run-preview.png)
3. [建立檔案清單](../ai截圖對話/ai-dialogue-03-created-files-list.png)
