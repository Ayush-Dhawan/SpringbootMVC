package org.springjdbc.springmvcboot;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/getOne")
    public ModelAndView getStudentById(ModelAndView mv, @RequestParam("id") int id){
//        mv.setViewName("getOne");
        mv.addObject("result", repo.getOne(id));

        return mv;
    }

    @PostMapping("/addStudent")
    public ModelAndView addStudent(@ModelAttribute Student student, ModelAndView model) {
        try {
            // Attempt to save the student
            repo.save(student);

            // Add success message and redirect to the success page or student list
            model.addObject("message", "Student added successfully!");
            return model;  // Assuming you have a 'students' endpoint to show the list

        } catch (DataAccessException e) {
            // Handle database-related exceptions here (e.g., issues with saving)
            model.addObject("error", "Error saving student: " + e.getMessage());
            e.printStackTrace();  // For debugging purposes, log the error

            return model;  // Return to an error page with the error message
        } catch (Exception e) {
            // Catch any other unexpected exceptions
            model.addObject("error", "An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();  // For debugging purposes, log the error

            return model;  // Return to an error page with the error message
        }
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
