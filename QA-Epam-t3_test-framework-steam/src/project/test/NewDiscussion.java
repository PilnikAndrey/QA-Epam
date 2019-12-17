package project.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import project.pageObject.DiscussionPage;
import project.pageObject.MainPage;

public class NewDiscussion extends Base {

    @Test
    public void createNewDiscussion() {
        MainPage mainPage = new MainPage();
        mainPage.clickDiscussion();
        DiscussionPage discussionPage = new DiscussionPage();
        Assert.assertTrue(discussionPage.isDiscussionPage());
        discussionPage.selectForum();
        discussionPage.newDiscussion();
        Assert.assertTrue(discussionPage.isNotAccess(),"User can create discussion");
    }
}
