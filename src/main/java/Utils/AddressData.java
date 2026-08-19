package Utils;

public class AddressData {
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

    public AddressData setFullName(String typeFirstname, String typeLastName) {
        this.typeFirstName = typeFirstname;
        this.typeLastName = typeLastName;
        return this;
    }

    public AddressData setCompany(String typeCompany) {
        this.typeCompany = typeCompany;
        return this;
    }

    public AddressData setAddress(String typeAddress1, String typeAddress2) {
        this.typeAddress1 = typeAddress1;
        this.typeAddress2 = typeAddress2;
        return this;
    }

    public AddressData setCountry(String chooseCountry, String typeState, String typeCity) {
        this.chooseCountry = chooseCountry;
        this.typeState = typeState;
        this.typeCity = typeCity;
        return this;
    }

    public AddressData setZipcode(String typeZipcode) {
        this.typeZipcode = typeZipcode;
        return this;
    }

    public AddressData setMobilePhone(String typeMobileNumber) {
        this.typeMobileNumber = typeMobileNumber;
        return this;
    }

}
