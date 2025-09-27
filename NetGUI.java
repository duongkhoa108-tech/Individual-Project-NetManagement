package NETLotGUI;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.ArrayList;
import javax.swing.JFrame;

public class NetGUI extends JFrame {
    private JTextArea displayArea;
    private JTextField txtId, txtName, txtPhone;
    private JComboBox<String> cmbPcType;
    private ArrayList<CustomerGUI> customers;

    public NetGUI() {
        customers = new ArrayList<>();
        setTitle("Net Cafe Management");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(displayArea);
        add(scroll, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new GridLayout(4, 2));
        bottom.add(new JLabel("ID Khach:"));
        txtId = new JTextField(); bottom.add(txtId);
        bottom.add(new JLabel("Ten khach:"));
        txtName = new JTextField(); bottom.add(txtName);
        bottom.add(new JLabel("SDT:"));
        txtPhone = new JTextField(); bottom.add(txtPhone);
        bottom.add(new JLabel("Loai may:"));
        cmbPcType = new JComboBox<>(new String[]{"Normal", "VIP"});
        bottom.add(cmbPcType);
        add(bottom, BorderLayout.SOUTH);

        JPanel buttons = new JPanel();
        JButton btnAdd = new JButton("Them KH");
        JButton btnRemove = new JButton("Xoa KH");
        JButton btnShow = new JButton("Hien thi");
        JButton btnTotal = new JButton("Tinh Tong Tien");
        JButton btnFind = new JButton("Tim KH");
        JButton btnCount = new JButton("So Luong KH");

        buttons.add(btnAdd); buttons.add(btnRemove); buttons.add(btnShow);
        buttons.add(btnTotal); buttons.add(btnFind); buttons.add(btnCount);
        add(buttons, BorderLayout.NORTH);

        btnAdd.addActionListener(e -> {
            CustomerGUI c = new CustomerGUI(
                txtId.getText(),
                txtName.getText(),
                txtPhone.getText(),
                new Date(),
                cmbPcType.getSelectedItem().toString()
            );
            customers.add(c);
            displayArea.append("Da them KH: " + c.getName() + "\n");
        });

        btnShow.addActionListener(e -> {
            displayArea.append("--- Danh sach KH ---\n");
            for (CustomerGUI c : customers) {
                displayArea.append(c.toString() + "\n");
            }
        });

        btnTotal.addActionListener(e -> {
            int total = 0;
            for (CustomerGUI c : customers) {
                
            }
            displayArea.append("Tong tien: " + total + " VND\n");
        });

        btnFind.addActionListener(e -> {
            CustomerGUI found = null;
            for (CustomerGUI c : customers) {
                if (c.getId().equals(txtId.getText())) {
                    found = c;
                    break;
                }
            }
            if (found != null) displayArea.append("Tim thay KH: " + found + "\n");
            else displayArea.append("Khong tim thay KH");
        });

        btnRemove.addActionListener(e -> {
            customers.removeIf(c -> c.getId().equals(txtId.getText()));
            displayArea.append("Da xoa KH: " + txtId.getText() + "\n");
        });

        btnCount.addActionListener(e -> {
            displayArea.append("So luong KH: " + customers.size() + "\n");
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NetGUI().setVisible(true));
    }
}
