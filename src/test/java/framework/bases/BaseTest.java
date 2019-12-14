package framework.bases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import framework.pageObjects.NavigationBarPage;
import framework.pageObjects.SearchedProductsPage;
import framework.utils.GetProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest {
    protected static WebDriver driver;
    protected GetProperties properties = new GetProperties();
    protected String url = properties.getString("URL");

    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentReports extentReports;
    protected static ExtentTest extentTest;

    public NavigationBarPage navigationBarPage;
    public SearchedProductsPage searchedProductsPage;

    @BeforeSuite(alwaysRun = true)
    @Parameters("browser")
    public void setUpSuite(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions opt = new ChromeOptions();
            opt.addArguments("disable-infobars");
            System.setProperty("webdriver.chrome.driver", properties.getString("CHROMEDRIVER_PATH"));
            driver = new ChromeDriver(opt);
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", properties.getString("FIREFOX_PATH"));
            driver = new FirefoxDriver();
        }
        setUpReports();
    }

    @BeforeTest
    public void navegarAInicio() {
        navigationBarPage = new NavigationBarPage(driver);
        driver.get(url);
    }

    public void setUpReports() {
        extentHtmlReporter = new ExtentHtmlReporter("reports/reporte.html");
        extentHtmlReporter.config().setDocumentTitle("Automation Reports");
        extentHtmlReporter.config().setReportName("Reporte de Pruebas Automatizadas");
        extentHtmlReporter.config().setTheme(Theme.STANDARD);

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);
    }


    @AfterMethod(alwaysRun = true)
    public void tearDownTest(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL, "Test Case: " + result.getName() + " failed");
            extentTest.log(Status.FAIL, "Caused: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(Status.SKIP, "Test Case: " + result.getName() + " skipped");
            extentTest.log(Status.SKIP, "Caused: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, "Test Case: " + result.getName() + " passed");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void flush() {
        extentReports.flush();
        driver.quit();
    }
}
