package Utils;

public class UserData {
    // Account infomation
    private String title = "Mr";
    private String password;
    private String day;
    private String month;
    private String year;
    private boolean newsletter;
    private boolean optin;

    // Address information
    private String typeFirstName;
    private String typeLastName;
    private String typeCompany;
    private String typeAddress1;
    private String typeAddress2;
    private String chooseCountry;
    private String typeState;
    private String typeCity;
    private String typeZipcode;
    private String typeMobileNumber;

    // Payment information;
    private String nameCard;
    private String numberCard;
    private String CVC;
    private String monthExpiration;
    private String yearExpiration;

    // Getter payment Info
    public String getNameCard() {
        return nameCard;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public String getCVC() {
        return CVC;
    }

    public String getMonthExpiration() {
        return monthExpiration;
    }

    public String getYearExpiration() {
        return yearExpiration;
    }

    // Setter payment info
    public UserData setNameCard(String nameCard) {
        this.nameCard = nameCard;
        return this;
    }

    public UserData setNumberCard(String numberCard) {
        this.numberCard = numberCard;
        return this;
    }

    public UserData setCVC(String CVC) {
        this.CVC = CVC;
        return this;
    }

    public UserData setMonthExpiration(String monthExpiration) {
        this.monthExpiration = monthExpiration;
        return this;
    }

    public UserData setYearExpiration(String yearExpiration) {
        this.yearExpiration = yearExpiration;
        return this;
    }

    // Getter Address Information
    public String getFirstName() {
        return typeFirstName;
    }

    public String getLastName() {
        return typeLastName;
    }

    public String getCompany() {
        return typeCompany;
    }

    public String getAddress1() {
        return typeAddress1;
    }

    public String getAddress2() {
        return typeAddress2;
    }

    public String getCountry() {
        return chooseCountry;
    }

    public String getState() {
        return typeState;
    }

    public String getCity() {
        return typeCity;
    }

    public String getZipcode() {
        return typeZipcode;
    }

    public String getMobileNumber() {
        return typeMobileNumber;
    }

    // Getter account information
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

    // Setter account information
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

    // Setter Address Information
    public UserData setFullName(String typeFirstname, String typeLastName) {
        this.typeFirstName = typeFirstname;
        this.typeLastName = typeLastName;
        return this;
    }

    public UserData setCompany(String typeCompany) {
        this.typeCompany = typeCompany;
        return this;
    }

    public UserData setAddress(String typeAddress1, String typeAddress2) {
        this.typeAddress1 = typeAddress1;
        this.typeAddress2 = typeAddress2;
        return this;
    }

    public UserData setCountry(String chooseCountry, String typeState, String typeCity) {
        this.chooseCountry = chooseCountry;
        this.typeState = typeState;
        this.typeCity = typeCity;
        return this;
    }

    public UserData setZipcode(String typeZipcode) {
        this.typeZipcode = typeZipcode;
        return this;
    }

    public UserData setMobilePhone(String typeMobileNumber) {
        this.typeMobileNumber = typeMobileNumber;
        return this;
    }
}