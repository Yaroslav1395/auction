public class Sold extends State{
    public Sold(Lot lot) {
        super(lot);
    }

    @Override
    public void startSale() {
        System.out.println("Нельзя начать продажу, так как товар уже продан");
        System.out.println("Введите номер действия: ");
    }

    @Override
    public void raisePrice() {
        System.out.println("Нельзя повысить цену, так как товар уже продан");
        System.out.println("Введите номер действия: ");
    }

    @Override
    public void withdraw() {
        System.out.println("Нельзя снять с торгов, так как товар уже продан");
        System.out.println("Введите номер действия: ");
    }

    @Override
    public void giveToTheWinner() {
        System.out.println("Нельзя выдать покупателю, так как товар уже выдан");
        System.out.println("Введите номер действия: ");
    }
}

