package data_action;
//com.opensymphony.xwork2.ActionSupport
//java包  
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
    	//声明Connection对象
		Connection con = null;

		con = connectsql.connectTheDb();//************************1
        //遍历查询结果集
        //Connection conn=null;
        try {
            //加载驱动程序
          
            //1.getConnection()方法，连接MySQL数据库！！
            
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            //String sql = "select * from book left join author on book.authorid = author.authorid where book.title = '"+name+"'";
            //3.ResultSet类，用来存放获取的结果集！！
        	String sql = "insert into author(authorid,name,age,country) values('"+authorID+"','"+Name+"','"+age+"','"+country+"')";  
            ResultSet rs = statement.executeQuery(sql);
            statement.close();
            rs.close();
            con.close();
       } catch(SQLException e) {
           //数据库连接失败异常处理
           e.printStackTrace();  
       }catch (Exception e) {
           // TODO: handle exception
           e.printStackTrace();
       }
        return temp_name;
	
	}
}
