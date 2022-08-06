package com.ms.util;

import java.io.File;
import java.net.URL;

/**
 * @author shiguang
 */
public class FileLoader {

    public boolean exists() {
        System.out.println(FileLoader.class.getResource("/").getPath());
        URL resource = FileLoader.class.getResource("/src/doc");
        if (resource == null) {
            return false;
        }
        File f = new File(resource.getFile());
        return f.exists();
    }

  public static void main(String[] args) {
    //
      FileLoader f = new FileLoader();
    System.out.println(f.exists());
  }

    //  public static void main(String[] args) throws IOException {
//    //
//      String tempPath = FileUtils.getTempDirectory().getPath();
//      File file = new File(tempPath + File.separator + "/test");
//      file.mkdirs();
//      System.out.println(tempPath);
//      InputStream in = DictCache.class.getResourceAsStream("/lib");
//      FileOutputStream fos = new FileOutputStream();
//      IOUtils.copyLarge(in, fos);
//
//      FileUtils.copyInputStreamToFile(in, file);
//
////      FileUtils.deleteQuietly(file);
//      FileUtils.deleteDirectory(file);
//  }
}
