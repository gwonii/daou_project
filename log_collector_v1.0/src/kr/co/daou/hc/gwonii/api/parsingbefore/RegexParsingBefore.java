package kr.co.daou.hc.gwonii.api.parsingbefore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;

import static kr.co.daou.hc.gwonii.api.ApiGlobalValue.*;


public class RegexParsingBefore {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private ArrayList<String> splitedArrayWords;
    private String ip;
    private String email;
    private String time;
    private String httpMethod;
    private String requestUri;
    private ArrayList<String> timeDetail;

    // 전달받은 log 정보를 parsing하는 main method
    public void doRegexParsing(String inputLog) {

        splitedArrayWords = splitData(inputLog);

        ip = getIpParsingData(splitedArrayWords.get(IP));
        email = getEmailParsingData(splitedArrayWords.get(EMAIL));
        time = getTimeParsingData(splitedArrayWords.get(TIME));
        httpMethod = getHttpMethodParsingData(splitedArrayWords.get(HTTP_METHOD));
        requestUri = getRequestUriParsingData(splitedArrayWords.get(REQUEST_URI));

        timeDetail = splitTimeData(splitedArrayWords.get(TIME));
    }

    // 전달받은 log 정보를 split하는 역할
    public ArrayList<String> splitData(String inputLogData) {

        String[] splitedWords = null;
        ArrayList<String> splitedArrayWords = null;

        //split으로 먼저 자른다.
        splitedWords = inputLogData.split("\\s|\\[|\\]");
        splitedArrayWords = new ArrayList<>(Arrays.asList(splitedWords));

        // 스페이스와 '[' ']' 가 연속으로 등장하는 경우를 대비하여 빈칸을 제거한다.
        for (int i = 0; i < splitedArrayWords.size(); i++) {
            if (splitedArrayWords.get(i).isEmpty()) {
                splitedArrayWords.remove(i);
            }
        }

        return splitedArrayWords;
    }

    public ArrayList<String> splitTimeData(String inputTimeData) {

        String[] splitedWords = null;
        ArrayList<String> splitedArrayWords = null;

        splitedWords = inputTimeData.split("\\/|\\:");
        splitedArrayWords = new ArrayList<>(Arrays.asList(splitedWords));

        return splitedArrayWords;
    }

    // IP Parser
    public String getIpParsingData(String ipData) {
        Matcher ipMatcher = null;
        String outputIp = "";

        ipMatcher = IP_PATTERN.matcher(ipData);
        if (ipMatcher.find()) {
            outputIp = ipMatcher.group();
        }

        return outputIp;
    }

    // email parser
    public String getEmailParsingData(String emailData) {
        Matcher emailMatcher = null;
        String outputEmail = "";

        emailMatcher = EMAIL_PATTERN.matcher(emailData);
        if (emailMatcher.find()) {
            outputEmail = emailMatcher.group();
        }

        return outputEmail;
    }

    // time parser
    public String getTimeParsingData(String timeData) {
        Matcher timeMatcher = null;
        String outputTime = "";

        timeMatcher = TIME_PATTERN.matcher(timeData);
        if (timeMatcher.find()) {
            outputTime = timeMatcher.group();
        }

        return outputTime;
    }

    // http method parser
    public String getHttpMethodParsingData(String httpMethodData) {
        Matcher httpMethodMatcher = null;
        String outputHttpMethod = "";

        httpMethodMatcher = HTTP_METHOD_PATTERN.matcher(httpMethodData);
        if (httpMethodMatcher.find()) {
            outputHttpMethod = httpMethodMatcher.group();
        }

        return outputHttpMethod;
    }

    // request uri parser
    public String getRequestUriParsingData(String requestUriData) {
        Matcher requestMatcher = null;
        String outputRequestUri = "";

        requestMatcher = REQUEST_URI_PATTERN.matcher(requestUriData);
        if (requestMatcher.find()) {
            outputRequestUri = requestMatcher.group();
        }

        return outputRequestUri;
    }

    public String getIp() {
        return ip;
    }

    public String getEmail() {
        return email;
    }

    public String getTime() {
        return time;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public ArrayList<String> getTimeDetail() {
        return timeDetail;
    }

    @Override
    public String toString() {
        return ip + ' ' +  email + ' ' + time + ' ' + httpMethod + ' ' + requestUri;
    }
}
