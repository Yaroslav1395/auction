public class Sold extends State{
    public Sold(Lot lot) {
        super(lot);
    }

    @Override
    public void startSale() {
        System.out.println("������ ������ �������, ��� ��� ����� ��� ������");
    }

    @Override
    public void raisePrice() {
        System.out.println("������ �������� ����, ��� ��� ����� ��� ������");
    }

    @Override
    public void withdraw() {
        System.out.println("������ ����� � ������, ��� ��� ����� ��� ������");
    }

    @Override
    public void giveToTheWinner() {
        System.out.println("������ ������ ����������, ��� ��� ����� ��� �����");
    }
}

