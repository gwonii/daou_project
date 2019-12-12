package kr.co.daou.hc.gwonii.api.controller.getter;

import com.jcraft.jsch.*;
import kr.co.daou.hc.gwonii.api.model.FTPSettingModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class FTPConnection {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final String PATH = "/opt/TerraceTims/log/catalina/webmail";

    private FTPSettingModel ftpSettingModel;

    private Session session;
    private Channel channel;
    private ChannelSftp channelSftp;
    private JSch jsch;

    public FTPConnection (FTPSettingModel ftpSettingModel) {
        this.ftpSettingModel = ftpSettingModel;
    }

    public void init() {

        session = null;
        channel = null;
        channelSftp = null;

        // JSch 객체 생성
        jsch = new JSch();

        try {
            // FTP 통신을 위하여 session 기본 설정
            setSession();

            // session connect
            connectSession();

            // channel connect
            connectChannel();

            LOGGER.info("FTP connection init 완료");

        } catch (JSchException e) {
            LOGGER.error("FTP connection init 실패");
        }
        channelSftp = (ChannelSftp) channel;
    }

    private void setSession() {
        // 세션 객체 생성
        try {
            session = jsch.getSession(ftpSettingModel.getUser(), ftpSettingModel.getHost(), ftpSettingModel.getPort());
        } catch (JSchException e) {
            LOGGER.error("setSession 실패 : 개인 정보에 문제가 발생했습니다.");
        }
        // 패스워드 설정
        session.setPassword(ftpSettingModel.getPassword());
        // 세션관련 설정정보 설정
        Properties config = new Properties();
        // 호스트 정보 검사 x
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);

        LOGGER.info("session setting 완료");
    }

    private void connectSession() throws JSchException {
        // session 접속
        session.connect();

        LOGGER.info("session connect 완료");
    }

    private void connectChannel() throws JSchException {
        // sftp  channel 접속
        channel = session.openChannel("sftp");
        channel.connect();

        LOGGER.info("channel connect 완료");
    }


    public void disConnect() {
        //sftp disconnect
        channelSftp.quit();
        session.disconnect();

        LOGGER.info("disconnect 완료");
    }

    public ChannelSftp getChannelSftp() {
        return channelSftp;
    }

    public String getPATH() {
        return PATH;
    }
}
