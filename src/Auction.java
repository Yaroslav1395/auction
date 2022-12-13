import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Auction {
    private Lots lots;

    public Auction() {
        this.lots = new Lots();
    }

    private int userInput(){
        System.out.println("������� �����: ");
        int userNumber;
        try {
            userNumber = new Scanner(System.in).nextInt() - 1;
            if (userNumber >= this.lots.getLots().length){
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e){
            System.out.println("� ������ ��� ����� �����");
            System.out.println("��������� �������");
            userNumber = userInput();
        }
        catch (InputMismatchException e){
            System.out.println("����� ����� ������ �����");
            System.out.println("��������� �������");
            userNumber = userInput();
        }
        return userNumber;
    }

    public void startAuction(){
        this.lots.printLots();
        printLotInformation();
    }

    public void printLotInformation(){
        System.out.println("�������� ����� ����");
        this.lots.lotInformation(this.userInput());
    }

}
