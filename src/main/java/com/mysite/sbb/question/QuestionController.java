package com.mysite.sbb.question;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import lombok.RequiredArgsConstructor;
import com.mysite.sbb.answer.AnswerForm;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;
import java.security.Principal;
import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.user.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.access.prepost.PreAuthorize;


@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;
    private final UserService userService;
    
    @PreAuthorize("isAuthenticated()")
	@GetMapping("/list")
	public String list(Model model,@RequestParam(defaultValue="0") int page) {
		Page<Question> paging = this.questionService.getList(page);
        model.addAttribute("paging", paging);
//		List<Question> questionList = this.questionService.getList();
//		model.addAttribute("questionList", questionList);
		return "question_list";
	}
	
    @PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable Integer id, AnswerForm answerForm) {
		Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
		return "question_detail";
    }
	
	@GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }
	
	@PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        SiteUser siteUser = this.userService.getUser(principal.getName());
        this.questionService.create(questionForm.getSubject(), questionForm.getContent(), siteUser);
        return "redirect:/question/list";
	}
}
