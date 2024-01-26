package bot.download;


import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyTelegramBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            try{
                Location location = update.getMessage().getLocation();
                String authorSignature = update.getMessage().getAuthorSignature();
                System.out.println(location);
                System.out.println(authorSignature);
                String s=update.getMessage().getText();
                System.out.println("s"+s);
                URL url=new URL(update.getMessage().getText());
                System.out.println("url"+url);
                HttpURLConnection huc=(HttpURLConnection)url.openConnection();
                int i=0;
                InputStream inputStream = huc.getInputStream();
                byte[] a=new byte[inputStream.available()];
                java.io.File file=new java.io.File("file/music.mp3");
                file.getParentFile().mkdir();
                OutputStream outputStream=new FileOutputStream(file);
                while ((i= inputStream.read(a))!=-1){
                    outputStream.write(a,0,i);
                }
                inputStream.close();
                outputStream.close();
                huc.disconnect();
            }catch(Exception e){System.out.println(e);}
            // Set variables
//            String message_text = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            String audioFilePath="file/music.mp3";


            SendDocument audioMessage = new SendDocument();
                    audioMessage.setChatId(String.valueOf(chatId));
                    audioMessage.setDocument(new InputFile(new File(audioFilePath)));

            try {
                execute(audioMessage); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        // Return bot username
        // If bot username is @MyAmazingBot, it must return 'MyAmazingBot'
        return "*********";
    }

    @Override
    public String getBotToken() {
        // Return bot token from BotFather
        return "******************";
    }
}
