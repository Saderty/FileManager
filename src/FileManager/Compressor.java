package FileManager;

import java.io.File;
import java.io.IOException;

import static FileManager.FileManager.deleteFileOrFolder;

class Compressor {
    private static File archive7z = new File("F:\\Program Files\\7-Zip\\7z.exe");
    private static File archiveLzop = new File("F:\\BULAT\\lzop.exe");

    final static String COMPRESSION_7Z = "7z";
    final static String COMPRESSION_BZ2 = "bz2";
    final static String COMPRESSION_GZ = "gz";
    final static String COMPRESSION_ZIP = "zip";
    final static String COMPRESSION_TAR = "tar";
    final static String COMPRESSION_LZOP = "lzop";

    static boolean Compress(File sourcePath, String compression) throws IOException, InterruptedException {
        return Compress(sourcePath, sourcePath, compression);
    }

    static boolean Compress(File sourcePath, String compression, int delay) throws IOException, InterruptedException {
        return Compress(sourcePath, sourcePath, compression, delay);
    }

    static boolean Compress(File sourcePath, File targetPath, String compression) throws IOException, InterruptedException {
        return Compress(sourcePath, targetPath, compression, 0);
    }

    static boolean Compress(File sourcePath, File targetPath, String compression, int delay) throws IOException, InterruptedException {
        if (!isArchive(sourcePath)) {
            if (compression.equals(COMPRESSION_7Z)) {
                Runtime.getRuntime().exec(archive7z + " a -t7z -ssw -mx9 -mmt1 -r0 \"" + targetPath +
                        "\" \"" + sourcePath + "\"");
                System.out.println(archive7z + " a -t7z -ssw -mx9 -r0 \"" + targetPath +
                        "\" \"" + sourcePath + "\"");
            }
            if (compression.equals(COMPRESSION_ZIP)) {
                Runtime.getRuntime().exec(archive7z + " a -tzip -ssw -mx9 -r0 \"" + targetPath +
                        "\" \"" + sourcePath + "\"");
            }
            if (compression.equals(COMPRESSION_TAR)) {
                Runtime.getRuntime().exec(archive7z + " a -ttar -ssw -mx9 -r0 \"" + targetPath +
                        "\" \"" + sourcePath + "\"");
            }
            if (compression.equals(COMPRESSION_BZ2)) {
                if (sourcePath.isDirectory()) {
                    return false;
                }
                Runtime.getRuntime().exec(archive7z + " a -tbzip2 -ssw -mx9 -r0 \"" + targetPath +
                        "\" \"" + sourcePath + "\"");
            }
            if (compression.equals(COMPRESSION_GZ)) {
                if (sourcePath.isDirectory()) {
                    return false;
                }
                Runtime.getRuntime().exec(archive7z + " a -tgzip -ssw -mx9 -r0 \"" + targetPath +
                        "\" \"" + sourcePath + "\"");
            }
            if (compression.equals(COMPRESSION_LZOP)) {
                if (sourcePath.isDirectory()) {
                    return false;
                }
                Runtime.getRuntime().exec(archiveLzop + " -9 \"" + targetPath +
                        "\" -o \"" + sourcePath + "\"");
            }
        } else {
            return false;
        }

        //TODO : Change compression result
        if (delay != 0) {
            boolean complete = false;
            Thread.sleep(delay);
            long length;

            if (sourcePath.length() < 1024 * 1024) {
                Thread.sleep(500);
                return true;
            }

            long timeDelaySec = sourcePath.length() * 1000 / (1024 * 1024 * 10);

            while (!complete) {
                length = new File(targetPath + "." + compression).length();
                Thread.sleep(timeDelaySec);
                if (new File(targetPath + "." + compression).length() == length) {
                    complete = true;
                }
            }
            Thread.sleep(500);
        }
        return true;
    }

    static boolean DeCompress(File sourcePath) throws IOException, InterruptedException {
        return DeCompress(sourcePath, 0);
    }

    static boolean DeCompress(File sourcePath, int delay) throws IOException, InterruptedException {
        return DeCompress(sourcePath, sourcePath, delay);
    }

    static boolean DeCompress(File sourcePath, File targetPath) throws IOException, InterruptedException {
        return DeCompress(sourcePath, targetPath, 0);
    }

    static boolean DeCompress(File sourcePath, File targetPath, int delay) throws IOException, InterruptedException {
        String q = sourcePath.toString();
        String s = q.substring(q.lastIndexOf('.') + 1, q.length());
        switch (s) {
            case COMPRESSION_7Z:
                return DeCompress(sourcePath, targetPath, COMPRESSION_7Z, delay);
            case COMPRESSION_BZ2:
                return DeCompress(sourcePath, targetPath, COMPRESSION_BZ2, delay);
            case COMPRESSION_GZ:
                return DeCompress(sourcePath, targetPath, COMPRESSION_GZ, delay);
            case COMPRESSION_ZIP:
                return DeCompress(sourcePath, targetPath, COMPRESSION_ZIP, delay);
            case COMPRESSION_TAR:
                return DeCompress(sourcePath, targetPath, COMPRESSION_TAR, delay);
            case COMPRESSION_LZOP:
                return DeCompress(sourcePath, targetPath, COMPRESSION_LZOP, delay);
        }
        return false;
    }

