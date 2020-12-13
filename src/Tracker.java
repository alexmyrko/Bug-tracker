import ticket.Ticket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Tracker {
    // Untill tickets receiving will be implemented via DAO
    Map<Integer, Ticket> tickets = new HashMap<>();
    public static void main(String[] args) throws IOException {
        Tracker tracker = new Tracker();
        Operation operation = ReadHelper.askOperation();
        System.out.println(operation);
    }
}
