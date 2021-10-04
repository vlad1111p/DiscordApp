package com.commands.music;

import com.commands.CommandContext;
import com.commands.ICommand;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.managers.AudioManager;

@SuppressWarnings("ConstantConditions")
public class JoinCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        final TextChannel channel = ctx.getChannel();
        final Member selfMember = ctx.getSelfMember();
        final GuildVoiceState selfVoiceState = selfMember.getVoiceState();

        if(selfVoiceState.inVoiceChannel()){
            channel.sendMessage("Bot is already in a voice channel").queue();
            return;
        }

        final Member member = ctx.getMember();
        final GuildVoiceState memberVoiceState = member.getVoiceState();
        if(!memberVoiceState.inVoiceChannel()){
            channel.sendMessage("you need to be connected to a voice channel").queue();
            return;
        }
        if(selfMember.hasPermission(Permission.VOICE_CONNECT)) {
            AudioManager audioManager = ctx.getGuild().getAudioManager();
            VoiceChannel memberChannel = memberVoiceState.getChannel();
            audioManager.openAudioConnection(memberChannel);
            channel.sendMessageFormat("Connecting to `\uD83D\uDD0A %s`", memberChannel.getName()).queue();
        }
    }

    @Override
    public String getName() {
        return "join";
    }

    @Override
    public String getHelp() {
        return "Makes the bot join the voice channel";
    }
}
