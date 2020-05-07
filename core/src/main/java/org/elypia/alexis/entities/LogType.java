/*
 * Copyright 2019-2020 Elypia CIC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.elypia.alexis.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Allows guilds to choose what messages they are subscribed too.
 *
 * @author seth@elypia.org (Seth Falco)
 */
@Entity
@Table(name = "log_type")
public class LogType implements Serializable {

    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_type_id")
    private int logTypeId;

    @Column(name = "log_type_name", unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    public int getLogTypeId() {
        return logTypeId;
    }

    public void setLogTypeId(int logTypeId) {
        this.logTypeId = logTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
