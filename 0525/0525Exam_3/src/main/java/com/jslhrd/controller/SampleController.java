package com.jslhrd.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jslhrd.domain.SampleDTO;
import com.jslhrd.domain.TodoDTO;

@Controller
@RequestMapping("/sample/")
public class SampleController{
	private static final Logger log = LoggerFactory.getLogger(SampleController.class);
	
	
	@RequestMapping("aaa")
	public void basic3() {
		log.info("basic222() test .....");
		

	}
	
	
	@GetMapping("board_write")
	public void basic() {
		log.info("basic44() test .....");
	}
	
	@PostMapping("board_write")
	public void basic2() {
		log.info("basic44() test .....");
	}
	
	
	@GetMapping("ex01")
	public String ex01(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("SampleDTO" + dto);
		log.info("page" + page);
		return "ex01";
	}
	
	@GetMapping("exRedirect")
	public String exRedirect(RedirectAttributes rttr) {
		SampleDTO dto =new SampleDTO();
		dto.setAge(14);
		dto.setName("aaa");
		rttr.addFlashAttribute("page", 10);
		rttr.addFlashAttribute("sampleDTO", dto);
		return "redirect:/sample/ex01";
	}
	
	@GetMapping("ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam int age) {
		log.info("name:" + name + ", age:" +  age);
		return "ex02";
	}

	@GetMapping("ex02List")
	public String ex02List(@RequestParam("ids") List<String> list) {
		log.info("list : " + list);
		return "ex02List";
	}
	
	@GetMapping("ex02ArrayList")
	public String ex02ArrayList(@RequestParam("ids") ArrayList<String> alist) {
		log.info("Arraylist : " + alist);
		return "ex02List";
	}
	
	@GetMapping("ex02String")
	public String ex02ArrayList(@RequestParam("ids") String[] str) {
		log.info("String[] : " + Arrays.toString(str));
		return "ex02List";
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@GetMapping("ex03")
	public String ex01(TodoDTO dto) {
		log.info("TodoDTO: " + dto);
		return "ex03";
	}
	
	@GetMapping("exModel")
	public String ex04(Model model, SampleDTO dto, @RequestParam("money") int money) {
		
		List<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("이길동");
		list.add("강길동");
		list.add("박길동");
		list.add("우길동");
		
		model.addAttribute("list", list);
		//model.addAttribute("dto", dto);
		
		log.info("model:" +  model);
		log.info("list:" +  list);
		log.info("dto:" + dto);
		
		return "exModel";
	}
	
	@GetMapping("ex05")
	public @ResponseBody SampleDTO ex05() {
		log.info("ex05().....");
		
		SampleDTO dto = new SampleDTO();
		dto.setName("aaa");
		dto.setAge(20);
		
		return dto;
	}
	
	//등록폼
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload()..........");
	}
	
	//등록처리
	@PostMapping("/exUploadPro")
	public String exUploadPro(ArrayList<MultipartFile> files) {
		log.info("/exUploadPro()...............");
		files.forEach(file -> {
			log.info("---------------------------------------");
			log.info("name" + file.getOriginalFilename());
			log.info("size" + file.getSize());
		});
		return "test";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
