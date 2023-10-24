package me.robert.Events;

import me.robert.Main;
import me.robert.WebSite;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class chatEvent extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if(event.getChannel().getId().equalsIgnoreCase("1161315426060476426")){
            String[] mesaj = event.getMessage().getContentRaw().split(" ");
            if(mesaj[0].equalsIgnoreCase("log")){
                Main.logTask.download(mesaj[1],mesaj[2]);
                event.getChannel().sendMessage("http://188.212.101.110/download/"+mesaj[2]).queue();
                event.getMessage().delete().queue();
            }
        }
        if(event.getAuthor().isBot()){
            if(event.getMessage().getContentRaw().equalsIgnoreCase("VoteReport")){
                String haveVoted= "";
                String didntVoted="";
                String q="";

                WebSite a = new WebSite();
                for(Member m : event.getGuild().getMembers()){
                    if(!m.getUser().isBot()){
                        try {
                            if(a.getContent(m.getNickname()).equalsIgnoreCase("1")){
                                haveVoted=haveVoted+m.getNickname()+", ";
                            }
                            else {
                                didntVoted=didntVoted+m.getNickname()+", ";
                                q=q+"@"+m.getUser().getId()+" ";
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                event.getMessage().delete().queue();
                EmbedBuilder builder = new EmbedBuilder();
                builder.setColor(Color.RED);
                builder.setFooter("play.addicted2.ro // Robi");
                builder.addField("Cine a votat?","\n"+haveVoted,false);
                builder.addField("Cine n-a votat?","\n"+didntVoted,false);
                builder.setTitle("StaffVote Report");
                TextChannel textChannel = event.getGuild().getTextChannelById("1160201431081549884");
                textChannel.sendMessageEmbeds(builder.build()).queue();
                textChannel.sendMessage(q).queue();
            }
        }
    }
}
