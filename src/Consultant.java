import java.io.IOException;

public class Consultant {
    private String name ;

    public Consultant(String name) {
        this.name = "Аэро" + name;
    }

    public void Hello(){
        System.out.println("Здравствуйте, я ИИ "+ name +", чем могу помочь?" );
    }

    public void viewBaseOfTour(String condition) throws IOException {
        for (Tour ofTour : BaseOfTour.getBase(condition)){
            System.out.println(ofTour.toString());
        }
        System.out.println();
    }

    public void payReceipt(String nameOfTour) throws Exception {
        System.out.println(name + ": С вас "+ BaseOfTour.getTour(nameOfTour).getPrice() + " рублей");
    }

    public String askForBuy(String nameOfTour) throws Exception {
        System.out.println(name + ": Вы выбрали тур:");
        System.out.println(BaseOfTour.getTour(nameOfTour));
        if(BaseOfTour.getTour(nameOfTour).isNeedVisa()){
            System.out.println(name + ": Предоставьте визу для оформления");
            return "needVisa";
        }else return "needntVisa";
    }
    public void askForAgree(){
        System.out.println(name + ": Подтверждаете тур?");
    }
    public void thanksForPay(){
        System.out.println(name + ": Спасибо за покупку, приходите к нам еще");
    }

}
