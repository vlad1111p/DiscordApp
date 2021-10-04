package com;

import com.banvayne.Clear;
import com.banvayne.Commands;
import com.banvayne.Jokes;

import com.banvayne.Listener;
import com.database.SQLiteDataSource;
import com.memberfunc.GuildMemberJoin;
import com.memberfunc.GuildMemberLeave;
import com.reactions.GuildMessageReceived;

import me.duncte123.botcommons.messaging.EmbedUtils;
import me.duncte123.botcommons.web.WebUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.interactions.commands.Command;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;


public class DMusician {

    private DMusician() throws LoginException, SQLException {

        SQLiteDataSource.getConnection();
        WebUtils.setUserAgent("Mozilla/5.0 ban Vayne#0348 / vlad1111p#8432");
        EmbedUtils.setEmbedBuilder(()->
                new EmbedBuilder()
                        .setColor(Color.BLUE)
                        .setFooter("Example"));
    }

    public static JDA jda;
    public static String prefix = "/";
    public static Jokes joke = new Jokes();

    public static void main(String[] args) throws LoginException, SQLException {
        jda = JDABuilder.createDefault(Config.get("TOKEN")).build();
        jda.getPresence().setStatus(OnlineStatus.IDLE);
        jda.getPresence().setActivity(Activity.watching("professional league players"));
        initializeListeners();
        createSaveDirectory();
        new DMusician();


//"ODkzNTE1MzEwMTM5ODUwODE0.YVck-g.cnyz-wwdVxQ4gCslTupTyrD0rbA"
    }





    private static void createSaveDirectory() {
        File savePath = new File("C:/Users/vlad1/IdeaProjects/DiscordAPP/src/main/java/com/playlists");
        if (!savePath.exists() || !savePath.isDirectory()) {
            System.out.println(
                    savePath.mkdir() ? "[INFO] Path \"saves_playlists\" successfully created!" : "[ERROR] Failed to create path \"saves_playlists\"!"
            );
        }
    }


    private static void initializeListeners() {

        jda.addEventListener(new Commands());
        jda.addEventListener(new Clear());
        jda.addEventListener(new GuildMemberJoin());
        jda.addEventListener(new GuildMemberLeave());
        jda.addEventListener(new GuildMessageReceived());
        jda.addEventListener(new Listener());


    }


}
