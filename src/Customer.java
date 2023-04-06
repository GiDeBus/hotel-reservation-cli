import java.util.regex.Pattern;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private final String emailRegex = "^(.+)@(.+).com$";
    private final Pattern pattern = Pattern.compile(emailRegex);

    public Customer(String firstName, String lastName, String email) {
        if(!pattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fistName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(!pattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        this.email = email;
    }
    @Override
    public String toString() {
        return " firstName: " + firstName + " lastName: " + lastName + " email: " + email;
    }
}
