/**
 * 
 */
package objectRepository;

import org.openqa.selenium.By;

/**
 * @author WangMingxun
 *
 */
public class MatterMost {

	public final static By Login_ID = By.xpath("//input[@name='loginId']");
	public final static By Login_PW = By.xpath("//input[@name='password']");
	public final static By SIGN_IN = By.id("loginButton");
	public final static By Logout = By.xpath("//*[@id='logout']/span[text()='Logout']");
	public final static By Logout_narrowDisplay = By.xpath("//i[@class='icon fa fa-sign-out']");
	public final static By User_Status = By.id("status-dropdown");
	public final static By Online = By.linkText("Online");
	public final static By Away = By.linkText("Away");
	public final static By Offline = By.linkText("Offline");
	public final static By navbar = By.xpath("//button[@class='navbar-toggle'][@type='button']");
//	public final static By navbar_right = By.xpath("//button[@class='navbar-toggle navbar-right__icon menu-toggle pull-right'][@type='button']");
	public final static By Header_Infor = By.id("channelHeaderDropdown");
	public final static By orgName = By.xpath(".//*[@id='sidebar-left']//ul[@class='nav nav-pills nav-stacked']//h4/span[text()='cyberobject']");
	public final static By appList(String appname) {
		By xpath;
		xpath = By.xpath( "//span[@class='sidebar-item__name' and text()='" + appname + "']");
		return xpath;
	}
	
	
	
	public final static By Dialog_Status_Title = By
			.xpath("//*[@class='modal-title']/span[text()='Your status is set to \"Away\"']");
	public final static By Dialog_Status_Content = By.className("modal-body");
	public final static By Dialog_Status_Chkbox = By.xpath("//input[@type='checkbox text-right margin-bottom--none']/label/span[text()='Do not ask me again']");
	public final static By Dialog_Status_Yes = By
			.xpath("//button[@class='btn btn-primary']/span[text()='Yes, set my status to \"Online\"']");
	public final static By Dialog_Status_No = By
			.xpath("//button[@class='btn btn-default']/span[text()='No, keep it as \"Away\"']");

	public final static By SYS_Setting = By.xpath("//*[@class='sidebar-header-dropdown__icon']");
	public final static By SYS_Setting_narrowDisplay = By.xpath("//button[@class='navbar-toggle navbar-right__icon menu-toggle pull-right'][@type='button']");

	public final static By Account_Settings = By.xpath("//*[@id='accountSettings']/span[text()='Account Settings']");
	public final static By Account_Settings_UserNameDesc = By.id("UsernameDesc");
	public final static By Account_Settings_Close = By
			.xpath("//div[@class='settings-modal modal-dialog']/div/div/button[@class='close']");

	public final static By Engage_Request_Title = By
			.xpath("//div[@class='detailRequestWin']/div[1][text()='Engage Request']");
	public final static By Engage_Request_Content = By
			.xpath("//div[@class='detailRequestWin']/div[2][@class='detailcontent']");
	public final static By Accept = By.xpath("//div[@class='detailRequestWin']//input[@value='Accept']");
	public final static By Decline = By.xpath("//div[@class='detailRequestWin']//input[@value='Decline']");

	public final static By Leave_TopBar = By
			.xpath("//*[@id='channel-header']//span[@class='glyphicon glyphicon-log-out']");
	public final static By Leave_SideBar = By
			.xpath("//*[@id='sidebar-left']//span[@class='glyphicon glyphicon-log-out']");

	public final static By Element_Status = By.xpath("/parent::li");
	public final static By Send_Box = By.id("post_textbox");
	public final static By Post_List = By.className("post-list__content");
	public final static By Post_Last = By.xpath("//div[@class='post-list__content']/div[last()]/div");

	public final static By Mode_CM = By.xpath("//*[@id='app-content']//a[@href='#'][text()='CM']/parent::li");
	public final static By Mode_Monitor = By.xpath("//*[@id='app-content']//a[@href='#'][text()='MONITOR']/parent::li");

	public final static By Post_NewMessage_title = By.xpath("//div[contains(@id,'new_message')]");
	public final static By Post_Messages =By.xpath("//div[contains(@id,'new_message')]/following-sibling::div");

	
	
	public static By APP(String appName) {
		return By.xpath("//ul//span[@class='sidebar-item__name'][text()='" + appName + "']");
	};

	/**
	 * @see For Last message, actNum=0; For Last-1 message, actNum=1.
	 * @param actNum
	 * @return 获取Forward-To-CUST By.
	 */
	public static By Forward_ToCUST(int actNum) {
		By temp = null;

		temp = By.xpath("//div[@class='post-list__content']/div[last()-" + actNum
				+ "][not(@class='date-separator')][not(@class='new-separator')]/div//span[@class='glyphicon forward-tocust']");

		return temp;
	}

	/**
	 * @see For Last message, actNum=0; For Last-1 message, actNum=1.
	 * @param actNum
	 * @return 获取Forward-To-CM By.
	 */
	public static By Forward_ToCM(int actNum) {
		By tempID = null;

		tempID = By.xpath("//div[@class='post-list__content']/div[last()-" + actNum
				+ "][not(@class='date-separator')][not(@class='new-separator')]/div//span[@class='glyphicon forward-tocm']");

		return tempID;
	}

}
