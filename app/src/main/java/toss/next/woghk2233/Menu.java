package toss.next.woghk2233;

public class Menu {
    private String name;
    private String category;
    private boolean hotOrIceAvailable;
    private boolean decafAvailable;
    private int price;

    public Menu(String name, String category, boolean hotOrIceAvailable, boolean decafAvailable, int price) {
        this.name = name;
        this.category = category;
        this.hotOrIceAvailable = hotOrIceAvailable;
        this.decafAvailable = decafAvailable;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public boolean isHotIceSelectable() {
        return hotOrIceAvailable;
    }

    public boolean isDecafSelectable() {
        return decafAvailable;
    }

    public int getPrice() {
        return price;
    }

    // Getter 및 Setter 메서드 생략
}