import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;
import java.util.List;

public class TryIt {

    public static void main(String[] args) {

        TicketService service = new TicketService();

        // Build initial ticket
        IncidentTicket t = service.createTicket(
                "TCK-1001",
                "reporter@example.com",
                "Payment failing on checkout"
        );

        System.out.println("Created:");
        System.out.println(t);

        // Assign agent (returns NEW ticket)
        t = service.assign(t, "agent@example.com");

        // Escalate (returns NEW ticket)
        t = service.escalateToCritical(t);

        System.out.println("\nAfter service updates:");
        System.out.println(t);

        // Attempt external modification
        System.out.println("\nAttempting external tag mutation...");

        try {
            List<String> tags = t.getTags();
            tags.add("HACKED_FROM_OUTSIDE");
        } catch (UnsupportedOperationException e) {
            System.out.println("External mutation blocked: " + e);
        }

        System.out.println("\nFinal ticket state:");
        System.out.println(t);
    }
}