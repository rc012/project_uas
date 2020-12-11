import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {
    private JLabel menu = new JLabel("MENU");
    static JLabel beliHewanMenu = new JLabel("      BELI HEWAN");
    static JLabel penitipanMenu = new JLabel("      PENITITPAN");
    static JLabel perawatanMenu = new JLabel("      PERAWATAN");
    static JLabel accessoriesMenu = new JLabel("      ACCESSORIES");
    static JLabel petFoodMenu = new JLabel("      PET FOOD");
    static JLabel logout = new JLabel("      LOGOUT");
    static JLabel close = new JLabel("      CLOSE");

    Font style = new Font("Calibri",Font.ITALIC,17);
    Font style1 = new Font("Calibri",Font.ITALIC,32);


    Color background = new Color(255, 140, 0);
    public Menu(){
        setSize(200,550);
        setLayout(null);
        setBackground(background);

        menu.setBounds(50,30,200,40);
        menu.setForeground(Color.BLACK);
        menu.setFont(style1);

        beliHewanMenu.setBounds(0,100,200,50);
        beliHewanMenu.setFont(style);
        beliHewanMenu.setBackground(background);
        beliHewanMenu.setForeground(Color.BLACK);
        beliHewanMenu.setOpaque(true);

        penitipanMenu.setBounds(0,150,200,50);
        penitipanMenu.setFont(style);
        penitipanMenu.setBackground(background);
        penitipanMenu.setForeground(Color.BLACK);
        penitipanMenu.setOpaque(true);

        perawatanMenu.setBounds(0,200,200,50);
        perawatanMenu.setFont(style);
        perawatanMenu.setBackground(background);
        perawatanMenu.setForeground(Color.BLACK);
        perawatanMenu.setOpaque(true);

        accessoriesMenu.setBounds(0,250,200,50);
        accessoriesMenu.setFont(style);
        accessoriesMenu.setBackground(background);
        accessoriesMenu.setForeground(Color.BLACK);
        accessoriesMenu.setOpaque(true);

        petFoodMenu.setBounds(0,300,200,50);
        petFoodMenu.setFont(style);
        petFoodMenu.setBackground(background);
        petFoodMenu.setForeground(Color.BLACK);
        petFoodMenu.setOpaque(true);

        logout.setBounds(0,450,200,50);
        logout.setFont(style);
        logout.setBackground(background);
        logout.setForeground(Color.BLACK);
        logout.setOpaque(true);

        close.setBounds(0,500,200,50);
        close.setFont(style);
        close.setBackground(background);
        close.setForeground(Color.BLACK);
        close.setOpaque(true);

        add(menu);
        add(beliHewanMenu);
        add(penitipanMenu);
        add(perawatanMenu);
        add(accessoriesMenu);
        add(petFoodMenu);
        add(logout);
        add(close);

        setVisible(true);
    }
}
