package com.elypia.alexis.discord.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Command groups are used when overloading commands, ie there is
 * the same command multiple times; just with different parameters.
 * Rather than create metadata for these commands multiple times, we
 * can associate it with a CommandGroup, and it will copy the data from
 * the main Command.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandGroup {

    /**
     * During a default command, it will default to the primary
     * command of the CommandGroup. (The one that specifies the @Command
     * META-DATA in the first place.)
     *
     * @return The identifier for the CommandGroup.
     */

    String value();
}