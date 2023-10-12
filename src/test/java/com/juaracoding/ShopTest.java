package com.juaracoding;

import org.example.Driver.DriverSingleton;
import org.example.pages.LoginPage;
import org.example.pages.Shop;
import org.example.utils.Constans;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ShopTest {
    private WebDriver driver;
    private LoginPage loginPage = new LoginPage();
    private Shop shop = new Shop();

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance(Constans.CHROME);
        driver = DriverSingleton.getDriver();
//        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(Constans.URL);

        //step
        loginPage = new LoginPage();
         shop = new Shop();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);        //close
        DriverSingleton.classObjectInstance();
    }

    @Test(priority = 1)
    public void testValidLogin(){
        loginPage.loginForm("feryokta16","#Amala1908");
        Assert.assertEquals(loginPage.getTxtDashboard(),"Hello Feryokta16 (not Feryokta16? Log out)");
        System.out.println("berhasil login");
//        shop.recruitment();
//        Assert.assertEquals(shop.getTxtBaju(),"TOKYO TALKIES");
    }
    @Test(priority = 2)
    public void testCari(){
        shop.recruitment();
        Assert.assertEquals(shop.getTxtBaju(),"TOKYO TALKIES");
        System.out.println("ketemu");
    }
    @Test(priority = 3)
    public void testAdd(){
        shop.add();
        Assert.assertEquals(shop.getTxtContain(),"TOKYO TALKIES");
    }
    @Test(priority = 4)
    public void testKeluar(){
        DriverSingleton.delay(20);
        loginPage.logOutAcount();
        System.out.println("keluar");
    }

}
