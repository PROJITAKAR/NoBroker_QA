package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.*;

public class CookieManager {

    private static final String FILE_PATH = "cookies.json";

    // ✅ Save cookies as JSON
    public static void saveCookies(WebDriver driver) {
        try {
            File file = new File(FILE_PATH);

            if (file.exists()) {
                file.delete();
            }

            Set<Cookie> cookies = driver.manage().getCookies();
            List<Map<String, Object>> cookieList = new ArrayList<>();

            for (Cookie cookie : cookies) {
                Map<String, Object> map = new HashMap<>();

                map.put("name", cookie.getName());
                map.put("value", cookie.getValue());
                map.put("domain", cookie.getDomain());
                map.put("path", cookie.getPath());
                map.put("expiry", cookie.getExpiry() != null ? cookie.getExpiry().getTime() : null);

                cookieList.add(map);
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter writer = new FileWriter(file);
            gson.toJson(cookieList, writer);
            writer.close();

            System.out.println("✅ Cookies saved in JSON!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ✅ Load cookies from JSON
    public static void loadCookies(WebDriver driver) {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) return;

            Gson gson = new Gson();

            Type type = new TypeToken<List<Map<String, Object>>>() {}.getType();
            List<Map<String, Object>> cookies =
                    gson.fromJson(new FileReader(file), type);

            for (Map<String, Object> map : cookies) {

                Date expiry = null;
                if (map.get("expiry") != null) {
                    expiry = new Date(((Double) map.get("expiry")).longValue());
                }

                Cookie cookie = new Cookie(
                        (String) map.get("name"),
                        (String) map.get("value"),
                        (String) map.get("domain"),
                        (String) map.get("path"),
                        expiry
                );

                driver.manage().addCookie(cookie);
            }

            System.out.println("✅ Cookies loaded from JSON!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ✅ Validate cookies (expiry check)
    public static boolean areCookiesValid() {

        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) return false;

            Gson gson = new Gson();

            Type type = new TypeToken<List<Map<String, Object>>>() {}.getType();
            List<Map<String, Object>> cookies =
                    gson.fromJson(new FileReader(file), type);

            for (Map<String, Object> map : cookies) {

                if (map.get("expiry") == null) {
                    System.out.println("⚠ Session cookie → invalid");
                    return false;
                }

                Date expiry = new Date(((Double) map.get("expiry")).longValue());
                System.out.println("Expiry: " + expiry);

                if (expiry.before(new Date())) {
                    System.out.println("❌ Cookie expired");
                    return false;
                }
            }

        } catch (Exception e) {
            return false;
        }

        System.out.println("✅ All cookies valid");
        return true;
    }
}