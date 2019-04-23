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

package org.pgmini.miniprint.model;

import org.json.JSONObject;
import org.pgmini.miniprint.dao.UserDao;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.MongoCollectionUtils;

import java.util.ArrayList;
import java.util.UUID;

public class User {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private UUID uuid;
    private String password;
    private boolean admin;
    private ArrayList<Integer> quota;
    private JSONObject metadata;

    public User() {
        id = 0;
    }
    public User(int id, String password) {
        UserDao userDao = new UserDao();
    }

    public String hashpass(String pw, UUID uuid) {
        return "";
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setQuota(ArrayList<Integer> quota) {
        this.quota = quota;
    }

    public ArrayList<Integer> getQuota() {
        return quota;
    }

    public void setMetadata(JSONObject metadata) {
        this.metadata = metadata;
    }

    public JSONObject getMetadata() {
        return metadata;
    }
}
