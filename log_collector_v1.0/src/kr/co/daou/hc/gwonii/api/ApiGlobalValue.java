package kr.co.daou.hc.gwonii.api;

import java.util.regex.Pattern;

public class ApiGlobalValue {

    // 전체 log 정보에 대하여
    public static final int IP = 0;
    public static final int ANONSYMOUS = 1;
    public static final int EMAIL = 2;
    public static final int TIME = 3;
    public static final int HTTP_METHOD = 5;
    public static final int REQUEST_URI = 6;

    // 전체 time 정보에 대하여
    public static final int DAY = 0;
    public static final int MONTH = 1;
    public static final int YEAR = 2;
    public static final int HOUR = 3;
    public static final int MINUTE = 4;
    public static final int SECOND = 5;

    public static final Pattern IP_PATTERN = Pattern.compile("^[\\d\\.]{7,15}$");
    public static final Pattern EMAIL_PATTERN = Pattern.compile("^([\\da-z_\\.-])+@+([0-9a-z\\.-])+\\.+([a-z\\.]){2,6}$");
    public static final Pattern TIME_PATTERN = Pattern.compile("^([\\da-zA-Z\\/-:]){20}$");
    public static final Pattern HTTP_METHOD_PATTERN = Pattern.compile("^([A-Za-z]{3,7})$");
    public static final Pattern REQUEST_URI_PATTERN = Pattern.compile("^([\\da-zA-Z\\/]){1,100}$");

}
