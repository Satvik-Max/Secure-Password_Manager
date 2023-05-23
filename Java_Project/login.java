import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class login {

    public static void main(String[] args) {
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
        label.setBounds(500 , 0 ,280 ,280);
        label.setBorder(border);
        frame.setLayout(null);
        


        JLabel APP2 = new JLabel("Enter Admin Capcha :");
        APP2.setFont(new Font("Serif", Font.BOLD, 18));
        APP2.setBounds(550, 440, 180, 30);

        JTextField input3 = new JTextField();
        input3.setBounds(500, 500, 190, 30);
        input3.setFont(new Font("comic sans", Font.BOLD, 20));

        JButton APP3 = new JButton();
        APP3.setText("Login");
        APP3.setBackground(Color.black);
        APP3.addActionListener(f->{ 
            if(input3.getText().equals("")) {
                JOptionPane.showMessageDialog(null, " Please Fill All Credentials ", "Incomplete Credential", JOptionPane.WARNING_MESSAGE);
                }
            else{
                Project_jdbc pj = new Project_jdbc();
                pj.login(input3.getText(),frame);
            }
         });
        APP3.setForeground(Color.cyan);
        APP3.setBounds(690, 500, 90, 30);

        frame.add(label);
        frame.add(input3);
        frame.add(APP3);
        frame.add(APP2);
        frame.pack();
    }
}
