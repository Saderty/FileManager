package FileManager;

import java.io.File;
import java.io.IOException;

public class Compressor {
    static File archive7z = new File("F:\\Program Files\\7-Zip\\7z.exe");
    static File archiveLzop = new File("F:\\BULAT\\lzop.exe");

    final static String COMPRESSION_7Z = "7z";
    final static String COMPRESSION_BZ2 = "bz2";
    final static String COMPRESSION_GZ = "gz";
    final static String COMPRESSION_ZIP = "zip";
    final static String COMPRESSION_TAR = "tar";
    final static String COMPRESSION_LZOP = "lzop";

    static void compress(File sourcePath, File targetPath, String compression) throws IOException {
        if (!compression.equals(COMPRESSION_LZOP)) {
            targetPath = new File(targetPath.toString().substring(0, sourcePath.toString().lastIndexOf("\\")));
            if (compression.equals(COMPRESSION_7Z)) {
                Runtime.getRuntime().exec(archive7z + " a -t7z -ssw -mx9 -r0 " + targetPath + ".7z " + sourcePath);
            }
            if (compression.equals(COMPRESSION_BZ2)) {
                Runtime.getRuntime().exec(archive7z + " a -tbzip2 -ssw -mx9 -r0 " + targetPath + ".bz2 " + sourcePath);
            }
            if (compression.equals(COMPRESSION_GZ)) {
                Runtime.getRuntime().exec(archive7z + " a -tgzip -ssw -mx9 -r0 " + targetPath + ".gz " + sourcePath);
            }
            if (compression.equals(COMPRESSION_ZIP)) {
                Runtime.getRuntime().exec(archive7z + " a -tzip -ssw -mx9 -r0 " + targetPath + ".zip " + sourcePath);
            }
            if (compression.equals(COMPRESSION_TAR)) {
                Runtime.getRuntime().exec(archive7z + " a -ttar -ssw -mx9 -r0 " + targetPath + ".tar " + sourcePath);
            }
        }
        if (compression.equals(COMPRESSION_LZOP)) {
            Runtime.getRuntime().exec(archiveLzop + " -9 " + targetPath + " -o " + sourcePath + ".lzop");
        }
    }

    static void compress(File sourceFile, String compression) throws IOException {
        compress(sourceFile, sourceFile, compression);
    }

    static void deCompress(File sourcePath, File targetPath, String compression) throws IOException {
        if (!compression.equals(COMPRESSION_LZOP)) {
            targetPath = new File(targetPath.toString().substring(0, sourcePath.toString().lastIndexOf("\\")));
            if (compression.equals(COMPRESSION_7Z)) {
                Runtime.getRuntime().exec(archive7z + " x -t7z -ssw " + sourcePath + ".7z -o" + targetPath);
            }
            if (compression.equals(COMPRESSION_BZ2)) {
                Runtime.getRuntime().exec(archive7z + " x -tbzip2 -ssw " + sourcePath + ".bz2 -o" + targetPath);
            }
            if (compression.equals(COMPRESSION_GZ)) {
                Runtime.getRuntime().exec(archive7z + " x -tgzip -ssw " + sourcePath + ".gz -o" + targetPath);
            }
            if (compression.equals(COMPRESSION_ZIP)) {
                Runtime.getRuntime().exec(archive7z + " x -tzip -ssw " + sourcePath + ".zip -o" + targetPath);
            }
            if (compression.equals(COMPRESSION_TAR)) {
                Runtime.getRuntime().exec(archive7z + " x -ttar -ssw " + sourcePath + ".tar -o" + targetPath);
            }
        }
        if (compression.equals(COMPRESSION_LZOP)) {
            Runtime.getRuntime().exec(archiveLzop + " -d " + targetPath + ".lzop -o " + sourcePath);
        }
    }

    static void deCompress(File sourcePath, String compression) throws IOException {
        deCompress(sourcePath, sourcePath, compression);
    }

    static void deCompress(File sourcePath) throws IOException {
        String s = sourcePath.toString().substring(sourcePath.toString().lastIndexOf(".\\"), sourcePath.toString().length());
        switch (s) {
            case COMPRESSION_7Z:
                deCompress(sourcePath, sourcePath, COMPRESSION_7Z);
                break;
            case COMPRESSION_BZ2:
                deCompress(sourcePath, sourcePath, COMPRESSION_BZ2);
                break;
            case COMPRESSION_GZ:
                deCompress(sourcePath, sourcePath, COMPRESSION_GZ);
                break;
            case COMPRESSION_ZIP:
                deCompress(sourcePath, sourcePath, COMPRESSION_ZIP);
                break;
            case COMPRESSION_TAR:
                deCompress(sourcePath, sourcePath, COMPRESSION_TAR);
                break;
            case COMPRESSION_LZOP:
                deCompress(sourcePath, sourcePath, COMPRESSION_LZOP);
                break;
        }
    }

    public static void main(String[] args) {
        File file = new File("F:\\BULAT\\_TEST\\install.exe");

        /**
         IF NOT LZOP
         int a = file.toString().lastIndexOf("\\");
         deCompress(file, new File(file.toString().substring(0, a)), COMPRESSION_ZIP);

         IF LZOP
         deCompress(file, file, COMPRESSION_LZOP);
         */
    }
}
