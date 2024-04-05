package bcd_assignments;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class StaffMenuPage implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==update){
                x.setVisible(false);
                Main.staffUpdatePasswordPage.getJFrame().setVisible(true);
            }
            
            else if(e.getSource()==submit){
                x.setVisible(false);
                Main.staffSubmitCredentialPage.getJFrame().setVisible(true);
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
    private Panel p0,p1,p2,p3,p4;
    private Label title;
    private Button update,submit,view,logout;
    public StaffMenuPage(){
        x = new JFrame("Staff Menu Page");
        x.setSize(500,500);
        x.setLocation(700,300);
        p0 = new Panel();
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();
        p4 = new Panel();
        
        title = new Label("Staff Main Menu");
        title.setFont(new Font("SansSerif", Font.BOLD, 14));
        p0.add(title);
        
        update = new Button("Modify Account Password");
        p1.add(update);
        
        submit = new Button("Submit Personal Medical Staff Credential");
        p2.add(submit);
        
        view = new Button("View Personal Medical Staff Credential");
        p3.add(view);
        
        logout = new Button("Logout");
        p4.add(logout);

        update.addActionListener(this);
        submit.addActionListener(this);
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