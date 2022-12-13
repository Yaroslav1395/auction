import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Auction {
    private Lots lots;

    public Auction() {
        this.lots = new Lots();
    }

    private int userInput(){
        System.out.println("Введите число: ");
        int userNumber;
        try {
            userNumber = new Scanner(System.in).nextInt() - 1;
            if (userNumber >= this.lots.getLots().length){
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e){
            System.out.println("В списке нет такой цифры");
            System.out.println("Повторите попытку");
            userNumber = userInput();
        }
        catch (InputMismatchException e){
            System.out.println("Ввели букву вместо цифры");
            System.out.println("Повторите попытку");
            userNumber = userInput();
        }
        return userNumber;
    }

    public void startAuction(){
        this.lots.printLots();
        printLotInformation();
    }

    public void printLotInformation(){
        System.out.println("Выберите номер лота");
        this.lots.lotInformation(this.userInput());
    }

}
