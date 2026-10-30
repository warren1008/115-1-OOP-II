# Week 3：基本繪圖

依使用者指定，以 `week3` 作為本週資料夾名稱。課堂練習和回家作業分開存放。

| 類別 | 題目 | 程式 | 說明 |
| --- | --- | --- | --- |
| 課堂練習 | 畫一個機器人 | `RobotPractice.java` | [執行方式與座標](class-practice/README.md) |
| 回家作業 01 | 我的小房子 | `MyLittleHouse.java` | [規格、執行方式與證據](assignment-01/README.md) |

兩份程式都使用 Java 內建 Swing/AWT，不需要額外套件。繪圖原點在畫布左上角，x 向右增加，y 向下增加。圖形依程式順序繪製，後畫的內容會覆蓋前面的內容。

兩份程式已編譯、實際執行並保存截圖，詳見 [驗證紀錄](verification.md)。

## 快速執行

在本資料夾開啟 PowerShell，執行：

```powershell
# 課堂練習
javac -encoding UTF-8 -d class-practice\out class-practice\src\RobotPractice.java
java -cp class-practice\out RobotPractice

# 關閉機器人視窗後，再執行回家作業
javac -encoding UTF-8 -d assignment-01\out assignment-01\src\MyLittleHouse.java
java -cp assignment-01\out MyLittleHouse
```

`out/` 為本機編譯產物，已由課程根目錄的 `.gitignore` 排除。

## 共用 AI 對話截圖

機器人與小房子共用 [ai截圖對話](ai截圖對話/README.md) 中的同一組 3 張 AI 對話截圖：

1. [需求與完成摘要](ai截圖對話/ai-dialogue-01-requirements-and-completion.png)
2. [完成結果與執行預覽](ai截圖對話/ai-dialogue-02-result-and-run-preview.png)
3. [建立檔案清單](ai截圖對話/ai-dialogue-03-created-files-list.png)

該資料夾另外保留 2 張題目截圖，已依內容命名，詳見共用截圖索引。

## 繳交前

- 小房子的簽名已填入使用者提供的 `A1123307 黃品勛`。
- 本週有使用 AI 協助，已加入使用者提供的 3 張真實 AI 對話截圖，兩份程式共用相同檔案。
- 回家作業的 [Reflection.md](assignment-01/Reflection.md) 已補齊全文；繳交前須由本人閱讀，確認實際分工、個人理解與文字表達。
- 本週程式、Reflection 與證據統一存放於課程儲存庫 `warren1008/115-1-OOP-II` 的 `week3/`；教師指定的課程平台繳交須另行處理。
