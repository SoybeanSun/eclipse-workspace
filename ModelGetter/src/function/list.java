package function;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import java.io.File;

public class list {
	 String infor=null;
	
	 public void setInfor(String infor) {
		 this.infor=infor;
	 }
	 public String getInfor() {
		 return infor;
	 }
	 private ArrayList<String> listFile(String src){
		 //将源路径下所有子目录的路径名存放到数组列表中
		 ArrayList<String> fileList=new ArrayList<String>();
		 File f=new File(src);
		 File[] files=f.listFiles();//得到f文件中的所有文件
		 if(files==null) {
			 setInfor("不存在子目录");
			 Logger.getLogger("list.class").error(getInfor());
		 }
		 for(File temp:files) {
			 fileList.add(temp.getAbsolutePath().toString());
		 }
		 return fileList;
		 
		 
	 }
	 private ArrayList

}
