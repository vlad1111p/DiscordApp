package com.commands;

import com.fasterxml.jackson.databind.JsonNode;

import net.dv8tion.jda.api.entities.TextChannel;
import okhttp3.OkHttpClient;


import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class InstagramCommand implements ICommand {


    @Override
    public void handle(CommandContext ctx) {
//        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
////
////
//        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
//        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        OkHttpClient httpClient = new OkHttpClient.Builder()
//                .addNetworkInterceptor(loggingInterceptor)
//                .addInterceptor(new ErrorInterceptor())
//                .cookieJar(new DefaultCookieJar(new CookieHashSet()))
//                .build();
//        final List<String> args = ctx.getArgs();
//        final TextChannel channel = ctx.getChannel();
//        if (args.isEmpty()) {
//            channel.sendMessage("you must provide a username to look up").queue();
//            return;
//        }
//        final String usn = args.get(0);
//        Instagram instagram = new Instagram(httpClient);
//
//        Account account = getAccount(Instagram instagram,String usn);
//        System.out.println(account.getMedia().getCount());
//
//
//////        WebUtils.ins.getJSONObject("https://apis.duncte123.me/insta/" + usn).async((json) -> {
//////            if (!json.get("success").asBoolean()) {
//////                channel.sendMessage(json.get("error").get("message").asText()).queue();
//////                return;
//////            }
//
//
////    }
////
//////            final JsonNode user = json.get("user");
//////            final String username = user.get("username").asText();
//////            final String pfp = user.get("profile_pic_url").asText();
//////            final String biography = user.get("biography").asText();
//////            final boolean isPrivate = user.get("is_private").asBoolean();
//////            final int following = user.get("following").get("count").asInt();
//////            final int followers = user.get("followers").get("count").asInt();
//////            final int uploads = user.get("uploads").get("count").asInt();
//////
//////            final EmbedBuilder embed = EmbedUtils.getDefaultEmbed()
//////                    .setTitle("Instagram info of " + username, "https://www.instagram.com/" + username)
//////                    .setThumbnail(pfp)
//////                    .setDescription(String.format(
//////                            "**Private account:** %s\n**Bio:** %s\n**Following:** %s\n**Followers:** %s\n**Uploads:** %s",
//////                            toEmote(isPrivate),
//////                            biography,
//////                            following,
//////                            followers,
//////                            uploads
//////                    ))
//////                    .setImage(getLatestImage(json.get("images")));
//////
//////            channel.sendMessage(embed.build()).queue();
////        });
//
//    }
//
//    @Override
//    public String getName() {
//        return "instagram";
//    }
//
//    @Override
//    public List<String> getAliases() {
//        return Collections.singletonList("insta");
//    }
//
//    @Override
//    public String getHelp() {
//        return "shows the instagram statistics of a user with the latest image\nUsage : /instagram <username>";
//    }
//
//    private String getLatestImage(JsonNode json) {
//        if (!json.isArray()) {
//            return null;
//        }
//
//        if (json.size() == 0) {
//            return null;
//        }
//
//        return json.get(0).get("url").asText();
//    }
//
//    private String toEmote(boolean bool) {
//        return bool ? "<:sliderRight:582718257598038017>" : "<:sliderLeft:582718257866473472>";
//    }
//
//    private Account getAccount(Instagram instagram,String usn) throws IOException {
//
//        return instagram.getAccountByUsername(usn);
//    }
//}
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getHelp() {
        return null;
    }
}