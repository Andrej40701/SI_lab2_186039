import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    private SILab2 lab2 = new SILab2();
    private User user0 = null;
    private User user1 = new User("Andrej", null, "andrej.stanojkovik@gmail.com");
    private User user2 = new User("Andrej", null, "");
    private User user3 = new User("Andrej", null, "andrej#gmail.com");
    private User user4 = new User("Andrej", null, "andrej@gmailcom");
    private List<String> allUsers1 = new ArrayList<>(Arrays.asList("Andrej40701"));
    private List<String> allUsers2 = new ArrayList<>(Arrays.asList("Andrej"));

    @Test
    void everyPathTest() {

        //1, 2, 13, 14
        assertFalse(lab2.function(user0, allUsers1));

        //1, 2, 3, 13, 14
        assertFalse(lab2.function(user1, allUsers2));

        //1, 2, 3, 4, 5.1, 5.2, 11, 12, 14 - not possible

        //1, 2, 3, 4, 5.1, 5.2, 11, 13, 14
        assertFalse(lab2.function(user2, allUsers1));

        //1, 2, 3, 4, 5.1, 5.2, (6, 8, 10, 5.3, 5.2), 11, 12, 14 - not possible

        //1, 2, 3, 4, 5.1, 5.2, (6, 8, 10, 5.3, 5.2), 11, 13, 14
        assertFalse(lab2.function(user3, allUsers1));

        //1, 2, 3, 4, 5.1, 5.2, (6, 7, 8, 10, 5.3, 5.2), 11, 12, 14 - not possible

        //1, 2, 3, 4, 5.1, 5.2, (6, 7, 8, 10, 5.3, 5.2), 11, 13, 14
        assertFalse(lab2.function(user4, allUsers1));

        //1, 2, 3, 4, 5.1, 5.2, (6, 8, 9, 10, 5.3, 5.2), 11, 12, 14 - not possible

        //1, 2, 3, 4, 5.1, 5.2, (6, 8, 9, 10, 5.3, 5.2), 11, 13, 14 - not possible

        //1, 2, 3, 4, 5.1, 5.2, (6, 7, 8, 9, 10, 5.3, 5.2), 11, 12, 14
        assertTrue(lab2.function(user1, allUsers1));

        //1, 2, 3, 4, 5.1, 5.2, (6, 7, 8, 9, 10, 5.3, 5.2), 11, 13, 14 - not possible
    }

    @Test
    void everyStatementTest() {
        assertTrue(lab2.function(user1, allUsers1));
        assertFalse(lab2.function(user0, allUsers1));
    }
}