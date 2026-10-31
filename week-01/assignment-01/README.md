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

- 程式碼：已完成，位於 `src/LoginWindow.java`。
- 編譯：使用 JDK 25.0.2、UTF-8 編譯成功。
- 自動化 GUI 測試：2026-11-01 重新驗證通過，包含 `equals()` 與物件參考不同的案例；詳見 [驗證紀錄](evidence/run/verification.md)。
- 執行截圖：[登入成功畫面](evidence/run/login-success.png)。
- AI 對話截圖：已加入 10 張真實對話截圖，依時間順序存放於 `evidence/ai-dialogue/`。
- Reflection：[全文已整理](Reflection.md)，保留本人已修改的內容並補上這次提出的 `equals()` 疑問；繳交前需本人確認理解與文字表達。

## 已完成的測試

- 視窗標題為「登入」，尺寸為 340 × 220。
- 關閉方式設定為 `EXIT_ON_CLOSE`。
- 帳號或密碼留白時顯示紅色提示。
- 錯誤帳密顯示紅色錯誤訊息，並清空密碼欄。
- `admin`／`1234` 顯示綠色「登入成功」。
- Enter 鍵綁定登入按鈕。
- 從輸入框取得的字串，即使與字串常值不是同一個物件，仍可透過 `equals()` 正確登入。
- `Admin` 與 `admin` 視為不同帳號；帳號會去除前後空白，密碼保留前後空白。
- 實際派送視窗關閉事件後，程式正常結束。

## 編譯與執行

在本作業資料夾開啟 PowerShell：

```powershell
javac -encoding UTF-8 -d out src\*.java
java -cp out LoginWindow
```

示範帳密僅用於本題本機練習。可先按空白登入、再輸入錯誤帳密，最後輸入 `admin`／`1234`，觀察提示與密碼清空的差別。

## 檔案結構

```text
assignment-01/
|-- src/LoginWindow.java
|-- evidence/
|   |-- assignment/作業_1.png
|   |-- run/                     執行截圖與 verification.md
|   `-- ai-dialogue/             10 張真實 AI 對話截圖
|-- README.md
`-- Reflection.md
```

## AI 使用聲明

本作業已使用 AI 協助整理題目、分析題目附帶的 AI 範例、產生修正版程式與執行測試。真實 AI 對話截圖已保存於 `evidence/ai-dialogue/`；2026-11-01 的驗證屬於 AI 協助的自動測試。Reflection 已區分協作內容與本人提出的疑問，繳交前仍須本人確認理解及表達。
