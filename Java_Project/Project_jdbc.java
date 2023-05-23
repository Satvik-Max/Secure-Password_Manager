import java.awt.Color;
import java.awt.Font;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

class Project_jdbc
{
    String readweb()
    {
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Project";
            con = DriverManager.getConnection(url, "root", "2107067");
            System.out.println("Connection Successfull !!");

            String readdata = "SELECT * FROM Password_Management";
            Statement smt = con.createStatement();
            ResultSet rs1 = smt.executeQuery(readdata);
            while(rs1.next()){

                String website = rs1.getString("website");
                
                return website;

            }
        }
        catch(SQLException s)
        {
            JOptionPane.showMessageDialog(null, " Data Not Added  ", "ERROR ", JOptionPane.WARNING_MESSAGE);
        }
        catch(ClassNotFoundException c)
        {
            JOptionPane.showMessageDialog(null, " Data Not Added  ", "ERROR ", JOptionPane.WARNING_MESSAGE);
        }
        finally
        {
            try{
                if(con!=null){
                    con.close();
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, " Connection Error ", "ERROR ", JOptionPane.WARNING_MESSAGE);
            }
        }
        return null;
    }
    String readpass()
    {
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Project";
            con = DriverManager.getConnection(url, "root", "2107067");
            System.out.println("Connection Successfull !!");

            String readdata = "SELECT * FROM Password_Management";
            Statement smt = con.createStatement();
            ResultSet rs1 = smt.executeQuery(readdata);
            while(rs1.next()){

                String password = rs1.getString("password");
                
                return password;

            }
        }
        catch(SQLException s)
        {
            JOptionPane.showMessageDialog(null, " Data Not Added  ", "ERROR ", JOptionPane.WARNING_MESSAGE);
        }
        catch(ClassNotFoundException c)
        {
            JOptionPane.showMessageDialog(null, " Data Not Added  ", "ERROR ", JOptionPane.WARNING_MESSAGE);
        }
        finally
        {
            try{
                if(con!=null){
                    con.close();
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, " Connection Error ", "ERROR ", JOptionPane.WARNING_MESSAGE);
            }
        }
        return null;
    }
    void insert(String website,String password)
    {
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Project";
            con = DriverManager.getConnection(url, "root", "2107067");
            System.out.println("Connection Successfull !!");

            
            PreparedStatement psmt = con.prepareStatement(" insert into Password_Management values(?,?) ");
            
            psmt.setString(1, website);
            psmt.setString(2, password);

            psmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, " Added To Database Successfully ", "Successfull ", JOptionPane.PLAIN_MESSAGE);
              
        }
        catch(SQLException s)
        {
            JOptionPane.showMessageDialog(null, " Data Not Added  ", "ERROR ", JOptionPane.WARNING_MESSAGE);
        }
        catch(ClassNotFoundException c)
        {
            JOptionPane.showMessageDialog(null, " Data Not Added  ", "ERROR ", JOptionPane.WARNING_MESSAGE);
        }
        finally
        {
            try{
                if(con!=null){
                    con.close();
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, " Connection Error  ", "ERROR ", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    String Search(String Website)
    {
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Project";
            con = DriverManager.getConnection(url, "root", "2107067");
            System.out.println("Connection Successfull !!");

            String readdata = "SELECT * FROM Password_Management";
            Statement smt = con.createStatement();
            boolean result = true;
            ResultSet rs1 = smt.executeQuery(readdata);
            while(rs1.next()){

                String data = rs1.getString("website");
                String pass = rs1.getString("password").toString();
                if(Website.equals(data))
                {
                    return pass;
                }
                else{
                    result = false;
                }
            }
            if(result==false){
                JOptionPane.showMessageDialog(null, " Data Not Found  ", "ERROR ", JOptionPane.WARNING_MESSAGE);
            }
        }
        catch(SQLException s)
        {
            JOptionPane.showMessageDialog(null, " Data Not Added  ", "ERROR ", JOptionPane.WARNING_MESSAGE);
        }
        catch(ClassNotFoundException c)
        {
            JOptionPane.showMessageDialog(null, " Data Not Added  ", "ERROR ", JOptionPane.WARNING_MESSAGE);
        }
        finally
        {
            try{
                if(con!=null){
                    con.close();
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, " Connection Error ", "ERROR ", JOptionPane.WARNING_MESSAGE);
            }
        }
        return null;
    }
    void Update_Pass(String website, String Pass) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Project";
            con = DriverManager.getConnection(url, "root", "2107067");
            System.out.println("Connection successful!");
    
            String sql = "UPDATE Password_Management SET password=? WHERE website=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, Pass);
            stmt.setString(2, website);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Password updated successfully", "Successful", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to update password: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Failed to load database driver: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Failed to close statement: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Failed to close connection: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    void login(String capcha,JFrame frame)
    {
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Project";
            con = DriverManager.getConnection(url, "root", "2107067");
            System.out.println("Connection Successfull !!");

            String readdata = "SELECT * FROM login";
            Statement smt = con.createStatement();
            boolean result = true;
            ResultSet rs1 = smt.executeQuery(readdata);
            while(rs1.next()){

                String data = rs1.getString("User_Capcha");
                if(capcha.equals(data))
                {
                   gui g = new gui();
                   g.start();
                   frame.dispose();
                }
                else{
                    result = false;
                }
            }
            if(result==false){
                JOptionPane.showMessageDialog(null, " Admin Not Found  ", "ERROR ", JOptionPane.WARNING_MESSAGE);
            }
        }
        catch(SQLException s)
        {
            JOptionPane.showMessageDialog(null, " Data Not Added  ", "ERROR ", JOptionPane.WARNING_MESSAGE);
        }
        catch(ClassNotFoundException c)
        {
            JOptionPane.showMessageDialog(null, " Data Not Added  ", "ERROR ", JOptionPane.WARNING_MESSAGE);
        }
        finally
        {
            try{
                if(con!=null){
                    con.close();
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, " Connection Error ", "ERROR ", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    void view_all(JFrame frame,Border border)
    {
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Project";
            con = DriverManager.getConnection(url, "root", "2107067");
            System.out.println("Connection Successfull !!");

            String readdata = "SELECT * FROM password_Management";
            
            Statement smt = con.createStatement();
            ResultSet rs1 = smt.executeQuery(readdata);

            JTextArea area = new JTextArea();
            area.setBorder(border);
            area.setBounds(500, 300, 280, 400);
            area.setBackground(Color.GRAY);
            area.setForeground(Color.GREEN);
            Font font = new Font("Arial", Font.BOLD, 16);
            area.setFont(font);
            StringBuffer sb = new StringBuffer();
            while(rs1.next()){

                String website = rs1.getString("website");
                String pass = rs1.getString("password");
                sb.append(website);
                sb.append("\t");
                sb.append(pass);
                sb.append("\n");
                
            }
            area.setText(sb.toString());
            frame.add(area);
                        
        }
        catch(SQLException s)
        {
            JOptionPane.showMessageDialog(null, " Data Not Added  ", "ERROR ", JOptionPane.WARNING_MESSAGE);
        }
        catch(ClassNotFoundException c)
        {
            JOptionPane.showMessageDialog(null, " Data Not Added  ", "ERROR ", JOptionPane.WARNING_MESSAGE);
        }
        finally
        {
            try{
                if(con!=null){
                    con.close();
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, " Connection Error ", "ERROR ", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    public static void main(String[] args) {

       
        System.out.println(" Normal Termination !! ");
    }
}