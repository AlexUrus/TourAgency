import java.util.Scanner;

public class Client extends Human{

    public Client(String name) {
        super(name);
    }
    @Override
    public void Hello(){
        System.out.println("Здраствуйте, я "+ name );
    }


}


