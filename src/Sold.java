public class Sold extends State{
    public Sold(Lot lot) {
        super(lot);
    }

    @Override
    public void startSale() {
        System.out.println("������ ������ �������, ��� ��� ����� ��� ������");
        System.out.println("������� ����� ��������: ");
    }

    @Override
    public void raisePrice() {
        System.out.println("������ �������� ����, ��� ��� ����� ��� ������");
        System.out.println("������� ����� ��������: ");
    }

    @Override
    public void withdraw() {
        System.out.println("������ ����� � ������, ��� ��� ����� ��� ������");
        System.out.println("������� ����� ��������: ");
    }

    @Override
    public void giveToTheWinner() {
        System.out.println("������ ������ ����������, ��� ��� ����� ��� �����");
        System.out.println("������� ����� ��������: ");
    }
}

