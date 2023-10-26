package bot.download;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Main3 {
    public static void main(String[] args) {
        int[] ratings={1,2,2};

            int sum=0;
            for(int i=0;i<ratings.length;i++){
                int j=i;
                if((j+1)!= ratings.length && ratings[j]>ratings[j+1]){
                    sum+=2;
                }else if((j-1)>=0 && ratings[i-1]<ratings[i]){
                    sum+=2;
                }else sum++;
            }
        System.out.println(sum);
        System.out.println("commite name saved");
        System.out.println("conflickt");
        System.out.println(100000);
        System.out.println(66667);
        System.out.println("gggggggg");
        System.out.println("sadfsdf");
    }
}

