package data_action;
//com.opensymphony.xwork2.ActionSupport
//java��  
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
    	//����Connection����
    	Connection con = null;

		con = connectsql.connectTheDb();//************************1
        aa= new ArrayList<book>();
        //Connection conn=null;
        try {  

            //1.getConnection()����������MySQL���ݿ⣡��

            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.����statement���������ִ��SQL��䣡��
            Statement statement = con.createStatement();
            //Ҫִ�е�SQL���
            //String sql = "select * from book left join author on book.authorid = author.authorid where book.title = '"+name+"'";
            //3.ResultSet�࣬������Ż�ȡ�Ľ��������
            String sql = "delete from book where book.isbn= '"+bookisbn+"'";
            boolean rs = statement.execute(sql);
            temp_name = "FAIL";
            statement.close();
            con.close();
        } catch (SQLException e) {  
            System.out.println("�������ݿ�ʱ����");  
            e.printStackTrace();  
        } catch (Exception e) {  
            System.out.println("����ʱ����");  
            e.printStackTrace();  
        }  
        return "SUCCESS";
	}
  
}