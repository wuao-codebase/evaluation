package top.watech.evaluation.service;

import org.apache.ibatis.session.SqlSession;
import top.watech.evaluation.mapper.EvalMapper;
import top.watech.evaluation.po.Evaluat;
import top.watech.evaluation.util.SqlSessionFactoryUtil;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JingJixue {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            EvalMapper evalMapper = sqlSession.getMapper(EvalMapper.class);
            EvalService evalService = new EvalService();
            List<String> list = Arrays.asList("20101","20102","020103T","020104T","020105T","020106T");
            List<Evaluat> eval = evalMapper.getEval(list);
            for (Evaluat evaluat : eval) {
                StringBuilder evals = new StringBuilder();
                evals.append(evalService.compnear("总学分", evaluat.getBYXFZS(), 150));
                evals.append(evalService.compmin("师资人数", evaluat.getJSZS(), 10));
                evals.append(evalService.comptowmax("生师比", evaluat.getZXSRS(), evaluat.getJSZS(), 18));
                evals.append(evalService.compthreemin("副教授以上", evaluat.getZGJSZS(), evaluat.getFGJSZS(), evaluat.getJSZS(), 0.3));
                evals.append(evalService.compmin("生均图书", evaluat.getZYTUSHU(), 100));
                if ((evals).length() > 0) {
                    //System.out.println(evaluat.getXXXM()+"-"+evaluat.getXYMC()+"-"+evaluat.getSANJMC()+"\t"+evals);
                    arrayList.add(evaluat.getXXXM() + "-" + evaluat.getXYMC() + "-" + evaluat.getSANJMC() + "\t" + evals.toString()+"\r\n");
                }
            }
            FileWriter writer = new FileWriter(args[0]+"\\经济学类.txt");
            writer.write( "————经济学类————\r\n");
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
