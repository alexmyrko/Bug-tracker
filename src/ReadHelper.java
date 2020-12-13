import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadHelper {
    public static String readString() {
        String text = null;



        return text;
    }

    // Should receive from console decimal number of operation and return Enum type of corresponding operation
    public static Operation askOperation() throws IOException {
        Operation operation = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter operation no.: ");
        while(true) {
            String text = reader.readLine();
            try {
                operation = Operation.values()[Integer.parseInt(text)];
                return operation;
            } catch (Exception e) {
                System.out.println("Not exist !  Try again !");
            }
        }
    }

    // Should receive from console decimal id number, check and return if exist
    public int chooseTicketId(){
        int ticketId = 0;


        return ticketId;
    }

}
