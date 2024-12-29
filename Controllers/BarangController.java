package Controllers;

import Models.Barang;

import java.util.ArrayList;

public class BarangController {
    private ArrayList<Barang> daftarBarang;

    public BarangController() {
        daftarBarang = new ArrayList<>();
    }

    public ArrayList<Barang> getDaftarBarang() {
        return daftarBarang;
    }

    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
    }

    public String getNamaBarangById(int idBarang) {
        return daftarBarang.stream()
                .filter(b -> b.getIdBarang() == idBarang)
                .map(Barang::getNama)
                .findFirst()
                .orElse("Tidak Diketahui");
    }

    public int getNextId() {
        return daftarBarang.size() + 1;
    }

    public void updateBarang(int idBarang, String nama, int harga, int stok) {
        for (Barang barang : daftarBarang) {
            if (barang.getIdBarang() == idBarang) {
                barang.setNama(nama);
                barang.setHarga(harga);
                barang.setStock(stok);
                break;
            }
        }
    }
    public Barang getBarangById(int id) {
        return daftarBarang.stream()
                .filter(barang -> barang.getIdBarang() == id)
                .findFirst()
                .orElse(null);
    }
}
