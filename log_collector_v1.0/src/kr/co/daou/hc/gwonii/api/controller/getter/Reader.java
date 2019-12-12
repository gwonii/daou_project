package kr.co.daou.hc.gwonii.api.controller.getter;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;
import kr.co.daou.hc.gwonii.api.ApiUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Reader {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    // field
    private List<String> redData;
    private ChannelSftp channelSftp;
    private Loader loader;


    // constructor
    public Reader(ChannelSftp channelSftp) {
        this.channelSftp = channelSftp;
        redData = new ArrayList<>();
        loader = new Loader(channelSftp);
    }

    // method

    /**
     * Description : Reader class에서 유일한 public method가 될 것
     */
    public BufferedReader readData(String path) {
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;

//        Loader loader = new Loader(channelSftp);
        channelSftp = loader.loadData(path);

        for (int i = 0; i < loader.getFileNameList().size(); i++) {
            if (redData.contains(loader.getFileNameList().get(i))) {

            } else {
                redData.add(loader.getFileNameList().get(i));
                inputStream = openFileInputStream(loader.getFileNameList().get(i));
                bufferedReader = ApiUtil.inputStreamReader(inputStream);
                return bufferedReader;
            }
//            System.out.println(redData.get(i));
        }
        return null;
    }


    /**
     *
     * @param fileName
     * @returndd
     */
    private InputStream openFileInputStream(String fileName) {
        InputStream inputStream = null;

        try {
            inputStream = channelSftp.get(fileName);
        } catch (SftpException e) {
            LOGGER.error("openFileInputStream 실패 : 해당하는 파일을 찾지 못했습니다");
        }

        return inputStream;
    }



    public ChannelSftp getChannelSftp() {
        return channelSftp;
    }
}
