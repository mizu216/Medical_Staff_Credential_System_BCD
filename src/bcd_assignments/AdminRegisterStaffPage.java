package bcd_assignments;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class AdminRegisterStaffPage implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==confirm){
                String firstName = firstNameInput.getText();
                String lastName = lastNameInput.getText();
                firstNameInput.setText("");
                lastNameInput.setText("");
                if (firstName.length()==0||lastName.length()==0){
                    JOptionPane.showMessageDialog(x,"You Cannot Leave Blank in the Field!!!");
                }
                else{
                    String msg = Database.registerStaff(firstName,lastName);
                    JOptionPane.showMessageDialog(x,msg);
                }
            }
            else if(e.getSource()==back){
                firstNameInput.setText("");
                lastNameInput.setText("");
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
    private Label firstNameText,lastNameText, title;
    private TextField firstNameInput,lastNameInput;
    private Button confirm,back;
    public AdminRegisterStaffPage(){
        x = new JFrame("Admin Register Staff Page");
        x.setSize(500,500);
        x.setLocation(700,300);
        
        p0 = new Panel();
        p1 = new Panel(new GridLayout(2,1));
        p2 = new Panel();
        p3 = new Panel(new GridLayout(2,1));
        p4 = new Panel();
        p5 = new Panel();
        p6 = new Panel();
        p7 = new Panel();
        
        title = new Label("Register New Staff");
        title.setFont(new Font("SansSerif", Font.BOLD, 14));
        p0.add(title);
        
        firstNameText = new Label("First Name",Label.CENTER);
        firstNameInput = new TextField(30);
        p2.add(firstNameInput);
        p1.add(firstNameText);
        p1.add(p2);
        
        
        lastNameText = new Label("Last Name",Label.CENTER);
        lastNameInput = new TextField(30);
        p4.add(lastNameInput);
        p3.add(lastNameText);
        p3.add(p4);
        
        confirm = new Button("Confirm");
        back = new Button("Back");
        confirm.addActionListener(this);
        back.addActionListener(this);
        p5.add(back);
        p6.add(confirm);
        p7.add(p5);
        p7.add(p6);

        x.setLayout(new GridLayout(4,1));
        x.add(p0);
        x.add(p1);
        x.add(p3);
        x.add(p7);
        x.getContentPane().setBackground(Color.lightGray);
        x.setVisible(false);
    }
}