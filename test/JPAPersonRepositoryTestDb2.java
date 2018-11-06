import org.junit.Test;

import java.util.concurrent.ExecutionException;

public class JPAPersonRepositoryTestDb2 extends JPAPersonRepositoryTest {

    @Override
    public String dbName() {
        return "db2";
    }

    @Test
    public void testPawel() throws ExecutionException, InterruptedException {
        shouldReturnCorrectPerson(1l, "Pawel");
    }
}