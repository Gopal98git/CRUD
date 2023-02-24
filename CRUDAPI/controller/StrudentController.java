package com.CrudApi.CRUDAPI.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CrudApi.CRUDAPI.dao.StudentDao;
import com.CrudApi.CRUDAPI.entity.Student;

@RestController
public class StrudentController {

	@Autowired
	StudentDao SD;
	@GetMapping("ShowRecords")
	public List<Student> records() throws ClassNotFoundException, SQLException{
		return SD.records();
	}
	
	@PostMapping("insert")
	public String insertdata(@RequestBody List<Student> s) throws ClassNotFoundException, SQLException {
		SD.insertdata(s);
		return "records updated";
	}
	@DeleteMapping("delete/{id}")
	public String deleteRecord(@PathVariable int id) throws ClassNotFoundException, SQLException {
		SD.DeleteRecord(id);
		return "Record Deleted";
	}
	@PutMapping("update")
	public String update(@RequestBody Student s) throws ClassNotFoundException, SQLException {
		SD.update(s);
		return "Records updated";
		
	}
	
	
}
