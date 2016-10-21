/*
 * 接收要更改的 bookisbn
 * 查找  书对应的bookinformation  和 authorinformation
 * 传递给 UpdateBookPage.jsp
 * 
 * */

package data_action;
//com.opensymphony.xwork2.ActionSupport
//java包  
import java.sql.*;
import java.util.ArrayList;
import com.opensymphony.xwork2.ActionSupport;

import connectsql.connectsql;

import connectsql.connectsql;
public class ToUpdate extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private book oldBook;
	private author oldAuthor;
	public author getOldAuthor() {
		return oldAuthor;
	}

	public void setOldAuthor(author oldAuthor) {
		this.oldAuthor = oldAuthor;
	}

	private String bookisbn;
	public String getBookisbn() {
		return bookisbn;
	}

	public void setBookisbn(String bookisbn) {
		this.bookisbn = bookisbn;
	}

	public book getOldBook() {
		return oldBook;
	}

	public void setOldBook(book oldBook) {
		this.oldBook = oldBook;
	}
	
	public String ToUpdate(){
		String temp_name = "FAIL";
		
		System.out.println(bookisbn);
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
            String sql = "select * from book left join author on book.authorid  = author.authorid where book.isbn = '"+bookisbn+"'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){ 
               oldBook = new book();
               oldAuthor = new author();
               oldBook.setIsbn(rs.getString("isbn"));
               oldBook.setTitle(rs.getString("title"));
               oldBook.setAuthorid(rs.getString("authorid"));
               oldBook.setPublisher(rs.getString("publisher"));
               oldBook.setPublishdate(rs.getString("publishdate"));
               oldBook.setPrice(rs.getString("price"));
               oldAuthor.setAge(rs.getString("age"));
               oldAuthor.setAuthorid(rs.getString("authorid"));
               oldAuthor.setCountry(rs.getString("country"));
               oldAuthor.setName(rs.getString("name"));
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
        System.out.println(oldBook.isbn);
        return temp_name;
	}
	
}
