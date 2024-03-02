package org.example;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.sql.Connection;

import static org.example.Utility.executeQuery;
import static org.example.Utility.readFromFileQuery;

public class DatabaseInitService {
    private static Logger loger = LogManager.getLogger(DatabaseInitService.class);

    public static void main(String[] args) {
        Connection connection = H2Database.getINSTANCE().getConnection();

        String sqlFilePath = "sql/init_db.sql";

        String query = null;
        try {
            query = readFromFileQuery(sqlFilePath);
            executeQuery(connection, query);

        } catch (FileNotFoundException ex) {
            loger.error("Can't find file with sql statement");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


