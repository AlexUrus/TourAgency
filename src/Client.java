import java.util.Scanner;

public class Client {

    private String name;

    public String getChoiceCountry() {
        return choiceCountry;
    }

    public void setChoiceCountry(String choiceCountry) {
        this.choiceCountry = choiceCountry;
    }

    private String choiceCountry;

    public Client(String name) {
        this.name = name;
    }

    public void Prihod(){
        System.out.println(name+
                ": Здраствуйте, я хочу купить билет");
    }

    public void askHotTour(){
        System.out.println(name + ": Покажите список горящих туров");
    }
    public void askDefTour(){
        System.out.println(name + ": Покажите список всех туров");
    }

    public void agreeInfo(){
        System.out.println(name + ": Да, все верно");
    }

    public void pay(){
        System.out.println(name + " прикладывает карту и делает пиииииииииик");
    }
    public void choiceTour(String nameOfTour){
        setChoiceCountry(nameOfTour);
        System.out.println(name + ": Хочу слетать в " + nameOfTour );
    }
    public void viewVisa(String visa){
        if(visa == "needVisa") {
            System.out.println(name + " Вот моя виза");
        }
    }

}


