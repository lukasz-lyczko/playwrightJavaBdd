package steps;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Cookie;
import enums.SharedInfoTag;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ScenarioContext {
    public Page page;
    public static Playwright playwright = Playwright.create();
    public static Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    public BrowserContext context;
    private final ConcurrentHashMap<String, Object> sharedInfo = new ConcurrentHashMap<>();

    public ScenarioContext() {
        context = browser.newContext(
                new Browser.NewContextOptions().setBaseURL("https://www.reserved.com/pl/pl/")
        );
        Cookie consentCookie = new Cookie("CookieConsent", "{stamp:%27test==%27%2Cnecessary:true%2Cpreferences:true%2Cstatistics:true%2Cmarketing:true%2Cmethod:%27explicit%27%2Cver:1%2Cutc:1691080348550%2Cregion:%27pl%27}")
                .setDomain("www.reserved.com")
                .setPath("/");
        context.addCookies(List.of(consentCookie));
        context.tracing().start(
                new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true)
        );
        context.setDefaultNavigationTimeout(30000.00d);
        context.setDefaultTimeout(30000.00d);

        page = context.newPage();
    }

    public <T> T getSharedInfo(SharedInfoTag key, Class<T> valueType) {
        return getSharedInfo(key.name(), valueType);
    }

    public <T> T getSharedInfo(String key, Class<T> valueType) {
        try {
            return valueType.cast(sharedInfo.get(key));
        } catch (ClassCastException e) {
            return null;
        }
    }

    public void setSharedInfo(SharedInfoTag key, Object obj) {
        setSharedInfo(key.name(), obj);
    }

    public void setSharedInfo(String key, Object obj) {
        sharedInfo.put(key, obj);
    }

    public void cleanUp() {
        sharedInfo.clear();
    }
}
