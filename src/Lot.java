public class Lot {
    private String id;
    private String name;
    private double price;
    private int honorary_code;
    private String state_as_string;
    private boolean is_sale;
    private transient State state;

    public void setState(State state) {
        this.state = state;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isIs_sale() {
        return is_sale;
    }

    public void setIs_sale(boolean is_sale) {
        this.is_sale = is_sale;
    }
}
