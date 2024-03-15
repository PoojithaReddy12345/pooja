package testScripts;

import java.util.Locale.Category;
import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.BaseClass;
import GenericLibraries.IConstantPath;

public class AddCategoryTest extends BaseClass
{
	@Test
	public void addcategoryTest()
	{
	
	SoftAssert soft=new SoftAssert();
	home.clickCoursesTab();
	home.clickCategoryLink();
	soft.assertTrue(Category.getPageHeader().contains("category"));
	Category.clickNewButton();
	jutil.pause(2000);
	soft.assertEquals(addCategory.getPageHeader(),"Add new Category");
	
	
	
	Map<String,String> map=excel.readFromExcel("Sheet1","Add Category");
	addCategory.setName(map.get("Name"));
	addCategory.clickSave();
	
	soft.assertTrue(course.getSuccessAlertMessage().contains("course added successfully"));
	course.deleteCourse(web, map.get("name"));
	soft.assertTrue(course.getSuccessAlertMessage().contains("Category deleted successfully"));
	if(course.getSuccessAlertMessage().contains("Category deleted successfully"))
		excel.updateTestStatus("sheet1"," Add Category", "Pass",IConstantPath.EXCEL_PATH);
	else
		excel.updateTestStatus("sheet1"," Add Category", "Fail",IConstantPath.EXCEL_PATH);
	soft.assertAll();
	
	}
}

