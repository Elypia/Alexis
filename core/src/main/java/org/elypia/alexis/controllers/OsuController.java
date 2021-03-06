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

package org.elypia.alexis.controllers;

import org.elypia.alexis.configuration.ApiConfig;
import org.elypia.alexis.i18n.AlexisMessages;
import org.elypia.commandler.annotation.Param;
import org.elypia.commandler.dispatchers.standard.*;
import org.elypia.commandler.newb.AsyncUtils;
import org.elypia.commandler.producers.MessageSender;
import org.elypia.elypiai.osu.Osu;
import org.elypia.elypiai.osu.data.OsuMode;
import org.slf4j.*;

import javax.inject.Inject;
import javax.validation.constraints.Size;

/**
 * @author seth@elypia.org (Seth Falco)
 */
@StandardController
public class OsuController {

    private static final Logger logger = LoggerFactory.getLogger(OsuController.class);

    private final AlexisMessages messages;
    private final Osu osu;
    private final MessageSender sender;

    @Inject
    public OsuController(AlexisMessages messages, ApiConfig config, MessageSender sender) {
        this.messages = messages;
        this.osu = new Osu(config.getOsu());
        this.sender = sender;
    }

    // TODO: Make a generic callback exception error handler and dash that in there
    @StandardCommand
    public void get(@Param @Size(min = 3, max = 15) String username, @Param("osu") OsuMode mode) {
        var scopeToContextualInstances = AsyncUtils.copyContext();

        osu.getPlayer(username, mode).subscribe(
            (player) -> {
                var requestContext = AsyncUtils.applyContext(scopeToContextualInstances);
                sender.send(player);
                requestContext.deactivate();
            },
            (ex) -> {
                var requestContext = AsyncUtils.applyContext(scopeToContextualInstances);
                sender.send(messages.genericNetworkError());
                requestContext.deactivate();
            },
            () -> {
                var requestContext = AsyncUtils.applyContext(scopeToContextualInstances);
                sender.send(messages.playerNotFound(username));
                requestContext.deactivate();
            });
    }
}
