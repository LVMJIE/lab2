/*
 * book's  information  booklist()     
 * 
 * book + author's  information   bookinformation()
 * 
 * 
 * */
package data_action;
//java包  
import java.sql.*;
import java.util.ArrayList;
import com.opensymphony.xwork2.ActionSupport;

import connectsql.connectsql;
import connectsql.connectsql;
public class searchauthor extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String authorname;
	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	private ArrayList<book> aa= new ArrayList<book>();
	public ArrayList<book> getAa() {
		return aa;
	}

	public void setAa(ArrayList<book> aa) {
		this.aa = aa;
	}

    public String SearchBook(){
    	System.out.println(authorname);
    	//boolean  flag = false;
    	String temp_name = "FAIL";
    	//声明Connection对象
    	Connection con = null;

		con = connectsql.connectTheDb();//************************1
        //遍历查询结果集;
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
            String sql = "select * from book where authorid = any(select authorid from author where author.name = '"+authorname+"')";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
               book user1= new book();
               user1.setIsbn(rs.getString("isbn"));
               user1.setTitle(rs.getString("title"));
               user1.setAuthorid(rs.getString("authorid"));
               user1.setPublisher(rs.getString("publisher"));
               user1.setPublishdate(rs.getString("publishdate"));
               user1.setPrice(rs.getString("price"));
               aa.add(user1);
               temp_name = "SUCCESS";
            }
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