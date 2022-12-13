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
        System.out.println("������� ����� ��������: ");
    }

    @Override
    public void withdraw() {
        if (super.getLot().isIs_sale()){
            System.out.println("����� ������");
            System.out.println("������� ����� ��������: ");
        }
        else {
            super.getLot().setState(new In_stock(super.getLot()));
            super.getLot().setState_as_string("�� ������");
            System.out.println("������� ����� ��������: ");
        }
    }

    @Override
    public void giveToTheWinner() {
        if(super.getLot().isIs_sale()){
            super.getLot().setState(new Sold(super.getLot()));
            if(super.getLot().getPrice() >= 1000){
                super.getLot().setContext(new Context(new Gold_Code()));
            } else if (super.getLot().getPrice() >= 500 && super.getLot().getPrice() < 1000) {
                super.getLot().setContext(new Context(new Silver_Code()));
            } else {
                super.getLot().setContext(new Context(new Bronze_Code()));
            }
            super.getLot().setHonorary_code(super.getLot().getContext().getCode(super.getLot().getId()));
            super.getLot().setState_as_string("�������");
            System.out.println("����� ����� ����������");
            System.out.println("������� ����� ��������: ");
        }
        else {
            System.out.println("����� �� ������. ���������� ������");
            System.out.println("������� ����� ��������: ");
        }
    }
}



