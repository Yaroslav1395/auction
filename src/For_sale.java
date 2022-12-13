public class For_sale extends State{
    public For_sale(Lot lot) {
        super(lot);
    }

    @Override
    public void startSale() {
        System.out.println("����� ��� �� ������");
    }

    @Override
    public void raisePrice() {
        super.getLot().setPrice(super.getLot().getPrice() + 20);
        super.getLot().setIs_sale(true);
        System.out.println("���� ��������");
    }

    @Override
    public void withdraw() {
        if (super.getLot().isIs_sale()){
            System.out.println("����� ������");
        }
        else {
            super.getLot().setState(new In_stock(super.getLot()));
            super.getLot().setState_as_string("�� ������");
        }
    }

    @Override
    public void giveToTheWinner() {
        if(super.getLot().isIs_sale()){
            super.getLot().setState(new Sold(super.getLot()));
            super.getLot().setState_as_string("�������");
        }
        else {
            System.out.println("����� �� ������. ���������� ������");
        }
    }
}



