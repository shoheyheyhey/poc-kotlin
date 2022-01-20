# poc-kotlin
kotlinデモ用

## 環境構築(for Mac)
1. Dockerインストール [参考](https://qiita.com/kurkuru/items/127fa99ef5b2f0288b81)

## ローカル環境でアプリ起動
#### keycloak(認可サーバ)起動手順 8180ポート
`docker-compose up -d`

立ち上げたらlocalhost:8180へアクセス＞Administration Console＞admin/adminコンソール画面にログインできる


#### API立ち上げ 8081ポート
IntelliJでgradle＞kotlin-demo＞Tasks＞application＞bootRunから起動
