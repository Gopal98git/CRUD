package com.CrudApi.CRUDAPI.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Repository;
import com.CrudApi.CRUDAPI.entity.Student;

@Repository
public class StudentDao {
public Connection con() throws ClassNotFoundException, SQLException{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?useSSL=false","root","Gopal@98");
	return conn;
}
	public List<Student> records() throws ClassNotFoundException, SQLException {
	PreparedStatement pr=con().prepareStatement("select * from student");
	ResultSet rs=pr.executeQuery();	
	List<Student> list=new ArrayList();
	while(rs.next()) {
	Student student=new Student();
	int id=rs.getInt(1);
	String name=rs.getString(2);
	String college=rs.getString(3);
	String depart=rs.getString(4);student.setName(name);
	student.setId(id);student.setCollege(college);student.setDepartment(depart);
	list.add(student);
	}
	return list;
	}

	public void insertdata(List<Student> s) throws ClassNotFoundException, SQLException {
		PreparedStatement pr=con().prepareStatement("insert into student values(?,?,?,?)");
        List<Student> lst=new ArrayList();
        lst.addAll(s);
       Iterator<Student> litr=lst.iterator();
        while(litr.hasNext()) {
        	Student st=litr.next();
		int id=st.getId();String name=st.getName();String college=st.getCollege();String depart=st.getDepartment();
        		pr.setInt(1,id);pr.setString(2, name);
        		pr.setString(3,college);pr.setString(4, depart);
		pr.executeUpdate();
        }
	}
	public void DeleteRecord(int id) throws ClassNotFoundException, SQLException {
		PreparedStatement pr=con().prepareStatement("delete from student where id=?");
		pr.setInt(1, id);
		pr.executeUpdate();
	}
	public void update(Student s) throws ClassNotFoundException, SQLException {
		PreparedStatement prr=con().prepareStatement("update student set name=? ,department=? where id=?");
		int idd=s.getId();String namee=s.getName();String depart=s.getDepartment();
		prr.setInt(3, idd);prr.setString(1, namee);prr.setString(2, depart);
        prr.executeUpdate();
	}
}
