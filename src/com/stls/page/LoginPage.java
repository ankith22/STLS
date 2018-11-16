package com.stls.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public class LoginPage extends BasePage
{
 @FindBy(id="username")
 private WebElement username;
 
 @FindBy(name="pwd")
 private WebElement password;
 
 @FindBy(xpath="//div[.='Login ']")
 private WebElement loginbutton;
 
 @FindBy(xpath="//a[.='Logout']")
 private WebElement logoutlink;
 
 @FindBy(xpath="//span[contains(.,'invalid')]")
 private WebElement errmsg;
 
 public LoginPage(WebDriver driver){
 PageFactory.initElements(driver, this);}
 
 public void setUsername(String un)
 {
  username.sendKeys(un);
 }
 
 public void setPassword(String pw)
 {
  password.sendKeys(pw);
 }
 
 public void clickLogin()
 {
  loginbutton.click();
 }
 
 public void clickLogout()
 {
  logoutlink.click();
 }
 
 public void errorMessageIsDisplayed()
 {
  errmsg.isDisplayed();
 }
}
