package kr.co.daou.hc.gwonii.api.controller.saving;

import kr.co.daou.hc.gwonii.api.model.ParsingLogModel;

import java.time.LocalDate;
import java.time.LocalTime;

public class CheckTime {

    public String checkTime(ParsingLogModel log) {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        if (currentDate.getYear() > log.getYear()
                || currentDate.getMonthValue() > log.getMonth()
                || currentDate.getDayOfMonth() > log.getDay()) {
            return SaveGlobalValue.DAY_FILE;

        } else if (currentTime.getHour() > log.getHour()) {
            return SaveGlobalValue.HOUR_FILE;

        } else if (currentTime.getMinute() > log.getMinute()) {
            return SaveGlobalValue.MINUTE_FILE;

        } else {
            return SaveGlobalValue.SECOND_FILE;
        }
    }


}
