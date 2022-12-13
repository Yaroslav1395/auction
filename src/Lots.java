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
            i.setState_as_string("На складе");
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

    private void lotInformatonHeader(){
        String format = " %-13s| %-9s| %-10s| %-7s| %-7s%n";
        System.out.printf(format, "ID", "Name", "State", "Price", "Code");
    }

    public void lotInformation(int userNumber){
        lotInformatonHeader();
        String format = " %-13s| %-9s| %-10s| %-7s| %-7s%n";
        System.out.printf(format,
                this.lots[userNumber].getId(),
                this.lots[userNumber].getName(),
                this.lots[userNumber].getState_as_string(),
                this.lots[userNumber].getPrice(),
                this.lots[userNumber].getHonorary_code());
    }
}
