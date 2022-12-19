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
       client.Prihod();
       client.askHotTour();
       consultant.viewBaseOfTour("hot");
       client.askDefTour();
       consultant.viewBaseOfTour("default");
       client.choiceTour("Чехия");
       consultant.askForBuy(client.getChoiceCountry());
       client.viewVisa(consultant.askForBuy(client.getChoiceCountry()));
       consultant.askForAgree();
       client.agreeInfo();
       consultant.payReceipt(client.getChoiceCountry());
       client.pay();
       consultant.thanksForPay();

       System.out.println();
       Close();
   }

}
