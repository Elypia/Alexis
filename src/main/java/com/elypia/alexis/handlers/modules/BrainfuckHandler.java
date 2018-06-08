package com.elypia.alexis.handlers.modules;

import com.elypia.commandler.CommandHandler;
import com.elypia.commandler.annotations.*;
import com.elypia.commandler.events.MessageEvent;
import com.elypia.elypiai.Brainfuck;

@Module(
    name = "Module",
    aliases = {"brainfuck", "bf"},
    description = "Compile Brainfuck code into Strings."
)
public class BrainfuckHandler extends CommandHandler {

    @Default
    @CommandGroup("interpret")
    @Command(aliases = {"compile", "interpret"}, help = "Compile Brainfuck code into something non-nerds understand.")
    @Param(name = "code", help = "The code to compile.")
    public void interpretBrainfuck(MessageEvent event, String code) {
        interpretBrainfuck(event, code, new byte[0]);
    }

    @CommandGroup("interpret")
    @Param(name = "code", help = "The code to compile.")
    @Param(name = "args", help = "The arguments for input, represented by a , in brainfuck.")
    public void interpretBrainfuck(MessageEvent event, String code, byte[] args) {
        try {
            Brainfuck brainfuck = Brainfuck.compile(code, args);
            String result = brainfuck.interpret();
            event.reply(result);
        } catch (IllegalArgumentException ex) {
            event.reply(ex.getMessage());
        }
    }
}