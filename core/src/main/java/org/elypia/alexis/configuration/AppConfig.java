/*
 * Copyright 2019-2020 Elypia CIC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.elypia.alexis.configuration;

import org.apache.deltaspike.core.api.config.*;

/**
 * @author seth@elypia.org (Seth Falco)
 */
@Configuration(prefix = "application.")
public interface AppConfig {

    /**
      * @return The applications name.
     */
    @ConfigProperty(name = "name")
    String getApplicationName();

    /**
     * @return Where the source-code for this project can be accessed.
     * Or null if the source-code is not publically accesible.
     */
    @ConfigProperty(name = "git")
    String getGitUrl();
}
