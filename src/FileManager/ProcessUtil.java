package FileManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class ProcessUtil {
    static boolean checkArchive(){
        return checkProcesses(new String[]{"7z.exe"});
    }

    static boolean checkProcesses(String[] data) {
        if (data == null) {
            return false;
        }

        try {
            String line;
            Process p;
            List<String> processes = new ArrayList<>();

            //p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe /v /fo list");
            p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");

            try (BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                while ((line = input.readLine()) != null) {
                    processes.add(line.toLowerCase());
                }
            }

            for (String process : processes) {
                for (String datas : data) {
                    if (process.contains(datas.toLowerCase())) {
                        //System.err.println("ANTICHEAT: Strange proccess detected!");
                        return true;
                    }
                }
            }

        } catch (Exception ignored) {
        }

        return false;
    }
}
