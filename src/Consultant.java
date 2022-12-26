import java.io.IOException;
import java.util.Scanner;

public class Consultant extends Human {

    public Consultant(String name) throws IOException {
        super(name);
        BaseOfTour.readBase();
    }
    @Override
    public void Hello(){
        System.out.println("Здравствуйте, я консультант "+ name);

    }
    public void ChoiceAction() throws Exception {

        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true){
            System.out.println("Выберите действие: \n" +
                    "1. Показать список горящих туров\n" +
                    "2. Показать список всех туров\n" +
                    "3. Купить билет\n" +
                    "4. Выйти");
            choice = scanner.nextInt();
            switch (choice){
                case 1:{
                    System.out.println("Список горящих туров:");
                    viewBaseOfTour("hot");
                    break;
                }
                case 2:{
                    System.out.println("Список всех туров:");
                    viewBaseOfTour("default");
                    break;
                }
                case 3:{
                    actionPayTour();
                    break;
                }
                case 4:{
                    goodBye();
                    return;
                }
                default:{
                    System.out.println("Укажите корректный номер действия");
                    break;
                }
            }
        }
    }

    private void actionPayTour() throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean needVisa;
        boolean answerForPay;
        String visa = "";
        System.out.println("Напишите название страны, в которую желаете полететь: ");
        String nameOfTour = choiceCountryTour();
        viewChoicedTour(nameOfTour);

        needVisa = needVisa(nameOfTour);
        if(needVisa){
            visa = scanner.next();
            while (!visa.equals("Виза")){
                System.out.println("Предоставьте визу, пожалуйста(слово: Виза)");
                visa = scanner.next();
            }
        }
        answerForPay = askForAgree();
        if(answerForPay){
            payReceipt(nameOfTour);
            thanksForPay();
        }
    }

    private String choiceCountryTour(){
        String choicedTour ="";
        boolean isExists = false;
        while (!isExists){
            Scanner scanner = new Scanner(System.in);
            choicedTour = scanner.next();
            isExists = checkTour(choicedTour);
        }
        return choicedTour;
    }
    private void viewBaseOfTour(String condition) throws IOException {
        for (TourWithVisa ofTour : BaseOfTour.getBase(condition)){
            System.out.println(ofTour.toString());
        }
        System.out.println();
    }

    private void payReceipt(String nameOfTour) throws Exception {
        System.out.println(name + ": С вас "+ BaseOfTour.getTour(nameOfTour).getPrice() + " рублей");
    }

    private boolean needVisa(String nameOfTour) throws Exception {
        if(BaseOfTour.getTour(nameOfTour).isNeedVisa()){
            System.out.println(name + ": Предоставьте визу для оформления");
            return true;
        }else return false;
    }

    private boolean checkTour(String nameOfTour){
        boolean exists = BaseOfTour.exitsTour(nameOfTour);
        if(exists){
            return true;
        }else {
            System.out.println("Укажите корректную страну");
            return false;
        }

    }

    private void viewChoicedTour(String nameOfTour) throws Exception {
        System.out.println(name + ": Вы выбрали тур:");
        System.out.println(BaseOfTour.getTour(nameOfTour));
    }
    private boolean askForAgree(){
        System.out.println(name + ": Подтверждаете тур?");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        while ((!answer.equals("Да")) && (!answer.equals("Нет"))){
            System.out.println("Я вас не понял, скажите Да или Нет");
            answer = scanner.next();
        }
        if(answer.equals("Да")) return true;
        else return false;
    }
    private void thanksForPay(){
        System.out.println(name + ": Спасибо за покупку");
    }
    private void goodBye(){
        System.out.println(name + ": До свидания, приходите к нам еще");
    }

}
