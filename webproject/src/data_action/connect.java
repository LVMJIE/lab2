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
import java.util.ArrayList;
import com.opensymphony.xwork2.ActionSupport;

import connectsql.connectsql;




public class connect extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String name;
	private ArrayList<book> aa  = new ArrayList<book>();
	private ArrayList<author> bb= new ArrayList<author>();
	public ArrayList<author> getBb() {
		return bb;
	}

	public void setBb(ArrayList<author> bb) {
		this.bb = bb;
	}

	private String bookisbn;
	
	public String getBookisbn() {
		return bookisbn;
	}

	public void setBookisbn(String bookisbn) {
		this.bookisbn = bookisbn;
	}

	//static book list = new book();
	public ArrayList<book> getAa() {
		return aa;
	}

	public void setAa(ArrayList<book> aa) {
		this.aa = aa;
	}
 
	public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String booklist(){
    	System.out.println(bookisbn);
    	System.out.println(name);
    	//boolean  flag = false;
    	String temp_name = "FAIL";
    	//����Connection����
    	Connection con = null;

		con = connectsql.connectTheDb();//************************1
        //������ѯ�����
        aa= new ArrayList<book>();
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
            String sql = "select * from book";
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
           //���ݿ�����ʧ���쳣����
           e.printStackTrace();  
       }catch (Exception e) {
           // TODO: handle exception
           e.printStackTrace();
       }
        return temp_name;
    }
    
    public String bookinformation(){
    	//boolean  flag = false;
    	System.out.println(bookisbn);
    	System.out.println(name);
    	String temp_name = "FAIL";
    	//����Connection����
    	Connection con = null;

		con = connectsql.connectTheDb();//************************1
        //������ѯ�����
        aa= new ArrayList<book>();
        try {
            //������������

            //1.getConnection()����������MySQL���ݿ⣡��

            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.����statement���������ִ��SQL��䣡��
            Statement statement = con.createStatement();
            //Ҫִ�е�SQL���
            String sql = "select * from book left join author on book.authorid = author.authorid where isbn = '"+bookisbn+"'";
            //String sql = "select * from book  where isbn = '7-111-16379-6/TN.343'";
            //3.ResultSet�࣬������Ż�ȡ�Ľ������
           // String sql = "select * from book";
            ResultSet rs = statement.executeQuery(sql);
           //System.out.println("1"+rs.getString("title")+"1");
            while(rs.next()){    
            	System.out.println("************try***");
               book user1= new book();
               author user2 = new author();
               user1.setIsbn(rs.getString("isbn"));
               user1.setTitle(rs.getString("title"));
               user1.setAuthorid(rs.getString("authorid"));
               user1.setPublisher(rs.getString("publisher"));
               user1.setPublishdate(rs.getString("publishdate"));
               user1.setPrice(rs.getString("price"));
               user2.setAuthorid(rs.getString("authorid"));
               user2.setAge(rs.getString("age"));
               user2.setCountry(rs.getString("country"));
               user2.setName(rs.getString("name"));
               aa.add(user1);
               bb.add(user2);
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
        return temp_name;
    }
}
