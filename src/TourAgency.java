public class TourAgency  {
   private static String nameAgency = "Турагентство Аэросейлс";

   private static void Open(){
       System.out.println(nameAgency + " открылось");
   }
   private static void Close(){
       System.out.println(nameAgency + " закрылось");
   }
   public static void main(String[] args) throws Exception {
       Open();
       System.out.println();

       Client client = new Client("Alex");
       Consultant consultant = new Consultant("Константин");
       System.out.println("Вас приветствует " + nameAgency);

       consultant.Hello();
       client.Hello();
       consultant.ChoiceAction();

       Close();
   }

}
