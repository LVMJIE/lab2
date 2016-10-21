package sayhello;

import java.util.ArrayList;
import data_action.book;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorld extends ActionSupport {
    /**
	 * 
	 */
	private ArrayList<book> aa;
	private static final long serialVersionUID = 1L;
	private String name;
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
    
    
    
    public String ein() {
        
        if(name.equals("w"))
        {
        	name = "Hello, " + this.name + "!"; 
        	return "SUCCESS";
        }
        else
        	name = "Hello, " + this.name + "!"; 
    	return "FAIL";
    	
        
    }
    public String asd(){
    	aa=new ArrayList<book>();
    	book g = new book();
        g.authorid="111";
        g.isbn="111";
        g.price="111";
        g.publishdate="111";
        g.publisher="111";
        g.title="111";
    	aa.add(g);
    	g = new book();
    	g.authorid="112";
        g.isbn="112";
        g.price="121";
        g.publishdate="121";
        g.publisher="112";
        g.title="311";
    	aa.add(g);
    	return "asd";
    }
}