# 📦 Sistem Manajemen Inventaris dan Penjualan

Sistem ini adalah aplikasi manajemen inventaris dan penjualan berbasis Java Swing dengan arsitektur **Model-View-Controller (MVC)**. Aplikasi ini memungkinkan pengguna untuk mengelola data barang, memperbarui stok, serta mencatat transaksi penjualan dengan mudah.

## 🚀 Fitur Utama

1. **Manajemen Barang**
   - Tambah Barang
   - Update Barang
   - Lihat Daftar Barang

2. **Manajemen Penjualan**
   - Catat Transaksi Penjualan
   - Lihat Daftar Transaksi

3. **Dashboard Terpadu**
   - Navigasi melalui tab untuk daftar barang dan transaksi
   - Aksi cepat untuk tambah, update, dan transaksi

## 🛠️ Teknologi yang Digunakan

- Java 8+
- Swing (GUI)
- Model-View-Controller (MVC) Architecture

## 📂 Struktur Proyek

```
📁 src/
├── Controllers/
│   ├── BarangController.java
│   ├── PenjualanController.java
│
├── Models/
│   ├── Barang.java
│   ├── Penjualan.java
│
├── Views/
│   ├── BarangView.java
│   ├── PenjualanView.java
│   ├── DashboardView.java
│
└── Main.java
```

## ▶️ Cara Menjalankan

1. Clone repository ini:
   ```bash
   git clone https://github.com/username/inventory-sales.git
   ```
2. Buka proyek di IDE favorit Anda (misalnya IntelliJ IDEA atau NetBeans).
3. Jalankan file `Main.java`.

## 📊 Diagram Alur (MVC)
```
User ↔️ View ↔️ Controller ↔️ Model ↔️ Database
```

## 🤝 Kontribusi
Kontribusi terbuka untuk semua! Jika Anda ingin menambahkan fitur baru atau memperbaiki bug, silakan buat pull request.

## 📄 Lisensi
Proyek ini dilisensikan di bawah **MIT License**.

---
**Dibuat dengan ❤️ oleh [Nama Anda]**

*Terima kasih telah menggunakan sistem ini!*
