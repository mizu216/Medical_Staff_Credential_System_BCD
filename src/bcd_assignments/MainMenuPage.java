package bcd_assignments;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class MainMenuPage implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==admin){
                x.setVisible(false);
                Main.adminLoginPage.getJFrame().setVisible(true);
            }
            if(e.getSource()==staff){
                x.setVisible(false);
                Main.staffLoginPage.getJFrame().setVisible(true);
            }
            
            else if(e.getSource()==exit){
                System.exit(0);
            }
        }
        
        catch(Exception ex){
            JOptionPane.showMessageDialog(x,"Error!!! Please Try Again");
            ex.printStackTrace();
        }
    }
    
    public JFrame getJFrame(){
        return x;
    }
    private JFrame x;
    private Panel p0,p1,p2,p3,p4;
    private Label title;
    private Button admin,staff,exit;
    public MainMenuPage(){
        x = new JFrame("Main Menu Page");
        x.setSize(500,500);
        x.setLocation(700,300);
        p0 = new Panel();
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();
        
        title = new Label("Select Login Interface");
        title.setFont(new Font("SansSerif", Font.BOLD, 14));
        p0.add(title);
        
        admin = new Button("Login as Admin");
        p1.add(admin);

        staff = new Button("Login as Staff");
        p2.add(staff);

        exit = new Button("Quit");
        p3.add(exit);

        admin.addActionListener(this);
        staff.addActionListener(this);
        exit.addActionListener(this);
        
        x.setLayout(new GridLayout(4,1));
        x.add(p0);
        x.add(p1);
        x.add(p2);
        x.add(p3);
        x.getContentPane().setBackground(Color.lightGray);
        x.setVisible(true);
    }
}