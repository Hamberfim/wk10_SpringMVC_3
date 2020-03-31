package dmacc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dmacc.beans.Student;
import dmacc.repository.StudentDAO;

@Controller
public class StudentApplicationController {
	
	@Autowired
	private StudentDAO dao;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
	    List<Student> listStudent = dao.list();
	    model.addAttribute("listStudent", listStudent);
	    return "index";
	}
	
	
	@RequestMapping("/new")
	public String showNewForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "new_form";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("student") Student student) {
		dao.save(student);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditForm(@PathVariable(name="id") int id) {
		ModelAndView mav = new ModelAndView("edit_form");
		Student student = dao.get(id);
		mav.addObject("student", student);
		return mav;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("student") Student student) {
		dao.update(student);
		return "redirect:/";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(name="id") int id) {
		dao.delete(id);
		return "redirect:/";
	}

}
