public class In_stock extends State{
    public In_stock(Lot lot) {
        super(lot);
    }

    @Override
    public void startSale() {
        super.getLot().setState(new For_sale(super.getLot()));
        System.out.println("Лот выставлен на торги");
    }

    @Override
    public void raisePrice() {
        System.out.println("Товар не участвует в торгах");
    }

    @Override
    public void withdraw() {
        System.out.println("Нельзя выставить товар, который не участвует в торгах");
    }

    @Override
    public void giveToTheWinner() {
        System.out.println("Нельзя отдать товар со склада");
    }
}
