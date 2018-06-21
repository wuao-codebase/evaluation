package top.watech.evaluation.service;

import java.io.File;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        String[] list ={"E:\\text.txt"};
        File file=new File(list[0]);
        if(!file.exists())
        {
           file.createNewFile();
        }
        Zhexue.main(list);
        JingJixue.main(list);
        DianZiXinXi.main(list);
        JiSuanJi.main(list);
        YiShuLiLun.main(list);
        YiXueJiShu_YXJianYan.main(list);
    }
}
