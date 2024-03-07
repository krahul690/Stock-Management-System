/*
 * this class use to  show a user name a in display 
 */
package emart.pojo;

/**
 *
 * @author LENOVO
 */
public class UserProfile {
    private static String username;
    private static String usertype;
    private static String userid;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        UserProfile.username = username;
    }

    public static String getUsertype() {
        return usertype;  
    }

    public static void setUsertype(String usertype) {
        UserProfile.usertype = usertype;
    }

    public static String getUserid() {
        return userid;
    }

    public static void setUserid(String userid) {
        UserProfile.userid = userid;
    }



}
