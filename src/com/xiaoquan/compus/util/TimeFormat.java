package com.xiaoquan.compus.util;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormat {
    public static String getFullDate(Date issueTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        return issueTime == null ? "" : sdf.format(issueTime);
    }

    //将时间格式转换成符合Timestamp要求的格式.
    public static Timestamp getSqlDateTime(Date issueTime) {
        String nowTime = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss").format(issueTime);
        return Timestamp.valueOf(nowTime);
    }

}
