<h1>Step 1: </h1>
<p>Create a Spring boot project of type Spring web (enables MVC)</p>

<h2>Step 2: </h2>
<p>Create a webapp folder within src/main where we store our jsp files</p>

<h1>Step 3: </h1>
<p>We require controller classes which manage requests and responses, create HomeController.java which is used to call home</p>

            @RequestMapping("/")
        public String home(){
            System.out.println("home called");
            return "index.jsp";
        }

<h1>Step 4: </h1>
<p>Make sure to add tomcat jasper which helps converting jsp to servlets and show on the browser, else it will download the jsp files on hitting the url</p> <br />
<p> Jasper version should be same as tomcat version</p>

<h1>Step 5: </h1>
<p>Creating a form which takes 2 numbers and adds them</p>

    <form action="add">
        Enter 1st number: <input type="number" name="num1" />
        Enter 2nd number: <input type="number" name="num2" />
        <input type="submit" />
    </form>

<h1>For simplicity purposes add RequestMapping for add in homecontroller itself</h1>

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