    static boolean DeCompress(File sourcePath, File targetPath, String compression) throws IOException, InterruptedException {
        return DeCompress(sourcePath, targetPath, compression, 0);
    }

    static boolean DeCompress(File sourcePath, File targetPath, String compression, int delay) throws IOException, InterruptedException {
        if (isArchive(sourcePath)) {
            if (!compression.equals(COMPRESSION_LZOP)) {
                targetPath = new File(targetPath.toString().substring(0, sourcePath.toString().lastIndexOf("\\")));
                if (compression.equals(COMPRESSION_7Z)) {
                    Runtime.getRuntime().exec(archive7z + " x -t7z -ssw \"" + sourcePath + "\" -o\"" + targetPath + "\"");
                }
                if (compression.equals(COMPRESSION_BZ2)) {
                    Runtime.getRuntime().exec(archive7z + " x -tbzip2 -ssw \"" + sourcePath + "\" -o\"" + targetPath + "\"");
                }
                if (compression.equals(COMPRESSION_GZ)) {
                    Runtime.getRuntime().exec(archive7z + " x -tgzip -ssw \"" + sourcePath + "\" -o\"" + targetPath + "\"");
                }
                if (compression.equals(COMPRESSION_ZIP)) {
                    Runtime.getRuntime().exec(archive7z + " x -tzip -ssw \"" + sourcePath + "\" -o\"" + targetPath + "\"");
                }
                if (compression.equals(COMPRESSION_TAR)) {
                    Runtime.getRuntime().exec(archive7z + " x -ttar -ssw \"" + sourcePath + "\" -o\"" + targetPath + "\"");
                }
            }
            if (compression.equals(COMPRESSION_LZOP)) {
                targetPath = new File(targetPath.toString().substring(0, sourcePath.toString().lastIndexOf('.')));
                Runtime.getRuntime().exec(archiveLzop + " -d \"" + sourcePath + "\" -o \"" + targetPath + "\"");
            }

            if (delay != 0) {
                boolean complete = false;
                Thread.sleep(delay);
                long length;

                while (!complete) {
                    length = targetPath.length();

                    if (sourcePath.length() < 1024 * 1024) {
                        Thread.sleep(500);
                    } else {
                        Thread.sleep(sourcePath.length() * 1000 / (1024 * 1024 * 10));
                    }

                    if (targetPath.length() == length) {
                        complete = true;
                    }
                }
                Thread.sleep(500);
            }
        }
        return true;
    }

    static boolean isArchive(File file) {
        String s = file.toString().substring(file.toString().lastIndexOf('.') + 1, file.toString().length());
        return s.equals(COMPRESSION_7Z) || s.equals(COMPRESSION_BZ2) || s.equals(COMPRESSION_GZ)
                || s.equals(COMPRESSION_ZIP) || s.equals(COMPRESSION_TAR) || s.equals(COMPRESSION_LZOP);
    }

    static boolean isArchive(File file, String compression) {
        String s = file.toString().substring(file.toString().lastIndexOf('.') + 1, file.toString().length());

        return s.equals(compression);
    }

    static boolean compressFolder(File sourceFolder, File targetFolder, String compression) throws IOException, InterruptedException {
        if (sourceFolder.isDirectory()) {
            String[] directories = sourceFolder.list();
            for (String directory : directories) {
                Compress(new File(sourceFolder + "\\" + directory),
                        new File(targetFolder + "\\" + directory),
                        compression, 1);
            }
            return true;
        }
        return false;
    }

    static boolean deCompressFolder(File sourceFolder, File targetFolder) throws IOException, InterruptedException {
        if (sourceFolder.isDirectory()) {
            for (int i = 0; i < sourceFolder.list().length; i++) {
                DeCompress(new File(sourceFolder + "\\" + sourceFolder.list()[i]),
                        new File(targetFolder + "\\" + sourceFolder.list()[i]), 1);
            }
            return true;
        }
        return false;
    }

    static boolean rePack(File sourcePath) throws IOException, InterruptedException {
        File tmp = new File(sourcePath.toString().substring(0, sourcePath.toString().lastIndexOf('.')));
        tmp.mkdirs();
        sourcePath.renameTo(new File(tmp + "/" + sourcePath.getName()));
        Double sourceFile = (double) new File(tmp + "/" + sourcePath.getName()).length() / 1024 / 1024;
        System.out.println(sourceFile);
        while (!DeCompress(new File(tmp + "/" + sourcePath.getName()), 1)) {
            Thread.sleep(1000);
        }
        new File(tmp + "/" + sourcePath.getName()).delete();
        Runtime.getRuntime().exec(archive7z + " a -t7z -ssw -mx9 -mmt1 -r0 \"" +
                tmp + "\\" + sourcePath.getName() + "\"" +
                " \"" + tmp + "\\*" + "\"");
        Compress(new File(tmp + "\\*"), new File(tmp + "\\" + sourcePath.getName()), COMPRESSION_7Z, 2000);
        Thread.sleep(1000);
        Double targetFile = (double) new File(tmp + "/" + sourcePath.getName()).length() / 1024 / 1024;
        System.out.println(targetFile);
        new File(tmp + "/" + sourcePath.getName()).renameTo(sourcePath);
        Thread.sleep(1000);
        //deleteFileOrFolder(tmp.toPath());
        System.out.println("Saved : " + (sourceFile - targetFile) + " mB");
        return true;
    }
}