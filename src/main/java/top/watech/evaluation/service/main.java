package top.watech.evaluation.service;

import java.io.File;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        String[] list ={"E:\\evaluation"};
        File file =new File("E:\\evaluation");
        if  (!file .exists()  && !file .isDirectory())
        {
            file .mkdir();
        }
        Zhexue.main(list);
        JingJixue.main(list);
        CaiZhengxue.main(list);
        JinRongxue.main(list);
        JingJiYuMaoYi.main(list);
        FaXue.main(list);
        ZhengZhixue.main(list);
        SheHuixue.main(list);
        MinZuxue.main(list);
        MaKeLiLun.main(list);
        GongAnxue.main(list);
        JiaoYuxue.main(list);
        TiYuxue.main(list);
        ZhongGuoYuYan.main(list);
        WaiGuoYuYan.main(list);
        XingWenChuanbo.main(list);
        LiShixue.main(list);
        ShuXue.main(list);
        WuLixue.main(list);
        HuaXue.main(list);
        TianWenxue.main(list);
        DiliKeXue.main(list);
        DaQiKeXue.main(list);
        YingYongQiXiang.main(list);
        HaiYangKeXue.main(list);
        DiQiuWuLi.main(list);
        DiZhiXue.main(list);
        DiQiuHuaXue.main(list);
        DiQiuXinXi.main(list);
        GuShengWu.main(list);


        DianZiXinXi.main(list);
        JiSuanJi.main(list);
        YiShuLiLun.main(list);

    }
}
