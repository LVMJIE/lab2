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
    	//����Connection����
    	Connection con = null;

		con = connectsql.connectTheDb();//************************1
        //������ѯ�����;
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
           //���ݿ�����ʧ���쳣����
           e.printStackTrace();  
       }catch (Exception e) {
           // TODO: handle exception
           e.printStackTrace();
       }
        return temp_name;
    }
    
}