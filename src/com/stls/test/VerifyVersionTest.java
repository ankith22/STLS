package com.stls.test;

import org.testng.annotations.Test;

import com.stls.page.EnterTimeTrackPage;
import com.stls.page.LoginPage;

import generic.BaseTest;

public class VerifyVersionTest extends BaseTest
{
 @Test(priority=4)
 public void VerifyVersionTest()
 {
  LoginPage l=new LoginPage(driver);
  l.setUsername("admin");
  l.setPassword("manager");
  l.clickLogin(); 
  l.sleep(3); 
  EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
  e.clickHelp();
  e.clickAbout();
  e.verifyVersion("actiTIME 2017.4");
  e.clickClose();
  l.clickLogout();
 }

}
