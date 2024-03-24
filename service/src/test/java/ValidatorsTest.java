import by.nikolay.Validators;

public class ValidatorsTest {

    public static void main(String[] args) {

        String password = "Asshole";
        char[] pass = password.toCharArray();

        System.out.println(Validators.isValidEmail("virusss1990@gmail.com"));
        System.out.println(Validators.isValidPassword(pass));
    }
}
