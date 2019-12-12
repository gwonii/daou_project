package kr.co.daou.hc.gwonii.api.ftpconnection;

import kr.co.daou.hc.gwonii.api.controller.getter.FTPConnection;
import kr.co.daou.hc.gwonii.api.model.FTPSettingModel;
import org.junit.Test;

public class FTPConnectionTest {

    @Test
    public void init() {

        // given

        FTPSettingModel ftpSettingModel = new FTPSettingModel.FTPModelBuilder()
                .port(22)
                .host("172.22.1.66")
                .user("hc.gwonii")
                .password("1234")
                .build();
        FTPConnection ftpConnection = new FTPConnection(ftpSettingModel);
        // when
        ftpConnection.init();

        // then
//        assert ftpConnection.getConnection();
    }

}