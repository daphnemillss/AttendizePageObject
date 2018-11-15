/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.attendizepageobject;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author daphnemillss
 */
public class AttendizePage extends BasePage{
    private DropdownMenu dropMenu;
    
    private OrganiserMenu orgMenu;
    
    public AttendizePage(WebDriver driver) {
        super(driver);
    }
    
    public DropdownMenu getDropMenu() {
        return dropMenu;
    }
    
    public OrganiserMenu getOrgMenu(){
        return orgMenu;
    }
}
