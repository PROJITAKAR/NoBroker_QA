package utils;

import java.util.Set;
import org.openqa.selenium.WebDriver;

public class WindowUtils {

    // Get parent window
    public static String getParentWindow(WebDriver driver) {
        return driver.getWindowHandle();
    }

    // Switch to new tab
    public static void switchToNewTab(WebDriver driver, String parent) {
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(parent)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    // Switch back to parent
    public static void switchToParent(WebDriver driver, String parent) {
        driver.switchTo().window(parent);
    }

    // Close child tab and return
    public static void closeChildAndSwitchBack(WebDriver driver, String parent) {
        driver.close();
        driver.switchTo().window(parent);
    }
}