package kr.co.daou.hc.gwonii.api.controller.manager;

import kr.co.daou.hc.gwonii.api.controller.getter.FTPConnection;
import kr.co.daou.hc.gwonii.api.model.FTPSettingModel;
import org.junit.Test;

import java.util.List;

public class ManagerTest {

    @Test
    public void playRun() {

        //given

        // given
        FTPSettingModel ftpSettingModel = new FTPSettingModel.FTPModelBuilder()
                .port(22)
                .host("172.22.1.66")
                .user("hc.gwonii")
                .password("1234")
                .build();
        // fttp 연결하기
        FTPConnection ftpConnection = new FTPConnection(ftpSettingModel);
        ftpConnection.init();


        // when

        // log manager 생성
        UnparsedLogLogManager unparsedLogLogManager = new UnparsedLogLogManager(ftpConnection.getChannelSftp());

        unparsedLogLogManager.chanageDirectory(ftpConnection.getPATH());
        unparsedLogLogManager.readFileNameList();

        //path와 file 이름만 보내면 알아서 할 수 있도록............

        List<String> nameList = unparsedLogLogManager.getFileNameList();

        for (String name : nameList) {
            System.out.println(name);
        }

        // then


    }
}