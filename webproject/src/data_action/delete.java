package data_action;
//com.opensymphony.xwork2.ActionSupport
//java包  
import java.sql.*;
import java.util.ArrayList;
import com.opensymphony.xwork2.ActionSupport;

import connectsql.connectsql;
import connectsql.connectsql;
public class delete extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String bookisbn;

	public String getBookisbn() {
		return bookisbn;
	}

	public void setBookisbn(String bookisbn) {
		this.bookisbn = bookisbn;
	}
	private ArrayList<book> aa= new ArrayList<book>();
	public ArrayList<book> getAa() {
		return aa;
	}

	public void setAa(ArrayList<book> aa) {
		this.aa = aa;
	}
	public String delete(){
		System.out.println(bookisbn);
    	//System.out.println(name);
    	//boolean  flag = false;
    	String temp_name = "FAIL";
    	//声明Connection对象
    	Connection con = null;

		con = connectsql.connectTheDb();//************************1
        aa= new ArrayList<book>();
        //Connection conn=null;
        try {  

            //1.getConnection()方法，连接MySQL数据库！！

            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            //String sql = "select * from book left join author on book.authorid = author.authorid where book.title = '"+name+"'";
            //3.ResultSet类，用来存放获取的结果集！！
            String sql = "delete from book where book.isbn= '"+bookisbn+"'";
            boolean rs = statement.execute(sql);
            temp_name = "FAIL";
            statement.close();
            con.close();
        } catch (SQLException e) {  
            System.out.println("插入数据库时出错：");  
            e.printStackTrace();  
        } catch (Exception e) {  
            System.out.println("插入时出错：");  
            e.printStackTrace();  
        }  
        return "SUCCESS";
	}
  
}