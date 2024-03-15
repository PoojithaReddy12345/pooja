package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.BaseClass;

public class AddUserTest extends BaseClass
{
	@Test
	public void addUserTest()
	{
		SoftAssert soft=new SoftAssert();
		home.clickUsersTab();
		soft.assertTrue(users.getPageHeader().contains("users"));
		users.clickNewButton();
		soft.assertEquals(addUser.getPageHeader(),"Add New User" );
		
		Map<String,String> map=excel.readFromExcel("sheet1","Add User");
		addUser.setEmail(map.get("Email"));
		addUser.setPwd(map.get("Password"));
		addUser.setFirstName(map.get("FirstName"));
		addUser.setLastName(map.get("LastName"));
		addUser.setAddress(map.get("Address"));
		addUser.setContact(map.get("contact info"));
		addUser.uploadPhoto(map.get("Photo"));
		addUser.clickSave();
		
		soft.assertTrue(users.getSuccessAlertMessage().contains("success"));
		soft.assertAll();
		
		
	}

}
