package top.watech.evaluation.service;

import org.apache.ibatis.session.SqlSession;
import top.watech.evaluation.mapper.EvalMapper;
import top.watech.evaluation.po.Evaluat;
import top.watech.evaluation.util.SqlSessionFactoryUtil;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WaiGuoYuYan {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        ArrayList<String> arrayList = new ArrayList<String>();
        try{
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            EvalMapper evalMapper = sqlSession.getMapper(EvalMapper.class);
            EvalService evalService = new EvalService();
            List<String> list = Arrays.asList("50201","50202","50203","50204","50205","50206","50207","50208","50209","50210",
                    "50211","50212","50213","50214","50215","50216","50217","50218","50219","50220",
                    "50221","50222","50223","50224","50225","50226","50227","50228","50229","50230",
                    "50231","50232","50233","50234","50235","50236","50237","50238","50239","50240",
                    "50241","50242","50243","50244","50245","50246","50247","50248","50249","50250",
                    "50251","50252","50253","50254","50255","50256","50257","50258","50259","50260",
                    "50261","50262","50263","050264T","050265T","050266T","050267T","050268T");
            List<Evaluat> eval = evalMapper.getEval(list);
            for (Evaluat evaluat : eval) {
                StringBuilder evals = new StringBuilder();
                evals.append(evalService.compmin("学分下限", evaluat.getBYXFZS(), 150));
                evals.append(evalService.compmax("学分上限", evaluat.getBYXFZS(), 180));
                evals.append(evalService.compmin("师资人数", evaluat.getJSZS(), 6));
                evals.append(evalService.compmin("生均图书", evaluat.getZYTUSHU(), 100));
                evals.append(evalService.comptowmin("生均年教学运行支出(万元)",evaluat.getDNJXJF() ,evaluat.getZXSRS(), 0.1));
                if ((evals).length()>0) {
                    //   System.out.println(evaluat.getXXXM()+"-"+evaluat.getXYMC()+"-"+evaluat.getSANJMC()+"\t"+evals);
                    arrayList.add(evaluat.getXXXM()+"-"+evaluat.getXYMC()+"-"+evaluat.getSANJMC()+"\t"+evals.toString()+"\r\n");
                }
            }
            if(args.length==0){
                args = new String[]{"E:"};
            }
            FileWriter writer = new FileWriter(args[0]+"\\外国语言文学.txt");
            writer.write( "————外国语言文学————\r\n");
            for (String s : arrayList) {
                writer.write(s+"\r\n");
            }
            writer.close();
            sqlSession.commit();
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            sqlSession.rollback();
        }finally {
            if (sqlSession!=null) {
                sqlSession.close();
            }
        }
    }
}
