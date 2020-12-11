import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;

public class PetFood extends JPanel {
    private JSpinner spinner1 = new JSpinner();

    private Font font1 = new Font("Calibri", Font.BOLD,40);
    private Font font2 = new Font("Calibri", Font.ITALIC,16);

    private JLabel petFoodLabel = new JLabel("PET FOOD");
    private JLabel stuffLabel = new JLabel("BARANG");
    private JLabel categoryLabel = new JLabel("KATEGORY");
    private JLabel quantityLabel = new JLabel("JUMLAH");
    private JLabel searchLabel = new JLabel("PENCARIAN");
    private JLabel hargaLabel = new JLabel("HARGA");
    private JLabel totalLabel = new JLabel("TOTAl HARGA");
    private JLabel kodeLabel = new JLabel("KODE");

    private JButton btnPesan = new JButton("Order");
    private JButton btnDelete = new JButton("Delete");
    private JButton btnEdit = new JButton("Update");
    private JButton btnInsert = new JButton("Add");
    private JButton btnCari = new JButton("Search");

    private JTextField cariTextField = new JTextField();
    private JTextField hargaTextField = new JTextField();
    private JTextField totalTextField = new JTextField();
    private JTextField kodeTextField = new JTextField();

    private String dog[] = {"Whiskas Kaleng 250g", "Whiskas Kaleng 500g", "Royal Canin Kaleng 350g", "Royal Canin Kaleng 600g",
            "ProPlan Kaleng 300g", "ProPlan Kaleng 500g", "Blackwood Kaleng 350g", "Blackwood Kaleng 600g",
            "Whiskas 500g", "Whiskas 1kg", "Royal Canin 500g", "Royal Canin 1.2kg", "ProPlan 500g",
            "ProPlan 1kg", "Blackwood 500g", "Blackwood 1.2kg"};
    private String ktgr[]= {"Dog", "Cat"};

