package com.stls.test;

import org.testng.annotations.Test;

import com.stls.page.LoginPage;
import com.stls.page.UserPage;

import generic.BaseTest;

public class VerifyUserPageTest extends BaseTest 
{
 @Test(priority=2)
 public void VerifyUserPageTest()
 {
  LoginPage l=new LoginPage(driver);
  l.setUsername("admin");
  l.setPassword("manager");
  l.clickLogin(); 
  l.sleep(3);
  UserPage u=new UserPage(driver);
  u.clickUsers();
  u.sleep(2);
  u.verifyTitle(driver, "actiTIME - User List");
  u.sleep(5);
  l.clickLogout();
 }
}
