public class In_stock extends State{
    public In_stock(Lot lot) {
        super(lot);
    }

    @Override
    public void startSale() {
        super.getLot().setState(new For_sale(super.getLot()));
        System.out.println("��� ��������� �� �����");
    }

    @Override
    public void raisePrice() {
        System.out.println("����� �� ��������� � ������");
    }

    @Override
    public void withdraw() {
        System.out.println("������ ��������� �����, ������� �� ��������� � ������");
    }

    @Override
    public void giveToTheWinner() {
        System.out.println("������ ������ ����� �� ������");
    }
}
