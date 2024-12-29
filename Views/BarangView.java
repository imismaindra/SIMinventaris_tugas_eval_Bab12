package Views;

import Controllers.BarangController;
import Models.Barang;

import javax.swing.*;
import java.awt.*;

public class BarangView extends JPanel {
    private BarangController barangController;
    private JTable barangTable;
    private JButton addBarangButton, updateBarangButton, refreshButton;

    public BarangView(BarangController barangController) {
        this.barangController = barangController;
        setLayout(new BorderLayout());

        String[] barangColumnNames = {"ID", "Nama", "Harga", "Stok"};
        barangTable = new JTable(getBarangData(), barangColumnNames);
        add(new JScrollPane(barangTable), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        addBarangButton = new JButton("Tambah Barang");
        updateBarangButton = new JButton("Update Barang");
        refreshButton = new JButton("Refresh");

        buttonPanel.add(addBarangButton);
        buttonPanel.add(updateBarangButton);
        buttonPanel.add(refreshButton);

        add(buttonPanel, BorderLayout.SOUTH);

        addBarangButton.addActionListener(e -> openAddBarangFrame());
        updateBarangButton.addActionListener(e -> openUpdateBarangFrame());
        refreshButton.addActionListener(e -> refreshTable());
    }

    private String[][] getBarangData() {
        return barangController.getDaftarBarang().stream()
                .map(b -> new String[]{
                        String.valueOf(b.getIdBarang()),
                        b.getNama(),
                        String.valueOf(b.getHarga()),
                        String.valueOf(b.getStock())
                })
                .toArray(String[][]::new);
    }

    private void refreshTable() {
        barangTable.setModel(new javax.swing.table.DefaultTableModel(
                getBarangData(),
                new String[]{"ID", "Nama", "Harga", "Stok"}
        ));
    }

    private void openAddBarangFrame() {
        JFrame addFrame = new JFrame("🛒 Tambah Barang");
        addFrame.setSize(400, 300);
        addFrame.setLayout(new BorderLayout());
        addFrame.setResizable(false);
    
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    
        JLabel namaLabel = new JLabel("📝 Nama Barang:");
        JTextField namaField = new JTextField();
    
        JLabel hargaLabel = new JLabel("💵 Harga:");
        JTextField hargaField = new JTextField();
    
        JLabel stokLabel = new JLabel("📦 Stok:");
        JTextField stokField = new JTextField();
    
        JButton saveButton = new JButton("✅ Simpan");
        saveButton.setBackground(new Color(34, 139, 34));
        saveButton.setForeground(Color.WHITE);
    
        formPanel.add(namaLabel);
        formPanel.add(namaField);
        formPanel.add(hargaLabel);
        formPanel.add(hargaField);
        formPanel.add(stokLabel);
        formPanel.add(stokField);
        formPanel.add(new JLabel()); 
        formPanel.add(saveButton);
    
        addFrame.add(formPanel, BorderLayout.CENTER);
    
        saveButton.addActionListener(e -> {
            try {
                String nama = namaField.getText();
                int harga = Integer.parseInt(hargaField.getText());
                int stok = Integer.parseInt(stokField.getText());
    
                barangController.tambahBarang(new Barang(
                        barangController.getNextId(), nama, harga, stok
                ));
                JOptionPane.showMessageDialog(addFrame, "Barang berhasil ditambahkan!");
                addFrame.dispose();
                refreshTable();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(addFrame, "Input tidak valid!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    
        addFrame.setVisible(true);
    }

    private void openUpdateBarangFrame() {
        JFrame updateFrame = new JFrame("✏️ Update Barang");
        updateFrame.setSize(400, 350);
        updateFrame.setLayout(new BorderLayout());
        updateFrame.setResizable(false);
    
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    
        JLabel idLabel = new JLabel("🔑 ID Barang:");
        JTextField idField = new JTextField();
    
        JLabel hargaLabel = new JLabel("💵 Harga (opsional):");
        JTextField hargaField = new JTextField();
    
        JLabel stokLabel = new JLabel("📦 Stok (opsional):");
        JTextField stokField = new JTextField();
    
        JButton saveButton = new JButton("✅ Simpan");
        saveButton.setBackground(new Color(70, 130, 180));
        saveButton.setForeground(Color.WHITE);
    
        formPanel.add(idLabel);
        formPanel.add(idField);
        formPanel.add(hargaLabel);
        formPanel.add(hargaField);
        formPanel.add(stokLabel);
        formPanel.add(stokField);
        formPanel.add(new JLabel()); 
        formPanel.add(saveButton);
    
        updateFrame.add(formPanel, BorderLayout.CENTER);
    
        saveButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String hargaText = hargaField.getText();
                String stokText = stokField.getText();
    
                Barang barang = barangController.getBarangById(id);
    
                if (barang != null) {
                    if (!hargaText.isEmpty()) {
                        double harga = Double.parseDouble(hargaText);
                        barang.setHarga(harga);
                    }
                    if (!stokText.isEmpty()) {
                        int stok = Integer.parseInt(stokText);
                        barang.setStock(stok);
                    }
    
                    JOptionPane.showMessageDialog(updateFrame, "Barang berhasil diperbarui!");
                    updateFrame.dispose();
                    refreshTable();
                } else {
                    JOptionPane.showMessageDialog(updateFrame, "Barang tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(updateFrame, "Input tidak valid!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    
        updateFrame.setVisible(true);
    }
}
