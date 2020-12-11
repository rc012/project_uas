import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Hashtable;

public class BeliHewan extends JPanel{
    private JLabel title, code, kategori, jenis, harga, kata, cari;
    private JComboBox mainComboBox, subComboBox;
    private JTextField textFieldlCode, textFieldHarga, pencarian;
    private JButton add,update,delete,search, order;
    private Hashtable<Object, Object> subItems = new Hashtable<Object, Object>();
    private String columnNames[] = {"ID", "Kategori", "Jenis", "Harga"};
    private DefaultTableModel dtm = new DefaultTableModel(null,columnNames);;
    private JTable table = new JTable(dtm);
    private JScrollPane scrollPane = new JScrollPane(table);
    private Statement st;
    private ResultSet rs;
    public BeliHewan() {
        new Database();
        setLayout(null);
        setBackground(new Color(30, 47, 143));

        String Jenis[]={"-"};

        title = new JLabel("PEMBELIAN HEWAN");
        code = new JLabel("KODE");
        kategori = new JLabel("KATEGORI");
        jenis = new JLabel("JENIS");
        harga = new JLabel("HARGA");
        kata = new JLabel("*Setiap customer hanya bisa membeli 1 jenis hewan (Kebijakan Toko)");

        cari = new JLabel("PENCARIAN");

        String[] items = {"Select", "Anjing", "Kucing"};
        mainComboBox = new JComboBox(items);
        mainComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = (String) mainComboBox.getSelectedItem();
                Object o = subItems.get(item);

                if (o == null) {
                    subComboBox.setModel(new DefaultComboBoxModel());
                } else {
                    subComboBox.setModel(new DefaultComboBoxModel((String[]) o));
                }
            }
        });

        subComboBox = new JComboBox(Jenis);
        subComboBox.setPrototypeDisplayValue("");


        String[] subItems1 = {"Select Dog", "Beagle", "Shiba Inu", "Pug"};
        subItems.put(items[1], subItems1);
        String[] subItems2 = {"Select Cat", "Sphynx", "Persian", "Angora"};
        subItems.put(items[2], subItems2);

        textFieldlCode = new JTextField();
        textFieldHarga = new JTextField();
        pencarian = new JTextField();
        add = new JButton("Add");
        update = new JButton("Update");
        delete = new JButton("Delete");
        search = new JButton("Search");
        order = new JButton("Order");

        title.setBounds(250,30,400,40);
        title.setFont(new Font("Calibri",Font.BOLD,40));
        title.setForeground(Color.WHITE);

        code.setBounds(30, 140, 250, 30);
        code.setFont(new Font("Calibri", Font.ITALIC, 16));
        code.setBackground(new Color(20, 34, 56));
        code.setForeground(Color.WHITE);
        textFieldlCode.setBounds(140, 140, 180, 25);

        kategori.setBounds(30,190, 100,30);
        kategori.setFont(new Font("Calibri", Font.ITALIC, 16));
        kategori.setForeground(Color.WHITE);
        mainComboBox.setBounds(140, 190, 180, 25);

        jenis.setBounds(30, 230, 230, 30);
        jenis.setFont(new Font("Calibri", Font.ITALIC, 16));
        jenis.setForeground(Color.WHITE);
        subComboBox.setBounds(140, 230, 180, 25);

        harga.setBounds(30, 270, 270, 30);
        harga.setFont(new Font("Calibri", Font.ITALIC, 16));
        harga.setForeground(Color.WHITE);
        textFieldHarga.setBounds(140, 270, 180, 25);

        pencarian.setBounds(475,400,255,25);

        cari.setBounds(380,400,100,30);
        cari.setFont(new Font("Calibri", Font.ITALIC, 16));
        cari.setForeground(Color.WHITE);

        delete.setBounds(45, 320, 75, 25);
        update.setBounds(145, 320, 75, 25);
        add.setBounds(245, 320, 75, 25);
        search.setBounds(735,400,75,25);
        order.setBounds(720, 470, 90, 30);

        kata.setBounds(570, 530, 300, 25);
        kata.setFont(new Font("Calibri",Font.PLAIN,9));
        kata.setForeground(Color.WHITE);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertBeli();
                textFieldlCode.setText("");
                mainComboBox.setSelectedItem("Select");
                subComboBox.setSelectedItem("-");
                textFieldHarga.setText("");
            }
        });
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBeli();
                textFieldlCode.setText("");
                mainComboBox.setSelectedItem("Select");
                subComboBox.setSelectedItem("-");
                textFieldHarga.setText("");
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBeli();
                textFieldlCode.setText("");
                mainComboBox.setSelectedItem("Select");
                subComboBox.setSelectedItem("-");
                textFieldHarga.setText("");
            }
        });
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBeli();
            }
        });
        order.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Pembelian Berhasil");
            }
        });
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textFieldlCode.setText(dtm.getValueAt(table.getSelectedRow(),0)+"");
                mainComboBox.setSelectedItem(dtm.getValueAt(table.getSelectedRow(),1)+"");
                subComboBox.setSelectedItem(dtm.getValueAt(table.getSelectedRow(),2)+"");
                textFieldHarga.setText(dtm.getValueAt(table.getSelectedRow(),3)+"");
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
        add(title);
        add(code);
        add(textFieldlCode);
        add(kategori);
        add(mainComboBox);
        add(jenis);
        add(subComboBox);
        add(harga);
        add(textFieldHarga);
        add(add);
        add(update);
        add(delete);
        add(cari);
        add(pencarian);
        add(search);
        add(kata);
        add(order);

        subComboBox.addItemListener(new ToggleListener());

