package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class test1 {

	public static void main(String[] args) {
		Connection c=null;
		Statement s=null;
		// ��ʼ������
		for(int i=0;i<100;i++) {
			
		
		try {
			//������com.mysql.jdbc.Driver
			//����mysql-connector-java-5.08.-bin.jar��
			//������˵����Ĳ���ͻ��׳�ClassNotFound���쳣
			Class.forName("com.mysql.jdbc.Driver");
			
			c=DriverManager//���������ݿ�����ӣ�
					.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "admin");
			//���ݿ�������ip�����ݿ�˿ںţ����ݿ����ƣ����뷽ʽ���˺ţ����룻
			
			System.out.println("���ӳɹ�����ȡ���Ӷ���"+c);
			
			s=c.createStatement();
			
			System.out.println("��ȡstatement����"+s);
			
			String sql="insert into hero values(null,"+"'timoo'"+","+313.0f+","+50+")";
			s.execute(sql);
			
			System.out.println("�������ɹ�");
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			//�ر����ݿ�
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
