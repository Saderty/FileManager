package FileManager;

import java.io.File;
import java.io.IOException;

import static FileManager.Compressor.*;

public class TitaniumHelper {
    static String[] compressions = {COMPRESSION_7Z, COMPRESSION_BZ2, COMPRESSION_GZ, COMPRESSION_ZIP, COMPRESSION_TAR, COMPRESSION_LZOP};

    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("F:\\SYMLINK\\Users\\Downloads\\1\\Vanessa MainBeta-56270-1-7beta.7z");

        //for (int i = 0; i < compressions.length; i++) {
        //    System.out.println(Compress(file, compressions[i],1));
        //}

        //System.out.println(DeCompress(new File(file + "." + COMPRESSION_7Z)));

        //compressFolder(file,file,COMPRESSION_7Z);
        //System.out.println(rePack(file));
        System.out.println(Compress(new File("F:\\SYMLINK\\Users\\Downloads\\1\\Vanessa MainBeta-56270-1-7beta\\*"),
                new File("F:\\SYMLINK\\Users\\Downloads\\1\\Vanessa MainBeta-56270-1-7beta"),
                COMPRESSION_7Z));
    }
}