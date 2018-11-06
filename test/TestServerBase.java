import org.junit.After;
import org.junit.Before;
import play.Application;
import play.db.Database;
import play.db.Databases;
import play.db.evolutions.Evolutions;
import play.db.jpa.JPAApi;
import play.test.Helpers;
import play.test.WithServer;

import java.util.HashMap;
import java.util.Map;

public abstract class TestServerBase extends WithServer {

    public abstract String dbName();

    public String getDbUrl() {
        return "jdbc:h2:mem:play;MODE=MySQL";
    }

    @Override
    protected Application provideApplication() {
        final String dbName = dbName();
        final Map config = new HashMap();
        config.put(String.format("db.%s.driver", dbName), "org.h2.Driver");
        config.put(String.format("db.%s.url", dbName), getDbUrl());
        config.put(String.format("db.%s.username", dbName), "");
        config.put(String.format("db.%s.password", dbName), "");
        config.put(String.format("db.%s.jndiName", dbName), "DefaultDS");
        config.put("play.evolutions.enabled", "false");
        return Helpers.fakeApplication(config);
    }

    @Before
    public void runEvolutions() {
        final Database db = Databases.createFrom(dbName(), "org.h2.Driver", getDbUrl());
        final JPAApi jpaApi = app.injector().instanceOf(JPAApi.class);
        jpaApi.withTransaction(()->{ //for older playframework you can use JPA.withTransaction
            Evolutions.applyEvolutions(db);
        });
    }

    @After
    public void deleteEvolutions() {
        final Database db = Databases.createFrom(dbName(), "org.h2.Driver", getDbUrl());
        final JPAApi jpaApi = app.injector().instanceOf(JPAApi.class);
        jpaApi.withTransaction(()->{
            Evolutions.cleanupEvolutions(db);
        });
    }
}