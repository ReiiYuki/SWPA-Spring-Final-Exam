package com.voraton.finalexam.database;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class PatternJDCBCTemplate implements PatternDAO{
	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public void create(String name, String group, String imp) {
		String SQL = "insert into pattern (p_name, p_group, p_imp) values (?, ?, ?)";
		jdbcTemplateObject.update( SQL, name, group, imp);
	}
	
	public Pattern getPattern(Integer id) {
		String SQL = "select * from pattern where id = ?";
		Pattern pattern = jdbcTemplateObject.queryForObject(SQL,
				new Object[]{id}, new PatternMapper());
		return pattern;
	}
	
	public List<Pattern> listPatterns() {
		String SQL = "select * from pattern";
		List <Pattern> patterns = jdbcTemplateObject.query(SQL,
				new PatternMapper());
		return patterns;
	}
	
	public void delete(Integer id){
		String SQL = "delete from pattern where id = ?";
		jdbcTemplateObject.update(SQL, id);
	}
	
	public void update(Integer id, String name, String group, String imp ){
		String SQL = "update pattern set p_name = ?, p_group = ?, p_imp = ? where id = ?";
		jdbcTemplateObject.update(SQL, name, group, imp, id);
		return;
	}
}
