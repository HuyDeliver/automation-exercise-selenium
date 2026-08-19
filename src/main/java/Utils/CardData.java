package Utils;

public class CardData {
    private String nameCard;
    private String numberCard;
    private String CVC;
    private String monthExpiration;
    private String yearExpiration;

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
    public CardData setNameCard(String nameCard) {
        this.nameCard = nameCard;
        return this;
    }

    public CardData setNumberCard(String numberCard) {
        this.numberCard = numberCard;
        return this;
    }

    public CardData setCVC(String CVC) {
        this.CVC = CVC;
        return this;
    }

    public CardData setMonthExpiration(String monthExpiration) {
        this.monthExpiration = monthExpiration;
        return this;
    }

    public CardData setYearExpiration(String yearExpiration) {
        this.yearExpiration = yearExpiration;
        return this;
    }
}
