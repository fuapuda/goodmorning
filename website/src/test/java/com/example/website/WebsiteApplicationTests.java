package com.example.website;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class WebsiteApplicationTests {
    @Autowired
    DataSource ds;

    @Test
    void contextLoads() {
    }

    @Test
    public void getConnection() throws SQLException {
        Connection conn = ds.getConnection();
        System.err.println(conn);
    }
}
