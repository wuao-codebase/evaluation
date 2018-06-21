package top.watech.evaluation.service;

import java.text.DecimalFormat;

public class test {
    public static void main(String[] args) {
        DecimalFormat df=new DecimalFormat("0.00");
        double d=1252000.00002563;
        String st=df.format(d);
        System.out.println(st);
    }
}
