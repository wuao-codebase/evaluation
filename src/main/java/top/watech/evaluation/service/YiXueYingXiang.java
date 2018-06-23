package top.watech.evaluation.service;

import org.apache.ibatis.session.SqlSession;
import top.watech.evaluation.mapper.EvalMapper;
import top.watech.evaluation.po.Evaluat;
import top.watech.evaluation.util.SqlSessionFactoryUtil;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YiXueYingXiang {

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        ArrayList<String> arrayList = new ArrayList<String>();
        try{
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            EvalMapper evalMapper = sqlSession.getMapper(EvalMapper.class);
            EvalService evalService = new EvalService();
            List<String> list = Arrays.asList("101003");
            List<Evaluat> eval = evalMapper.getEval(list);
            for (Evaluat evaluat : eval) {
                StringBuilder evals = new StringBuilder();
                evals.append(evalService.compmin("学分下限", evaluat.getBYXFZS(), 160));
                evals.append(evalService.comptowmax("生师比", evaluat.getZXSRS(), evaluat.getJSZS(), 16));
                evals.append(evalService.compsummin("实践基地", evaluat.getXNSXJD(),evaluat.getXWSXJD(), 1));
                if ((evals).length()>0) {
                    //   System.out.println(evaluat.getXXXM()+"-"+evaluat.getXYMC()+"-"+evaluat.getSANJMC()+"\t"+evals);
                    arrayList.add(evaluat.getXXXM()+"-"+evaluat.getXYMC()+"-"+evaluat.getSANJMC()+"\t"+evals.toString()+"\r\n");
                }
            }
            if(args.length==0){
                args = new String[]{"E:"};
            }
            FileWriter writer = new FileWriter(args[0]+"\\医学影像.txt");
            writer.write( "————医学影像————\r\n");
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