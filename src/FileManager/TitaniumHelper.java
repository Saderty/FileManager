package FileManager;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static FileManager.Compressor.*;

public class TitaniumHelper {
    public static void main(String[] args) throws IOException {
        String mainFile = "F:\\BULAT\\Backup\\Saderty Phone Backup\\SD_Card\\TB\\qq\\";

    /*    for (int i = 0; i < mainFile.list().length; i++) {
            File file = new File(mainFile + "\\" + mainFile.list()[i]);
            if (isArchive(file)) {
                deCompress(file);
                compress(file, COMPRESSION_GZ);
            }
        }*/
        mainFile += "aa.tar";
        //deCompress(new File(mainFile));
       deCompress(new File(mainFile));
    }
}
