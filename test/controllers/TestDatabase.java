package controllers;

import com.google.common.collect.ImmutableMap;
import org.junit.*;
import play.db.*;

import java.sql.Connection;

import static org.junit.Assert.assertTrue;

public class TestDatabase {

    Database database;

    @Before
    public void createDatabase() {
        database = Databases.createFrom(
                "org.postgresql.Driver",
                "jdbc:postgresql://localhost:5432/postgres",
                ImmutableMap.of(
                        "username", "postgres",
                        "password", "1234"
                )
        );
    }

    @Test
    public void testDatabase() throws Exception {
        Connection connection = database.getConnection();
        connection.prepareStatement("insert into Agency values (10, 'testing', 'test')").execute();

        assertTrue(
                connection.prepareStatement("select * from Agency where agency_id = 10")
                        .executeQuery().next()
        );
    }

    @After
    public void shutdownDatabase() {
        database.shutdown();
    }
}
