package com.voraton.finalexam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.voraton.finalexam.database.Pattern;
import com.voraton.finalexam.database.PatternJDCBCTemplate;


@Controller
@RequestMapping("/")
public class AppController {
	
	// Wired to StudentJDBCTemplate in AppConfig
	@Autowired
	private PatternJDCBCTemplate patternJDBCTemplate;
	
	// Home Mapping
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String homePage() {
		return "home";
	}
	
	// Add new student get mapping
	@GetMapping(value = { "/addNewPattern"})
	public ModelAndView addNewStudentForm() {
		Pattern pattern = new Pattern();
		return new ModelAndView("addNewPattern", "pattern", pattern);
	}
	
	// Add new student post mapping
	@PostMapping(value = { "/addNewPattern"})
	public ModelAndView addNewPatternSubmit(@ModelAttribute("pattern") Pattern pattern,ModelMap model) {
		boolean isValid = ( !pattern.getName().isEmpty() && !pattern.getGroup().isEmpty() && !pattern.getImp().isEmpty() ) ? true : false;
		if( isValid ) {
			pattern.setId(patternJDBCTemplate.listPatterns().size() + 1);
			patternJDBCTemplate.create(pattern.getName(), pattern.getGroup(), pattern.getImp());
			return patternsListPage(model.addAttribute("message", "Successfully Add New Pattern"));
		}
		return new ModelAndView("addNewPattern", "message", "Invalid inputs!");
	}
	
	@GetMapping(value = { "/viewPatterns"})
	public ModelAndView patternsListPage(ModelMap model) {
		Map<String, List<Pattern>> patterns = new HashMap<String, List<Pattern>>();
		patterns.put("patterns", patternJDBCTemplate.listPatterns());

		return new ModelAndView("viewPatterns", patterns);
	}
	
	@GetMapping("/editPattern/{id}")
	public ModelAndView editStudentPage(@PathVariable Integer id) {
		Pattern pattern = patternJDBCTemplate.getPattern(id);
		return new ModelAndView("editPattern", "pattern", pattern);
	}
	
	@PostMapping("/editPattern/{id}")
	public ModelAndView editStudentSubmit(@ModelAttribute Pattern pattern, ModelMap model) {
		patternJDBCTemplate.update(pattern.getId(), pattern.getName(), pattern.getGroup(), pattern.getImp());
		return patternsListPage(model.addAttribute("message", "Successfully edited pattern"));
	}
	
	@PostMapping("deletePattern/{id}")
	public ModelAndView deleteStudent(@PathVariable Integer id, ModelMap model) {
		patternJDBCTemplate.delete(id);
		return patternsListPage(model);
	}
	
}
