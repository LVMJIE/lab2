/*
 * ����Ҫ���ĵ� bookisbn
 * ����  ���Ӧ��bookinformation  �� authorinformation
 * ���ݸ� UpdateBookPage.jsp
 * 
 * */

package data_action;
//com.opensymphony.xwork2.ActionSupport
//java��  
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
           //���ݿ�����ʧ���쳣����
           e.printStackTrace();  
       }catch (Exception e) {
           // TODO: handle exception
           e.printStackTrace();
       }
        System.out.println(oldBook.isbn);
        return temp_name;
	}
	
}
