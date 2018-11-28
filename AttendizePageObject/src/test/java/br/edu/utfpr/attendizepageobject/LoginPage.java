/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.attendizepageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author daphnemillss
 */
public class LoginPage extends AttendizePage{
    
    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get("http://169.254.3.124/");
    }
    
    @FindBy(id = "email")
    WebElement inputEmail;
    
    @FindBy(id = "password")
    WebElement inputSenha;
    
    @FindBy(xpath = "//*[@id=\"main\"]/section/form/div/div/div/div/div[4]/button")
    WebElement buttonLogin;
    
    public LoginPage preencherLogin(String email, String senha){
        inputEmail.sendKeys(email);
        inputSenha.sendKeys(senha);
        
        return this;
    }
    
    public DashboardPage clicarEmLogin(){
        buttonLogin.click();
        
        return new DashboardPage(driver);
    }
}
