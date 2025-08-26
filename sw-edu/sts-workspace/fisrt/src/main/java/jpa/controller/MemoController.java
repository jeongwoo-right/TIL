package jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jpa.entity.Memos;
import jpa.service.MemoService;

@RestController
public class MemoController {

	@Autowired
	MemoService memoService;
	
	@RequestMapping("/inputmemo")
	List<Memos> input(@RequestParam("username") String username, @RequestParam("title") String title, @RequestParam("contents") String contents) {
		return memoService.input(username, title, contents);
	}
	
	
	@RequestMapping("/outputmemo")
	List<Memos> output(@RequestParam("username") String username) {
		return memoService.output(username);
	}
}
