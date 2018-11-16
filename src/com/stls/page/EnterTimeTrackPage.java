package com.stls.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic.BasePage;

public class EnterTimeTrackPage extends BasePage
{
  @FindBy(xpath="//div[@class='popup_menu_icon support_icon']") 
  private WebElement help;
  
  @FindBy(linkText="About your actiTIME")
  private WebElement aboutActiTIME;
  
  @FindBy(xpath="//span[@class='productVersion']")
  private WebElement version;
  
  @FindBy(id="aboutPopupCloseButtonId")
  private WebElement closebutton;
  
  public EnterTimeTrackPage(WebDriver driver)
  {
   PageFactory.initElements(driver, this);
  }
  
  public void clickHelp()
  {
   sleep(2);
   help.click();
  }
  
  public void clickAbout()
  {
   sleep(2);
   aboutActiTIME.click();
  }
  
  public void verifyVersion(String eversion)
  {
   String aversion = version.getText();
   Assert.assertEquals(eversion, aversion);
  }
  
  public void clickClose()
  {
   sleep(2);
   closebutton.click();
  }
}
	

