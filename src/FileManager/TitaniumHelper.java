package FileManager;

import java.io.File;
import java.io.IOException;

import static FileManager.Compressor.*;

public class TitaniumHelper {
    static String[] compressions = {COMPRESSION_7Z, COMPRESSION_BZ2, COMPRESSION_GZ, COMPRESSION_ZIP, COMPRESSION_TAR, COMPRESSION_LZOP};

    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("F:\\SYMLINK\\Users\\Downloads\\1\\SFW_MASTER.7z");

        System.out.println(rePack(file));
    }
}