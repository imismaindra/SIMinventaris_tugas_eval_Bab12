package Models;

import java.time.LocalDate;
import java.util.Date;

public class Penjualan {
    private int idPenjualan;
    private int idBarang;
    private int quantitas;
    private LocalDate tanggal;
    private double totalHarga;

    public Penjualan(int idPenjualan, int idBarang, int quantitas, LocalDate tanggal, double totalHarga) {
        this.idPenjualan = idPenjualan;
        this.idBarang = idBarang;
        this.quantitas = quantitas;
        this.tanggal = tanggal;
        this.totalHarga = totalHarga;
    }

    public int getIdPenjualan() { return idPenjualan; }
    public int getIdBarang() { return idBarang; }
    public int getQuantitas() { return quantitas; }
    public LocalDate getTanggal() { return tanggal; }
    public double getTotalHarga() { return totalHarga; }
}
