package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class test1 {

	public static void main(String[] args) {
		Connection c=null;
		Statement s=null;
		// 初始化驱动
		for(int i=0;i<100;i++) {
			
		
		try {
			//驱动类com.mysql.jdbc.Driver
			//就在mysql-connector-java-5.08.-bin.jar中
			//如果忘了导包的步骤就会抛出ClassNotFound的异常
			Class.forName("com.mysql.jdbc.Driver");
			
			c=DriverManager//建立与数据库的连接；
					.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "admin");
			//数据库所处的ip，数据库端口号，数据库名称，编码方式，账号，密码；
			
			System.out.println("连接成功，获取连接对象"+c);
			
			s=c.createStatement();
			
			System.out.println("获取statement对象"+s);
			
			String sql="insert into hero values(null,"+"'timoo'"+","+313.0f+","+50+")";
			s.execute(sql);
			
			System.out.println("插入语句成功");
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			//关闭数据库
			if(s!=null)
				try {
					s.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			if(c!=null)
				try {
					c.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
		}
		}
		

	}

}
