package com.elypia.alexis.discord.handlers.modules;

import com.elypia.alexis.discord.events.MessageEvent;
import com.elypia.alexis.discord.handlers.impl.CommandHandler;
import com.elypia.elypiai.Brainfuck;
import com.elypia.jdautils.annotations.command.Command;
import com.elypia.jdautils.annotations.command.CommandGroup;
import com.elypia.jdautils.annotations.command.Module;
import com.elypia.jdautils.annotations.command.Param;

@Module(
    aliases = {"Brainfuck", "bf"},
    help = "Compile Brainfuck code into Strings.",
    defaultCommand = "compile"
)
public class BrainfuckHandler extends CommandHandler {

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
