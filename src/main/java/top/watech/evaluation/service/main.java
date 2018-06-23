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
        DianZiXinXi.main(list);
        JiSuanJi.main(list);
        YiShuLiLun.main(list);
        YiXueJiShu_YXJianYan.main(list);
    }
}
