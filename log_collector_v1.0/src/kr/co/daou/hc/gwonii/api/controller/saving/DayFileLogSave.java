package kr.co.daou.hc.gwonii.api.controller.saving;

import kr.co.daou.hc.gwonii.api.model.ParsingLogModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;

public class DayFileLogSave implements LogSave {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public void writeFile(String fileName, ArrayList<ParsingLogModel> contents) {

        BufferedWriter fileWriter = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            fileWriter = new BufferedWriter(new FileWriter(filePath + fileName + extension));
//            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath + fileName + extension));

            for (ParsingLogModel text : contents ) {
                fileWriter.write(text.toString() + "\n");
//                bufferedOutputStream.write("\n".getBytes());
            }

//            bufferedOutputStream.close();
            fileWriter.close();

        } catch (FileNotFoundException e) {
            LOGGER.error("bufferedOutputStream open 실패");
        } catch (IOException e) {
            LOGGER.error("file write 실패");
        }
    }



}
