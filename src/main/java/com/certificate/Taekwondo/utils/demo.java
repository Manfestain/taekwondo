package com.certificate.Taekwondo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo {
    public static void main(String[] args) {
        Pattern p=Pattern.compile("/admin/.*");
        Matcher m=p.matcher("/login/");
        boolean b = m.matches();
        System.out.println(b);
    }
}
