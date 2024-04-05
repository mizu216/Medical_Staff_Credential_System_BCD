/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcd_assignments;

/**
 *
 * @author limzi
 */
public class Main {
    public static AdminLoginPage adminLoginPage;
    public static AdminMenuPage adminMenuPage;
    public static AdminRegisterStaffPage adminRegisterStaffPage;
    public static AdminViewAllStaffPage adminViewAllStaffPage;
    public static StaffLoginPage staffLoginPage;
    public static StaffMenuPage staffMenuPage;
    public static StaffSubmitCredentialPage staffSubmitCredentialPage;
    public static StaffViewPersonalCredentialPage staffViewPersonalCredentialPage;
    public static MainMenuPage mainMenuPage;
    public static String loginUser = null;


    
    public static void main(String[] args) {
        adminLoginPage = new AdminLoginPage();
        adminMenuPage = new AdminMenuPage();
        adminRegisterStaffPage = new AdminRegisterStaffPage();
        adminViewAllStaffPage = new AdminViewAllStaffPage();
        staffLoginPage = new StaffLoginPage();
        staffMenuPage = new StaffMenuPage();
        staffSubmitCredentialPage = new StaffSubmitCredentialPage();
        staffViewPersonalCredentialPage = new StaffViewPersonalCredentialPage();
        mainMenuPage = new MainMenuPage();
        
    }
}
