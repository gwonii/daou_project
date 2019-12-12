package kr.co.daou.hc.gwonii.api.controller.getter;

import kr.co.daou.hc.gwonii.api.controller.parsing.RegexParsing;
import kr.co.daou.hc.gwonii.api.model.FTPSettingModel;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class GetterTest {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Test
    public void playRun() {

        // given

        // ftp connect
        FTPSettingModel ftpSettingModel = new FTPSettingModel.FTPModelBuilder()
                .port(22)
                .host("172.22.1.66")
                .user("hc.gwonii")
                .password("1234")
                .build();
        FTPConnection ftpConnection = new FTPConnection(ftpSettingModel);
        ftpConnection.init();

        RegexParsing regexParsing = new RegexParsing();
        // road data

        // read data

        Reader reader = new Reader(ftpConnection.getChannelSftp());

        int count = 2;
        while(count != 0) {

            BufferedReader bufferedReader = reader.readData(ftpConnection.getPATH());
            String currentLine = null;

            while (true) {
                try {
                    if ((currentLine = bufferedReader.readLine()) == null)
                        break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(currentLine);
            }
            count--;
        }




        // send data


    }
}