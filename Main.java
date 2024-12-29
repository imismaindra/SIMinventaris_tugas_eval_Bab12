import Controllers.*;
import Views.*;

public class Main {
    public static void main(String[] args) {
        BarangController barangController = new BarangController();
        PenjualanController penjualanController = new PenjualanController();
        barangController.tambahBarang(new Models.Barang(1, "Pensil", 2000, 50));
        barangController.tambahBarang(new Models.Barang(2, "Buku", 5000, 30));
        new DashboardView(barangController, penjualanController);
    }
}
