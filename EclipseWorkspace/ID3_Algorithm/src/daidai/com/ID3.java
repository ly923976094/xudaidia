package daidai.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ID3 {

    /**
     * 文件流读取训练元组
     * 
     * @return 训练元组集合
     * @throws IOException
     */
    public static ArrayList<ArrayList<String>> readFData(String fileUrl)
            throws IOException {
        ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                new FileInputStream("F:\\weather.test.txt")));
        String temp = null;
        String[] tempArray = null;
        while ((temp = in.readLine()) != null) {
            tempArray = temp.split("\\t");
            ArrayList<String> s = new ArrayList<String>();
            for (int i = 0; i < tempArray.length; i++) {
                // ///////////////
                s.add(tempArray[i]);
            }
            datas.add(s);
        }
        in.close();
        return datas;
    }

    /**
     * 文件流读取候选属性
     * 
     * @return 候选属性集合
     * @throws IOException
     */
    public static ArrayList<String> readFCandAttr(String fileUrl)
            throws IOException {
        ArrayList<String> candAttr = new ArrayList<String>();
        String temp = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(
                new FileInputStream("F:\\weather.feature.txt")));
        while ((temp = in.readLine()) != null) {
            candAttr.add(temp);
        }
        in.close();
        return candAttr;
    }

    public static void main(String[] args) throws IOException {

        ArrayList<ArrayList<String>> Datas = readFData("F:\\weather.test.txt"); //读入数据文件 长宽不限 需用table键隔开
        ArrayList<String> features = readFCandAttr("F:\\weather.feature.txt"); //读入特征文件 长宽不限 需用table键隔开

        DecisionTree.buildTree(Datas, features);
    }
}