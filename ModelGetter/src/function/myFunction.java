package function;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import org.apache.log4j.Logger;


public  class myFunction {
	
	 Scanner in=new Scanner(System.in);
	 String src=in.nextLine();
	 String dest=in.nextLine();
	 String infor=null;
	 
	 public void setInfor(String infor) {
		 this.infor=infor;
	 }
	 public String getInfor() {
		 return infor;
	 }
	 public boolean get(String src,String dest) {
		 if(src==null||dest==null) {//判断输入文件路径是否合法
			 
			 setInfor("文件路径为空");
			 Logger.getLogger("myFunction.class").error(getInfor());
			 return false;
					 		 
		 }
		 String xml="filter.xml";
		 ArrayList<String> fliteredList=filter(src, xml);
		 //将源文件中目录过滤,得到的目录为过滤后目录
		 if(fliteredList==null) {//判断过滤后的目录是否为空
			 return false;
		 } 
		 
		 for(Iterator<String> iterator=fliteredList.iterator();iterator.hasNext();) 
			 //使用迭代器对目录列表进行遍历
			 {
				 list l=new list();//创建list的实例
				 ArrayList<String> dateList=l.getDatelist(iterator.next());
				 //获取各目录子目录的datelist（各版本日期列表）
				 if(dateList==null) {//子目录为空
					 setInfor(l.lgetInfor());//将infor设为l对象中的infor
					 Logger.getLogger("myFunction.class").error(getInfor());
					 return false;
					  
				 }
				 
				 String newest=compareDate(src,dateList);//比较后得到最新版本的目录
				 src=iterator.next()+"\\"+newest;
				 
				 boolean b=copyDir(src,dest);//将新版本目录在目标路径下创建
				 if(!b) {
					 return false;
				 }
			 }
			 return true;
			 				 			 	 		 			 
	 }
	 
	 
	 
	 private ArrayList<String> filter(String src,String xml){
		 filter f=new filter();//创建一个filter实例
		 ArrayList<String> fileList=new ArrayList<String>();
		 //初始化fileList，用于存放目录的字符串
		 list l=new list();//创建一个list的实例
		 fileList=l.listFile(src);
		 //调用list类中的listFile方法,将源文件中所有目录的路径名以字符串的形式存放到fileList中
		 if(fileList==null) {
			 setInfor(l.getInfor());
			 Logger.getLogger("myFunction.class").error(getInfor());
			 return null;
		 }
		 fileList=filter.filterDir(src,fileList,xml);
		 //将fileList与xml中需要过滤 目录比较，然后进行过滤
		 if (fileList == null) {
				setInfo(f.getInfor());
				Logger.getLogger("function.class").error(getInfor());
				return null;
		 }
		 return fileList;	 	 	 
	 }
	 
	  
	 private String compareDate(String src,ArrayList<String> dateList) {
		 //将得到的子目录的dateList的各个时间进行比较，返回最新版本的字符串
		 compare c=new compare();//将compare进行实例化
		 
		 for(int i=0;i<dateList.size();i++) {//遍历子目录的dateList
			 if(c.isValidDate(dateList.get(i))==false) {
				 //判断子目录命名是否合法
				 setInfo(c.getInfor());
				 Logger.getLogger("function.class").error(getInfor());
				 return null;
			 }
		 }
		 src=c.compare(dateList);//调用compare方法，得到最新版本的目录字符串形式
		 return src;
	 }
	 private boolean copyDir(final String src, final String dest) {

			 copy co = new copy();//将copy进行实例化
		     boolean b = co.copyDir(src, dest);//调用co中的copyDir方法拷贝文件到指定路径
			if (!b) {//如果拷贝不成功，返回false
				setInfor(co.getLastErrInfo());
				Logger.getLogger("function.class").error(getInfor());
				return false;
			}
			return true;
		}
	 
	 
}
	
		
	
	
	


