package com.stls.test;

import org.testng.annotations.Test;

import com.stls.page.LoginPage;

import generic.BaseTest;

public class HomePageTest extends BaseTest
{
 @Test(priority=5)
 public void HomePageTest()
 {
  LoginPage l=new LoginPage(driver);
  l.setUsername("admin");
  l.setPassword("manager");
  l.clickLogin();
  l.sleep(3);
  l.verifyTitle(driver, 10, "actiTIME - Enter Time-Track");
  l.sleep(2);
  l.clickLogout();  
 }
}