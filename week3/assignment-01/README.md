# 回家作業 01：我的小房子

主程式為 `src/MyLittleHouse.java`，簽名為使用者提供的 `A1123307 黃品勛`。

## 題目要求與對照

題目：[我的小房子](evidence/assignment/my-little-house-assignment.png)，亦見本機 `GUI_Draw.pdf` 第 30 頁。

| 要求 | 程式中的實作 |
| --- | --- |
| 500 × 400 畫布 | `setPreferredSize(new Dimension(500, 400))` 配合 `pack()` |
| 天空與草地 | 兩個 `fillRect`，上半部 y=0–199 為天藍色，下半部 y=200–399 為綠色 |
| 黃色正圓太陽、至少 8 條光芒 | `fillOval(65, 45, 60, 60)`，以迴圈及 `Math.cos`、`Math.sin` 畫 12 條 `drawLine` |
| 至少 3 個重疊白色橢圓組成的雲 | 3 個白色 `fillOval`，中間橢圓較高 |
| 房屋主體 | `fillRect` 填色，`drawRect` 畫外框，(140,200)，220 × 145 |
| 三角形屋頂只能用三條線段 | 頂點 (125,200)、(250,120)、(375,200)，正好 3 次 `drawLine`，不填色 |
| 門與門把 | 棕色 `fillRoundRect` 和黃色小 `fillOval` |
| 至少 2 扇十字框窗戶 | 兩扇窗都用 `fillRect`、`drawRect`，再各用兩條 `drawLine` 畫十字 |
| 畫面角落簽名 | `g.drawString("A1123307 黃品勛", 350, 385)`，位於右下角 |

程式依題目編號加上繁體中文註解，使用課堂的基本 Swing/AWT 繪圖方式。

沿用講義介紹的 `Graphics2D`，用 `BasicStroke(2)` 將線寬設為 2 像素，讓屋頂、外框與十字窗框清楚可見；繪圖方法仍是題目指定的 `drawLine`、`drawRect` 等方法。

## 編譯與執行

使用 JDK，不需要 Maven、Gradle 或額外套件。在 `week3/assignment-01` 中執行：

```powershell
javac -encoding UTF-8 -d out src\MyLittleHouse.java
java -cp out MyLittleHouse
```

按右上角的關閉按鈕結束程式。視窗固定大小，保留題目要求的畫布尺寸。

## 座標與繪圖順序

- `fillRect(x, y, width, height)` 的 x、y 是左上角座標；後兩個參數是寬與高。
- 太陽中心是 (95,75)，光芒起點距中心 40、終點距中心 53；每次增加 30 度，12 次正好繞一圈。
- 背景先畫，再畫太陽、雲、房屋、屋頂、門窗，最後簽名。
- 屋頂依題意只畫三角形外框，因此三角形內仍是天空色。
- `drawString` 的 y=385 是文字基準線，與畫布底部保留距離。

## 檔案與繳交狀態

```text
assignment-01/
|-- src/MyLittleHouse.java
|-- evidence/
|   |-- assignment/my-little-house-assignment.png
|   |-- run/my-little-house.png
|   `-- ai-dialogue/README.md    指向本週共用 AI 截圖
|-- README.md
`-- Reflection.md
```

- 已保存 [實際執行截圖](evidence/run/my-little-house.png)。編譯、畫面尺寸、外觀、重畫與視窗關閉等檢查，見本週 [驗證紀錄](../verification.md)。
- 本作業使用 AI 協助整理需求、撰寫程式與驗證，未聲稱「未使用 AI」。
- 已加入使用者提供的 3 張真實 AI 對話截圖，與機器人課堂練習共用 [同一組檔案](../ai截圖對話/README.md)，集中存放於本週 `ai截圖對話/`。
- `Reflection.md` 已依本次真實對話、程式修改與驗證紀錄補齊全文，清楚註明 AI 與學生的分工；繳交前仍須本人閱讀，確認符合自己的理解與表達。
- 本作業隨本週內容保存於課程儲存庫 `warren1008/115-1-OOP-II` 的 `week3/`；教師指定的課程平台繳交須另行處理。

## 共用 AI 對話紀錄

1. [需求與完成摘要](../ai截圖對話/ai-dialogue-01-requirements-and-completion.png)
2. [完成結果與執行預覽](../ai截圖對話/ai-dialogue-02-result-and-run-preview.png)
3. [建立檔案清單](../ai截圖對話/ai-dialogue-03-created-files-list.png)
