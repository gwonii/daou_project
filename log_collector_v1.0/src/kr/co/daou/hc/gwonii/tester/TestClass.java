//package kr.co.daou.hc.gwonii.tester;
//
//import kr.co.daou.hc.gwonii.api.ApiUtil;
//import kr.co.daou.hc.gwonii.api.controller.getter.FTPConnection;
//import kr.co.daou.hc.gwonii.api.model.FTPModel;
//import kr.co.daou.hc.gwonii.api.parsingbefore.RegexParsingBefore;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.time.LocalDate;
//import java.util.ArrayList;
//
//import static kr.co.daou.hc.gwonii.api.ApiGlobalValue.*;
//
//public class TestClass {
//
//    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
//
//    private static final String PATH = "/opt/TerraceTims/log/catalina/webmail";
//
//    public static int number = 0;
//
//    public void testMethod() {
//
//        ArrayList<String> serverFiles = null;
//        ArrayList<RegexParsingBefore> log = null;
//        String prefixFileName = "access_2019-12-0";
//        String extension = ".txt";
//        String day = "";
//
//
//        LocalDate currentTime = LocalDate.now();
//
//        FTPConnection ftpConnection = new FTPConnection();
//        FTPModel ftpModel = new FTPModel.FTPModelBuilder()
//                .port(22)
//                .host("172.22.1.66")
//                .user("hc.gwonii")
//                .password("1234")
//                .build();
//
//        // fttp 연결하기
//        ftpConnection.init(ftpModel);
//
//        RegexParsingBefore regexParser = null;
//
////        Files.walk(Paths.get("/home/you/Desktop")).forEach(filePath -> {
////            if (Files.isRegularFile(filePath)) {
////                System.out.println(filePath);
////            }
////        });
//
//        ftpConnection.fileRead(PATH);
//        LOGGER.info("file read 성공");
//
//        // 시간순으로 내림차순
//        serverFiles = new ArrayList<>();
//        serverFiles = ftpConnection.getServerFile();
//
//        // 시간 순서대로 모든 파일 나열
//        for (String nowFileName : serverFiles) {
//            log = new ArrayList<>();
//
//            InputStream inputStream = ftpConnection.fileDownload(PATH, nowFileName);
//            LOGGER.info("Log read를 위해 stream 구성");
//
//            // 이것이 return 값으로 bufferReader 객체를 보낸다. 그거 받고
//            BufferedReader bfr = ApiUtil.inputStreamReader(inputStream);
//
//            try {
//                String currentLine = null;
//                while ((currentLine = bfr.readLine()) != null) {
//                    regexParser = new RegexParsingBefore();
//
//                    // String parsing
//                    regexParser.doRegexParsing(currentLine);
//
//                    // 현재 날짜와 비교
//                if (currentTime.getDayOfYear() > Integer.parseInt(regexParser.getTimeDetail().get(DAY))) {
//                    log.add(regexParser);
//                }
//
//                    //
//
////                    System.out.println(regexParser.toString());
//
//                    // 여기서 한 줄 단위로 데이터를 저장시켜야 한다.
//                    // 그리고 저장을 하기위해서는 time을 처리할 수 있는 로직이 필요하다.
//
//                    number++;
//                }
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            LOGGER.info("number : " + number);
//        }
////        for (RegexParsing regexParsing : log) {
////            System.out.println(regexParsing.toString());
////        }
//        ftpConnection.disConnect();
//        LOGGER.info("disconnect");
//        LOGGER.info("FTPUtill & RegexParsingUtil intersection completed");
//    }
//
//}
//
