import java.util.Arrays;

public class Lots {
    private final Lot[] lots = File_servise.readJsonLots("./lots.json");

    public Lots() {
        setStartLotsState();
    }

    public Lot[] getLots() {
        return Arrays.copyOf(this.lots, this.lots.length);
    }

    private void setStartLotsState(){
        for (Lot i: this.lots) {
            i.setState(new In_stock(i));
            i.setState_as_string("On base");
        }
    }

    private void printLotsHeader(){
        String format = "%2s | %-15s| %s%n";
        System.out.printf(format,
                "#",
                "ID",
                "name");
        System.out.println("---------------------------------");
    }

    public void printLots(){
        String format = "%2s | %-15s| %s%n";
        this.printLotsHeader();
        for (int i = 0; i <this.lots.length; i++){
            System.out.printf(format, i + 1, this.lots[i].getId(), this.lots[i].getName());
        }

    }

    public void printLotInformation(int userNumber, Auction auction){
        this.lots[userNumber].lotInformation(auction);
    }
}