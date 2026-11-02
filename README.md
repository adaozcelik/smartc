# SMART-C Backend (Spring Boot)

## Proje Açıklaması
SMART-C, kampüs içindeki servis (shuttle) ve tesis kullanımını yönetmek için geliştirilmiş bir sistemdir. Bu repository, projenin backend (server) kısmını içermektedir.

---

## Kullanılan Teknolojiler
- Java (Spring Boot)
- MySQL
- Spring Data JPA
- REST API
- Postman (test için)

---

## Şu Ana Kadar Yapılanlar

### 1. Proje Kurulumu
- Spring Boot projesi oluşturuldu
- Katmanlı yapı kuruldu:
  - controller
  - service
  - repository
  - entity
  - dto
  - config

---

### 2. Veritabanı Kurulumu (MySQL)
- smartc_db veritabanı oluşturuldu
- users tablosu oluşturuldu

```sql
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(50)
);
```

---

### 3. Test Kullanıcısı Eklendi

```sql
INSERT INTO users (name, email, password, role)
VALUES ('Ada Ozcelik', 'ada@smartc.com', '1234', 'STUDENT');
```

---

### 4. Backend - Login API
- /auth/login endpoint geliştirildi
- Kullanıcı doğrulama işlemi yapılıyor

---

### 5. Postman ile Test

Endpoint:
```
POST http://localhost:8080/auth/login
```

Body:
```json
{
  "email": "ada@smartc.com",
  "password": "1234"
}
```

Başarılı response:
```json
{
  "message": "Login successful",
  "userId": 1,
  "name": "Ada Ozcelik",
  "role": "STUDENT"
}
```

---

## Projeyi Çalıştırma

1. MySQL çalışıyor olmalı
2. application.properties içinde DB ayarlarını yap:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/smartc_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

3. Projeyi çalıştır:

```bash
mvn spring-boot:run
```

4. API test için Postman kullan

---

## Proje Yapısı

```
src/main/java/com/smartc/smartc/
│
├── controller
├── service
├── repository
├── entity
├── dto
├── config
```

---

## Notlar
- Şu an sadece login sistemi hazır
- Şifreler plain text (ileride hash yapılacak)
- Security basit seviyede (geliştirilecek)

---

## Devam Edilecek Kısımlar
- Register API
- JWT Authentication
- Shuttle sistemi
- Reservation sistemi

---

## Geliştirici
Sıla Özcan
Ada Özçelik
