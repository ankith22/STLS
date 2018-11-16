package com.stls.test;

import org.testng.annotations.Test;

import com.stls.page.LoginPage;

import generic.BaseTest;
import generic.Excel;

public class InvalidLogin extends BaseTest
{
 @Test(priority=3)
 public void InvalidLogin()
 {
  int rc=Excel.getRowCount(XLPATH, "InvalidLogin");
  for(int i=1;i<=rc;i++)
  {
   String un=Excel.getCellValue(XLPATH, "InvalidLogin", i, 0);
   String pw=Excel.getCellValue(XLPATH, "InvalidLogin", i, 1);
   LoginPage l=new LoginPage(driver);
   l.setUsername(un);
   l.setPassword(pw);
   l.clickLogin();
   l.sleep(3);
   l.errorMessageIsDisplayed();
  }
 }
}
