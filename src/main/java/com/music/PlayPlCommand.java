package com.music;

import com.commands.CommandContext;
import com.commands.ICommand;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.managers.AudioManager;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;

@SuppressWarnings("ConstantConditions")
public class PlayPlCommand implements ICommand {
    @SuppressWarnings("ConstantConditions")
    @Override


    public void handle(CommandContext ctx) {
        final GuildMusicManager musicManager = PlayerManager.getInstance().getMusicManager(ctx.getGuild());
        final TextChannel channel = ctx.getChannel();
        final Member selfMember = ctx.getSelfMember();
        final Member member = ctx.getMember();
        final AudioPlayer player = musicManager.scheduler.getPlayer();
        final BlockingQueue<AudioTrack> queue = musicManager.scheduler.getQueue();

        final GuildVoiceState memberVoiceState = member.getVoiceState();
        if (ctx.getArgs().isEmpty()&&!player.isPaused()) {
            channel.sendMessage("Whops! Something went wrong\n" +
                    "Try putting all the arguments in the command").queue();
            return;
        }
        final Member self = ctx.getSelfMember();
        final GuildVoiceState selfVoiceState = self.getVoiceState();

        if (!selfVoiceState.inVoiceChannel()) {
            channel.sendMessage("I need to be in a voice channel for this to work").queue();
            if (selfMember.hasPermission(Permission.VOICE_CONNECT)) {
                AudioManager audioManager = ctx.getGuild().getAudioManager();
                VoiceChannel memberChannel = memberVoiceState.getChannel();
                audioManager.openAudioConnection(memberChannel);
                channel.sendMessageFormat("Connecting to `\uD83D\uDD0A %s`", memberChannel.getName()).queue();
                String link = String.join(" ", ctx.getArgs());
                if (!isUrl(link)) {
                    link = "ytsearch:" + link;
                }

                PlayerManager.getInstance().loadAndPlayPl(channel, link);
                return;
            }
        }


        if (!memberVoiceState.inVoiceChannel()) {
            channel.sendMessage("You need to be in a voice channel for this command to work").queue();
            return;
        }

        if (!memberVoiceState.getChannel().equals(selfVoiceState.getChannel())) {
            channel.sendMessage("You need to be in the same voice channel as me for this to work").queue();
            return;
        }

        String link = String.join(" ", ctx.getArgs());
        if (!isUrl(link)) {
            link = "ytsearch:" + link;
        }

        if(player.isPaused()){

            final AudioTrack playingTrack = player.getPlayingTrack();
            player.setPaused(false);
            return;
        }

        PlayerManager.getInstance().loadAndPlayPl(channel, link);
    }


    private boolean isUrl(String url) {
        try {
            new URI(url);
            return true;
        } catch (URISyntaxException e) {
            return false;
        }
    }

    @Override
    public String getName() {
        return "playpl";
    }

    @Override
    public String getHelp() {
        return "adds a playlist\n" +
                "can also resume\n"+
                "Usage: `/play <youtube playlist link>`";
    }
    @Override
    public List<String> getAliases() {
        return Collections.singletonList("ppl");
    }
}

