package peaksoft;

import org.junit.Assert;
import org.junit.Test;
import org.peaksoft.model.User;
import org.peaksoft.service.UserService;
import org.peaksoft.service.UserServiceImpl;

import java.util.List;

public class UserServiceTest {

    private final UserService userService = new UserServiceImpl();

    private final String testName = "Kanat";
    private final String testLastName = "Subanov";
    private final byte testAge = 23;

    @Test
    public void dropUsersTable() {
        try {
            userService.dropUsersTable();
            userService.dropUsersTable();
        } catch (Exception e) {
            Assert.fail("Pri testirovanii udalenia tablicy proizoshlo iskliuchenie\n" + e);
        }
    }

    @Test
    public void createUsersTable() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
        } catch (Exception e) {
            Assert.fail("Pri testirovanii sozdanii tablicy polzovotelei proizoshlo iskliuchenie\n" + e.getMessage());
        }
    }

    @Test
    public void saveUser() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(testName, testLastName, testAge);

            User user = userService.getAllUsers().get(0);

            if (!testName.equals(user.getName())
                    || !testLastName.equals(user.getLastName())
                    || testAge != user.getAge()
            ) {
                Assert.fail("User byl ne korrektno dobavlen v bazy dannyh");
            }

        } catch (Exception e) {
            Assert.fail("Vo vremia testirovania cohranenia polzovotelia proizoshlo iskliuchenie\n" + e);
        }
    }

    @Test
    public void removeUserById() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(testName, testLastName, testAge);
            userService.removeUserById(1L);
        } catch (Exception e) {
            Assert.fail("Pri testirovanii udalenia polzovotelia po id proizoshlo iskliuchenie\n" + e);
        }
    }

    @Test
    public void getAllUsers() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(testName, testLastName, testAge);
            List<User> userList = userService.getAllUsers();

            if (userList.size() != 1) {
                Assert.fail("Proverte korrektnost raboty metoda cohranenia polzovotelia/udalenia ili sozdania tablicy");
            }
        } catch (Exception e) {
            Assert.fail("Pri popytke dostat vseh polzovatelei iz bazy dannyx proizoshlo iskliuchenie\n" + e);
        }
    }

    @Test
    public void cleanUsersTable() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(testName, testLastName, testAge);
            userService.cleanUsersTable();

            if (userService.getAllUsers().size() != 0) {
                Assert.fail("Metod ochishenie tablicy polzovatelei realizovan ne korrektno");
            }
        } catch (Exception e) {
            Assert.fail("Pri testirovanii ochistki tablicy polzovatelei proizoshlo iskliuchenie\n" + e);
        }
    }
}