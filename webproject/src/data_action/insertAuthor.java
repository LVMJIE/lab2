package data_action;
//com.opensymphony.xwork2.ActionSupport
//java��  
import java.sql.*;
import java.util.ArrayList;
import com.opensymphony.xwork2.ActionSupport;

import connectsql.connectsql;
import connectsql.connectsql;
public class insertAuthor extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String authorID;
	public String getAuthorID() {
		return authorID;
	}
	public void setAuthorID(String authorID) {
		this.authorID = authorID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	private String Name;
	private String age;
	private String country;
	
	public String insertAuthor(){
		String temp_name = "FAIL";
		
		System.out.println(authorID+Name+age+country);
    	//����Connection����
		Connection con = null;

		con = connectsql.connectTheDb();//************************1
        //������ѯ�����
        //Connection conn=null;
        try {
            //������������
          
            //1.getConnection()����������MySQL���ݿ⣡��
            
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.����statement���������ִ��SQL��䣡��
            Statement statement = con.createStatement();
            //Ҫִ�е�SQL���
            //String sql = "select * from book left join author on book.authorid = author.authorid where book.title = '"+name+"'";
            //3.ResultSet�࣬������Ż�ȡ�Ľ��������
        	String sql = "insert into author(authorid,name,age,country) values('"+authorID+"','"+Name+"','"+age+"','"+country+"')";  
            ResultSet rs = statement.executeQuery(sql);
            statement.close();
            rs.close();
            con.close();
       } catch(SQLException e) {
           //���ݿ�����ʧ���쳣����
           e.printStackTrace();  
       }catch (Exception e) {
           // TODO: handle exception
           e.printStackTrace();
       }
        return temp_name;
	
	}
}
