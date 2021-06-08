import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World..!!");

        ApplicationContext context = new ClassPathXmlApplicationContext("ormconfig.xml");

        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        Student student = new Student();
        student.setId(3);
        student.setName("Shekhar");
        student.setAddress("Pune");

        studentDao.insert(student);

        System.out.println(studentDao.getStudent(2));

        studentDao.getStudents().stream().forEach(System.out::println);

        studentDao.delete(3);

    }
}
