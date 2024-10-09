package org.springjdbc.springmvcboot;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(){
        System.out.println("home called");
        return "index.jsp";
    }

    @RequestMapping("add")
    public ModelAndView add(HttpServletRequest request, @RequestParam("num1") int i,@RequestParam("num2") int j){
//        int i = Integer.parseInt(request.getParameter("num1"));
//        int j = Integer.parseInt(request.getParameter("num2"));
//        HttpSession session = request.getSession();
//        session.setAttribute("sum", i+j);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("add.jsp");
        mv.addObject("sum", i + j);
        return mv;
    }
}
