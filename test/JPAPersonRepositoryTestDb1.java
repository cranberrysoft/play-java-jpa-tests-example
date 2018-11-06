import org.junit.Test;

import java.util.concurrent.ExecutionException;

public class JPAPersonRepositoryTestDb1 extends JPAPersonRepositoryTest {

    @Override
    public String dbName() {
        return "db1";
    }

    @Test
    public void testMariusz() throws ExecutionException, InterruptedException {
        shouldReturnCorrectPerson(1l, "Mariusz");
    }

}