    private String object[] ={"ID","Kategori","Nama Barang","Harga","Jumlah","Total Harga"};
    private JComboBox comboBox1 = new JComboBox(ktgr);
    private JComboBox comboBox2 = new JComboBox(dog);
    private Hashtable<Object, Object> subItems = new Hashtable<Object, Object>();
    private DefaultTableModel dtm = new DefaultTableModel(null,object);
    private JTable table1 = new JTable(dtm);
    private JScrollPane scrollPane = new JScrollPane(table1);
    private Statement st;
    private ResultSet rs;
    public PetFood(){
        new Database();
        setLayout(null);
        setBackground(new Color(30, 47, 143));

        petFoodLabel.setBounds(340,30, 300,40);
        petFoodLabel.setFont(font1);
        petFoodLabel.setForeground(Color.WHITE);

        kodeLabel.setBounds(30,140, 100,30);
        kodeLabel.setFont(font2);
        kodeLabel.setForeground(Color.WHITE);

        stuffLabel.setBounds(30,230, 100,30);
        stuffLabel.setFont(font2);
        stuffLabel.setForeground(Color.WHITE);

        categoryLabel.setBounds(30,190, 100,30);
        categoryLabel.setFont(font2);
        categoryLabel.setForeground(Color.WHITE);

        quantityLabel.setBounds(30,310, 100,30);
        quantityLabel.setFont(font2);
        quantityLabel.setForeground(Color.WHITE);

        searchLabel.setBounds(380,400,100,30);
        searchLabel.setFont(font2);
        searchLabel.setForeground(Color.WHITE);

        hargaLabel.setBounds(30,270,100,30);
        hargaLabel.setFont(font2);
        hargaLabel.setForeground(Color.WHITE);

        totalLabel.setBounds(30,350,100,30);
        totalLabel.setFont(font2);
        totalLabel.setForeground(Color.WHITE);

        comboBox1.setBounds(140, 190 ,180, 25);
        comboBox2.setBounds(140, 230 ,180, 25);
        spinner1.setBounds(140, 310, 50, 25);
        cariTextField.setBounds(475,400,255,25);
        hargaTextField.setBounds(140,270,180,25);
        totalTextField.setBounds(140,350,180,25);
        kodeTextField.setBounds(140,140,180,25);

        btnPesan.setBounds(720, 470, 90, 30);
        btnEdit.setBounds(145,400,75,25);
        btnDelete.setBounds(45,400,75,25);
        btnInsert.setBounds(245,400,75,25);
        btnCari.setBounds(735,400,75,25);

        scrollPane.setBounds(380,140,430,250);
        String[] items = {"Select", "Dog", "Cat"};
        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String item = (String) comboBox1.getSelectedItem();
                Object o = subItems.get(item);
                if (o == null) {
                    comboBox2.setModel(new DefaultComboBoxModel());
                } else {
                    comboBox2.setModel(new DefaultComboBoxModel((String[]) o));
                }
            }
        });
        comboBox2.setPrototypeDisplayValue("");
        String[] subItems1 = {"Whiskas Kaleng 250g", "Whiskas Kaleng 500g", "Royal Canin Kaleng 350g", "Royal Canin Kaleng 600g",
                "ProPlan Kaleng 300g", "ProPlan Kaleng 500g", "Blackwood Kaleng 350g", "Blackwood Kaleng 600g",
                "Whiskas 500g", "Whiskas 1kg", "Royal Canin 500g", "Royal Canin 1.2kg", "ProPlan 500g",
                "ProPlan 1kg", "Blackwood 500g", "Blackwood 1.2kg"};
        subItems.put(items[1], subItems1);
        String[] subItems2 = {"Whiskas Kaleng 250g", "Whiskas Kaleng 500g", "Royal Canin Kaleng 350g", "Royal Canin Kaleng 600g",
                "ProPlan Kaleng 300g", "ProPlan Kaleng 500g", "Blackwood Kaleng 350g", "Blackwood Kaleng 600g", "Kit Cat Kaleng 250g",
                "Kit Cat Kaleng 500g", "Whiskas 500g", "Whiskas 1kg", "Royal Canin 500g", "Royal Canin 1.2kg", "ProPlan 500g",
                "ProPlan 1kg", "Blackwood 500g", "Blackwood 1.2kg", "Kit Cat 500g", "Kit Cat 1.2kg"};
        subItems.put(items[2], subItems2);
        comboBox2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String items = (String) comboBox2.getSelectedItem();

                if ("Whiskas Kaleng 250g".equals(items)) {
                    hargaTextField.setText(String.valueOf(18000));
                } else if ("Whiskas Kaleng 500g".equals(items)) {
                    hargaTextField.setText(String.valueOf(40000));
                } else if ("Royal Canin Kaleng 350g".equals(items)) {
                    hargaTextField.setText(String.valueOf(30000));
                } else if ("Royal Canin Kaleng 600g".equals(items)) {
                    hargaTextField.setText(String.valueOf(70000));
                } else if ("ProPlan Kaleng 300g".equals(items)) {
                    hargaTextField.setText(String.valueOf(30000));
                } else if ("ProPlan Kaleng 500g".equals(items)) {
                    hargaTextField.setText(String.valueOf(50000));
                } else if ("Blackwood Kaleng 350g".equals(items)) {
                    hargaTextField.setText(String.valueOf(55000));
                } else if ("Blackwood Kaleng 600g".equals(items)) {
                    hargaTextField.setText(String.valueOf(100000));
                } else if ("Kit Cat Kaleng 250g".equals(items)) {
                    hargaTextField.setText(String.valueOf(35000));
                } else if ("Kit Cat Kaleng 500g".equals(items)) {
                    hargaTextField.setText(String.valueOf(65000));
                } else if ("Whiskas 500g".equals(items)) {
                    hargaTextField.setText(String.valueOf(45000));
                } else if ("Whiskas 1kg".equals(items)) {
                    hargaTextField.setText(String.valueOf(99000));
                } else if ("Royal Canin 500g".equals(items)) {
                    hargaTextField.setText(String.valueOf(50000));
                } else if ("Royal Canin 1.2kg".equals(items)) {
                    hargaTextField.setText(String.valueOf(120000));
                } else if ("ProPlan 500g".equals(items)) {
                    hargaTextField.setText(String.valueOf(60000));
                } else if ("ProPlan 1kg".equals(items)) {
                    hargaTextField.setText(String.valueOf(130000));
                } else if ("Blackwood 500g".equals(items)) {
                    hargaTextField.setText(String.valueOf(50000));
                } else if ("Blackwood 1.2kg".equals(items)) {
                    hargaTextField.setText(String.valueOf(100000));
                } else if ("Kit Cat 500g".equals(items)) {
                    hargaTextField.setText(String.valueOf(25000));
                } else if ("Kit Cat 1.2kg".equals(items)) {
                    hargaTextField.setText(String.valueOf(60000));
                } else{
                    hargaTextField.setText("-");
                }
            }
        });
        spinner1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int harga = Integer.parseInt(hargaTextField.getText());
                int jumlah = Integer.parseInt(spinner1.getValue().toString());
                int total = harga * jumlah;
                totalTextField.setText(String.valueOf(total));
            }
        });
        btnPesan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Pembelian Berhasil");
            }
        });
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertFood();
                kodeTextField.setText("");
                comboBox1.setSelectedItem("Dog");
                comboBox2.setSelectedItem("Whiskas Kaleng 250g");
                spinner1.setValue(0);
                hargaTextField.setText("");
                totalTextField.setText("");
            }
        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFood();
                kodeTextField.setText("");
                comboBox1.setSelectedItem("Dog");
                comboBox2.setSelectedItem("Whiskas Kaleng 250g");
                spinner1.setValue(0);
                hargaTextField.setText("");
                totalTextField.setText("");
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFood();
                kodeTextField.setText("");
                comboBox1.setSelectedItem("Dog");
                comboBox2.setSelectedItem("Whiskas Kaleng 250g");
                spinner1.setValue(0);
                hargaTextField.setText("");
                totalTextField.setText("");
            }
        });
        btnCari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchFood();
            }
        });
        table1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                kodeTextField.setText(dtm.getValueAt(table1.getSelectedRow(),0)+"");
                comboBox1.setSelectedItem(dtm.getValueAt(table1.getSelectedRow(),1)+"");
                comboBox2.setSelectedItem(dtm.getValueAt(table1.getSelectedRow(), 2) + "");
                hargaTextField.setText(dtm.getValueAt(table1.getSelectedRow(),3)+"");
                spinner1.setValue(dtm.getValueAt(table1.getSelectedRow(),4));
                totalTextField.setText(dtm.getValueAt(table1.getSelectedRow(),5)+"");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        add(petFoodLabel);
        add(kodeLabel);
        add(stuffLabel);
        add(categoryLabel);
        add(quantityLabel);
        add(searchLabel);
        add(hargaLabel);
        add(totalLabel);
        add(kodeTextField);
        add(cariTextField);
        add(hargaTextField);
        add(totalTextField);
        add(comboBox1);
        add(comboBox2);
        add(spinner1);
        add(btnInsert);
        add(btnCari);
        add(scrollPane);
        add(btnDelete);
        add(btnEdit);
        add(btnPesan);
        showDataFood();
    }
    public void showDataFood(){
        try{
            String sql = "SELECT * FROM petfood";
            st = Database.connect.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Object[] row = {
                        rs.getString("foodID"),
                        rs.getString("foodKategori"),
                        rs.getString("foodBarang"),
                        rs.getInt("foodHarga"),
                        rs.getInt("foodJumlah"),
                        rs.getInt("foodTotal")
                };
                dtm.addRow(row);
            }
        }catch (NullPointerException| SQLException e){
            e.printStackTrace();
        }
    }
    public void insertFood(){
        String kode = kodeTextField.getText();
        String kategori = comboBox1.getSelectedItem().toString();
        String brg = comboBox2.getSelectedItem().toString();
        int harga = Integer.parseInt(hargaTextField.getText());
        int jumlah = Integer.parseInt(spinner1.getValue().toString());
        int total = Integer.parseInt(totalTextField.getText());
        dtm.setRowCount(0);
        try{
            String sql = "INSERT INTO petfood VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = Database.connect.prepareStatement(sql);
            ps.setString(1, kode);
            ps.setString(2, kategori);
            ps.setString(3,brg);
            ps.setInt(4, harga);
            ps.setInt(5, jumlah);
            ps.setInt(6,total);
            ps.execute();
            showDataFood();
            JOptionPane.showMessageDialog(null,"Insert Success");
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Insert Failed");
        }
    }
    public void updateFood(){
        try{
            String sql = "UPDATE petfood SET foodKategori=?, foodBarang=?, foodHarga=?, foodJumlah=?, foodTotal=? WHERE foodID=?";
            PreparedStatement st = Database.connect.prepareStatement(sql);
            dtm.setRowCount(0);
            try{
                st.setString(1,comboBox1.getSelectedItem().toString());
                st.setString(2,comboBox2.getSelectedItem().toString());
                st.setInt(3, Integer.parseInt(hargaTextField.getText()));
                st.setInt(4, Integer.parseInt(spinner1.getValue().toString()));
                st.setInt(5, Integer.parseInt(totalTextField.getText()));
                st.setString(6,kodeTextField.getText());
                st.execute();
                showDataFood();
                JOptionPane.showMessageDialog(null,"Update Success");
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Update Fail");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteFood(){
        try{
            String sql = "DELETE FROM petfood WHERE foodID = '"+ kodeTextField.getText()+"'";
            PreparedStatement stmt = Database.connect.prepareStatement(sql);

            stmt.execute();
            showDataFood();
            JOptionPane.showMessageDialog(null,"Delete Success");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Delete Fail");
        }
    }
    public void searchFood(){
        try{
            String sql = "SELECT * FROM petfood WHERE foodBarang LIKE '%"+cariTextField.getText()+"%'";
            Statement st = Database.connect.createStatement();
            rs = st.executeQuery(sql);
            dtm.setRowCount(0);
            while(rs.next()){
                Object[] row = {
                        rs.getString("foodID"),
                        rs.getString("foodKategori"),
                        rs.getString("foodBarang"),
                        rs.getInt("foodHarga"),
                        rs.getInt("foodJumlah"),
                        rs.getInt("foodTotal")
                };
                dtm.addRow(row);
            }
        }catch (NullPointerException| SQLException e){
            e.printStackTrace();
        }
    }
}
