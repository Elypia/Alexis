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

package org.elypia.alexis.configuration;

import org.apache.deltaspike.core.api.config.*;

/**
 * @author seth@elypia.org (Seth Falco)
 */
@Configuration(prefix = "application.author.")
public interface AuthorConfig {

    /** The name of the author of the bot. */
    @ConfigProperty(name = "name")
    String getName();

    /** The url linking to a resource of the author. */
    @ConfigProperty(name = "url")
    String getUrl();

    /** The logo or icon that represents the author of the bot. */
    @ConfigProperty(name = "icon-url")
    String getIconUrl();

    /** The support guild to get help with the bot. */
    @ConfigProperty(name ="support-guild-id")
    Long getSupportGuildId();
}
