package Utils;

public class UserData {
    private String title = "Mr";
    private String password;
    private String day;
    private String month;
    private String year;
    private boolean newsletter;
    private boolean optin;

    public String getTitle() {
        return title;
    }

    public String getPassword() {
        return password;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public boolean isNewsletter() {
        return newsletter;
    }

    public boolean isOptin() {
        return optin;
    }

    public UserData setTitle(String title) {
        this.title = title;
        return this;
    }

    public UserData setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserData setDateOfBirth(String day, String month, String year) {
        this.day = day;
        this.month = month;
        this.year = year;
        return this;
    }

    public UserData setOption(boolean newsletter, boolean optin) {
        this.newsletter = newsletter;
        this.optin = optin;
        return this;
    }
}