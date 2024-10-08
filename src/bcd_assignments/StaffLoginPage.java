package bcd_assignments;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class StaffLoginPage implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==login){
                String username = usernameInput.getText();
                String password = passwordInput.getText();
                usernameInput.setText("");
                passwordInput.setText("");
//                if (Database.staffLogin(username,password) == true){
//                    Main.loginUser = username;
//                    x.setVisible(false);
//                    Main.staffMenuPage.getJFrame().setVisible(true); 
//                }
                if (username.equals("jason") && password.equals("abc")) {
                  Main.loginUser = username;
                  x.setVisible(false);
                  Main.staffMenuPage.getJFrame().setVisible(true); 
                }
                else{
                    JOptionPane.showMessageDialog(x,"Invalid Username and Password!!!");
                }
                
            }
            else if(e.getSource()==back){
                x.setVisible(false);
                Main.mainMenuPage.getJFrame().setVisible(true);
            }
        }
        
        catch(Exception ex){
            JOptionPane.showMessageDialog(x,"Error Loading!!! Please Try Again");
            ex.printStackTrace();
        }   
    }
     
    public JFrame getJFrame(){
        return x;
    }
    private JFrame x;
    private Panel p0,p1,p2,p3,p4, p5,p6,p7;
    private Label usernameText,passwordText, title;
    private TextField usernameInput,passwordInput;
    private Button login,back;
    public StaffLoginPage(){
        x = new JFrame("Staff Login Page");
        x.setSize(500,500);
        x.setLocation(700,300);
        
        p0 = new Panel();
        p1 = new Panel(new GridLayout(2,1));
        p2 = new Panel(new GridLayout(2,1));
        p3 = new Panel();
        p4 = new Panel();
        p5 = new Panel();
        p6 = new Panel();
        p7 = new Panel();
        
        title = new Label("Staff Login");
        title.setFont(new Font("SansSerif", Font.BOLD, 14));
        p0.add(title);
        
        usernameText = new Label("USERNAME",Label.CENTER);
        usernameInput = new TextField(30);
        p3.add(usernameInput);
        p1.add(usernameText);
        p1.add(p3);
        
        passwordText = new Label("PASSWORD",Label.CENTER);
        passwordInput = new TextField(30);
        p4.add(passwordInput);
        p2.add(passwordText);
        p2.add(p4);
        
        login = new Button("Login");
        back = new Button("Back");
        login.addActionListener(this);
        back.addActionListener(this);
        p5.add(back);
        p6.add(login);
        p7.add(p5);
        p7.add(p6);

        x.setLayout(new GridLayout(4,1));
        x.add(p0);
        x.add(p1);
        x.add(p2);
        x.add(p7);
        x.getContentPane().setBackground(Color.lightGray);
        x.setVisible(false);
    }
}