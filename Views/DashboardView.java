package Views;

import Controllers.BarangController;
import Controllers.PenjualanController;

import javax.swing.*;
import java.awt.*;

public class DashboardView extends JFrame {
    private BarangController barangController;
    private PenjualanController penjualanController;

    public DashboardView(BarangController barangController, PenjualanController penjualanController) {
        this.barangController = barangController;
        this.penjualanController = penjualanController;

        setTitle("Dashboard Inventaris dan Penjualan");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

   
        JPanel topPanel = new JPanel();
        JLabel titleLabel = new JLabel("Dashboard Manajemen Inventaris & Penjualan");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);

    
        JTabbedPane tabbedPane = new JTabbedPane();

        BarangView barangView = new BarangView(barangController);
        PenjualanView penjualanView = new PenjualanView(penjualanController, barangController);

        tabbedPane.addTab("Daftar Barang", barangView);
        tabbedPane.addTab("Daftar Transaksi", penjualanView);

        add(tabbedPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
