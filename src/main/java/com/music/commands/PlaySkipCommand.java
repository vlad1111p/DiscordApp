package com.music.commands;

import com.commands.CommandContext;
import com.commands.ICommand;

import java.util.Collections;
import java.util.List;

public class PlaySkipCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {

//TODO
//
//
        new PlayCommand().handle(ctx);
        new SkipCommand().handle(ctx);

    }

    @Override
    public String getName() {
        return "playskip";
    }

    @Override
    public String getHelp() {
        return "null";
    }
    @Override
    public List<String> getAliases() {
        return Collections.singletonList("ps");
    }
}
