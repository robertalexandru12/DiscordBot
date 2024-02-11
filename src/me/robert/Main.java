package me.robert;

import me.robert.Events.chatEvent;
import me.robert.Events.commandEvent;
import me.robert.Events.guildReady;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static JDA jdaBot;
    public static LogTask logTask;
    public static void main(String[] args) throws LoginException {
        jdaBot = JDABuilder.createDefault("API_KEY_BOT")
                .addEventListeners(new guildReady())
                .setChunkingFilter(ChunkingFilter.ALL)
                .setMemberCachePolicy(MemberCachePolicy.ALL)
                .setActivity(Activity.playing("play.addicted2.ro")).enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .build();
        jdaBot.addEventListener(new chatEvent());
        jdaBot.addEventListener(new commandEvent());;
      /*  jdaBot.updateCommands().addCommands(Commands.slash("addicted2","Comanda principala a botului")
                .addOption()).queue();*/
        logTask = new LogTask();
        TimerTask timerTask = new reportVoteTask();
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 1000L);
    }


}
