package me.robert.Events;

import me.robert.Main;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class commandEvent extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if(event.getName().equalsIgnoreCase("addicted2") && event.getChannel().getId().equalsIgnoreCase("1161315426060476426")){

            OptionMapping option = event.getOption("option");


            if(Objects.requireNonNull(option).getAsString().equalsIgnoreCase("votereport")){
                String result="";
                for(Member m : Objects.requireNonNull(event.getGuild()).getMembers()){

                    if(!m.getUser().isBot()) result=result+m.getEffectiveName()+" ";
                }
                TextChannel textChannel = event.getGuild().getTextChannelById("1160201431081549884");
                textChannel.sendMessage("VoteReport").queue();
            }
            else if(option.getAsString().equalsIgnoreCase("logs")){
                OptionMapping sectiune = event.getOption("sectiune");
                assert sectiune != null;
                if(sectiune.getAsString().equalsIgnoreCase("survival")){
                    Main.logTask.getFilesFromServer("Survival120");
                }
                else if(sectiune.getAsString().equalsIgnoreCase("boxpvp")){
                    Main.logTask.getFilesFromServer("BoxPvp");
                }
                else event.getChannel().sendMessage("Aceasta sectiune nu este inregistrata").queue();
            }
            else event.getChannel().sendMessage("Nu exista comanda!").queue();
        }

    }

}
