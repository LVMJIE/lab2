package data_action;
import java.sql.*;
import java.sql.Connection;//java��  

import connectsql.connectsql;
import connectsql.connectsql;
public class connection {
	public static void main(String[] args) {
        //����Connection����

        //����������
        Connection con = null;

		con = connectsql.connectTheDb();//************************1
        //������ѯ�����
        try {
            //������������

            //1.getConnection()����������MySQL���ݿ⣡��

            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.����statement���������ִ��SQL��䣡��
            Statement statement = con.createStatement();
            //Ҫִ�е�SQL���
            String sql = "select * from author";
            //3.ResultSet�࣬������Ż�ȡ�Ľ��������
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("-----------------");
            System.out.println("ִ�н��������ʾ:");  
            System.out.println("-----------------");  
            System.out.println(" ID" + "\t" + " Name");  
            System.out.println("-----------------");  
             
            String name = null;
            String id = null;
            while(rs.next()){
                //��ȡstuname��������
                name = rs.getString("authorid");
                //��ȡstuid��������
                id = rs.getString("name");
                //����ʹ��ISO-8859-1�ַ�����name����Ϊ�ֽ����в�������洢�µ��ֽ������С�
                //Ȼ��ʹ��GB2312�ַ�������ָ�����ֽ����顣
                name = new String(name.getBytes("ISO-8859-1"),"gb2312");
                //������
                System.out.println(id + "\t" + name);
            }
            rs.close();
            con.close();
        } catch(SQLException e) {
            //���ݿ�����ʧ���쳣����
            e.printStackTrace();  
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            System.out.println("���ݿ����ݳɹ���ȡ����");
        }
    }
}
