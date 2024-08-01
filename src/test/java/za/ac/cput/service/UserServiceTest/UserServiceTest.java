package za.ac.cput.service.UserServiceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Name;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.service.UserService.UserService;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.class)
public class UserServiceTest {
   @Autowired
   private UserService userService;

   private User user1;
   private User user2;
   private User user3;

   @BeforeEach
   void setUp(){
      Name name1 = new Name.NameBuilder().setFirstName("Sipho")
              .setMiddleName("Sethu")
              .setLastName("Makhambeni")
              .build();
      Name name2 = new Name.NameBuilder().setFirstName("William")
              .setMiddleName("Siips")
              .setLastName("Belic")
              .build();
      Name name3 = new Name.NameBuilder().setFirstName("Franklin")
              .setMiddleName("Andre")
              .setLastName("Clinton")
              .build();

      Contact contact1 = new Contact.Builder()
              .setEmail("Makhambenisethu@gmail.com")
              .setPhoneNumber("0782126539")
              .build();
      Contact contact2 = new Contact.Builder()
              .setEmail("WiSiBE@gmail.com")
              .setPhoneNumber("0713146034")
              .build();
      Contact contact3 = new Contact.Builder()
              .setEmail("fc11gtav@gmail.com")
              .setPhoneNumber("0657728901")
              .build();


      user1 = UserFactory.buildUser(1L,name1,"Male", LocalDate.of(2000,07,02),"password",contact1);
      user2 = UserFactory.buildUser(2L,name2,"Female",LocalDate.of(2002,02,05),"1L0v3u",contact2);
      user3 = UserFactory.buildUser(3L,name1,"Male",LocalDate.of(1990,01,22),"securepassword",contact3);


   }
   @Test
   void create(){
      System.out.println("======CREATE=====");
      User createdUser = userService.save(user1);
      assertNotNull(createdUser);
      System.out.println(createdUser);

      User createdUser2 = userService.save(user2);
      assertNotNull(createdUser2);
      System.out.println(createdUser2);

      User createdUser3 = userService.save(user3);
      assertNotNull(createdUser3);
      System.out.println(createdUser3);
   }
   @Test
   @Order(2)
   void read(){
      User readUser = userService.read(user1.getUserId());
      System.out.println(readUser);
      assertNotNull(readUser);
      System.out.println(readUser);

      User readUser2 = userService.read(user2.getUserId());
      System.out.println(readUser2);
      assertNotNull(readUser2);
      System.out.println(readUser2);

      User readUser3 = userService.read(user3.getUserId());
      System.out.println(readUser3);
      assertNotNull(readUser3);
      System.out.println(readUser3);
   }
   @Test
   @Order(3)
   void update(){
      System.out.println("======UPDATE======");

      User updatedUser = new User.UserBuilder().copy(user3).setPassword("P@$$W0rd").build();
      User savedUser = userService.save(updatedUser);
      assertNotNull(savedUser);
      System.out.println(savedUser);
   }
   @Test
   @Order(4)
   void deleteById(){
      boolean deleted = userService.deleteById(user2.getUserId());
      assertTrue(deleted);
      System.out.println("User Deleted");
   }

   @Test
   @Order(5)
   void getAll(){
      List<User> userList = userService.getAll();
      assertNotNull(userList);
      System.out.println(userList);
   }
}
