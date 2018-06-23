package top.watech.evaluation.service;

import java.io.File;

public class test {
    public static void main(String[] args) {
        File[] roots = File.listRoots();
        for (int i =0; i < roots.length; i++) {
            System.out.println(roots[i]);
        }
    }
}
