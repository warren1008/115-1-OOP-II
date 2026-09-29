# Week 01 - Assignment 01：登入視窗

## 題目來源

- [作業_1.png](evidence/assignment/作業_1.png)
- 題目要求使用 AI 生成「一個有輸入框和按鈕的登入視窗」，並檢視產生結果。

## 圖片中可確認的內容

- 使用 Java Swing 建立登入視窗。
- 視窗包含帳號、密碼輸入區與登入按鈕。
- 題目圖片附有一份 AI 產生的 `BadLogin` 範例，後續實作時需檢查其版面、字串比較、密碼欄位與登入判斷等問題。

## 實作內容

- 使用 `BorderLayout`、`GridLayout` 與 `FlowLayout` 排列元件，不使用未設定位置的 `null` 版面。
- 帳號使用 `JTextField`，密碼使用 `JPasswordField`。
- 按下登入按鈕或 Enter 都會進行判斷。
- 示範帳號為 `admin`，密碼為 `1234`。
- 空白欄位、登入成功與登入失敗都有畫面訊息。
- 關閉視窗時結束程式，視窗開啟時置中。

## 目前狀態

- 程式碼：已完成初版，位於 `src/LoginWindow.java`。
- 編譯：使用 JDK 25.0.2、UTF-8 編譯成功。
- 自動化 GUI 測試：全部通過。
- 執行截圖：[登入成功畫面](evidence/run/login-success.png)。
- AI 對話截圖：待使用者將本次真實對話截圖放入 `evidence/ai-dialogue/`。
- Reflection：已有依本次修改整理的草稿，提交前需由使用者確認並改成自己的表達。

## 已完成的測試

- 視窗標題為「登入」，尺寸為 340 × 220。
- 關閉方式設定為 `EXIT_ON_CLOSE`。
- 帳號或密碼留白時顯示紅色提示。
- 錯誤帳密顯示紅色錯誤訊息，並清空密碼欄。
- `admin`／`1234` 顯示綠色「登入成功」。
- Enter 鍵綁定登入按鈕。

## 預定編譯與執行

```powershell
javac -encoding UTF-8 -d out src\*.java
java -cp out LoginWindow
```

## AI 使用聲明

本作業已使用 AI 協助整理題目、分析題目附帶的 AI 範例並產生修正版程式。真實 AI 對話截圖仍需由使用者保存；Reflection 草稿必須經使用者確認並改成自己的表達。
