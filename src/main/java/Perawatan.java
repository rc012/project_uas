import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Perawatan extends JPanel {
    private JLabel title,pilihan,tanggal, cari, kode, harga, nGroom, nShower, nHaircut, nNailTrimming, nTraining, nMedCheckUp;
    private JCheckBox cbGroom, cbShower, cbCut, cbNailTrim, cbCheckUp, cbTraining;
    private JTextField pencarian, kodeCari, hargaCari, pilihanCari;
    private JButton add,update,delete,search,booking;
    private DefaultTableModel dtm;
    private JTable table;
    private JScrollPane scrollPane;
    private Statement st;
    private ResultSet rs;
    private JDateChooser kalender;
    private int total=0,groom,shower,cut,nailtrim,checkup,training;
    private String groomvalue="",showervalue="",cutvalue="",nailtrimvalue="",trainingvalue="",checkupvalue="";
    public Perawatan() {
        setLayout(null);
        setBackground(new Color(30, 47, 143));

        kalender = new JDateChooser();

        title = new JLabel("PERAWATAN");

        pilihan = new JLabel("PILIHAN  :");

        cbGroom = new JCheckBox("Grooming");
        nGroom = new JLabel("Rp120.000");
        nShower = new JLabel ("Rp125.000");
        cbShower = new JCheckBox("Shower");
        cbCut = new JCheckBox("Hair Cut");
        nHaircut = new JLabel("Rp100.000");
        cbNailTrim = new JCheckBox("Nail Trimming");
        nNailTrimming = new JLabel("Rp110.000");
        cbTraining = new JCheckBox("Training");
        nTraining = new JLabel("Rp200.000");
        cbCheckUp = new JCheckBox("Med.Checkup");
        nMedCheckUp = new JLabel("Rp250.000");

        kode = new JLabel("KODE");
        kodeCari = new JTextField();

        harga = new JLabel("HARGA");
        hargaCari = new JTextField();

        tanggal = new JLabel("TANGGAL");
        pencarian = new JTextField();

        cari = new JLabel("PENCARIAN");

        add = new JButton("Add");
        update = new JButton("Update");
        delete = new JButton("Delete");
        search = new JButton("Search");
        booking = new JButton("Booking");

        title.setBounds(310,30,400,40);
        title.setFont(new Font("Calibri", Font.BOLD, 40));
        title.setForeground(Color.WHITE);

        pilihan.setBounds(30, 110, 250, 30);
        pilihan.setFont(new Font("Calibri", Font.ITALIC, 16));
        pilihan.setForeground(Color.WHITE);

        cbGroom.setBounds(30, 140, 120, 30);
        cbGroom.setBackground(new Color(30, 47, 143));
        cbGroom.setForeground(Color.WHITE);
        nGroom.setBounds(180, 140, 250, 30);
        nGroom.setBackground(new Color(30, 47, 143));
        nGroom.setForeground(Color.WHITE);

        cbShower.setBounds(30, 170, 120, 30);
        cbShower.setBackground(new Color(30, 47, 143));
        cbShower.setForeground(Color.WHITE);
        nShower.setBounds(180, 170, 250, 30);
        nShower.setBackground(new Color(30, 47, 143));
        nShower.setForeground(Color.WHITE);

        cbCut.setBounds(30, 200, 120, 30);
        cbCut.setBackground(new Color(30, 47, 143));
        cbCut.setForeground(Color.WHITE);
        nHaircut.setBounds(180, 200, 250, 30);
        nHaircut.setBackground(new Color(30, 47, 143));
        nHaircut.setForeground(Color.WHITE);

        cbNailTrim.setBounds(30, 230, 120, 30);
        cbNailTrim.setBackground(new Color(30, 47, 143));
        cbNailTrim.setForeground(Color.WHITE);
        nNailTrimming.setBounds(180, 230, 250, 30);
        nNailTrimming.setBackground(new Color(30, 47, 143));
        nNailTrimming.setForeground(Color.WHITE);

        cbTraining.setBounds(30, 260, 120, 30);
        cbTraining.setBackground(new Color(30, 47, 143));
        cbTraining.setForeground(Color.WHITE);
        nTraining.setBounds(180, 260, 250, 30);
        nTraining.setBackground(new Color(30, 47, 143));
        nTraining.setForeground(Color.WHITE);

        cbCheckUp.setBounds(30, 290, 120, 30);
        cbCheckUp.setBackground(new Color(30, 47, 143));
        cbCheckUp.setForeground(Color.WHITE);
        nMedCheckUp.setBounds(180, 290, 250, 30);
        nMedCheckUp.setBackground(new Color(30, 47, 143));
        nMedCheckUp.setForeground(Color.WHITE);

        kode.setBounds(30, 340, 400,30);
        kode.setFont(new Font("Calibri", Font.ITALIC, 16));
        kode.setForeground(Color.WHITE);
        kodeCari.setBounds(140, 340, 180, 25);

        harga.setBounds(30, 380, 400,30);
        harga.setFont(new Font("Calibri", Font.ITALIC, 16));
        harga.setForeground(Color.WHITE);
        hargaCari.setBounds(140, 380, 180, 25);

        tanggal.setBounds(30, 420, 400,30);
        tanggal.setFont(new Font("Calibri", Font.ITALIC, 16));
        tanggal.setForeground(Color.WHITE);

        kalender.setBounds(140, 420, 180, 25);

        pencarian.setBounds(475,400,255,25);

        cari.setBounds(380,400,100,30);
        cari.setFont(new Font("Calibri", Font.ITALIC, 16));
        cari.setForeground(Color.WHITE);

        delete.setBounds(45, 470, 75, 25);
        update.setBounds(145, 470, 75, 25);
        add.setBounds(245, 470, 75, 25);
        search.setBounds(735,400,75,25);
        booking.setBounds(720, 470, 90, 30);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertPerawatan();
                kodeCari.setText("");
                hargaCari.setText("");
                cbGroom.setSelected(false);
                cbCheckUp.setSelected(false);
                cbCut.setSelected(false);
                cbNailTrim.setSelected(false);
                cbShower.setSelected(false);
                cbTraining.setSelected(false);
            }
        });
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePerawatan();
                kodeCari.setText("");
                hargaCari.setText("");
                cbGroom.setSelected(false);
                cbCheckUp.setSelected(false);
                cbCut.setSelected(false);
                cbNailTrim.setSelected(false);
                cbShower.setSelected(false);
                cbTraining.setSelected(false);
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePerawatan();
                kodeCari.setText("");
                hargaCari.setText("");
                cbGroom.setSelected(false);
                cbCheckUp.setSelected(false);
                cbCut.setSelected(false);
                cbNailTrim.setSelected(false);
                cbShower.setSelected(false);
                cbTraining.setSelected(false);
            }
        });
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchPerawatan();
            }
        });
        booking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Pemesanan Berhasil");
            }
        });
