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
@Configuration(prefix = "application.api.twitch.")
public interface TwitchConfig {

    /** Twitch Client ID, this is the public identifier for the application. */
    @ConfigProperty(name = "client-id")
    String getClientId();

    /** Twitch API Secret, this is a private password-like field which can only be read once. */
    @ConfigProperty(name = "client-secret")
    String getClientSecret();

    /** Where to redirect after successful authentication. */
    @ConfigProperty(name = "redirect-uri")
    String getRedirectUri();
}
