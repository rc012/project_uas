import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MainMenu extends JFrame {
    private JLabel dragbar = new JLabel();
    private JLabel logo = new JLabel();
    private ImageIcon icon = new ImageIcon("img/logo.png");
    BeliHewan beli = new BeliHewan();
    Penitipan penitipan = new Penitipan();
    Perawatan perawatan = new Perawatan();
    Accessories accessories = new Accessories();
    PetFood petFood = new PetFood();
    private int mouseX;
    private int mouseY;
    public MainMenu(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1050,550);
        setLayout(null);

        dragbar.setBounds(0,0,1050,30);
        mouseMotionListenner();
        mouseListener();

        logo.setIcon(icon);
        logo.setBounds(200,0,850,550);
        logo.setHorizontalAlignment(JLabel.CENTER);
        logo.setVerticalAlignment(JLabel.CENTER);
        logo.setOpaque(true);
        logo.setBackground(Color.LIGHT_GRAY);

        beli.setBounds(200,0,850,550);
        beli.setVisible(false);

        penitipan.setBounds(200,0,850,550);
        penitipan.setVisible(false);

        perawatan.setBounds(200,0,850,550);
        perawatan.setVisible(false);

        accessories.setBounds(200,0,850,550);
        accessories.setVisible(false);

        petFood.setBounds(200,0,850,550);
        petFood.setVisible(false);

        add(dragbar);
        add(new Menu());
        add(beli);
        add(penitipan);
        add(perawatan);
        add(accessories);
        add(petFood);
        add(logo);
        setUndecorated(true);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void mouseListener(){
        Menu.logout.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Sign_In();
                dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Menu.logout.setBackground(new Color(26, 38, 115));
                Menu.logout.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Menu.logout.setBackground(new Color(255, 140, 0));
                Menu.logout.setForeground(Color.BLACK);
            }
        });

        Menu.beliHewanMenu.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                beli.setVisible(true);
                penitipan.setVisible(false);
                perawatan.setVisible(false);
                accessories.setVisible(false);
                petFood.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Menu.beliHewanMenu.setBackground(new Color(26, 38, 115));
                Menu.beliHewanMenu.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Menu.beliHewanMenu.setBackground(new Color(255, 140, 0));
                Menu.beliHewanMenu.setForeground(Color.BLACK);
            }
        });

        Menu.penitipanMenu.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                penitipan.setVisible(true);
                perawatan.setVisible(false);
                accessories.setVisible(false);
                beli.setVisible(false);
                petFood.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Menu.penitipanMenu.setBackground(new Color(26, 38, 115));
                Menu.penitipanMenu.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Menu.penitipanMenu.setBackground(new Color(255, 140, 0));
                Menu.penitipanMenu.setForeground(Color.BLACK);
            }
        });

        Menu.perawatanMenu.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                perawatan.setVisible(true);
                accessories.setVisible(false);
                beli.setVisible(false);
                penitipan.setVisible(false);
                petFood.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Menu.perawatanMenu.setBackground(new Color(26, 38, 115));
                Menu.perawatanMenu.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Menu.perawatanMenu.setBackground(new Color(255, 140, 0));
                Menu.perawatanMenu.setForeground(Color.BLACK);
            }
        });

        Menu.accessoriesMenu.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                accessories.setVisible(true);
                beli.setVisible(false);
                penitipan.setVisible(false);
                perawatan.setVisible(false);
                petFood.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Menu.accessoriesMenu.setBackground(new Color(26, 38, 115));
                Menu.accessoriesMenu.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Menu.accessoriesMenu.setBackground(new Color(255, 140, 0));
                Menu.accessoriesMenu.setForeground(Color.BLACK);
            }
        });

        Menu.petFoodMenu.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                petFood.setVisible(true);
                beli.setVisible(false);
                penitipan.setVisible(false);
                perawatan.setVisible(false);
                accessories.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Menu.petFoodMenu.setBackground(new Color(26, 38, 115));
                Menu.petFoodMenu.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Menu.petFoodMenu.setBackground(new Color(255, 140, 0));
                Menu.petFoodMenu.setForeground(Color.BLACK);
            }
        });

        Menu.close.addMouseListener(new MouseListener() {
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
                Menu.close.setBackground(new Color(26, 38, 115));
                Menu.close.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Menu.close.setBackground(new Color(255, 140, 0));
                Menu.close.setForeground(Color.BLACK);
            }
        });
    }

    public void mouseMotionListenner(){
        dragbar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
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

        dragbar.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int kordinatX = e.getXOnScreen();
                int kordinatY = e.getYOnScreen();

                setLocation(kordinatX-mouseX,kordinatY-mouseY);
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }
}
