<h1>Step 1: </h1>
<p>Add this dependancy</p>

         <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
            <version>3.3.3</version>
        </dependency>

<h1>Step 2: </h1>
<p>Create a repository constructor for students called StudentRepo</p> <br />
<p>It must be an interface which extends JpaRepository</p>

        package org.springjdbc.springmvcboot;
        import org.springframework.data.jpa.repository.JpaRepository;

        public interface StudentRepo extends JpaRepository<Student, Integer> {

        }

<p>JpaRepository comes fom the library we added earlier and it contains alot of inbuilt methods such as findAll()</p>

<h1>Step 3: </h1>
<p>In the homeController create an object of student repo</p>

         @Autowired
         StudentRepo repo;

<h1>Step 4: </h1>
<p>Try using the default findAll method without any implementation written by you to find that it actually works!</p>

    @GetMapping("/getAll")
    public ModelAndView getStudents(ModelAndView mv){
        mv.setViewName("getAll");
        mv.addObject("db_data", repo.findAll());

        return mv;
    }
<p>This is why spring-boot-starter-data-jpa is such a deal breaker</p> <br />
<p>It implements the commonly used methods such as findAll and findById on its own.</p>

