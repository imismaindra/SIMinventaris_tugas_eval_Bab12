package Controllers;

import Models.Barang;
import Models.Penjualan;

import java.util.ArrayList;
import java.time.LocalDate;

public class PenjualanController {
    private ArrayList<Penjualan> daftarTransaksi;

    public PenjualanController() {
        daftarTransaksi = new ArrayList<>();
    }

    public ArrayList<Penjualan> getDaftarTransaksi() {
        return daftarTransaksi;
    }

    public void catatTransaksi(int idBarang, int quantitas, BarangController barangController) {
        Barang barang = barangController.getDaftarBarang().stream()
                .filter(b -> b.getIdBarang() == idBarang)
                .findFirst()
                .orElse(null);

        if (barang == null) {
            System.out.println("Barang dengan ID " + idBarang + " tidak ditemukan!");
            return;
        }

        if (barang.getStock() < quantitas) {
            System.out.println("Stok barang tidak mencukupi untuk transaksi ini!");
            return;
        }
        barang.setStock(barang.getStock() - quantitas);
        int totalHarga = (int) (barang.getHarga() * quantitas);
        Penjualan transaksi = new Penjualan(
                daftarTransaksi.size() + 1,
                idBarang,
                quantitas,
                LocalDate.now(),
                totalHarga
        );
        daftarTransaksi.add(transaksi);

        System.out.println("Transaksi berhasil dicatat! Stok tersisa: " + barang.getStock());
    }
}
