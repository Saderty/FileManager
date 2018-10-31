package FileManager;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static FileManager.Compressor.*;

public class TitaniumHelper {
    public static void main(String[] args) throws IOException, InterruptedException {
        File sourceFile = new File("F:\\BULAT\\Backup\\Saderty Phone Backup\\SD_Card\\TB\\");
        File targetFile = new File("F:\\BULAT\\Backup\\Saderty Phone Backup\\SD_Card\\TBGZ\\");

        //ONLY AT ADD CALLBACK
        for (int i = 0; i < sourceFile.list().length; i++) {
            File file = new File(sourceFile + "\\" + sourceFile.list()[i]);
            String s = file.toString().substring(file.toString().lastIndexOf('.') + 1, file.toString().length());
            if (s.equals(COMPRESSION_GZ)) {
                deCompress(file, new File(targetFile + "\\" + sourceFile.list()[i]));
            }
        }
    }
}
