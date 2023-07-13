package com.springstudy.shop;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
@Log4j2
@SpringBootTest
public class MariadbTest {


    private DataSource dataSource;

    @Test
    public void testConnection() throws SQLException {

        @Cleanup
        Connection con = dataSource.getConnection();

        log.info("ㅈㅈ"+con);

        Assertions.assertNotNull(con);
    }




}
