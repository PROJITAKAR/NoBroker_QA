package utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.util.Set;

public class CookieManager {

    // Save cookies to file
    public static void saveCookies(WebDriver driver) {
        try {
            File file = new File("cookies.data");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            Set<Cookie> cookies = driver.manage().getCookies();
            oos.writeObject(cookies);

            oos.close();
            fos.close();

            System.out.println("Cookies saved!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Load cookies from file
    public static void loadCookies(WebDriver driver) {
        try {
            File file = new File("cookies.data");
            if (!file.exists()) return;

            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Set<Cookie> cookies = (Set<Cookie>) ois.readObject();

            for (Cookie cookie : cookies) {
                driver.manage().addCookie(cookie);
            }

            ois.close();
            fis.close();

            System.out.println("Cookies loaded!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}