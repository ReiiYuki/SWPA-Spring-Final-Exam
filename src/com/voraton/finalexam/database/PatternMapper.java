package com.voraton.finalexam.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PatternMapper implements RowMapper<Pattern>{
	public Pattern mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pattern pattern = new Pattern();
		pattern.setId(rs.getInt("id"));
		pattern.setName(rs.getString("p_name"));
		pattern.setGroup(rs.getString("p_group"));
		pattern.setImp(rs.getString("p_imp"));
		return pattern;
	}
}
