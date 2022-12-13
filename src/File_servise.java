import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class File_servise {
    private static final Gson gson = new Gson();

    public static Lot[] readJsonLots(String path){
        Path pathToJson = Paths.get(path);
        String lots;
        try {
            lots = Files.readString(pathToJson);
        }catch (IOException e){
            throw new RuntimeException();
        }
        return gson.fromJson(lots, Lot[].class);
    }

    public static void writeLotsToJson(Auction auction, String path){
        Path pathToJson = Paths.get(path);
        String lots = gson.toJson(auction);
        try {
            byte[] lotsByte = lots.getBytes(lots);
            Files.write(pathToJson, lotsByte);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
