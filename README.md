# Akakce Mobil Uygulama Otomasyon Test Projesi

Bu proje, Akakce mobil uygulamasının temel işlevlerini otomatik olarak test etmek amacıyla hazırlanmıştır.  
Java, Appium ve Cucumber kullanılarak geliştirilmiş basit bir test otomasyon projesidir.

---

## Projede Neler Var?

- Kullanıcı Akakçe mobil uygulamasına girer
- Üye olmadan devam et seçeneği ile ilerler (Login bilgisi isterse)
- Arama kutusuna “Laptop” yazar ve aratır.
- Filtrele butonuna tıklar.
- Alt Kategori -> Bilgisayar,Donanım seçer ve Ürünleri Gör butonuna tıklar.
- Sıralama seçeneklerinden En Yüksek Fiyat seçeneğini seçer.
- Sonuç ekranından 10. Ürüne tıklar ve Ürüne Git butonuna tıklar.
- Ürün detayı ekranında Satıcıya Git butonunun görüntülendiğini doğrular.


---

## Projede Temel Alınan Telefon

- Android Studio Medium Phone Width: 1080 Height: 2400
- Android version 16.0


---

## Kullanılan Teknolojiler

- Java  
- Appium  
- JUnit  
- Maven
- Cucumber

---

## Proje Yapısı

- `base` – Appium konfigürasyonları  
- `locater` – Kullanılan locaterların bulunduğu dosyalar
- `stepDefinitions` – Cucumber steplerinin yönlendirildiği dosya
- `steps` – Android metotlarının bulunduğu dosya
- `resource\feature` - Test dosyası

---

## Nasıl Çalıştırılır?

1. Projeyi klonlayın:

   ```bash
   git clone https://github.com/Salusmoon/akakceTest.git
