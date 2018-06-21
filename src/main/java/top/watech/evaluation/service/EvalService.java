package top.watech.evaluation.service;


public class EvalService {
    //单值在标准左右10 学分左右
    public  String compnear(String rule, String a,double value) {
        if (Double.valueOf(a)<value-10||Double.valueOf(a)>value+10) {
            return rule+a+"不符合标准"+value+"左右\t";
        }
        return "";
    }
    //单值比标准小  师资人数 生均图书 学分下限
    public  String compmin(String rule, String a,double value) {
        if (Double.valueOf(a)<value) {
            return rule+a+"不符合最小"+value+"的标准\t";
        }
        return "";
    }
    //单值比标准小   学分上限
    public  String compmax(String rule, String a,double value) {
        if (Double.valueOf(a)>value) {
            return rule+a+"不符合最大"+value+"的标准\t";
        }
        return "";
    }
    //比值比标准值大  生师比
    public  String comptowmax(String rule,String a,String b,double value) {
        double temp = Double.valueOf(a)/Double.valueOf(b);
        if (temp>value) {
            return rule+temp+"不符合最大"+value+"的标准\t";
        }
        return "";
    }
    //比值比标准值小  生均教学仪器费用 生均教学支出
    public  String comptowmin(String rule,String a,String b,double value) {
        double temp = Double.valueOf(a)/Double.valueOf(b);
        if (temp<value) {
            return rule+temp+"不符合最小"+value+"的标准\t";
        }
        return "";
    }
    //和的比值比较  副教授以上
    public  String compthreemin(String rule,String a,String b,String c,double value) {
        double temp =(Double.valueOf(a)+Double.valueOf(b))/Double.valueOf(c);
        if (temp<value) {
            return rule+temp+"不符合最小"+value+"的标准\t";
        }
        return "";
    }
  }