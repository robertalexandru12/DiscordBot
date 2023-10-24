package me.robert;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

import java.io.File;
import java.io.IOException;

public class LogTask {
    public void getFilesFromServer(String server){
        File folder  = new File("/home/mc/" + server + "/logs/");
        File[] fisiere = folder.listFiles();
        String result = "Loguri " + server + "\n";
        TextChannel textChannel = Main.jdaBot.getTextChannelById("1161315426060476426");
        long time = 464000000;
        for(File i : fisiere){
          //  textChannel.sendMessage(i.getName()).queue();
            if(System.currentTimeMillis()-i.lastModified()<time)
                result=result+i.getName()+"\n";
        }
       textChannel.sendMessage("```" +result+"```").queue();
       // System.out.println(result);
    }
    public void download(String server, String file) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                String command = "cp -r /home/mc/" + server + "/logs/"+file + " /var/www/html/download";
                Runtime run = Runtime.getRuntime();
                Process pr = null;
                try {
                    pr = run.exec(command);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    pr.waitFor() ;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                        Thread.sleep(300000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                command = "rm -rf /var/www/html/download/"+file;
                run = Runtime.getRuntime();
                try {
                    pr = run.exec(command);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    pr.waitFor() ;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();
    }
}
