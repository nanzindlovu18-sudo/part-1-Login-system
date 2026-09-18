class Login {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String cellPhoneNumber;
    private boolean loginStatus;

    public Login(String firstName, String lastName, String username,
                 String password, String cellPhoneNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity() {

        if (password.length() < 8) {
            return false;
        }

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {

            char character = password.charAt(i);

            if (Character.isUpperCase(character)) {
                hasCapital = true;
            }

            if (Character.isDigit(character)) {
                hasNumber = true;
            }

            if (!Character.isLetterOrDigit(character)) {
                hasSpecial = true;
            }
        }

        return hasCapital && hasNumber && hasSpecial;
    }

    public boolean checkCellPhoneNumber() {
        return cellPhoneNumber.matches("^\\+27\\d{9}$");
    }

    public String registerUser() {

        if (!checkUserName()) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber()) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }

        return "Username successfully captured.";
    }

    public boolean loginUser(String enteredUsername, String enteredPassword) {

        loginStatus = enteredUsername.equals(username)
                && enteredPassword.equals(password);

        return loginStatus;
    }

    public String returnLoginStatus() {

        if (loginStatus) {
            return "Welcome " + firstName + " " + lastName
                    + ", it is great to see you again.";
        }

        return "Username or password incorrect, please try again.";
    }
}


public class Main {

    public static void main(String[] args) {

        Login user = new Login(
            "Kyle",
            "Smith",
            "KY1_1",
            "Ch&&sec@ke99!",
            "+27838968976"
        );

        System.out.println("===== REGISTRATION TEST =====");

        System.out.println("Username valid: " + user.checkUserName());
        System.out.println("Password valid: " + user.checkPasswordComplexity());
        System.out.println("Cell phone valid: " + user.checkCellPhoneNumber());

        System.out.println(user.registerUser());

        System.out.println();
        System.out.println("===== LOGIN TEST =====");

        boolean result = user.loginUser(
            "wrong",
            "wrong password"
        );

        System.out.println("Login successful: " + result);
        System.out.println(user.returnLoginStatus());
    }
}