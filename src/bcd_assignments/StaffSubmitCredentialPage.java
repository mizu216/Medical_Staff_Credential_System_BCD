package bcd_assignments;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
public class StaffSubmitCredentialPage implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==confirm){
                String credentialNo = credentialNoInput.getText();
                String credentialType = credentialTypeInput.getText();
                String status = statusInput();
                String ceDueDate = CEDueDateInput.getText();
                String firstIssueDate = firstIssueDateInput.getText();
                String lastIssueDate = lastIssueDateInput.getText();
                String expirationDate = expirationDateInput.getText();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                formatter.parse(ceDueDate);
                formatter.parse(firstIssueDate);
                formatter.parse(lastIssueDate);
                formatter.parse(expirationDate);
                if(credentialNo.length()!=10){
                    JOptionPane.showMessageDialog(x,"The length of credential No should be 10!!!");
                }
                else if (credentialType.length()==0){
                    JOptionPane.showMessageDialog(x,"Please not leaving blank on Credential Type Field!!!");
                }
                else if("".equals(status)){
                    JOptionPane.showMessageDialog(x,"Please select a status!!!");
                }
                else{
                
                }
            }
            else if(e.getSource()== back){
                String username = credentialNoInput.getText();
                String name = credentialTypeInput.getText();
                String ceDueDate = CEDueDateInput.getText();
                String firstIssueDate = firstIssueDateInput.getText();
                String lastIssueDate = lastIssueDateInput.getText();
                String expirationDate = expirationDateInput.getText();
                credentialNoInput.setText("");
                credentialTypeInput.setText("");
                CEDueDateInput.setText("");
                firstIssueDateInput.setText("");
                lastIssueDateInput.setText("");
                x.setVisible(false);
                Main.staffMenuPage.getJFrame().setVisible(true);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(x,"Invalid Date Input!!! Please follow dd-MM-yyyy");
        }
        
    }
    public JFrame getJFrame(){
        return x;
    }
    
    public String statusInput(){
        String status = "";
        if(active.isSelected()){
            status = "Active";
        }
        else if (expired.isSelected()){
            status = "Expired";
        }
        else if (closed.isSelected()){
            status = "Closed";
        }
        else if (superseded.isSelected()){
            status = "Superseded";
        }
        return status;
    }
    
    private JFrame x;
    private Panel p0,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18;
    private Label credentialNoText,credentialTypeText,statusText,CEDueDateText,firstIssueDateText,lastIssueDateText,expirationDateText,title;
    private TextField credentialNoInput,credentialTypeInput,CEDueDateInput,firstIssueDateInput,lastIssueDateInput,expirationDateInput;
    private JRadioButton active,expired,closed,superseded;
    private ButtonGroup statusButton;
    private Button confirm,back;
    public StaffSubmitCredentialPage(){
        x = new JFrame("Staff Submit Credential Page");
        x.setSize(500,500);
        x.setLocation(700,300);
        p0 = new Panel(new GridLayout(2,1));
        p1 = new Panel();
        p2 = new Panel(new GridLayout(2,1));
        p3 = new Panel();
        p4 = new Panel(new GridLayout(2,1));
        p5 = new Panel();
        p6 = new Panel(new GridLayout(2,1));
        p7 = new Panel();
        p8 = new Panel(new GridLayout(2,1));
        p9 = new Panel();
        p10 = new Panel(new GridLayout(2,1));
        p11 = new Panel();
        p12 = new Panel();
        p13 = new Panel();
        p14 = new Panel();
        p15 = new Panel(new GridLayout(4,2));
        p16 = new Panel();
        p17 = new Panel(new GridLayout(2,1));
        p18 = new Panel(new GridLayout(2,2));

        credentialNoText = new Label("Credential Number",Label.CENTER);
        credentialNoInput = new TextField(30);
        p0.add(credentialNoText);
        p1.add(credentialNoInput);
        p0.add(p1);
        
        credentialTypeText = new Label("Credential Type",Label.CENTER);
        credentialTypeInput = new TextField(30);
        p2.add(credentialTypeText);
        p3.add(credentialTypeInput);
        p2.add(p3);
        
        statusText = new Label("Status Type",Label.CENTER);
        active = new JRadioButton("Active");
        expired = new JRadioButton("Expired");
        closed = new JRadioButton("Closed");
        superseded = new JRadioButton("Superseded");
        active.addActionListener(this);
        expired.addActionListener(this);
        closed.addActionListener(this);
        superseded.addActionListener(this);
        statusButton = new ButtonGroup();
        statusButton.add(active);
        statusButton.add(expired);
        statusButton.add(closed);
        statusButton.add(superseded);
        p18.add(active);
        p18.add(expired);
        p18.add(closed);
        p18.add(superseded);
        p17.add(statusText);
        p17.add(p18);
        
        CEDueDateText = new Label("CE Due Date (dd-MM-yyyy)",Label.CENTER);
        CEDueDateInput = new TextField(30);
        p4.add(CEDueDateText);
        p5.add(CEDueDateInput);
        p4.add(p5);
        
        firstIssueDateText = new Label("First Issue Date (dd-MM-yyyy)",Label.CENTER);
        firstIssueDateInput = new TextField(30);
        p6.add(firstIssueDateText);
        p7.add(firstIssueDateInput);
        p6.add(p7);
           
        lastIssueDateText = new Label("Last Issue Date (dd-MM-yyyy)",Label.CENTER);
        lastIssueDateInput = new TextField(30);
        p8.add(lastIssueDateText);
        p9.add(lastIssueDateInput);
        p8.add(p9);
        
        expirationDateText = new Label("Expiration Date (dd-MM-yyyy)",Label.CENTER);
        expirationDateInput = new TextField(30);
        p10.add(expirationDateText);
        p11.add(expirationDateInput);
        p10.add(p11);
        
            
        back = new Button("Back");
        confirm= new Button("Confirm");
        confirm.addActionListener(this);
        back.addActionListener(this);
        p12.add(back);
        p13.add(confirm);
        p14.add(p12);
        p14.add(p13);
        
        p15.add(p0);
        p15.add(p2);
        p15.add(p17);
        p15.add(p4);
        p15.add(p6);
        p15.add(p8);
        p15.add(p10);

        
        title = new Label("Submit Credential");
        title.setFont(new Font("SansSerif", Font.BOLD, 14));
        p16.add(title);
        
        x.add(p16,BorderLayout.NORTH);
        x.add(p15,BorderLayout.CENTER);
        x.add(p14,BorderLayout.SOUTH);
    }
}
