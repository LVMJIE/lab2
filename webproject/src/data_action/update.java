/*
 *修改作者  信息
 * 
 * 
 * */


package data_action;
import connectsql.connectsql;
//com.opensymphony.xwork2.ActionSupport
//java包  
import java.sql.*;
import com.opensymphony.xwork2.ActionSupport;

public class update extends ActionSupport {
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
	
	public String getBauthorid() {
		return bauthorid;
	}

	public void setBauthorid(int bauthorid) {
		this.bauthorid = bauthorid+"";
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

	public void setPrice(int price) {
		this.price = price+"";
	}

	public String getAuthorid() {
		return authorid;
	}

	public void setAuthorid(String authorid) {
		this.authorid = authorid+"";
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
		this.age = age+"";
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	private String bauthorid;
	private String publisher;
	private String publishdate;
	private String price;
	private String authorid;
	private String name;
	private String age;
	private String country;
	
	public String Update(){
		String temp_name = "FAIL";
		System.out.println("***********************"+isbn);
		System.out.println("***********************"+bauthorid);
		System.out.println("***********************"+price);
		System.out.println("***********************"+publisher);
    	//声明Connection对象
		Connection conn = null;

		conn = connectsql.connectTheDb();//************************1

        try {

            if(!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            Statement statement = conn.createStatement();
            String sql = "update book set price ='"+price+"' where isbn= '"+isbn+"'";
            int rs = statement.executeUpdate(sql);
 
            sql = "update book set book.publisher ='"+publisher+"' where book.isbn= '"+isbn+"'";
            rs = statement.executeUpdate(sql);
            
            sql = "update book set book.publishdate ='"+publishdate+"' where book.isbn= '"+isbn+"'";
            rs = statement.executeUpdate(sql);
            
            sql = "select* from author where author.authorid ='"+authorid+"'";//search author according to authorid
            ResultSet rsselect = statement.executeQuery(sql);//
            boolean flag = false;
            //1.getConnection()方法，连接MySQL数据库！！
            Connection conexit = connectsql.connectTheDb();//******************************2
            if(!conexit.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statexit = conexit.createStatement();
            temp_name = "SUCCESS";
            if(rsselect.next())
            {//authorid exit!     换作者 + 加调 整作者信息
                //1.getConnection()方法，连接MySQL数据库！！
            	
            	
                //要执行的SQL语句
                //String sql = "select * from book left join author on book.authorid = author.authorid where book.title = '"+name+"'";
                //3.ResultSet类，用来存放获取的结果集！！
                //String sql = "select * from book where isbn = '"+bookisbn+"'";
                
            	System.out.println("******rs*************6");
            	flag = true;
            	sql = "update book set authorid ='"+authorid+"'"+"where book.isbn = '"+isbn+"'";
            	int asexit = statexit.executeUpdate(sql);
            	sql = "update author set name ='"+name+"'"+"where authorid = '"+authorid+"'";
            	int asexit1 = statexit.executeUpdate(sql);
            	sql = "update author set age ='"+age+"'"+"where authorid = '"+authorid+"'";
            	int asexit2 = statexit.executeUpdate(sql);
            	sql = "update author set country ='"+country+"'"+"where authorid = '"+authorid+"'";
            	int asexit3 = statexit.executeUpdate(sql);
                
            }
            statexit.close();
            conexit.close();
            System.out.println("******rs*************67");
            if(!flag)//author id doesn't exit,create new author!
            {
            	//声明Connection对象
            	System.out.println("******rs*************7");
                try {
                	Connection con = null;
            		con = connectsql.connectTheDb();//************************3
                    //加载驱动程序
                    //1.getConnection()方法，连接MySQ
                    if(!con.isClosed())
                        System.out.println("Succeeded connecting to the Database!");
                    //2.创建statement类对象，用来执行SQL语句！！
                    System.out.println("******rs*************8");
                    //1.getConnection()方法，连接MySQL数据库！！
                    
                    if(!con.isClosed())
                        System.out.println("Succeeded connecting to the Database!");
                    //2.创建statement类对象，用来执行SQL语句！！
                    Statement stateinsert = con.createStatement();
                    //要执行的SQL语句
                    //String sql = "select * from book left join author on book.authorid = author.authorid where book.title = '"+name+"'";
                    //3.ResultSet类，用来存放获取的结果集！！
                    
                	String sqlinsert = "insert into author(authorid,name,age,country) values('"+authorid+"','"+name+"','"+age+"','"+country+"')";  
                    int rsinsert = stateinsert.executeUpdate(sqlinsert);
                    sql = "update book set authorid ='"+authorid+"'"+" where book.isbn = '"+isbn+"'";
                	int asexit = stateinsert.executeUpdate(sql);temp_name="SUCCESS";
                    stateinsert.close();
                    con.close();
               } catch(SQLException e) {
                   //数据库连接失败异常处理
                   e.printStackTrace();  
               }catch (Exception e) {
                   // TODO: handle exception
                   e.printStackTrace();
               }
                
            }//finish insert
            temp_name = "SUCCESS";
            statement.close();
            rsselect.close();
            conexit.close();         

            conn.close();//finish update
       } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        return temp_name;
	}
}
