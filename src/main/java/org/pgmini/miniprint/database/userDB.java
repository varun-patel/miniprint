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

import org.pgmini.miniprint.model.*;

public class userDB {
    public User getUser (Login login) {

        return new User();
    }
    public String verifyUser(String username, String password){

        //default auth to false
        String auth;

        String hash = Hash(password, "saltystudentsdb");

        boolean verified = false;

        ResultSet output = RunStatement("SELECT password FROM students WHERE email = '" + username + "';");

        try {
            while (output.next()) {
                verified = output.getString(1).equals(hash);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return parseAuth(output, verified);

    }
}
