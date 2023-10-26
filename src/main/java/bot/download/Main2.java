package bot.download;

import org.telegram.telegrambots.meta.api.objects.Location;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main2 {
    public static void main(String[] args) {
        try{

            URL url=new URL("https://www.youtube.com/watch?v=6Rg-FZ9I5i8");
            System.out.println("url"+url);
            HttpURLConnection huc=(HttpURLConnection)url.openConnection();
            int i=0;
            InputStream inputStream = huc.getInputStream();
            byte[] a=new byte[10];
//            java.io.File file=new java.io.File("file/music.mp3");
//            file.getParentFile().mkdir();
//            OutputStream outputStream=new FileOutputStream(file);
            while ((i= inputStream.read(a))!=-1){
//                outputStream.write(a,0,i);
                System.out.println(new String(a));
            }
            inputStream.close();
//            outputStream.close();
            huc.disconnect();
        }catch(Exception e){System.out.println(e);}
    }
}
