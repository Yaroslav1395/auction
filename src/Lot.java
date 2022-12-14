import java.util.InputMismatchException;
import java.util.Scanner;

public class Lot {
    private String id;
    private String name;
    private double price;
    private String honorary_code;
    private boolean is_sale;
    private String state_as_string;
    private transient State state;
    //в клиентском классе создаем ссылку на контекст
    //через эту ссылку мы можем применить конкретную стратегию
    private transient Context context;

    public Lot(String id, String name, double price, String honorary_code, boolean is_sale, String state_as_string) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.honorary_code = honorary_code;
        this.is_sale = is_sale;
        this.state_as_string = state_as_string;
    }

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

    public State getState() {
        return state;
    }

    public String getHonorary_code() {
        return honorary_code;
    }

    public Context getContext() {
        return context;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setContext(Context context) {
        this.context = context;
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

    public void setHonorary_code(String honorary_code) {
        this.honorary_code = honorary_code;
    }

    private void lotInformatonHeader(){
        String format = " %-13s| %-9s| %-10s| %-7s| %-7s%n";
        System.out.printf(format, "ID", "Name", "State", "Price", "Code");
    }

    public void lotInformation(Auction auction){
        lotInformatonHeader();
        String format = " %-13s| %-9s| %-10s| %-7s| %-7s%n";
        System.out.printf(format,
                this.id,
                this.name,
                this.state_as_string,
                this.price,
                this.honorary_code);
                this.lotActions(auction);
    }

    private void lotActionsHeader(){
        System.out.println("1. Выставить на аукцион");
        System.out.println("2. Поднять цену");
        System.out.println("3. Выдать победителю");
        System.out.println("4. Снять с торгов");
        System.out.println("5. Отобразить информацию о товаре");
        System.out.println("6. Вернуться в список товаров");
        System.out.println("Введите номер действия");
    }
    public void lotActions(Auction auction){
        this.lotActionsHeader();
        boolean isExit = false;
        int userNumber;
        while (!isExit){
            userNumber = userActionInput();
            switch (userNumber) {
                case 1 -> {
                    this.getState().startSale();
                    File_servise.writeLotsToJson(auction.getLots().getLots(), "./lots.json");
                }
                case 2 -> {
                    this.getState().raisePrice();
                    File_servise.writeLotsToJson(auction.getLots().getLots(), "./lots.json");
                }
                case 3 -> {
                    this.getState().giveToTheWinner();
                    File_servise.writeLotsToJson(auction.getLots().getLots(), "./lots.json");
                }
                case 4 -> {
                    this.getState().withdraw();
                    File_servise.writeLotsToJson(auction.getLots().getLots(), "./lots.json");
                }
                case 5 -> this.lotInformation(auction);
                case 6 -> {
                    auction.startAuction();
                    isExit = true;
                }
            }
        }

    }

    private int userActionInput(){
        int userNumber;
        try {
            userNumber = new Scanner(System.in).nextInt();
            if(userNumber > 6){
                throw new IllegalArgumentException();
            }
            else {
                return  userNumber;
            }
        }
        catch (InputMismatchException e){
            System.out.println("Ввели букву вместо цифры");
            System.out.println("Повторите попытку");
            userNumber = userActionInput();
        }
        catch (IllegalArgumentException e){
            System.out.println("Действия под таким номером нет");
            System.out.println("Повторите попытку");
            userNumber = userActionInput();
        }
        return userNumber;
    }

}
