package kr.co.daou.hc.gwonii.api;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

// 현재 날짜 이전것과 이후 것을 나누는 클래스
public class FileClassification {

    private static final int YEAR = 0;
    private static final int MONTH = 1;
    private static final int DAY = 2;

    private ArrayList<String> beforeLog;
    private ArrayList<String> afterLog;

    private LocalDate currentDate = LocalDate.now();

    private String[] arrayTime;
    private String fileYear;
    private String fileMonth;
    private String fileDay;

    public void fileClassify (String inputLog) {
        // 현재 시간

        // input을 나누고 가져가야할 껀 년, 월, 일





//        splitedArrayWords = new ArrayList<>(Arrays.asList(splitedWords));
    }

    private void fileSplit(String inputLog) {
        arrayTime = inputLog.split("-|.|_");
        fileYear = arrayTime[YEAR];
        fileMonth = arrayTime[MONTH];
        fileDay = arrayTime[DAY];
    }
}
