package com.xiaoquan.compus.util;

public class StringUtil {
    public static boolean isEmpty(String data) {
        return data == null || "".equals(data) ? true : false;
    }

    public static String changeSqlNameToJavaName(String fieldName) {
        String[] subName = fieldName.split("_");
        StringBuffer sb = new StringBuffer();

        sb.append(subName[0]);
        for(int i = 1; i < subName.length; i++) {
            sb.append(Character.toUpperCase(subName[i].charAt(0)) + subName[i].substring(1));
        }
        return sb.toString();
    }

    public static String toUpCaseFirst(String name) {
        StringBuffer sb = new StringBuffer();
        sb.append(name.substring(0, 1).toUpperCase()).append(name.substring(1));
        return sb.toString();
    }

}
