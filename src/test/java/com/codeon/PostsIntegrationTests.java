package com.codeon;


import org.junit.runner.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.junit4.*;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CodeOnApplication.class)
@AutoConfigureMockMvc
public class PostsIntegrationTests {
//    private User testUser;
//    private HttpSession httpSession;
//
//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    UserRepo userDao;
//
//    @Autowired
//    PostRepo postsDao;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Before
//    public void setup() throws Exception {
//
//        testUser = userDao.findUserByUsername("testUser");
//
//        // Creates the test user if not exists
//        if(testUser == null){
//            User newUser = new User();
//            newUser.setUsername("testUser");
//            newUser.setPassword(passwordEncoder.encode("pass"));
//            newUser.setEmail("testUser@codeup.com");
//            testUser = userDao.save(newUser);
//        }
//
//        // Throws a Post request to /login and expect a redirection to the Ads index page after being logged in
//        httpSession = this.mvc.perform(post("/login").with(csrf())
//                .param("username", "testUser")
//                .param("password", "pass"))
//                .andExpect(status().is(HttpStatus.FOUND.value()))
//                .andExpect(redirectedUrl("/posts/show"))
//                .andReturn()
//                .getRequest()
//                .getSession();
//    }
//
//    //RUN TESTS TO TEST IF THE TEST WILL RUN
//    @Test
//    public void contextLoads() {
//        // Sanity Test, just to make sure the MVC bean is working
//        assertNotNull(mvc);
//    }
//
//    @Test
//    public void testIfUserSessionIsActive() throws Exception {
//        // It makes sure the returned session is not null
//        assertNotNull(httpSession);
//    }
//
//    @Test
//    public void testCreatePost() throws Exception {
//        // Makes a Post request to /posts/create and expect a redirection to the Ad
//        this.mvc.perform(
//                post("/posts/create").with(csrf())
//                        .session((MockHttpSession) httpSession)
//                        // Add all the required parameters to your request like this
//                        .param("title", "test")
//                        .param("body", "for sale"))
//                .andExpect(status().is3xxRedirection());
//    }
//
//    @Test
//    public void testShowPost() throws Exception {
//
//        Post existingPost = postsDao.findAll().get(0);
//
//        // Makes a Get request to /posts/{id} and expect a redirection to the Post show page
//        this.mvc.perform(get("/posts/" + existingPost.getId()))
//                .andExpect(status().isOk())
//                // Test the dynamic content of the page
//                .andExpect(content().string(containsString(existingPost.getBody())));
//    }
//
//    @Test
//    public void testPostsShow() throws Exception {
//        Post existingPost = postsDao.findAll().get(0);
//
//        // Makes a Get request to /posts/show and verifies that we get some of the static text of the ads/index.html template and at least the title from the first Ad is present in the template.
//        this.mvc.perform(get("/posts/show"))
//                .andExpect(status().isOk())
//                // Test the static content of the page
//                .andExpect(content().string(containsString("Latest Posts")))
//                // Test the dynamic content of the page
//                .andExpect(content().string(containsString(existingPost.getTitle())));
//    }
//
//    @Test
//    public void testEditPost() throws Exception {
//        // Gets the first Ad for tests purposes
//        Post existingPost = postsDao.findAll().get(postsDao.findAll().size() - 1);
//
//        // Makes a Post request to /posts/{id}/edit and expect a redirection to the Post show page
//        this.mvc.perform(
//                post("/posts/" + existingPost.getId() + "/edit").with(csrf())
//                        .session((MockHttpSession) httpSession)
//                        .param("title", "edited title")
//                        .param("body", "edited body"))
//                .andExpect(status().is3xxRedirection());
//        // Makes a GET request to /posts/{id} and expect a redirection to the Post show page
//        this.mvc.perform(get("/posts/" + existingPost.getId()))
//                .andExpect(status().isOk())
//                // Test the dynamic content of the page
//                .andExpect(content().string(containsString("edited title")))
//                .andExpect(content().string(containsString("edited body")));
//    }
//
//    @Test
//    public void testDeleteAd() throws Exception {
//        // Creates a test Ad to be deleted
//        this.mvc.perform(
//                post("/posts/create").with(csrf())
//                        .session((MockHttpSession) httpSession)
//                        .param("title", "post to be deleted")
//                        .param("body", "won't last long"))
//                .andExpect(status().is3xxRedirection());
//
//        // Get the recent Ad that matches the title
//        Post existingPost = postsDao.findPostByTitle("post to be deleted");
//
//        // Makes a Post request to /ads/{id}/delete and expect a redirection to the Ads index
//        this.mvc.perform(
//                delete("/posts//delete").with(csrf())
//                        .session((MockHttpSession) httpSession)
//                        .param("id", String.valueOf(existingPost.getId())))
//                .andExpect(status().is3xxRedirection());
//    }
}
