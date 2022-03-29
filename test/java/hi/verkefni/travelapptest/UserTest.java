package hi.verkefni.travelapptest;

import hi.verkefni.travelapp.User;
import hi.verkefni.travelapp.UserController;
import org.junit.*;

import static org.junit.Assert.*;


public class UserTest {
    private UserController userController;

    @Before
    public void setUp() {
        userController = new UserController();
        User user1 = new User("Gertrude Lastname",
                        "gertrude.lastname@aol.com", "password123");
        User user2 = new User("Geirþrúður Eftirnafn",
                "geirthrudur.eftirnafn@simnet.is", "lykilord123");
        userController.create(user1);
        userController.create(user2);
    }

    @Test
    public void searchTest() {
        User gertrude = userController.searchUser("Gertrude Lastname");
        assertNotNull(gertrude);
    }

    @Test
    public void emailTest() {
        User gertrude = userController.searchUser("Gertrude Lastname");
        assertEquals("gertrude.lastname@aol.com", gertrude.getEmail());
    }

    @Test
    public void passwordTest() {
        User geirthrudur = userController.searchUser("Geirþrúður Eftirnafn");
        assertEquals("lykilord123", geirthrudur.getPassword());
    }

    @Test
    public void changeEmailTest() {
        User geirthrudur = userController.searchUser("Geirþrúður Eftirnafn");
        geirthrudur.setEmail("jerry.seinfeld@simnet.is");
        User otherGeirthrudur = userController.searchUser("Geirþrúður Eftirnafn");
        assertEquals("jerry.seinfeld@simnet.is", otherGeirthrudur.getEmail());
    }

    @Test
    public void changePasswordTest() {
        User geirthrudur = userController.searchUser("Geirþrúður Eftirnafn");
        geirthrudur.setPassword("superduperpassword");
        User otherGeirthrudur = userController.searchUser("Geirþrúður Eftirnafn");
        assertEquals("superduperpassword", otherGeirthrudur.getPassword());
    }

    @Test
    public void deleteTest() {
        User user = userController.searchUser("Geirþrúður Eftirnafn");
        userController.delete(user);
        user = userController.searchUser("Geirþrúður Eftirnafn");
        assertNull(user);
    }

    @After
    public void tearDown() {
        userController = null;
    }
}
