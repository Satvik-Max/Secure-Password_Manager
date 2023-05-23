import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class gui extends Thread
{
    public void run()
    {
        JFrame frame = new JFrame(" Password_Manager ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("gpn_logo.jpg");
        frame.setIconImage(image.getImage());
        frame.setPreferredSize(new Dimension(500,500));
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

        JTextField gen_pass = new JTextField();
        gen_pass.setBounds(500, 320, 200, 30);
        gen_pass.setForeground(Color.black);
        gen_pass.setText("");
        gen_pass.setFont(new Font("comic sans", Font.BOLD, 20));
       
        JButton button = new JButton();
        button.setText("Generate");
        button.setBackground(Color.black);
        password_Generator p = new password_Generator();
        button.addActionListener(f->{ gen_pass.setText(p.Pass_Gen()); });
        button.setForeground(Color.cyan);
        button.setBounds(690, 320, 90, 30);

        
        JTextField input = new JTextField();
        String i = input.getText();
        System.out.println(i);
        input.setBounds(600, 380, 190, 30);
        input.setFont(new Font("comic sans", Font.BOLD, 20));

        JLabel APP = new JLabel("Website :");
        APP.setFont(new Font("Serif", Font.BOLD, 18));
        APP.setBounds(500, 380, 90, 30);

        
        JLabel APP2 = new JLabel("Password :");
        APP2.setFont(new Font("Serif", Font.BOLD, 18));
        APP2.setBounds(500, 440, 90, 30);

        JTextField input2 = new JTextField();
        String i2 = input.getText();
        input2.setBounds(600, 440, 190, 30);
        input2.setFont(new Font("comic sans", Font.BOLD, 20));
    

        JTextField input3 = new JTextField();
        String i3 = input.getText();
        System.out.println(i3);
        System.out.println(i2);
        input3.setBounds(500, 500, 190, 30);
        input3.setFont(new Font("comic sans", Font.BOLD, 20));

        JButton Update = new JButton();
        Update.setText("Update");
        Update.setBackground(Color.black);
        Update.addActionListener(f->{ 
            if(input3.getText().equals("")){
                JOptionPane.showMessageDialog(null, " Please Fill All Credentials ", "Incomplete Credential", JOptionPane.WARNING_MESSAGE);
            }
            else{
                
               Project_jdbc pj = new Project_jdbc();
               pj.Update_Pass(input3.getText(),input2.getText());
            }
         });
        Update.setForeground(Color.cyan);
        Update.setBounds(790, 440, 90, 30);
        Update.setVisible(false);


        JButton APP3 = new JButton();
        APP3.setText("Search");
        APP3.setBackground(Color.black);
        APP3.addActionListener(f->{ 
            if(input3.getText().equals("")) {
                JOptionPane.showMessageDialog(null, " Please Fill All Credentials ", "Incomplete Credential", JOptionPane.WARNING_MESSAGE);
                }
            else{
                Project_jdbc pj = new Project_jdbc();
                String pass = pj.Search(input3.getText());
                input2.setText(pass);
                Update.setVisible(true);
            }
         });
        APP3.setForeground(Color.cyan);
        APP3.setBounds(690, 500, 90, 30);


        JButton add_app = new JButton();
        add_app.setText("ADD");
        add_app.setBackground(Color.black);
        add_app.addActionListener(f->{ 
            if(input.getText().equals("") ||  input2.getText().equals("")){
                JOptionPane.showMessageDialog(null, " Please Fill All Credentials ", "Incomplete Credential", JOptionPane.WARNING_MESSAGE);
            }
            else{
                
                Project_jdbc pj = new Project_jdbc();
                pj.insert(input.getText(), input2.getText());
                input.setText("");
                input2.setText("");
            }
         });
        add_app.setForeground(Color.cyan);
        add_app.setBounds(500, 600, 90, 30);

        JButton all = new JButton();
        all.setText(" View All ");
        all.setBackground(Color.black);
        all_Pass a = new all_Pass();
        all.addActionListener(f->{ a.start(); all.setEnabled(false);});
        all.setForeground(Color.cyan);
        all.setBounds(690, 600, 90, 30);

        JButton clear_Button = new JButton();
        clear_Button.setText("Clear");
        clear_Button.setBackground(Color.black);
        clear_Button.addActionListener(f->{ 
            gen_pass.setText("");
            input.setText("");
            input2.setText("");
            input3.setText("");
        });
        clear_Button.setForeground(Color.cyan);
        clear_Button.setBounds(600, 600, 80, 30);


        frame.setLayout(null);
        frame.add(label);
        frame.add(button);  
        frame.add(gen_pass); 
        frame.add(all);
        frame.add(clear_Button);
        frame.add(input);
        frame.add(APP);
        frame.add(input2);
        frame.add(APP2);
        frame.add(input3);
        frame.add(APP3);
        frame.add(add_app);
        frame.add(Update);
        frame.pack();
    }
    public static void main(String[] args) 
    {

    }
}