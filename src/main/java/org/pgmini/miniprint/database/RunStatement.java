/*
 * Point Grey Mini Print Service - authenticated printer utility
 * Copyright (C) 2019  Varun Patel <varun@varunpatel.ca>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.pgmini.miniprint.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.pgmini.miniprint.config.Logging;
import org.pgmini.miniprint.config.PropertiesLoader;

public class RunStatement {
    private final Properties properties = PropertiesLoader.loadProps();
    public ResultSet queryUsers(String query) {

        return query(query, properties.getProperty("db.users.url"));
    }
    public ResultSet queryPrintJobs(String query) {
        return query(query, properties.getProperty("db.printjobs.url"));
    }
    public ResultSet queryTickets(String query) {
        return query(query, properties.getProperty("db.tickets.url"));
    }
    
    public ResultSet query(String query, String jdbcDB) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            Logging.log(e.toString());
        }
        //create Connection and return it
        Connection connection;

        //create statement
        Statement statement;

        ResultSet output = null;

        //run query
        try {

            //connect to database using connection and url
            connection = DriverManager.getConnection("jdbc:postgresql://" + properties.getProperty("db.url") + ":" + properties.getProperty("db.port") + "/" + jdbcDB, properties.getProperty("db.username"), properties.getProperty("db.password"));

            //connect statement to new connection
            statement = connection.createStatement();

            //execute query and send output to resultset output
            output = statement.executeQuery(query);

        } catch (Exception e) {
            Logging.log(e.toString());
        }

        return output;
    }
}
