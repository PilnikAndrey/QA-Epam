package project.pageObject;

import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class DiscussionPage {

    private Label discussion = new Label(By.xpath("//h2[contains(@class,'discussion_primary_header')]"), "discussion");
    private Button forum = new Button(By.xpath("//body[contains(@class,'responsive_page')]/div[contains(@class,'responsive_page_frame with_header')]/div[contains(@class,'responsive_page_content')]/div[contains(@class,'responsive_page_template_content')]/div[contains(@class,'discussions_page')]/div[@id='discussions_tab_contents']/div[@id='forum_list_general']/div[contains(@class,'maincontent discussion_tab_content_area')]/div[contains(@class,'forum_list_ctn')]"), "");
    private Button newDiscussion = new Button(By.xpath("//a[@class='btn_darkblue_white_innerfade btn_medium responsive_OnClickDismissMenu']"), "newDiscussion");
    private Button access = new Button(By.xpath("//a[contains(text(),'create an account')]"), "access");

    public boolean isDiscussionPage() {
       return discussion.isDisplayed();
    }

    public void selectForum() {
        forum.click();
    }

    public void newDiscussion() {
        newDiscussion.click();
    }

    public boolean isNotAccess() {
        return access.isDisplayed();
    }
}
