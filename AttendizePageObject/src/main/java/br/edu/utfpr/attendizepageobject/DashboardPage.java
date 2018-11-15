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
public class DashboardPage extends AttendizePage{
    
    public DashboardPage(WebDriver driver) {
        super(driver);
    }
    
    
    public DashboardPage abrirMenuDeOpcoes(){
        getDropMenu().abrirMenu();
        
        return this;
    }
    
    public LoginPage clicarEmSignOut(){
        getDropMenu().sair();
        
        return new LoginPage(driver);
    }
}
