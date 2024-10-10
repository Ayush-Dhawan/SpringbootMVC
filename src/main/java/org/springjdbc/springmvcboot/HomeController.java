package org.springjdbc.springmvcboot;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    StudentRepo repo;

    @RequestMapping("/")
    public String home(){
        System.out.println("home called");
        return "index";
    }

    @GetMapping("/getAll")
    public ModelAndView getStudents(ModelAndView mv){
        mv.setViewName("getAll");
        mv.addObject("db_data", repo.findAll());

        return mv;
    }

    //without post method declaration and just having "add", it worked with both get and post or use PostMapping annotation
    @RequestMapping(value="add", method = RequestMethod.POST)
    public ModelAndView add(HttpServletRequest request, @RequestParam("num1") int i,@RequestParam("num2") int j){
//        int i = Integer.parseInt(request.getParameter("num1"));
//        int j = Integer.parseInt(request.getParameter("num2"));
//        HttpSession session = request.getSession();
//        session.setAttribute("sum", i+j);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("add");
        mv.addObject("sum", i + j);
        return mv;
    }
}
