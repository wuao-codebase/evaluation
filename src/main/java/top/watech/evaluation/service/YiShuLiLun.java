package top.watech.evaluation.service;

import org.apache.ibatis.session.SqlSession;
import top.watech.evaluation.mapper.EvalMapper;
import top.watech.evaluation.po.Evaluat;
import top.watech.evaluation.util.SqlSessionFactoryUtil;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YiShuLiLun {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            EvalMapper evalMapper = sqlSession.getMapper(EvalMapper.class);
            EvalService evalService = new EvalService();
            List<String> list = Arrays.asList("130101","130102T");
            List<Evaluat> eval = evalMapper.getEval(list);
            for (Evaluat evaluat : eval) {
                StringBuilder evals = new StringBuilder();
                evals.append(evalService.compmin("学分下限", evaluat.getBYXFZS(), 140));
                evals.append(evalService.compmin("师资人数", evaluat.getJSZS(), 8));
                evals.append(evalService.comptowmax("生师比", evaluat.getZXSRS(), evaluat.getJSZS(), 10));
                evals.append(evalService.compthreemin("副教授以上", evaluat.getZGJSZS(), evaluat.getFGJSZS(), evaluat.getJSZS(), 0.4));
                evals.append(evalService.comptowmin("专任教师中具有博士学位的比例",evaluat.getBSJSZS() ,evaluat.getJSZS(), 0.4));
                evals.append(evalService.compmin("生均图书", evaluat.getZYTUSHU(), 50));
                evals.append(evalService.comptowmin("生均年教学运行支出(万元)",evaluat.getDNJXJF() ,evaluat.getZXSRS(), 0.12));
                evals.append(evalService.comptowmin("生均专业教学科研仪器设备(万元)",evaluat.getZSBF() ,evaluat.getZXSRS(), 0.4));
                if ((evals).length() > 0) {
                    //System.out.println(evaluat.getXXXM()+"-"+evaluat.getXYMC()+"-"+evaluat.getSANJMC()+"\t"+evals);
                    arrayList.add(evaluat.getXXXM() + "-" + evaluat.getXYMC() + "-" + evaluat.getSANJMC() + "\t" + evals.toString()+"\r\n");
                }
            }
            if(args.length==0){
                args = new String[]{"C:"};
            }
            FileWriter writer = new FileWriter(args[0]+"\\艺术理论类.txt");
            writer.write( "————艺术理论类————\r\n");
            for (String s : arrayList) {
                writer.write(s + "\r\n");
            }
            writer.close();

            sqlSession.commit();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
