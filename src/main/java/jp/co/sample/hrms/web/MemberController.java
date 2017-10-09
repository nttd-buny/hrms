package jp.co.sample.hrms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.co.sample.hrms.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping("/member")
	public String getMember(@RequestParam(name = "id", required = false) long id,
			@RequestParam(name = "name", required = false) String name) {
		return this.memberService.getMember(id, name).getName();
	}

}
