package com.command;

public class PasteCommand implements ICommand{

    @Override
    public void handle(CommandContext ctx) {

    }

    @Override
    public String getName() {
        return "paste";
    }

    @Override
    public String getHelp() {
        return "Creates a txt in a doc" +
                "\n Usage : /paste [language] [text]";
    }
}
