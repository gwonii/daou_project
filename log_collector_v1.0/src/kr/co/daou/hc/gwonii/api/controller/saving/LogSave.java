package kr.co.daou.hc.gwonii.api.controller.saving;

import kr.co.daou.hc.gwonii.api.model.ParsingLogModel;

import java.util.ArrayList;

public interface LogSave {

    //field static 변수만 사용가능
    String filePath = "./../log_data/temp_data/";
    String extension = ".txt";

    // 나누어지는 것은 일 파일, 시간 파일, 분 파일이 되지 않을까 생각된다.

    // 파싱되 로그정보를 텍스트 파일에 저장한다.
    //
    void writeFile(String fileName, ArrayList<ParsingLogModel> contents);

}
