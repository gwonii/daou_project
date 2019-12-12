//package kr.co.daou.hc.gwonii.api.controller.save;
//
//import kr.co.daou.hc.gwonii.api.ApiUtil;
//import kr.co.daou.hc.gwonii.api.controller.getter.FTPConnection;
//import kr.co.daou.hc.gwonii.api.controller.parsing.RegexParsing;
//import kr.co.daou.hc.gwonii.api.controller.saving.CheckTime;
//import kr.co.daou.hc.gwonii.api.controller.saving.DayFileLogSave;
//import kr.co.daou.hc.gwonii.api.controller.saving.SaveUtil;
//import kr.co.daou.hc.gwonii.api.model.FTPModel;
//import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//
//import static kr.co.daou.hc.gwonii.api.controller.saving.SaveGlobalValue.DAY_FILE;
//
//public class SaveTest {
//
//    RegexParsing regexParsing = new RegexParsing();
//
//    @Test
//    public void playRun() {
//
//        final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
//        final String PATH = "/opt/TerraceTims/log/catalina/webmail";
//        ArrayList<String> serverFiles = new ArrayList<>();
//
//        // given
//        FTPConnection ftpConnection = new FTPConnection();
//        FTPModel ftpModel = new FTPModel.FTPModelBuilder()
//                .port(22)
//                .host("172.22.1.66")
//                .user("hc.gwonii")
//                .password("1234")
//                .build();
//
//            // fttp 연결하기
//        ftpConnection.init(ftpModel);
//
//        ftpConnection.fileRead(PATH);
//        LOGGER.info("file read 성공");
//
//        // 시간순으로 내림차순
//        serverFiles = ftpConnection.getServerFile();
//
//
//        // when
//
//        int limit = 0;
//        for (String nowFileName : serverFiles) {
//
//            limit++;
//            InputStream inputStream = ftpConnection.fileDownload(PATH, nowFileName);
//            LOGGER.info("Log read를 위해 stream 구성");
//
//            // 이것이 return 값으로 bufferReader 객체를 보낸다. 그거 받고
//            BufferedReader bfr = ApiUtil.inputStreamReader(inputStream);
//
//            try {
//                String currentLine = null;
//                while ((currentLine = bfr.readLine()) != null) {

//                      readData();
//
//                    // String parsing
//                    regexParsing.doParsing(currentLine);
//
//                    // 현재 날짜와 비교
//                    CheckTime checkTime = new CheckTime();
//                    if (checkTime.checkTime(regexParsing.getParsingLog()) == DAY_FILE) {
//
//                    } else if (true) { // 시간 파일
//                    } else if (true) { // 분 파일
//                    }
//                    ;
//
//                    //
//
////                    System.out.println(regexParser.toString());
//
//                    // 여기서 한 줄 단위로 데이터를 저장시켜야 한다.
//                    // 그리고 저장을 하기위해서는 time을 처리할 수 있는 로직이 필요하다.
//
//                }
//
//                String fileName = SaveUtil.timeToFileNameTranslator(regexParsing.getParsingLog());
//                DayFileLogSave dayFileLogSave = new DayFileLogSave();
//                dayFileLogSave.writeFile(fileName, regexParsing.getLogs());
//
//                if (limit == 3) {
//                    break;
//                }
////                // 여기서 하루에 대한 정보를 write한다.
////                String fileName = regexParser.getTimeDetail().get(YEAR)
////                        + regexParser.getTimeDetail().get(MONTH)
////                        + regexParser.getTimeDetail().get(DAY) ;
////                FileSave fileSave = new FileSave();
////                fileSave.writeFile(fileName, log);
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//        // then
//
//        // 폴더 확인
//
//    }
//}