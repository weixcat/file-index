import java.io.File;
import java.util.Scanner;

/**
 * Created by weix on 2017/6/15.
 */
public class Search {
    private static String parentPath;
    private static File parentDirectory;
    public static void input(){
        while (true){
            System.out.println("输入目录名:");
            Scanner in  = new Scanner(System.in);
            parentPath = in.next();
            parentDirectory = new File(parentPath);;
            if (!parentDirectory.isDirectory()){
                System.out.println("该目录不存在,请重新输入...");
            }
            else {
                break;
            }
        }
    }
    public static void indexFiles(File _parentDirectory){
        String[] fileNames = _parentDirectory.list();
        if (fileNames == null){
            //pass
        }
        else {
            for (String fileName : fileNames){
                File fileTmp = new File(_parentDirectory,fileName);
                if (fileTmp.isFile()){
                    System.out.println(fileTmp.getAbsolutePath());
                }
                if(fileTmp.isDirectory()){
                    indexFiles(new File(_parentDirectory,fileName));
                }
            }
        }
    }
    public static void main(String[] args) {
        input();
        indexFiles(parentDirectory);
        System.out.println("检索完毕...");
    }
}
