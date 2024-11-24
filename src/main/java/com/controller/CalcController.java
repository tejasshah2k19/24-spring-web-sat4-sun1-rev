package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.AddBean;

@Controller
public class CalcController {

	// method -> jsp open ->

	@GetMapping("add") // url
	public String openAdd() {
		return "Add";// jsp name
	}

	@PostMapping("addition")
	public String addOperation(@Validated AddBean obj, BindingResult result, Model model) {
		// read form input
		// getParameter

		if (result.hasErrors()) {
			model.addAttribute("result",result);
//			System.out.println(result.getFieldError("n1").getDefaultMessage());
			
			return "Add";
		}
		System.out.println(obj.getN1());
		System.out.println(obj.getN2());
		System.out.println(obj.getChoice());

		Integer ans = 0;

		if (obj.getChoice().equals("add")) {
			ans = obj.getN1() + obj.getN2();
		} else if (obj.getChoice().equals("sub")) {
			ans = obj.getN1() - obj.getN2();
		} else if (obj.getChoice().equals("mul")) {
			ans = obj.getN1() * obj.getN2();
		} else if (obj.getChoice().equals("div")) {
			ans = obj.getN1() / obj.getN2();
		}
		// controller -> jsp -> data -> send { ui Model }
		model.addAttribute("ans", ans);
		return "Result";
	}

}
