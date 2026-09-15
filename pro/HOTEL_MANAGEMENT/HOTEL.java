import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class HOTEL extends JFrame {

    static final String URL =
            "jdbc:mysql://localhost:3306/HOTEL_MANAGEMENT_SYSTEM";
    static final String USER = "root";
    static final String PASSWORD = "Vikram@300978";

    JTextField idField;
    JTextField nameField;
    JTextField emailField;
    JTextField phoneField;
    JTextField addressField;
    JTextField idProofField;

    JTable customerTable;
    DefaultTableModel model;

    public HOTEL() {

        setTitle("Hotel Management System");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("HOTEL MANAGEMENT SYSTEM");
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel header = new JPanel();
        header.add(title);

        mainPanel.add(header, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.setBorder(
                BorderFactory.createTitledBorder("Customer Details")
        );

        idField = new JTextField();
        nameField = new JTextField();
        emailField = new JTextField();
        phoneField = new JTextField();
        addressField = new JTextField();
        idProofField = new JTextField();

        formPanel.add(new JLabel("Customer ID:"));
        formPanel.add(idField);

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);

        formPanel.add(new JLabel("Phone:"));
        formPanel.add(phoneField);

        formPanel.add(new JLabel("Address:"));
        formPanel.add(addressField);

        formPanel.add(new JLabel("ID Proof:"));
        formPanel.add(idProofField);

        JButton addButton = new JButton("ADD");
        JButton updateButton = new JButton("UPDATE");
        JButton deleteButton = new JButton("DELETE");
        JButton searchButton = new JButton("SEARCH");
        JButton clearButton = new JButton("CLEAR");

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(clearButton);

        JPanel leftPanel = new JPanel(new BorderLayout());

        leftPanel.add(formPanel, BorderLayout.CENTER);
        leftPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainPanel.add(leftPanel, BorderLayout.WEST);

        model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Phone");
        model.addColumn("Address");
        model.addColumn("ID Proof");

        customerTable = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(customerTable);

        scrollPane.setBorder(
                BorderFactory.createTitledBorder("Customers")
        );

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);

        addButton.addActionListener(e -> addCustomer());

        updateButton.addActionListener(e -> updateCustomer());

        deleteButton.addActionListener(e -> deleteCustomer());

        searchButton.addActionListener(e -> searchCustomer());

        clearButton.addActionListener(e -> clearFields());

        customerTable.getSelectionModel()
                .addListSelectionListener(e -> {

                    int row = customerTable.getSelectedRow();

                    if (row >= 0) {

                        idField.setText(
                                model.getValueAt(row, 0).toString()
                        );

                        nameField.setText(
                                model.getValueAt(row, 1).toString()
                        );

                        emailField.setText(
                                model.getValueAt(row, 2).toString()
                        );

                        phoneField.setText(
                                model.getValueAt(row, 3).toString()
                        );

                        addressField.setText(
                                model.getValueAt(row, 4).toString()
                        );

                        idProofField.setText(
                                model.getValueAt(row, 5).toString()
                        );
                    }
                });

        loadCustomers();

        setVisible(true);
    }

    Connection getConnection() throws SQLException {

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }

    void addCustomer() {

        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();
        String idProof = idProofField.getText();

        if (name.isEmpty() || phone.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Name and Phone are required!"
            );

            return;
        }

        String sql =
                "INSERT INTO customers " +
                "(name,email,phone,address,id_proof) " +
                "VALUES (?,?,?,?,?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, address);
            ps.setString(5, idProof);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    this,
                    "Customer Added Successfully!"
            );

            clearFields();
            loadCustomers();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + e.getMessage()
            );
        }
    }

    void loadCustomers() {

        model.setRowCount(0);

        String sql = "SELECT * FROM customers";

        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                model.addRow(new Object[]{
                        rs.getInt("customer_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("id_proof")
                });
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error loading customers: " + e.getMessage()
            );
        }
    }

    void updateCustomer() {

        if (idField.getText().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Select a customer first!"
            );

            return;
        }

        String sql =
                "UPDATE customers SET " +
                "name=?, email=?, phone=?, address=?, id_proof=? " +
                "WHERE customer_id=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nameField.getText());
            ps.setString(2, emailField.getText());
            ps.setString(3, phoneField.getText());
            ps.setString(4, addressField.getText());
            ps.setString(5, idProofField.getText());

            ps.setInt(
                    6,
                    Integer.parseInt(idField.getText())
            );

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    this,
                    "Customer Updated Successfully!"
            );

            clearFields();
            loadCustomers();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + e.getMessage()
            );
        }
    }

    void deleteCustomer() {

        if (idField.getText().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Select a customer first!"
            );

            return;
        }

        int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete this customer?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION
        );

        if (choice != JOptionPane.YES_OPTION) {
            return;
        }

        String sql =
                "DELETE FROM customers WHERE customer_id=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(
                    1,
                    Integer.parseInt(idField.getText())
            );

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    this,
                    "Customer Deleted Successfully!"
            );

            clearFields();
            loadCustomers();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + e.getMessage()
            );
        }
    }

    void searchCustomer() {

        String search = JOptionPane.showInputDialog(
                this,
                "Enter customer name:"
        );

        if (search == null || search.isEmpty()) {
            return;
        }

        model.setRowCount(0);

        String sql =
                "SELECT * FROM customers WHERE name LIKE ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + search + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                model.addRow(new Object[]{
                        rs.getInt("customer_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("id_proof")
                });
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + e.getMessage()
            );
        }
    }

    void clearFields() {

        idField.setText("");
        nameField.setText("");
        emailField.setText("");
        phoneField.setText("");
        addressField.setText("");
        idProofField.setText("");

        customerTable.clearSelection();
    }

    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            SwingUtilities.invokeLater(
                    () -> new HOTEL()
            );

        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
    }
}