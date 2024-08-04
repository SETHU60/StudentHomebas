package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Name;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    final String BASE_URL = "http://localhost:8080/StudentHomeBas/user";

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
    void b_create(){
        String url = BASE_URL + "/save";

        System.out.println(user1);
        ResponseEntity<User> postResponse1 = restTemplate.postForEntity(url,user1, User.class);
        assertNotNull(postResponse1);
        assertNotNull(postResponse1.getBody());
        System.out.println("saved User: " + postResponse1.getBody());



        System.out.println(user2);
        ResponseEntity<User> postResponse2 = restTemplate.postForEntity(url,user2, User.class);
        assertNotNull(postResponse2);
        assertNotNull(postResponse2.getBody());
        System.out.println("saved User: " + postResponse2.getBody());



        System.out.println(user3);
        ResponseEntity<User> postResponse3 = restTemplate.postForEntity(url,user3, User.class);
        assertNotNull(postResponse3);
        assertNotNull(postResponse3.getBody());
        System.out.println("saved User: " + postResponse3.getBody());
    }
    @Test
    @Order(2)
    void c_read(){
        String url = BASE_URL + "/read" + user1.getUserId();

        System.out.println(user1.getUserId());

        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
        assertNotNull(response);
        User user = response.getBody();
        assertNotNull(user);
        assertEquals(user.getUserId(), user1.getUserId());
        System.out.println("Read User: " + user);

    }

    @Test
    @Order(3)
    void d_update(){
        String url = BASE_URL + "/update";

        User updatedUser = new User.UserBuilder().copy(user2).setPassword("P@$$W0rd").build();
        ResponseEntity<User> postResponse = restTemplate.postForEntity(url, updatedUser, User.class);
        assertNotNull(postResponse);
        User user = postResponse.getBody();
        assertNotNull(user);
        assertEquals(user.getUserId(), user2.getUserId());
        System.out.println("Read User: " + user);

    }

    @Test
    @Order(4)
    void e_delete(){
        String url = BASE_URL + "/delete" + user3.getUserId();

        restTemplate.delete(url);
        System.out.println("Deleted Account: " + user3);
    }
    @Test
    @Order(5)
    void f_getAll(){
        String url = BASE_URL + "/getAll";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        assertNotNull(response.getBody());
        System.out.println("Users found:" + response.getBody());
    }


}
