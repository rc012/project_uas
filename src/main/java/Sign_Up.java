import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;

public class Sign_Up extends JFrame {
    private JPanel container= new JPanel();

    private JLabel closeLabel = new JLabel("X");
    private JLabel titleLabel = new JLabel("Sign Up");
    private JLabel judulLabel = new JLabel("Sign Up");
    private JLabel namaLabel = new JLabel("Nama");
    private JLabel emailLabel = new JLabel("Email");
    private JLabel userLabel = new JLabel("Username");
    private JLabel passwordLabel = new JLabel("Password");
    private JLabel noTelpLabel = new JLabel("No.Telp");
    private JLabel alamatLabel = new JLabel("Alamat");

    private ImageIcon icon = new ImageIcon("img/pawprint.png");

    private JTextField namaTextField = new JTextField();
    private JTextField emailTextField = new JTextField();
    private JTextField userTextField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JTextField noTelpTextField = new JTextField();
    private JTextField alamatTextField = new JTextField();

    private JButton submitButton = new JButton("Submit");
    private JButton cancelButton = new JButton("Cancel");

    private JCheckBox showPassword = new JCheckBox("Show Password");

    private int mouseX;
    private int mouseY;
    public Sign_Up(){
        new Database();
        setSize(370,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        container.setLayout(null);
        container.setBackground(new Color(20, 34, 56));

        judulLabel.setForeground(Color.WHITE);
        judulLabel.setBounds(120,50,300,40);
        judulLabel.setFont(new Font("Ravie",Font.PLAIN,28));

        namaLabel.setBounds(60,100,100,30);
        namaLabel.setForeground(Color.WHITE);

        userLabel.setForeground(Color.WHITE);
        userLabel.setBounds(60,150,100,30);

        emailLabel.setForeground(Color.WHITE);
        emailLabel.setBounds(60,200,100,30);

        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(60,250,100,30);

        noTelpLabel.setForeground(Color.WHITE);
        noTelpLabel.setBounds(60,320,100,30);

        alamatLabel.setForeground(Color.WHITE);
        alamatLabel.setBounds(60,370,100,30);

        namaTextField.setBounds(150,100,160,30);
        userTextField.setBounds(150,150,160,30);
        emailTextField.setBounds(150,200,160,30);
        passwordField.setBounds(150,250,160,30);
        noTelpTextField.setBounds(150,320,160,30);
        alamatTextField.setBounds(150,370,160,30);

        showPassword.setForeground(Color.WHITE);
        showPassword.setBounds(146,280,150,30);
        showPassword.setBackground(new Color(20, 34, 56));

        submitButton.setForeground(Color.WHITE);
        submitButton.setBounds(200,425,110,30);
        submitButton.setBackground(new Color(45, 146, 235));

        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBounds(60,425,110,30);
        cancelButton.setBackground(new Color(45, 146, 235));

        closeLabel.setForeground(Color.BLACK);
        closeLabel.setHorizontalAlignment(JLabel.CENTER);
        closeLabel.setBounds(340,0,30,30);
        closeLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                closeLabel.setForeground(Color.WHITE);
                closeLabel.setBackground(Color.RED);
                closeLabel.setOpaque(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                closeLabel.setForeground(Color.BLACK);
                closeLabel.setBackground(new Color(255, 140, 0));
            }
        });

        titleLabel.setIcon(icon);
        titleLabel.setOpaque(true);
        titleLabel.setIconTextGap(5);
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setHorizontalAlignment(JLabel.LEFT);
        titleLabel.setVerticalTextPosition(JLabel.CENTER);
        titleLabel.setHorizontalTextPosition(JLabel.RIGHT);
        titleLabel.setBounds(0,0,370,30);
        titleLabel.setBackground(new Color(255, 140, 0));
        titleLabel.setFont(new Font("Times New Roman",Font.PLAIN,16));
        titleLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) { }

            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) { }

            @Override
            public void mouseEntered(MouseEvent e) { }

            @Override
            public void mouseExited(MouseEvent e) { }
        });

        titleLabel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int kordinatX = e.getXOnScreen();
                int kordinatY = e.getYOnScreen();

                setLocation(kordinatX-mouseX,kordinatY-mouseY);
            }

            @Override
            public void mouseMoved(MouseEvent e) { }
        });

        container.add(closeLabel);
        container.add(titleLabel);
        container.add(judulLabel);
        container.add(userLabel);
        container.add(namaLabel);
        container.add(emailLabel);
        container.add(passwordLabel);
        container.add(noTelpLabel);
        container.add(alamatLabel);
        container.add(namaTextField);
        container.add(userTextField);
        container.add(emailTextField);
        container.add(passwordField);
        container.add(noTelpTextField);
        container.add(alamatTextField);
        container.add(showPassword);
        container.add(submitButton);
        container.add(cancelButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                daftar();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Sign_In();
                dispose();
            }
        });

        showPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(showPassword.isSelected()){
                    passwordField.setEchoChar((char)0);
                }else{
                    passwordField.setEchoChar('*');
                }
            }
        });

        add(container);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }
    public void daftar(){
        String nama = namaTextField.getText();
        String noTelp = noTelpTextField.getText();
        String alamat = alamatTextField.getText();
        String user = userTextField.getText();
        String email = emailTextField.getText();
        passwordField.setEchoChar((char)0);
        String pass = String.valueOf(passwordField.getPassword());

        try{
            String sql = "INSERT INTO account(accName,accUsername,accEmail,accPassword,accNoTelp,accAlamat) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = Database.connect.prepareStatement(sql);
            ps.setString(1,nama);
            ps.setString(2,user);
            ps.setString(3,email);
            ps.setString(4,pass);
            ps.setString(5,noTelp);
            ps.setString(6,alamat);
            ps.execute();
            JOptionPane.showMessageDialog(null,"Success Sign Up");
            new Sign_In();
            dispose();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Failed Sign Up");
        }
    }
}
