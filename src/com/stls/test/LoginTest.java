package com.stls.test;

import org.testng.annotations.Test;

import com.stls.page.LoginPage;

import generic.BaseTest;
import generic.Excel;

public class LoginTest extends BaseTest
{
 @Test(priority=1)
 public void LoginTest()
 {
  String us=Excel.getCellValue(XLPATH, "ValidLogin", 1, 0);
  String pw=Excel.getCellValue(XLPATH, "ValidLogin", 1, 1);
  LoginPage l=new LoginPage(driver);
  l.setUsername(us);
  l.setPassword(pw);
  l.clickLogin();
  l.sleep(3);
  l.clickLogout();
 }
}
