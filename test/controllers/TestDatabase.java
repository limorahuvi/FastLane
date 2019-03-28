package controllers;

import com.google.common.collect.ImmutableMap;
import play.db.Database;
import play.db.Databases;
import play.db.evolutions.*;
import java.sql.Connection;

import org.junit.*;
import static org.junit.Assert.*;

public class TestDatabase{

    Database database;

    @Before
    public void createDatabase() {
        database = Databases.createFrom(
            "org.postgresql.Driver",
            "jdbc:postgresql://localhost:5432/dbtest",
        ImmutableMap.of(
            "username", "postgres",
            "password", "1234"
            ));
    }

    @After
    public void shutdownDatabase() {
        database.shutdown();
    }

    @Test
    public void testSomething() {

    }

}