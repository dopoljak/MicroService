package com.ilirium.database.commons;

import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dpoljak
 */
@ApplicationScoped
public class H2DatabaseBackup {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_SSS");

    public void makeBackupH2(DataSource dataSource) {
        try {
            String sql = String.format("BACKUP TO 'database_backup\\h2_backup_%s.zip'", SIMPLE_DATE_FORMAT.format(new Date()));
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            close(statement, connection);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    void close(AutoCloseable... closable) {
        for (AutoCloseable autoCloseable : closable) {
            try {
                autoCloseable.close();
            } catch (Exception e) {
            }
        }
    }
}
