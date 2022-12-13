public class For_sale extends State{
    public For_sale(Lot lot) {
        super(lot);
    }

    @Override
    public void startSale() {
        System.out.println("Товар уже на торгах");
    }

    @Override
    public void raisePrice() {
        super.getLot().setPrice(super.getLot().getPrice() + 20);
        super.getLot().setIs_sale(true);
        System.out.println("Цена повышена");
    }

    @Override
    public void withdraw() {
        if (super.getLot().isIs_sale()){
            System.out.println("Товар продан");
        }
        else {
            super.getLot().setState(new In_stock(super.getLot()));
            super.getLot().setState_as_string("На складе");
        }
    }

    @Override
    public void giveToTheWinner() {
        if(super.getLot().isIs_sale()){
            super.getLot().setState(new Sold(super.getLot()));
            super.getLot().setState_as_string("Продано");
        }
        else {
            System.out.println("Товар не куплен. Невозможно отдать");
        }
    }
}



