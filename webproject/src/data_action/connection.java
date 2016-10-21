package data_action;
import java.sql.*;
import java.sql.Connection;//java包  

import connectsql.connectsql;
import connectsql.connectsql;
public class connection {
	public static void main(String[] args) {
        //声明Connection对象

        //驱动程序名
        Connection con = null;

		con = connectsql.connectTheDb();//************************1
        //遍历查询结果集
        try {
            //加载驱动程序

            //1.getConnection()方法，连接MySQL数据库！！

            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = "select * from author";
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("-----------------");
            System.out.println("执行结果如下所示:");  
            System.out.println("-----------------");  
            System.out.println(" ID" + "\t" + " Name");  
            System.out.println("-----------------");  
             
            String name = null;
            String id = null;
            while(rs.next()){
                //获取stuname这列数据
                name = rs.getString("authorid");
                //获取stuid这列数据
                id = rs.getString("name");
                //首先使用ISO-8859-1字符集将name解码为字节序列并将结果存储新的字节数组中。
                //然后使用GB2312字符集解码指定的字节数组。
                name = new String(name.getBytes("ISO-8859-1"),"gb2312");
                //输出结果
                System.out.println(id + "\t" + name);
            }
            rs.close();
            con.close();
        } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();  
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            System.out.println("数据库数据成功获取！！");
        }
    }
}
