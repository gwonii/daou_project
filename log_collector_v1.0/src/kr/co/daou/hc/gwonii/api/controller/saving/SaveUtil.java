package kr.co.daou.hc.gwonii.api.controller.saving;

import kr.co.daou.hc.gwonii.api.model.ParsingLogModel;

import static kr.co.daou.hc.gwonii.api.ApiGlobalValue.*;

public class SaveUtil {

    public static String timeToFileNameTranslator(ParsingLogModel parsingLogModel) {

        String fileName;
        fileName = "" + String.format("%1$02d", parsingLogModel.getYear())
                + String.format("%1$02d", parsingLogModel.getMonth())
                + String.format("%1$02d", parsingLogModel.getDay());

        return fileName;
    }
}