//---------------------------Tables-------------------------------------------

        String columnNames[] = {"ID", "Pilihan", "Total Harga","Tanggal"};

        dtm = new DefaultTableModel(null,columnNames);
        table = new JTable(dtm);
        scrollPane = new JScrollPane(table);
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                kodeCari.setText(dtm.getValueAt(table.getSelectedRow(),0)+"");
                hargaCari.setText(dtm.getValueAt(table.getSelectedRow(),2)+"");
                try {
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)dtm.getValueAt(table.getSelectedRow(),3));
                    kalender.setDate(date);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
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

        scrollPane.setBounds(380,140,430,250);

        add(scrollPane);
//---------------------------------------------------------------------------

        add(title);
        add(pilihan);
        add(cbGroom);
        add(nGroom);
        add(cbShower);
        add(nShower);
        add(cbCut);
        add(nHaircut);
        add(cbNailTrim);
        add(nNailTrimming);
        add(cbTraining);
        add(nTraining);
        add(cbCheckUp);
        add(nMedCheckUp);
        add(kode);
        add(kodeCari);
        add(harga);
        add(hargaCari);
        add(tanggal);
        add(kalender);
        add(add);
        add(update);
        add(delete);
        add(cari);
        add(pencarian);
        add(search);
        add(booking);
        sum();
        showDataPerawatan();
    }
    public void sum(){
        cbGroom.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (cbGroom.isSelected()) {
                    groom = 120000;
                    total += groom;
                    groomvalue = cbGroom.getText();
                    hargaCari.setText(String.valueOf(total));
                } else {
                    total -= groom;
                    groomvalue = "";
                    hargaCari.setText(String.valueOf(total));
                }
            }
        });
        cbShower.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (cbShower.isSelected()) {
                    shower = 125000;
                    total += shower;
                    showervalue = cbShower.getText();
                    hargaCari.setText(String.valueOf(total));
                } else {
                    total -= shower;
                    showervalue = "";
                    hargaCari.setText(String.valueOf(total));
                }
            }
        });
        cbCut.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (cbCut.isSelected()) {
                    cut = 100000;
                    total += cut;
                    cutvalue = cbCut.getText();
                    hargaCari.setText(String.valueOf(total));
                } else {
                    total -= cut;
                    cutvalue = "";
                    hargaCari.setText(String.valueOf(total));
                }
            }
        });
        cbNailTrim.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (cbNailTrim.isSelected()) {
                    nailtrim = 110000;
                    total += nailtrim;
                    nailtrimvalue = cbNailTrim.getText();
                    hargaCari.setText(String.valueOf(total));
                } else {
                    total -= nailtrim;
                    nailtrimvalue = "";
                    hargaCari.setText(String.valueOf(total));
                }
            }
        });
        cbTraining.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(cbTraining.isSelected()) {
                    training = 200000;
                    total += training;
                    trainingvalue=cbTraining.getText();
                    hargaCari.setText(String.valueOf(total));
                }else{
                    total -= training;
                    trainingvalue="";
                    hargaCari.setText(String.valueOf(total));
                }
            }
        });
        cbCheckUp.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(cbCheckUp.isSelected()) {
                    checkup = 250000;
                    total += checkup;
                    checkupvalue = cbCheckUp.getText();
                    hargaCari.setText(String.valueOf(total));
                }else{
                    total -= checkup;
                    checkupvalue ="";
                    hargaCari.setText(String.valueOf(total));
                }
            }
        });
    }
    public void showDataPerawatan(){
        try{
            String sql = "SELECT * FROM perawatan";
            st = Database.connect.createStatement();
            rs = st.executeQuery(sql);
            dtm.setRowCount(0);
            while(rs.next()){
                Object[] row = {
                        rs.getString("perawatanID"),
                        rs.getString("perawatanPilihan"),
                        rs.getString("perawatanHarga"),
                        rs.getString("perawatanTgl")
                };
                dtm.addRow(row);
            }
        }catch (NullPointerException| SQLException e){
            e.printStackTrace();
        }
    }
    public void insertPerawatan(){
        String kode = kodeCari.getText();
        int harga = Integer.parseInt(hargaCari.getText());
        String check = groomvalue+ " " +showervalue+ " " +cutvalue+ " " +nailtrimvalue+ " " +trainingvalue+ " " +checkupvalue;
        pilihanCari.setText(check);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(kalender.getDate());
        dtm.setRowCount(0);
        try{
            String sql = "INSERT INTO perawatan VALUES(?, ?, ?, ?)";
            PreparedStatement ps = Database.connect.prepareStatement(sql);
            ps.setString(1, kode);
            ps.setString(2, check);
            ps.setInt(3, harga);
            ps.setString(4, date);
            ps.execute();
            showDataPerawatan();
            JOptionPane.showMessageDialog(null,"Insert Success");
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Insert Failed");
        }
    }
    public void updatePerawatan(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(kalender.getDate());
        try{
            String sql = "UPDATE perewatan SET perawatanPilihan=?, perawatanHarga=?, perawatanTgl=? WHERE perawatanID=?";
            PreparedStatement st = Database.connect.prepareStatement(sql);
            dtm.setRowCount(0);
            try{
                st.setString(1,pilihanCari.getText());
                st.setString(2,hargaCari.getText());
                st.setString(3,date);
                st.setString(4,kodeCari.getText());
                st.execute();
                showDataPerawatan();
                JOptionPane.showMessageDialog(null,"Update Success");
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Update Fail");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deletePerawatan(){
        try{
            String sql = "DELETE FROM perawatan WHERE perawatanID = '"+ kodeCari.getText()+"'";
            PreparedStatement stmt = Database.connect.prepareStatement(sql);

            stmt.execute();
            showDataPerawatan();
            JOptionPane.showMessageDialog(null,"Delete Success");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Delete Fail");
        }
    }
    public void searchPerawatan(){
        try{
            String sql = "SELECT * FROM perawatan WHERE perawatanTgl LIKE '%"+pencarian.getText()+"%'";
            Statement st = Database.connect.createStatement();
            rs = st.executeQuery(sql);
            dtm.setRowCount(0);
            while(rs.next()){
                Object[] row = {
                        rs.getString("perawatanID"),
                        rs.getString("perawatanPilihan"),
                        rs.getString("perawatanHarga"),
                        rs.getString("perawatanTgl")
                };
                dtm.addRow(row);
            }
        }catch (NullPointerException| SQLException e){
            e.printStackTrace();
        }
    }
}