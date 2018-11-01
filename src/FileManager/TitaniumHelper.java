package FileManager;

import java.io.File;
import java.io.IOException;

import static FileManager.Compressor.*;

public class TitaniumHelper {
    public static void main(String[] args) throws IOException, InterruptedException {
        File sourceFile = new File("F:\\BULAT\\Backup\\Saderty Phone Backup\\SD_Card\\TB3\\");
        File targetFile = new File("F:\\BULAT\\Backup\\Saderty Phone Backup\\SD_Card\\TB2\\");

        //ONLY AT ADD CALLBACK
    /*    for (int i = 0; i < sourceFile.list().length; i++) {
            File file = new File(sourceFile + "\\" + sourceFile.list()[i]);
            if (isArchive(file)) {
                deCompress(file, new File(targetFile + "\\" + sourceFile.list()[i]));
            }
        }
        */

       // System.out.println(compressFolder(sourceFile, targetFile, COMPRESSION_GZ));
        System.out.println(deCompressFolder(sourceFile, targetFile));
    }
}
