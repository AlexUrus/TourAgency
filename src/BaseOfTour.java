import java.io.*;
import java.util.*;

public class BaseOfTour {

    static {
        try {
            fileReader = new FileReader("F:\\OOP\\RGR_tourAgency\\base.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Проверьте ссылку на базу");
        }
    }

    private static FileReader fileReader;
    private static BufferedReader bufferedReader = new BufferedReader(fileReader);
    private static List<TourWithVisa> baseOfToursList = new ArrayList<>();
    public static void readBase() throws IOException {
        while (bufferedReader.ready()) {
            String str = bufferedReader.readLine();
            String[] words = str.split(" ");
            Tour tour = new TourBuilderPattern().setNumber(Integer.parseInt(words[0])).setCountry(words[1])
                    .setPrice(Integer.parseInt(words[2])).setComfort(Integer.parseInt(words[3]))
                    .setHotKoef(Integer.parseInt(words[4])).setNeedVisa(Integer.parseInt(words[5])).build();
            baseOfToursList.add((TourWithVisa) tour);
            //номер страна стоимость комфорт коэфInters коэфHot
        }
    }
    public static List<TourWithVisa> getBase(String condition) throws IOException {
       if(baseOfToursList.isEmpty()) readBase();
        switch (condition){
            case "hot":
                List<TourWithVisa> sortedHot = new ArrayList<>(baseOfToursList);
                ListIterator<TourWithVisa> iterator = sortedHot.listIterator();
                while (iterator.hasNext()){
                    if(!iterator.next().getHot()) iterator.remove();
                }
                return sortedHot;
            case "default":
                return baseOfToursList;
            default: throw new IOException("Не верный запрос");
        }
    }
    public static TourWithVisa getTour(String country) throws Exception {
        for(TourWithVisa tour : baseOfToursList){
            if(tour.getCountry().equals(country)) return tour;
        }
        throw new Exception("В базе нет такого тура");
    }
}
