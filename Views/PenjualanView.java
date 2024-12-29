package Views;

import Controllers.BarangController;
import Controllers.PenjualanController;

import javax.swing.*;
import java.awt.*;

public class PenjualanView extends JPanel {
    private PenjualanController penjualanController;
    private BarangController barangController;
    private JTable transaksiTable;
    private JButton transaksiButton, refreshButton;

    public PenjualanView(PenjualanController penjualanController, BarangController barangController) {
        this.penjualanController = penjualanController;
        this.barangController = barangController;
        setLayout(new BorderLayout());

        // Tabel Transaksi
        String[] transaksiColumnNames = {"ID", "ID Barang", "Nama Barang", "Quantitas", "Tanggal", "Total Harga"};
        transaksiTable = new JTable(getTransaksiData(), transaksiColumnNames);
        add(new JScrollPane(transaksiTable), BorderLayout.CENTER);

        // Tombol Aksi
        JPanel buttonPanel = new JPanel();
        transaksiButton = new JButton("Catat Transaksi");
        refreshButton = new JButton("Refresh");

        buttonPanel.add(transaksiButton);
        buttonPanel.add(refreshButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Event Handling
        transaksiButton.addActionListener(e -> openTransaksiFrame());
        refreshButton.addActionListener(e -> refreshTable());
    }

    private String[][] getTransaksiData() {
        return penjualanController.getDaftarTransaksi().stream()
                .map(t -> new String[]{
                        String.valueOf(t.getIdPenjualan()),
                        String.valueOf(t.getIdBarang()),
                        barangController.getNamaBarangById(t.getIdBarang()),
                        String.valueOf(t.getQuantitas()),
                        t.getTanggal().toString(),
                        String.valueOf(t.getTotalHarga())
                })
                .toArray(String[][]::new);
    }

    private void refreshTable() {
        transaksiTable.setModel(new javax.swing.table.DefaultTableModel(
                getTransaksiData(),
                new String[]{"ID", "ID Barang", "Nama Barang", "Quantitas", "Tanggal", "Total Harga"}
        ));
    }

    private void openTransaksiFrame() {
        JFrame transaksiFrame = new JFrame("💵 Catat Transaksi");
        transaksiFrame.setSize(400, 250);
        transaksiFrame.setLayout(new BorderLayout());
        transaksiFrame.setResizable(false);
    
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    
        JLabel idBarangLabel = new JLabel("🔑 ID Barang:");
        JTextField idBarangField = new JTextField();
    
        JLabel qtyLabel = new JLabel("🔢 Kuantitas:");
        JTextField qtyField = new JTextField();
    
        JButton saveButton = new JButton("✅ Simpan");
        saveButton.setBackground(new Color(255, 165, 0));
        saveButton.setForeground(Color.WHITE);
    
        formPanel.add(idBarangLabel);
        formPanel.add(idBarangField);
        formPanel.add(qtyLabel);
        formPanel.add(qtyField);
        formPanel.add(new JLabel()); // Spacer
        formPanel.add(saveButton);
    
        transaksiFrame.add(formPanel, BorderLayout.CENTER);
    
        saveButton.addActionListener(e -> {
            try {
                int idBarang = Integer.parseInt(idBarangField.getText());
                int qty = Integer.parseInt(qtyField.getText());
    
                penjualanController.catatTransaksi(idBarang, qty, barangController);
                JOptionPane.showMessageDialog(transaksiFrame, "Transaksi berhasil dicatat!");
                transaksiFrame.dispose();
                refreshTable();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(transaksiFrame, "Input tidak valid!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    
        transaksiFrame.setVisible(true);
    }
}
