/*
 * book's  information  booklist()     
 * 
 * book + author's  information   bookinformation()
 * 
 * 
 * */
package data_action;
//java��  
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
    	//����Connection����
		Connection conselect = null;

		conselect = connectsql.connectTheDb();//************************1
        //������ѯ�����;
        //Connection conn=null;
        
        try {
            //������������

            //1.getConnection()����������MySQL���ݿ⣡��

            if(!conselect.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.����statement���������ִ��SQL��䣡��
            Statement statement = conselect.createStatement();
            //Ҫִ�е�SQL���
            //String sql = "select * from book left join author on book.authorid = author.authorid where book.title = '"+name+"'";
            //3.ResultSet�࣬������Ż�ȡ�Ľ��������
        	String sqlinsert = "select * from author where authorid ='"+authorid+"'";
            ResultSet rs = statement.executeQuery(sqlinsert);
            boolean flag = false;
            if(!rs.next()){//no suach author    then new an author
            	Connection coninsert = null;

        		coninsert = connectsql.connectTheDb();//************************1
            	Statement stateinsert = coninsert.createStatement();
                //Ҫִ�е�SQL���
                //String sql = "select * from book left join author on book.authorid = author.authorid where book.title = '"+name+"'";
                //3.ResultSet�࣬������Ż�ȡ�Ľ��������
            	String sqlinserta = "insert into author(authorid,name,age,country) values('"+authorid+"','"+name+"','"+age+"','"+country+"')";  
                int rsinsert = stateinsert.executeUpdate(sqlinserta);
                coninsert.close();
                stateinsert.close();
                statement.close();
            }
            try {
                //������������
            	Connection con = null;

        		con = connectsql.connectTheDb();//************************1
                //1.getConnection()����������MySQL���ݿ⣡��

                if(!con.isClosed())
                    System.out.println("Succeeded connecting to the Database!");
                //2.����statement���������ִ��SQL��䣡��
                Statement statementqq = con.createStatement();
                //Ҫִ�е�SQL���
                //String sql = "select * from book left join author on book.authorid = author.authorid where book.title = '"+name+"'";
                //3.ResultSet�࣬������Ż�ȡ�Ľ��������
            	 sqlinsert = "insert into book(isbn,title,authorid,publisher,publishdate,price) values('"+isbn+"','"+title+"','"+authorid+"','"+publisher+"','"+publishdate+"','"+price+"')";  
                int rsqq = statementqq.executeUpdate(sqlinsert);
                //Ҫִ�е�SQL���
                //String sql = "select * from book left join author on book.authorid = author.authorid where book.title = '"+name+"'";
                //3.ResultSet�࣬������Ż�ȡ�Ľ��������   
                statement.close();
                con.close();
                temp_name="SUCCESS";
           } catch(SQLException e) {
               //���ݿ�����ʧ���쳣����
               e.printStackTrace();  
           }catch (Exception e) {
               // TODO: handle exception
               e.printStackTrace();
           }
            //Ҫִ�е�SQL���
            //String sql = "select * from book left join author on book.authorid = author.authorid where book.title = '"+name+"'";
            //3.ResultSet�࣬������Ż�ȡ�Ľ��������   
            rs.close();
            statement.close();
            conselect.close();
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
