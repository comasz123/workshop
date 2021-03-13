import org.apache.commons.validator.routines.EmailValidator;

public class MainMenuControl {

    public void deleteUser() {
        UserDao userDao = new UserDao();

        userDao.countUsers();
        int limit = userDao.lastIdValue();
        int id = KeyboardReader.readInt(limit, "Podaj id użytkownika:");

        userDao.displayName(id);
        userDao.delete(id);

    }

    public void listUsers() {
        UserDao userDao = new UserDao();

        User[] users = userDao.findAll();
        System.out.println("--------------------");
        for (User user : users) {
            System.out.println(user.userToString());
        }
        System.out.println("--------------------");

    }

    public void createUser() {
        UserDao userDao = new UserDao();
        boolean validate = true;
        String email = null;

        System.out.println("Podaj imię i nazwisko:");
        String name = KeyboardReader.readString();

        while (validate) {
            System.out.println("Podaj email:");
            email = KeyboardReader.readString();
            if (emailValidator(email)) {
                validate = false;
            } else {
                System.out.println("to nie jest adres email");
            }

        }

        System.out.println("Podaj hasło");
        String password = KeyboardReader.readString();
        String pw_hash = BCrypt.hashpw(password, BCrypt.gensalt());
        userDao.add(name, pw_hash, email);
        System.out.println("--------------------");
        System.out.println("Dodano nowego użytkownika:");
        System.out.println(name);
        System.out.println("--------------------");
    }

    public void editUser() {
        UserDao userDao = new UserDao();
        boolean validate = true;

        userDao.countUsers();
        int limit = userDao.lastIdValue();
        int pickUser = KeyboardReader.readInt(limit, "Podaj ID użytkownika:");
        if (!userDao.haveSuchUser(pickUser)) {
            System.out.println("Nie ma takiego użytkownika");
        } else {
            System.out.println("Edytujemy użytkownika: " + pickUser);
            System.out.println("Podaj imię i nazwisko:");
            String newName = KeyboardReader.readString();
            String newEmail=null;
            while (validate) {
                System.out.println("Podaj email:");
                newEmail = KeyboardReader.readString();
                if (emailValidator(newEmail)) {
                    validate = false;
                } else {
                    System.out.println("to nie jest adres email");
                }
            }

            userDao.edit(pickUser, newName, newEmail);

            System.out.println("--------------------");
            System.out.println("Dane użytkownika " + newName + " zostały zmienione");

            System.out.println("--------------------");
        }

    }

    public void logUser() {
        UserDao userDao = new UserDao();

        userDao.countUsers();
        int limit = userDao.lastIdValue();
        int id = KeyboardReader.readInt(limit, "Podaj id użytkownika:");

        System.out.println("Podaj hasło");
        String password = KeyboardReader.readString();
        String stored_hash = userDao.returnPassword(id);
        if (BCrypt.checkpw(password, stored_hash)) {
            System.out.println("użytkownik zalogowany");
        } else {
            System.out.println("Niepoprawne hasło");

        }
    }

    public void reindexUsers() {
        UserDao userDao = new UserDao();

        User[] users = userDao.findAll();
        userDao.delete_table();
        userDao.redoUsers(users);

    }

    public boolean emailValidator(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        if (validator.isValid(email)) {
            return true;
        }
        return false;
    }
}
