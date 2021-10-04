package com.commands;

import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;

public class HelpCommands implements ICommand {

    private final CommandManager manager;

    public HelpCommands(CommandManager manager) {

        this.manager = manager;

    }

    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();
        if (args.isEmpty()) {

            StringBuilder builder = new StringBuilder();

            builder.append("List of commands\n");

            manager.getCommands().stream().map(ICommand::getName).forEach(
                    (it) -> builder.append('`').append("/").append(it).append("`\n"));

            channel.sendMessage(builder.toString() + "/joke\n/info" + "\n❤" + "\n /clear [how many to clear]").queue();

            return;
        }
        String search = args.get(0);
        ICommand command = manager.getCommand(search);
        if (command == null) {
            channel.sendMessage("Nothing found for " + search).queue();
            return;
        }
        channel.sendMessage(command.getHelp()).queue();
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getHelp() {
        return "Show the list with commands in the bot\n Usage: /help [command] ";
    }
    @Override
    public List<String> getAliases() {

        return List.of("commands", "cmds", "commandlist");
    }
}
