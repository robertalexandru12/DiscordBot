package me.robert;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

import java.util.Calendar;
import java.util.TimerTask;

public class reportVoteTask extends TimerTask {

    @Override
    public void run() {
        Calendar cal = Calendar.getInstance();
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int second = cal.get(Calendar.SECOND);
        if ((((hour == 3) ? 1 : 0) & ((minute == 55) ? 1 : 0) & ((second == 30) ? 1 : 0))  != 0) {
            TextChannel textChannel = Main.jdaBot.getTextChannelById("1160201431081549884");
            textChannel.sendMessage("VoteReport").queue();
        }
    }

}
