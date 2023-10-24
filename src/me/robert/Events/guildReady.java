package me.robert.Events;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class guildReady extends ListenerAdapter {

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event){
        List<CommandData> commandData = new ArrayList<>();
        OptionData option1 = new OptionData(OptionType.STRING,"option","alege optiunea dorita",true)
                .addChoice("VoteReport","votereport")
                .addChoice("Logs", "logs");
        OptionData option2 = new OptionData(OptionType.STRING,"sectiune","alege sectiunea dorita",false)
                .addChoice("Survival","survival")
                .addChoice("BoxPvP","boxpvp");
        commandData.add(Commands.slash("addicted2","comanda principala a botului").addOptions(option1,option2));
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }
}
