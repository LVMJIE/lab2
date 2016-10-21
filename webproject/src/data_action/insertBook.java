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

import com.opensymphony.xwork2.ActionSupport;

import connectsql.connectsql;
import connectsql.connectsql;

public class insertBook extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String isbn;
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBauthorid() {
		return bauthorid;
	}

	public void setBauthorid(String bauthorid) {
		this.bauthorid = bauthorid;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAuthorid() {
		return authorid;
	}

	public void setAuthorid(String authorid) {
		this.authorid = authorid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	private String title;
	private String bauthorid;
	private String publisher;
	private String publishdate;
	private String price;
	private String authorid;
	private String name;
	private String age;
	private String country;
	
	public String insertBook(){
		System.out.println(bauthorid);
		String temp_name="SUCCESS";
    	//声明Connection对象
		Connection conselect = null;

		conselect = connectsql.connectTheDb();//************************1
        //遍历查询结果集;
        //Connection conn=null;
        
        try {
            //加载驱动程序

            //1.getConnection()方法，连接MySQL数据库！！

            if(!conselect.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = conselect.createStatement();
            //要执行的SQL语句
            //String sql = "select * from book left join author on book.authorid = author.authorid where book.title = '"+name+"'";
            //3.ResultSet类，用来存放获取的结果集！！
        	String sqlinsert = "select * from author where authorid ='"+authorid+"'";
            ResultSet rs = statement.executeQuery(sqlinsert);
            boolean flag = false;
            if(!rs.next()){//no suach author    then new an author
            	Connection coninsert = null;

        		coninsert = connectsql.connectTheDb();//************************1
            	Statement stateinsert = coninsert.createStatement();
                //要执行的SQL语句
                //String sql = "select * from book left join author on book.authorid = author.authorid where book.title = '"+name+"'";
                //3.ResultSet类，用来存放获取的结果集！！
            	String sqlinserta = "insert into author(authorid,name,age,country) values('"+authorid+"','"+name+"','"+age+"','"+country+"')";  
                int rsinsert = stateinsert.executeUpdate(sqlinserta);
                coninsert.close();
                stateinsert.close();
                statement.close();
            }
            try {
                //加载驱动程序
            	Connection con = null;

        		con = connectsql.connectTheDb();//************************1
                //1.getConnection()方法，连接MySQL数据库！！

                if(!con.isClosed())
                    System.out.println("Succeeded connecting to the Database!");
                //2.创建statement类对象，用来执行SQL语句！！
                Statement statementqq = con.createStatement();
                //要执行的SQL语句
                //String sql = "select * from book left join author on book.authorid = author.authorid where book.title = '"+name+"'";
                //3.ResultSet类，用来存放获取的结果集！！
            	 sqlinsert = "insert into book(isbn,title,authorid,publisher,publishdate,price) values('"+isbn+"','"+title+"','"+authorid+"','"+publisher+"','"+publishdate+"','"+price+"')";  
                int rsqq = statementqq.executeUpdate(sqlinsert);
                //要执行的SQL语句
                //String sql = "select * from book left join author on book.authorid = author.authorid where book.title = '"+name+"'";
                //3.ResultSet类，用来存放获取的结果集！！   
                statement.close();
                con.close();
                temp_name="SUCCESS";
           } catch(SQLException e) {
               //数据库连接失败异常处理
               e.printStackTrace();  
           }catch (Exception e) {
               // TODO: handle exception
               e.printStackTrace();
           }
            //要执行的SQL语句
            //String sql = "select * from book left join author on book.authorid = author.authorid where book.title = '"+name+"'";
            //3.ResultSet类，用来存放获取的结果集！！   
            rs.close();
            statement.close();
            conselect.close();
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
