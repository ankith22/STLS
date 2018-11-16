package com.stls.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public class UserPage extends BasePage
{
 @FindBy(xpath="//div[.='USERS']")
 private WebElement Users;
 
 public UserPage(WebDriver driver)
 {
  PageFactory.initElements(driver, this);
 }
 
 public void clickUsers()
 {
  Users.click();
 }
}
