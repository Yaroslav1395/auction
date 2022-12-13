public class Lot {
    private String id;
    private String name;
    private double price;
    private int honorary_code;
    private String state_as_string;
    private boolean is_sale;
    private transient State state;

    public double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getState_as_string() {
        return state_as_string;
    }

    public int getHonorary_code() {
        return honorary_code;
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

    public void setState(State state) {
        this.state = state;
    }

    public void setState_as_string(String state_as_string) {
        this.state_as_string = state_as_string;
    }
}
