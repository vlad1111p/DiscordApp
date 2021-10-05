package com.music;

import com.commands.CommandContext;
import com.commands.ICommand;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class ShowQueueCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        final TextChannel channel = ctx.getChannel();
        final Member self = ctx.getSelfMember();
        final GuildVoiceState selfVoiceState = self.getVoiceState();

        if (!selfVoiceState.inVoiceChannel()) {
            channel.sendMessage("I need to be in a voice channel").queue();
            return;
        }

        final Member member = ctx.getMember();
        final GuildVoiceState memberVoiceState = member.getVoiceState();
        final GuildMusicManager musicManager = PlayerManager.getInstance().getMusicManager(ctx.getGuild());
        final AudioPlayer player = musicManager.scheduler.getPlayer();
        final BlockingQueue<AudioTrack> queue = musicManager.scheduler.getQueue();

            queue.stream().toList()
                    .forEach(audioTrack -> channel.sendMessage(audioTrack.getInfo().title +" by "+
                            audioTrack.getInfo().author).queue());


    }

//     .append(track.getInfo().title)
//            .append("` by `")
//                        .append(track.getInfo().author)
//            .append('`')
//                        .queue();

    @Override
    public String getName() {
        return "showqueue";
    }

    @Override
    public List<String> getAliases() {

        return Collections.singletonList("sq");
    }

    @Override
    public String getHelp() {
        return "shows the queued songs";
    }
}
