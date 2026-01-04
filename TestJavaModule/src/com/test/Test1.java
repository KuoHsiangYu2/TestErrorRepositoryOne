package com.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) throws Exception {
        System.setErr(System.out);

        /* input_sample.txt */
        File filePath = new File("D:/TestJavaData_2/input_sample.txt"); // 檔案在專案的相對路徑.
        File inputFile = null;
        Scanner scanner = null;
        StringBuilder sb = new StringBuilder();
        String newLine = System.getProperty("line.separator");

        try {
            System.out.println("filePath.getCanonicalPath()");
            System.out.println("[" + filePath.getCanonicalPath() + "]"); // getCanonicalPath 絕對路徑.
            inputFile = new File(filePath.getCanonicalPath());
            scanner = new Scanner(inputFile, "UTF-8"); // 檔案編碼：UTF-8檔首無BOM.
            while (scanner.hasNext()) {
                sb.append(scanner.nextLine());
                sb.append(newLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
                scanner = null;
            }
        }

        String inputStr = sb.toString();
        System.out.println("inputStr");
        System.out.println("[" + inputStr + "]");

        System.out.println("------------------------------");

        List<PictureBean> pictureList = new ArrayList<PictureBean>();

        System.out.println("TODO: hsiangyu的問題：這邊完全卡住，不知道怎麼寫才能轉換。.");
        // TODO: hsiangyu的問題：這邊完全卡住，不知道怎麼寫才能轉換。.
        // 我會希望能寫個迴圈抓出 inputStr 裡面的值塞入 Java pictureList 物件.
        // 可能會跑個迴圈依序篩選要抓的值之類的。
        // 做出類似的程式動作
        // pictureList.add(new PictureBean(1, "https://hahost10.imgstream2.com/15411/01.jpg"));
        // pictureList.add(new PictureBean(2, "https://hahost10.imgstream2.com/15411/02.jpg"));
        StringFilter sf = new StringFilter();
        StringFilterVo vo = null;
        StringBuffer sbf = new StringBuffer(inputStr);
        PictureBean pb = null;
        String tmpStr = null;
        do {
			vo = sf.doFilter(sbf, "Large_cgurl[", "]", 2, 1);
			if (!"".equals(vo.getFilterStr())) {
				tmpStr = vo.getFilterStr();
				tmpStr = tmpStr.replace("Large_cgurl[" ,"");
				tmpStr = tmpStr.replace("]" ,"");
				pb = new PictureBean();
				pb.setKey(Integer.parseInt(tmpStr));
				sbf.delete(vo.getTagStartIdx(), vo.getTagEndIdx());
				
				vo = sf.doFilter(sbf, "= \"", "\";", 2, 1);
				if (!"".equals(vo.getFilterStr())) {
					tmpStr = vo.getFilterStr();
					tmpStr = tmpStr.replace("= \"" ,"");
					tmpStr = tmpStr.replace("\";" ,"");
					pb.setUrl(tmpStr);
					pictureList.add(pb);
					sbf.delete(vo.getTagStartIdx(), vo.getTagEndIdx());
				}
			}
		} while (!"".equals(vo.getFilterStr()));
        

        for (int i = 0; i < pictureList.size(); i++) {
            System.out.println("Key: " + pictureList.get(i).getKey() + ", URL: " + pictureList.get(i).getUrl());
        }

        System.out.println("finish");
    }

}
