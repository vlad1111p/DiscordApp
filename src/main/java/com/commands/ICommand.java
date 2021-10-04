package com.commands;

import java.io.IOException;
import java.util.List;

public interface ICommand {
    public void handle(CommandContext ctx) ;
    String getName();
    default List<String> getAliases(){

        return List.of();
    }
    String getHelp();

}
