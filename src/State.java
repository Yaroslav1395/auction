public abstract class State {
    private Lot lot;

    public State(Lot lot) {
        this.lot = lot;
    }

    public abstract void startSale();
    public abstract void raisePrice();
    public abstract void withdraw();
    public abstract void giveToTheWinner();
}
