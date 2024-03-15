package GenericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import ObjectRepo.AddNewCategoryPage;
import ObjectRepo.AddNewUserPage;
import ObjectRepo.CategoryPage;
import ObjectRepo.CourseListPage;
import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import ObjectRepo.UsersPage;

public class BaseClass {
	
	//@BeforeSuite
	//@BeforeTest

	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility web;
	protected WebDriver driver;
	
	public static WebDriver sdriver;
	
	protected LoginPage login;
	protected HomePage home;
	protected UsersPage users;
	protected CourseListPage course;
	protected AddNewUserPage addUser;
	protected AddNewCategoryPage addCourse;
	protected AddNewCategoryPage addCategory;

	
	
	@BeforeClass
	public void classConfig() {
		property = new PropertiesUtility();
		excel = new ExcelUtility();
		jutil = new JavaUtility();
		web = new WebDriverUtility();
		
		
		property.propertiesInit(IConstantPath.Properties_path);
		driver = web.LaunchAndMaximizeBrowser(property.readFromProperties("browser"));
		web.waitTilElementFound(Long.parseLong(property.readFromProperties("timeouts")));
		
		sdriver = driver;
	}
	
	@BeforeMethod
	public void methodConfig() {
		login = new LoginPage(driver);
		home = new HomePage(driver);
		users = new UsersPage(driver);
		course = new CourseListPage(driver);
		addUser = new AddNewUserPage(driver);
		addCategory = new AddNewCategoryPage(driver);
		addCourse = new AddNewCategoryPage(driver);
		
		excel.excelInit(IConstantPath.EXCEL_PATH);
		
		web.navigateToApp(property.readFromProperties("url"));
		login.loginToApp(property.readFromProperties("username"),property.readFromProperties("password"));;
	}
	
	@AfterMethod
	public void methodTeardown()  {
		home.SignoutofApp();
		excel.closeExcel();
	}
	
	@AfterClass
	public void classTeardown()
	{
		web.quitAllWindows();
	}
	
//AfterTest
	
}
