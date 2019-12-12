package kr.co.daou.hc.gwonii.api.controller.getter;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Method
 *      Public : loadData()            @param : path   @return : channelSftp
 *               getFileNameList()     @param :        @return : List<String>
 *
 *      Private : changeDirectory()    @param : path   @return : void
 *
 */


public class Loader {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    // field
    private ChannelSftp channelSftp;
    private List<String> fileNameList;

    // constructor
    public Loader (ChannelSftp channelSftp) {
        this.channelSftp = channelSftp;
    }


    // method

    public ChannelSftp loadData(String path) {
        chanageDirectory(path);
        return channelSftp;
    }

    public List<String> getFileNameList() {
        List<ChannelSftp.LsEntry> fileList = new Vector<>();
        List<String>fileNameList = new ArrayList<>();

        try {
            fileList = channelSftp.ls("*.txt");

        } catch (SftpException e) {
            LOGGER.error("readFileList 실패 : 해당하는 이름의 파일을 찾지 못했습니다.");
        }

        for (ChannelSftp.LsEntry entry : fileList) {
            fileNameList.add(entry.getFilename());
        }

        return fileNameList;
    }

    private void chanageDirectory(String path) {
        try {
            channelSftp.cd(path);
        } catch (SftpException e) {
            LOGGER.error("changeDirectory 실패 : 해당하는 path를 찾지 못했습니다.");
        }
    }
}
