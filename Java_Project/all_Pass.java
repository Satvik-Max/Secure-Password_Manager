import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class all_Pass extends Thread {

    public void run()
    {
        JFrame frame = new JFrame(" Password_Manager ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("gpn_logo.jpg");
        frame.setIconImage(image.getImage());
        // frame.setResizable(false);
        frame.setVisible(true);

        Border border = BorderFactory.createLineBorder(Color.black, 5);

        ImageIcon image2 = new ImageIcon("download.png");
        JLabel label = new JLabel();
        label.setIcon(image2);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setText(" Password_Manager ");
        label.setForeground(Color.red);
        label.setOpaque(false);
        label.setFont(new Font("georgia",Font.BOLD, 20));
        label.setIconTextGap(30);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBorder(border);
        frame.setLayout(null);
        label.setBounds(500 , 0 ,280 ,280);

        JButton APP3 = new JButton();
        APP3.setText("View");
        APP3.setBackground(Color.black);
        APP3.addActionListener(f->{ 
            Project_jdbc pj = new Project_jdbc();
            APP3.setVisible(false);
            pj.view_all(frame,border);
         });
        APP3.setForeground(Color.cyan);
        APP3.setBounds(690, 500, 90, 30);

        frame.add(APP3);
        frame.add(label);
        frame.pack();        
    }
    public static void main(String[] args) {
        all_Pass a = new all_Pass();
        a.start();
    }
}