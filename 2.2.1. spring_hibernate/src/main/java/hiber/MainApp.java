package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("mazda", 123)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("audi", 123)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("opel", 123)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("porshe", 123)));

      userService.listUsers().forEach(System.out::println);
      System.out.println("___Search by Auto___");
      System.out.println(userService.getUserByAutoProps("opel", 123));
      context.close();
   }
}
