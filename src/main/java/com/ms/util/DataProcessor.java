package com.ms.util;

import com.google.common.collect.Maps;
import com.ms.entity.ToneTypeAndPart;
import com.ms.enums.ToneEnum;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.*;

/**
 * @author shiguang
 */

@Slf4j
public class DataProcessor {

  public static void main(String[] args) throws IOException {
//    String pathName = "doc/PingShuiYun.txt";
//    System.out.println(processor(pathName));
      File file = new File("src/main/resources/lib/doc");
      if (!file.exists()) {
          log.error(file + " is not found.");
          return;
      }

      File[] files = file.listFiles();
      for (int i = 0; i < files.length; i++) {
          File f = files[i];
          if (f.isFile()) {
              Map<String, List<ToneTypeAndPart>> processor = DataProcessor.processor("src/doc/" + f.getName());
              System.out.println(processor);
          } else {
              log.error(f + "is not a dir.");
          }
      }
  }

  public static Map<String, List<ToneTypeAndPart>> processor(String pathName) throws IOException {
//      String pathName = "doc/PingShuiYun.txt";
      File file = new File(pathName);
      BufferedReader br = new BufferedReader(new FileReader(file));
      List<List<String>> result = new ArrayList<>();
      String s = null;
      while((s = br.readLine()) != null){
        if (s.length() == 0 || s == "") {
            continue;
        }
        List<String> str = handler(s.split("："));
        result.add(new ArrayList<>(str));
      }
      Map<String, List<ToneTypeAndPart>> map = Maps.newHashMap();
      for (List<String> list : result) {
          if (list.size() >= 2) {
              String str = list.get(1);
              for (int i = 0; i < str.length(); i++) {
                  char ch = str.charAt(i);
                  String st = list.get(0);
                  ToneTypeAndPart toneTypeAndPart = new ToneTypeAndPart();
                  if(st.substring(0, 2).equals("上平") || st.equals("下平")) {
                      toneTypeAndPart.setToneType(ToneEnum.LEVEL_TONE.getType());
                  } else {
                      toneTypeAndPart.setToneType(ToneEnum.OBLIQUE_TONE.getType());
                  }
                  toneTypeAndPart.setPart(st.substring(2, st.length()));
                  if (map.containsKey(String.valueOf(ch))) {
                      map.get(String.valueOf(ch)).add(toneTypeAndPart);
                  } else {
                      map.put(String.valueOf(ch), new ArrayList<>(Arrays.asList(toneTypeAndPart)));
                  }
              }
          }
      }
      return map;
  }

  private static List<String> handler(String[] str) {
      if(str.length < 2) {
        return Arrays.asList(str);
      }
      List<String> res = new ArrayList<>();
      res.add(str[0]);
      StringBuilder sb = new StringBuilder();
      String s = str[1];
      for(int i = 0; i < s.length(); i++){
          char ch = s.charAt(i);
          if (ch == '[') {
              int index = 1;
              while (s.charAt(i + index) != ']') {
                  index++;
              }
              i += index;
          } else {
              sb.append(ch);
          }
      }
      res.add(sb.toString());
      return res;
  }
}
