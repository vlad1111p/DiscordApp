package com.music;

import com.commands.CommandContext;
import com.commands.ICommand;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class ShuffleCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {

        final GuildMusicManager musicManager = PlayerManager.getInstance().getMusicManager(ctx.getGuild());
        final TextChannel channel = ctx.getChannel();
        final Member self = ctx.getSelfMember();
        final GuildVoiceState selfVoiceState = self.getVoiceState();

        final BlockingQueue<AudioTrack> queue = musicManager.scheduler.getQueue();

        final Member member = ctx.getMember();
        final GuildVoiceState memberVoiceState = member.getVoiceState();

        if (!memberVoiceState.inVoiceChannel()) {
            channel.sendMessage("You need to be in a voice channel ").queue();
            return;
        }


        ArrayList<AudioTrack> audioTracks = new ArrayList<AudioTrack>(queue.stream().toList());

        Collections.shuffle(audioTracks);
        queue.clear();
        queue.addAll(audioTracks);

        channel.sendMessage("The queue has been shuffle ").queue();
    }

    @Override
    public String getName() {
        return "shuffle";
    }

    @Override
    public List<String> getAliases() {
        return Collections.singletonList("cq");
    }

    @Override
    public String getHelp() {
        return "shuffles a queue";
    }
}
