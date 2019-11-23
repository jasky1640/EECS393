package dbconnect;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class UserInfoDBConnectTest {
    @Test
    public void testGetCourseSeries(){
        Assert.assertFalse(UserInfoDBConnect.IsCorrectAdminUserPasswordPair("haha","notexisted"));
        Assert.assertTrue(UserInfoDBConnect.IsCorrectNormalUserPasswordPair("jieyu","123456abc"));
        Assert.assertFalse(UserInfoDBConnect.IsCorrectNormalUserPasswordPair("jieyu","nope"));
        Assert.assertNotNull(UserInfoDBConnect.getCourseCodeTaken("jieyu"));
        Assert.assertNotNull(UserInfoDBConnect.getUserInfoDBConnectInstance());
        Assert.assertTrue(UserInfoDBConnect.IsUserNameUsed("jieyu"));
        Assert.assertFalse(UserInfoDBConnect.IsUserNameUsed("haha"));
    }
}
