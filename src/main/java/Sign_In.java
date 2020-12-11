import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class Sign_In extends JFrame {
    private JPanel container = new JPanel();

    private JLabel closeLabel = new JLabel("X");
    private JLabel userLabel = new JLabel("Username");
    private JLabel titleLabel = new JLabel("Sign In");
    private JLabel judulLabel = new JLabel("Happy Paws");
    private JLabel passwordLabel = new JLabel("Password");

    private ImageIcon icon = new ImageIcon("img/pawprint.png");

    private JTextField userTextField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();

     JButton signInButton = new JButton("Sign In");
    private JButton signUpButton = new JButton("Sign Up");

    private JCheckBox showPassword = new JCheckBox("Show Password");

    private int mouseX;
    private int mouseY;

    public Sign_In(){
        new Database();
        setSize(370,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        container.setLayout(null);
        container.setBackground(new Color(20, 34, 56));

        judulLabel.setForeground(Color.WHITE);
        judulLabel.setBounds(70,50,300,40);
        judulLabel.setFont(new Font("Ravie",Font.PLAIN,28));

        userLabel.setForeground(Color.WHITE);
        userLabel.setBounds(60,100,100,30);

        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(60,150,100,30);

        userTextField.setBounds(150,100,160,25);
        passwordField.setBounds(150,150,160,25);

        showPassword.setForeground(Color.WHITE);
        showPassword.setBounds(146,185,150,30);
        showPassword.setBackground(new Color(20, 34, 56));

        signInButton.setForeground(Color.WHITE);
        signInButton.setBounds(200,230,110,30);
        signInButton.setBackground(new Color(45, 146, 235));

        signUpButton.setForeground(Color.WHITE);
        signUpButton.setBounds(60,230,110,30);
        signUpButton.setBackground(new Color(45, 146, 235));

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

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userTextField.getText();
                passwordField.setEchoChar((char)0);
                String pass = String.valueOf(passwordField.getPassword());
                try{
                    String sql = "SELECT accUsername,accPassword FROM account WHERE accUsername='"+user+"' AND accPassword='"+pass+"'";
                    Statement st = Database.connect.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    if(rs.next()){
                        if(user.equals(rs.getString("accUsername")) && pass.equals(rs.getString("accPassword"))){
                            JOptionPane.showMessageDialog(null,"Success Sign In");
                            new MainMenu();
                            dispose();
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Wrong Username And Password");
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Sign_Up();
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

        container.add(closeLabel);
        container.add(titleLabel);
        container.add(judulLabel);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(signInButton);
        container.add(signUpButton);

        add(container);
        setUndecorated(true);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
