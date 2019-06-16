package com.xiaoquan.compus.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class VerifyCodeUtil {
        private final static Random rd = new Random();
        private final static String[] fontName = {"宋体","黑体","华文楷体","微软雅黑","华文隶书","楷体_GB2312"};
        private final static String codes = "123456789abcdefghijklmnpqrstuvwxyzABCEDFGHIJKLMNQPRSTUVWXYZ";
        private final static int WIDTH = 120;
        private final static int HEIGHT = 48;
        private final static int LINES = 7;
        private final static int LENS = 4;

        private static Color getColor() {
            return new Color(rd.nextInt(225),rd.nextInt(225),rd.nextInt(225));
        }
        private static String getFont() {
            return fontName[rd.nextInt(fontName.length)];
        }
        private static String getCode() {
            return String.valueOf(codes.charAt(rd.nextInt(codes.length())));
        }
        public static Map<String , Object> getImage() {
            BufferedImage bi = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
            String code = "";
            Graphics gh = bi.getGraphics();
            gh.setColor(Color.yellow);
            gh.fillRect(0, 0, WIDTH, HEIGHT);
            for (int i=0; i<LENS; i++) {
                gh.setColor(getColor());
                gh.setFont(new Font(getFont(), Font.BOLD, 25));
                String code2 = getCode();
                code += code2;
                gh.drawString(code2, WIDTH/(LENS+2)*(i+1), HEIGHT/3*2);
            }
            for (int j=0;j<LINES;j++) {
                gh.setColor(getColor());
                gh.drawLine(rd.nextInt(WIDTH), rd.nextInt(HEIGHT), rd.nextInt(WIDTH), rd.nextInt(HEIGHT));
            }
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("code", code);
            map.put("image", bi);
            return map;
        }

}
