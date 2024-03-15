package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.BaseClass;
import GenericLibraries.IConstantPath;

public class AddCourseTest extends BaseClass
{
@Test
public void addcourseataest()
{
	SoftAssert soft =new SoftAssert();
	home.clickCoursesTab();
	home.clickCourseListLink();
	soft.assertTrue(course.getPageHeader().contains("course List"));
	course.clickNewButton();
	jutil.pause(2000);
	soft.assertEquals(addCourse.getPageHeader(),"Add User course");
	
	
	
	Map<String,String> map=excel.readFromExcel("sheet1","Add course");
	addCourse.setName(map.get("Name"));
	addCourse.selectCategory(web,map.get("Category"));
	addCourse.setPrice(map.get("price"));
	addCourse.uploadPhoto(map.get("Photo"));
	addCourse.addDescription(web,map.get("Description"));
	addCourse.clickSave();
	
	
	soft.assertTrue(course.getSuccessAlertMessage().contains("course added successfully"));
	course.deleteCourse(web, map.get("name"));
	soft.assertTrue(course.getSuccessAlertMessage().contains("product deleted successfully"));
	if(course.getSuccessAlertMessage().contains("product deleted successfully"))
		excel.updateTestStatus("sheet1"," Add Course", "Pass",IConstantPath.EXCEL_PATH);
	else
		excel.updateTestStatus("sheet1"," Add Course", "Pass",IConstantPath.EXCEL_PATH);
	soft.assertAll();
}
}
