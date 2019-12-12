package kr.co.daou.hc.gwonii.api;

import java.io.*;
import java.util.ArrayList;

public class ApiUtil {

    public static String TAG = "UserFileReader.class";

    private ArrayList<String> sampleSet = new ArrayList<>();

    public static BufferedReader inputStreamReader(InputStream inputStream) {

        InputStreamReader inputStreamReader;
        BufferedReader bfr;
        String currentLine = "";

        inputStreamReader = new InputStreamReader(inputStream);
        bfr = new BufferedReader(inputStreamReader);

        return bfr;

    }

    public static String readFromRandomAccessFile(String file, int position) {

        String record = null;
        int nowPosition = 0;

        try {
            RandomAccessFile fileStore = new RandomAccessFile(file, "rw");

            // moves file pointer to position specified
            fileStore.seek(position);

            // reading String from RandomAccessFile
            record = fileStore.readUTF();

            fileStore.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return record;

    }

    public void fileRead() {

        try {

            File files = new File("./../../log/access_2019-12-01.txt");

            FileReader fr = new FileReader(files);

            BufferedReader bfr = new BufferedReader(fr);

            String currentLine = "";

            while ((currentLine = bfr.readLine()) != null) {

                sampleSet.add(currentLine);
                System.out.println(currentLine + "\n");
            }

        } catch (IOException e) {
            // 파일을 찾지 못한 경우
            e.printStackTrace();
        }
    }

}
