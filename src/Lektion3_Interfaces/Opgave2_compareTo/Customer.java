package Lektion3_Interfaces.Opgave2_compareTo;

public class Customer implements Comparable<Customer>{

    String firstName;
    String lastName;
    int age;


    /**
     * Compares the customer with another Customer Object
     * It overrides Object.compareTo, not String.compareTo,
     * which caused me some confusion at first, with the name.compareTo calls
     * The task is to make it compare for duplicate LastName,
     * and if it's identical, try again for FirstName, and then age.
     * @param otherCustomer the object to be compared.
     * @return the value 0 if identical, or negative/positive number depending on lexicography
     */
    @Override
    public int compareTo(Customer otherCustomer) {

        // Compare last name
        int lastNameComparison = this.lastName.compareTo(otherCustomer.lastName);
        if(lastNameComparison != 0){
            return lastNameComparison; //if the last name is not the same, return the negative/positive int
        }

        // Compare first name
        int firstNameComparison = this.firstName.compareTo(otherCustomer.firstName);
        if(firstNameComparison != 0){
            return firstNameComparison;
        }

        // Compare age
        int ageComparison = Integer.compare(this.age, otherCustomer.age);
        if(ageComparison != 0){
            return ageComparison;
        }

        //All fields are identical, therefore return that the two Customers are duplicate (the same person)
        return 0;
    }

    @Override
    public String toString(){
        return firstName + " " + lastName + " - " + age + " Years old";
    }

    // region Constructor - Get - Set
    public Customer(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    //endregion
}