//---------------------------Tables-------------------------------------------

        showDataBeli();
        scrollPane.setBounds(380,140,430,250);
        add(scrollPane);
    }

    public void showDataBeli(){
        mainComboBox.addItem("");
        subComboBox.addItem("");

        try{
            String sql = "SELECT * FROM belihewan";
            st = Database.connect.createStatement();
            rs = st.executeQuery(sql);
            dtm.setRowCount(0);
            while(rs.next()){
                Object[] row = {
                        rs.getString("beliID"),
                        rs.getString("beliKategori"),
                        rs.getString("beliJenis"),
                        rs.getInt("beliHarga")
                };
                dtm.addRow(row);
            }
        }catch (NullPointerException| SQLException e){
            e.printStackTrace();
        }
    }
    public void insertBeli(){
        String kode = textFieldlCode.getText();
        String kategori = mainComboBox.getSelectedItem().toString();
        String jenis = subComboBox.getSelectedItem().toString();
        int harga = Integer.parseInt(textFieldHarga.getText());

        try{
            String sql = "INSERT INTO belihewan VALUES(?, ?, ?, ?)";
            PreparedStatement ps = Database.connect.prepareStatement(sql);
            dtm.setRowCount(0);
            ps.setString(1, kode);
            ps.setString(2, kategori);
            ps.setString(3, jenis);
            ps.setInt(4, harga);
            ps.execute();
            showDataBeli();
            JOptionPane.showMessageDialog(null,"Insert Success");
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Insert Failed");
        }
    }
    public void updateBeli(){
        try{
            String sql = "UPDATE belihewan SET beliKategori=?, beliJenis=?, beliHarga=? WHERE beliID=?";
            PreparedStatement st = Database.connect.prepareStatement(sql);
            dtm.setRowCount(0);
            try{
                st.setString(1,mainComboBox.getSelectedItem().toString());
                st.setString(2,subComboBox.getSelectedItem().toString());
                st.setInt(3,Integer.parseInt(textFieldHarga.getText()));
                st.setString(4,textFieldlCode.getText());
                st.execute();
                showDataBeli();
                JOptionPane.showMessageDialog(null,"Update Success");
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Update Fail");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteBeli(){
        try{
            String sql = "DELETE FROM belihewan WHERE beliID = '"+ textFieldlCode.getText()+"'";
            PreparedStatement stmt = Database.connect.prepareStatement(sql);

            stmt.execute();
            showDataBeli();
            JOptionPane.showMessageDialog(null,"Delete Success");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Delete Fail");
        }
    }
    public void searchBeli(){
        mainComboBox.addItem("");
        subComboBox.addItem("");

        try{
            String sql = "SELECT * FROM belihewan WHERE beliJenis LIKE '%"+pencarian.getText()+"%'";
            Statement st = Database.connect.createStatement();
            rs = st.executeQuery(sql);
            dtm.setRowCount(0);
            while(rs.next()){
                Object[] row = {
                        rs.getString("beliID"),
                        rs.getString("beliKategori"),
                        rs.getString("beliJenis"),
                        rs.getInt("beliHarga")
                };
                dtm.addRow(row);
            }
        }catch (NullPointerException| SQLException e){
            e.printStackTrace();
        }
    }
    class ToggleListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            String items = (String) subComboBox.getSelectedItem();

            if ("Beagle".equals(items)) {
                textFieldHarga.setText(String.valueOf(7500000));
            }
            else if ("Shiba Inu".equals(items)) {
                textFieldHarga.setText(String.valueOf(10000000));
            }
            else if ("Pug".equals(items)) {
                textFieldHarga.setText(String.valueOf(3500000));
            }
            else if ("Sphynx".equals(items)) {
                textFieldHarga.setText(String.valueOf(22500000));
            }
            else if ("Persian".equals(items)) {
                textFieldHarga.setText(String.valueOf(15000000));
            }
            else if ("Angora".equals(items)) {
                textFieldHarga.setText(String.valueOf(6500000));
            } else{
                textFieldHarga.setText("-");
            }
        }
    }
}