import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class File_servise {
    private static final Gson gson = new Gson();

    public static Lot[] readJsonLots(){
        Path path = Paths.get("./lots.json");
        String lots;
        try {
            lots = Files.readString(path);
        }catch (IOException e){
            throw new RuntimeException();
        }
        return gson.fromJson(lots, Lot[].class);
    }

    public static void writeLotsToJson(Auction auction){
        Path path = Paths.get("./lots.json");
        String lots = gson.toJson(auction);
        try {
            byte[] lotsByte = lots.getBytes(lots);
            Files.write(path, lotsByte);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
