import org.junit.Test;

import java.util.concurrent.ExecutionException;

public class JPAPersonRepositoryTestDb3 extends JPAPersonRepositoryTest {

    @Override
    public String dbName() {
        return "db3";
    }

    @Test
    public void testMariusz() throws ExecutionException, InterruptedException {
        shouldReturnCorrectPerson(1l, "Michal");
    }

}