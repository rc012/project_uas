import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Penitipan extends JPanel {
    private JLabel title, code, type, start, end, cari;
    private JTextField textFieldlCode, pencarian;
    private JComboBox pil;
    private JDateChooser kalender;
    private JDateChooser kalender1;
    private JButton add,delete,update,search,booking;
    private DefaultTableModel dtm;
    private JTable table;
    private JScrollPane scrollPane;
    private Statement st;
    private ResultSet rs;
    public Penitipan() {
        setLayout(null);
        setBackground(new Color(30, 47, 143));

        //91, 2, 245
        String Pet[] = {"Anjing", "Kucing"};
        kalender = new JDateChooser();
        kalender1 = new JDateChooser();

        title = new JLabel("PENITIPAN");
        code = new JLabel("KODE");
        textFieldlCode = new JTextField();
        pencarian = new JTextField();
        type = new JLabel("JENIS");
        pil = new JComboBox(Pet);
        start = new JLabel("DARI");
        end = new JLabel("SAMPAI");
        add = new JButton("Add");
        update = new JButton("Update");
        delete = new JButton("Delete");
        search = new JButton("Search");
        booking = new JButton("Booking");

        cari = new JLabel("PENCARIAN");

        title.setBounds(330, 30, 400, 40);
        title.setFont(new Font("Calibri", Font.BOLD, 40));
        title.setForeground(Color.WHITE);

        //---------------------------------------------------------------------------

        code.setBounds(30, 140, 250, 30);
        code.setFont(new Font("Calibri", Font.ITALIC, 16));
        code.setBackground(new Color(20, 34, 56));
        code.setForeground(Color.WHITE);

        textFieldlCode.setBounds(140, 140, 180, 25);

        //---------------------------------------------------------------------------

        type.setBounds(30,190, 100,30);
        type.setFont(new Font("Calibri", Font.ITALIC, 16));
        type.setBackground(new Color(20, 34, 56));
        type.setForeground(Color.WHITE);

        pil.setBounds(140, 190, 180, 25);

        //---------------------------------------------------------------------------

        start.setBounds(30, 230, 250, 30);
        start.setFont(new Font("Calibri", Font.ITALIC, 16));
        start.setBackground(new Color(20, 34, 56));
        start.setForeground(Color.WHITE);

        kalender.setBounds(140, 230, 180, 25);

        //---------------------------------------------------------------------------

        end.setBounds(30, 270, 250, 30);
        end.setFont(new Font("Calibri", Font.ITALIC, 16));
        end.setBackground(new Color(20, 34, 56));
        end.setForeground(Color.WHITE);

        kalender1.setBounds(140, 270, 180, 25);

        //---------------------------------------------------------------------------

        pencarian.setBounds(475,400,255,25);

        cari.setBounds(380,400,100,30);
        cari.setFont(new Font("Calibri", Font.ITALIC, 16));
        cari.setForeground(Color.WHITE);

        //---------------------------------------------------------------------------

        delete.setBounds(45, 320, 75, 25);
        update.setBounds(145, 320, 75, 25);
        add.setBounds(245, 320, 75, 25);
        search.setBounds(735,400,75,25);
        booking.setBounds(720, 470, 90, 30);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertPenitip();
                textFieldlCode.setText("");
                pil.setSelectedItem("Anjing");
            }
        });
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePenitip();
                textFieldlCode.setText("");
                pil.setSelectedItem("Anjing");
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePenitip();
                textFieldlCode.setText("");
                pil.setSelectedItem("Anjing");
            }
        });
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchPenitip();
            }
        });
        booking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Pemesanan Berhasil");
            }
        });
//---------------------------Tables-------------------------------------------

        String columnNames[] = {"ID", "Tipe", "Mulai dari", "Sampai"};
        dtm = new DefaultTableModel(null,columnNames);
        table = new JTable(dtm);
        scrollPane = new JScrollPane(table);
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textFieldlCode.setText(dtm.getValueAt(table.getSelectedRow(),0)+"");
                pil.setSelectedItem(dtm.getValueAt(table.getSelectedRow(),1)+"");
                try {
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)dtm.getValueAt(table.getSelectedRow(),2));
                    Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse((String)dtm.getValueAt(table.getSelectedRow(),3));
                    kalender.setDate(date);
                    kalender1.setDate(date1);
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
        add(code);
        add(textFieldlCode);
        add(type);
        add(pil);
        add(start);
        add(kalender);
        add(end);
        add(kalender1);
        add(add);
        add(update);
        add(delete);
        add(cari);
        add(pencarian);
        add(search);
        add(booking);
        showDataPenitip();
    }
    public void showDataPenitip(){
        pil.addItem("");

        try{
            String sql = "SELECT * FROM penitipan";
            st = Database.connect.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Object[] row = {
                        rs.getString("penitipanID"),
                        rs.getString("penitipanJenis"),
                        rs.getString("penitipanTglTitip"),
                        rs.getString("penitipanTglAmbil")
                };
                dtm.addRow(row);
            }
        }catch (NullPointerException| SQLException e){
            e.printStackTrace();
        }
    }
    public void insertPenitip(){
        String kode = textFieldlCode.getText();
        String jenis = pil.getSelectedItem().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(kalender.getDate());
        String date1 = sdf.format(kalender1.getDate());
        dtm.setRowCount(0);
        try{
            String sql = "INSERT INTO penitipan VALUES(?, ?, ?, ?)";
            PreparedStatement ps = Database.connect.prepareStatement(sql);
            ps.setString(1, kode);
            ps.setString(2, jenis);
            ps.setString(3, date);
            ps.setString(4, date1);
            ps.execute();
            showDataPenitip();
            JOptionPane.showMessageDialog(null,"Insert Success");
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Insert Failed");
        }
    }
    public void updatePenitip(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(kalender.getDate());
        String date1 = sdf.format(kalender1.getDate());
        try{
            String sql = "UPDATE penitipan SET penitipanJenis=?, penitipanTglTitip=?, penitipanTglAmbil=? WHERE penitipanID=?";
            PreparedStatement st = Database.connect.prepareStatement(sql);
            dtm.setRowCount(0);
            try{
                st.setString(1,pil.getSelectedItem().toString());
                st.setString(2,date);
                st.setString(3,date1);
                st.setString(4,textFieldlCode.getText());
                st.execute();
                showDataPenitip();
                JOptionPane.showMessageDialog(null,"Update Success");
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Update Fail");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deletePenitip(){
        try{
            String sql = "DELETE FROM penitipan WHERE penitipanID = '"+ textFieldlCode.getText()+"'";
            PreparedStatement stmt = Database.connect.prepareStatement(sql);

            stmt.execute();
            showDataPenitip();
            JOptionPane.showMessageDialog(null,"Delete Success");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Delete Fail");
        }
    }
    public void searchPenitip(){
        pil.addItem("");

        try{
            String sql = "SELECT * FROM penitipan WHERE penitipanTglTitip LIKE '%"+pencarian.getText()+"%'";
            Statement st = Database.connect.createStatement();
            rs = st.executeQuery(sql);
            dtm.setRowCount(0);
            while(rs.next()){
                Object[] row = {
                        rs.getString("penitipanID"),
                        rs.getString("penitipanJenis"),
                        rs.getString("penitipanTglTitip"),
                        rs.getString("penitipanTglAmbil")
                };
                dtm.addRow(row);
            }
        }catch (NullPointerException| SQLException e){
            e.printStackTrace();
        }
    }
}
