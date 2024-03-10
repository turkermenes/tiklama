import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main implements ActionListener {


    JFrame frame;
    JPanel[] paneller = new JPanel[3];
    public static JPanel baslaPaneli, oyunPaneli, oyunBittiPaneli;
    public static JButton baslaButonu, oyunButonu, yenidenDeneButonu, anaMenuButonu;
    public static JLabel skorYazisi, sureYazisi, oyunBittiYazisi, oyunBittiSkorYazisi;

    public static int skorSayaci = 0, sure = 10;
    public static int rastgeleX = rastgeleSayi(100, 750);
    public static int rastgeleY = rastgeleSayi(100, 725);
    public static int renkSec = rastgeleSayi(1, 12);


    Main() {

        baslaButonu = new JButton("Başla");
        baslaButonu.setFont(new Font("Arial", Font.BOLD, 30));
        baslaButonu.addActionListener(this);
        baslaButonu.setBounds(320, 500, 200, 75);
        baslaButonu.setFocusable(false);
        baslaButonu.setBackground(Color.yellow);
        baslaButonu.setForeground(Color.red);
        baslaButonu.setVisible(true);

        baslaPaneli = new JPanel();
        baslaPaneli.add(baslaButonu);
        baslaPaneli.setVisible(true);

        skorYazisi = new JLabel();
        skorYazisi.setText("Skor: " + skorSayaci);
        skorYazisi.setForeground(Color.red);
        skorYazisi.setFont(new Font("Arial", Font.ITALIC, 30));
        skorYazisi.setBounds(10, 10, 200, 50);
        skorYazisi.setVisible(true);

        sureYazisi = new JLabel();
        sureYazisi.setVisible(true);
        sureYazisi.setText("Süre: " + sure + "s");
        sureYazisi.setForeground(Color.blue);
        sureYazisi.setFont(new Font("Arial", Font.ITALIC, 30));
        sureYazisi.setBounds(690, 10, 200, 50);
        sureYazisi.setVisible(true);

        oyunButonu = new JButton();
        oyunButonu.addActionListener(this);
        oyunButonu.setBounds(rastgeleX, rastgeleY, 50, 50);
        oyunButonu.setFocusable(false);
        oyunButonu.setVisible(true);

        oyunPaneli = new JPanel();
        oyunPaneli.add(oyunButonu);
        oyunPaneli.add(skorYazisi);
        oyunPaneli.add(sureYazisi);
        oyunPaneli.setVisible(false);

        oyunBittiYazisi = new JLabel();
        oyunBittiYazisi.setText("Oyun Bitti!");
        oyunBittiYazisi.setForeground(Color.red);
        oyunBittiYazisi.setFont(new Font("Broadway", Font.PLAIN, 80));
        oyunBittiYazisi.setBounds(200, 50, 500, 350);
        oyunBittiYazisi.setVisible(true);

        oyunBittiSkorYazisi = new JLabel();
        oyunBittiSkorYazisi.setForeground(Color.magenta);
        oyunBittiSkorYazisi.setFont(new Font("Calibri", Font.ITALIC, 60));
        oyunBittiSkorYazisi.setBounds(280, 280, 350, 100);
        oyunBittiSkorYazisi.setVisible(true);

        yenidenDeneButonu = new JButton("Yeniden Dene");
        yenidenDeneButonu.setBounds(325, 400, 200, 60);
        yenidenDeneButonu.setFocusable(false);
        yenidenDeneButonu.setFont(new Font("New Times Roman", Font.PLAIN, 25));
        yenidenDeneButonu.setBackground(Color.white);
        yenidenDeneButonu.setForeground(Color.blue);
        yenidenDeneButonu.addActionListener(this);
        yenidenDeneButonu.setVisible(true);

        anaMenuButonu = new JButton("Ana Menü");
        anaMenuButonu.setBounds(325, 480, 200, 60);
        anaMenuButonu.setFocusable(false);
        anaMenuButonu.setFont(new Font("New Times Roman", Font.PLAIN, 25));
        anaMenuButonu.setBackground(Color.white);
        anaMenuButonu.setForeground(Color.blue);
        anaMenuButonu.addActionListener(this);
        anaMenuButonu.setVisible(true);


        oyunBittiPaneli = new JPanel();
        oyunBittiPaneli.add(oyunBittiYazisi);
        oyunBittiPaneli.add(oyunBittiSkorYazisi);
        oyunBittiPaneli.add(yenidenDeneButonu);
        oyunBittiPaneli.add(anaMenuButonu);
        oyunBittiPaneli.setVisible(false);

        paneller[0] = baslaPaneli;
        paneller[1] = oyunPaneli;
        paneller[2] = oyunBittiPaneli;

        for (int i = 0; i < paneller.length; i++) {

            paneller[i].setBounds(0, 0, 850, 850);
            paneller[i].setLayout(null);
            paneller[i].setBackground(Color.lightGray);
        }

        frame = new JFrame("TiklamaOyunuES");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setBounds(0, 0, 850, 850);
        frame.setLocationRelativeTo(null);
        frame.add(baslaPaneli);
        frame.add(oyunPaneli);
        frame.add(oyunBittiPaneli);
        frame.setVisible(true);

    }

    public static void main(String[] args) {

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (sure >= 0 && oyunPaneli.isVisible()) {
                    sureYazisi.setText("Süre: " + sure + "s");
                    sure--;
                }

                if (sureYazisi.getText().equals("Süre: 0s")) {
                    oyunPaneli.setVisible(false);
                    oyunBittiSkorYazisi.setText("Skorunuz: " + skorSayaci);
                    oyunBittiPaneli.setVisible(true);
                }
            }
        };

        new Main();

        timer.scheduleAtFixedRate(task, 0, 1000);


    }

    public static void renkAyarla() {
        switch (renkSec) {
            case 1:
                oyunButonu.setBackground(Color.yellow);
                break;
            case 2:
                oyunButonu.setBackground(Color.blue);
                break;
            case 3:
                oyunButonu.setBackground(Color.cyan);
                break;
            case 4:
                oyunButonu.setBackground(Color.red);
                break;
            case 5:
                oyunButonu.setBackground(Color.orange);
                break;
            case 6:
                oyunButonu.setBackground(Color.gray);
                break;
            case 7:
                oyunButonu.setBackground(Color.white);
                break;
            case 8:
                oyunButonu.setBackground(Color.black);
                break;
            case 9:
                oyunButonu.setBackground(Color.green);
                break;
            case 10:
                oyunButonu.setBackground(Color.pink);
                break;
            case 11:
                oyunButonu.setBackground(Color.darkGray);
                break;
            case 12:
                oyunButonu.setBackground(Color.magenta);
                break;

        }
    }

    public static void oyunuSifirla() {
        sure = 10;
        skorSayaci = 0;
        skorYazisi.setText("Skor: " + skorSayaci);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == baslaButonu) {
            baslaPaneli.setVisible(false);
            renkAyarla();
            oyunPaneli.setVisible(true);
        }

        if (e.getSource() == oyunButonu) {
            renkSec = rastgeleSayi(1, 12);
            renkAyarla();
            rastgeleX = rastgeleSayi(100, 750);
            rastgeleY = rastgeleSayi(100, 725);

            oyunButonu.setBounds(rastgeleX, rastgeleY, 50, 50);
            skorSayaci++;
            skorYazisi.setText("Skor: " + skorSayaci);

        }

        if (e.getSource() == anaMenuButonu) {
            oyunuSifirla();
            oyunPaneli.setVisible(false);
            oyunBittiPaneli.setVisible(false);
            baslaPaneli.setVisible(true);
        }

        if (e.getSource() == yenidenDeneButonu) {
            oyunuSifirla();
            baslaPaneli.setVisible(false);
            oyunBittiPaneli.setVisible(false);
            oyunPaneli.setVisible(true);
        }

    }

    public static int rastgeleSayi(int min, int maks) {
        Random random = new Random();
        return random.nextInt(min, maks + 1);
    }
}
