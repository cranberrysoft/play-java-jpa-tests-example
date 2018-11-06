import models.JPAPersonRepository;
import models.Person;
import org.junit.Assert;

import java.util.concurrent.ExecutionException;

public abstract class JPAPersonRepositoryTest extends TestServerBase{

    public void shouldReturnCorrectPerson(Long id, String name) throws ExecutionException, InterruptedException {
        JPAPersonRepository jpaPersonRepository = app.injector().instanceOf(JPAPersonRepository.class);

        final Person person = jpaPersonRepository.get(id).toCompletableFuture().get();

        Assert.assertEquals(name, person.name);
    }
}
