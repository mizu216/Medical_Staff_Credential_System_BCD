package bcd_assignments;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class AdminMenuPage implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==register){
                x.setVisible(false);
                Main.adminRegisterStaffPage.getJFrame().setVisible(true);
            }
            
            else if (e.getSource()==view){
                x.setVisible(false);
            }
            
            
            else if(e.getSource()==logout){
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
    private Panel p0,p1,p2,p3,p4, p5;
    private Label title;
    private Button register,view,logout;
    public AdminMenuPage(){
        x = new JFrame("Admin Menu Page");
        x.setSize(500,500);
        x.setLocation(700,300);
        p0 = new Panel();
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();
        p4 = new Panel();
        
        title = new Label("Admin Main Menu");
        title.setFont(new Font("SansSerif", Font.BOLD, 14));
        p0.add(title);
        
        register = new Button("Register New Medical Staff");
        p1.add(register);
        
        view = new Button("View All Medical Staff");
        p2.add(view);
        
        logout = new Button("Logout");
        p3.add(logout);

        register.addActionListener(this);
        view.addActionListener(this);
        logout.addActionListener(this);
        
        x.setLayout(new GridLayout(4,1));
        x.add(p0);
        x.add(p1);
        x.add(p2);
        x.add(p3);
        x.getContentPane().setBackground(Color.lightGray);
        x.setVisible(false);
    }
}