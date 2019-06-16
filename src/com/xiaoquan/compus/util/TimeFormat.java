package com.xiaoquan.compus.util;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormat {
    public static String getFullDate(Date issueTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
        return issueTime == null ? "" : sdf.format(issueTime);
    }

    //��ʱ���ʽת���ɷ���TimestampҪ��ĸ�ʽ.
    public static Timestamp getSqlDateTime(Date issueTime) {
        String nowTime = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss").format(issueTime);
        return Timestamp.valueOf(nowTime);
    }

}
