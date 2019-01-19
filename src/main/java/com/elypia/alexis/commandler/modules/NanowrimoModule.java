package com.elypia.alexis.commandler.modules;

import com.elypia.commandler.Commandler;
import com.elypia.commandler.annotations.Module;
import com.elypia.commandler.annotations.*;
import com.elypia.commandler.metadata.ModuleData;
import com.elypia.elypiai.nanowrimo.Nanowrimo;
import com.elypia.jdac.alias.*;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.GenericMessageEvent;
import org.slf4j.*;

import javax.validation.constraints.Size;

@Module(id = "NaNoWriMo", aliases = {"nanowrimo", "nano", "nnwm"}, help = "nano.h")
public class NanowrimoModule extends JDACHandler {

    private static final Logger logger = LoggerFactory.getLogger(NanowrimoModule.class);

    private Nanowrimo nanowrimo;

    /**
     * Initialise the module, this will assign the values
     * in the module and create a {@link ModuleData} which is
     * what {@link Commandler} uses in runtime to identify modules,
     * commands or obtain any static data.
     *
     * @param commandler Our parent Commandler class.
     */
    public NanowrimoModule(Commandler<GenericMessageEvent, Message> commandler) {
        super(commandler);
        nanowrimo = new Nanowrimo();
    }

    @Command(id = "nano.info", aliases = {"get", "info"}, help = "nano.info.h")
    @Param(id = "common.username", help = "nano.info.p.name.h")
    public void getUser(JDACEvent event, @Size(min = 1, max = 60) String name) {
        nanowrimo.getUser(name, true).queue((user) -> {
            if (user.getError() == null) {
                event.send(user);
                return;
            }

            switch (user.getError()) {
                case USER_DOES_NOT_EXIST: {
                    event.send("nano.no_user");
                    return;
                }
                case USER_DOES_NOT_HAVE_A_CURRENT_NOVEL: {
                    event.send("nano.info.no_novel");
                }
            }
        }, (ex) -> logger.error("Failed to perform HTTP request!", ex));
    }
}
