package bcd_assignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    public static String registerStaff(String firstName,String lastName){
        try{
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/medical_staff_system","abc","abc");
            System.out.println("Database Connected");
            String username = firstName + lastName;
            int usernameNo = 1;
            boolean usernameUnique = false;
            while (usernameUnique==false){
                PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Staff_Table WHERE Username = ?");
                pstmt.setString(1, username);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    username = firstName + lastName + usernameNo;
                    usernameNo +=1;
                    usernameUnique = false;
                }
                else{
                    usernameUnique = true;
                    rs.close();
                    pstmt.close();
                }
            }
            String password = username + "123";
            PreparedStatement pstmt2 = conn.prepareStatement("INSERT INTO Staff_Table (Username, Password, FirstName, LastName) VALUES (?, ?, ?, ?)");
            pstmt2.setString(1, username);
            pstmt2.setString(2, password);
            pstmt2.setString(3, firstName);
            pstmt2.setString(4, lastName);
            pstmt2.executeUpdate();
            conn.commit();
            pstmt2.close();
            conn.close();
            return ("Your Username: " + username + "\n" + "Your Temporarily Password : "+password);
        }
        catch (SQLException ex){
            ex.printStackTrace();
            return ("Error Loading!!!");
        }
    }
    
    public static boolean staffLogin(String username, String password){
        try{
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/medical_staff_system","abc","abc");
            System.out.println("Database Connected");
            PreparedStatement pstmt = conn.prepareStatement("SELECT Password FROM Staff_Table WHERE Username = ?");
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String storedPassword = rs.getString("Password");
                if (storedPassword.equals(password)) {
                    return true;
                } else {
                    return false;
                }
            }
            rs.close();
            pstmt.close();
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean staffUpdatePassword(String username, String oldPassword, String newPassword){
        try{
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/medical_staff_system", "abc", "abc");
            PreparedStatement pstmt = conn.prepareStatement("SELECT Password FROM Staff_Table WHERE Username = ?");
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String storedPassword = rs.getString("Password");
                if (storedPassword.equals(oldPassword)) {
                    pstmt = conn.prepareStatement("UPDATE Staff_Table SET Password = ? WHERE Username = ?");
                    pstmt.setString(1, newPassword);
                    pstmt.setString(2, username);
                    int executeUpdate = pstmt.executeUpdate();
                    if (executeUpdate > 0) {
                        return true;//sucess
                    } else {
                        return false;//errorr modify,try again
                    }
                }
            }
            rs.close();
            pstmt.close();
            conn.close(); 
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
