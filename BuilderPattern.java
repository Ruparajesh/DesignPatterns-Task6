package Task5.DesignPatterns;
public class BuilderPattern 
{
   
    private final String firstName; 
    private final String lastName; 
    private final int age; // optional
    private final String phone; // optional
    private final String address; // optional
 
    private BuilderPattern (UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }
 
    //All getter, and NO setter to provde immutability
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
 
    @Override
    public String toString() {
        return "User: "+this.firstName+", "+this.lastName+", "+this.age+", "+this.phone+", "+this.address;
    }
 
    public static class UserBuilder 
    {
        private final String firstName;
        private final String lastName;
        private int age;
        private String phone;
        private String address;
 
        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }
        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }
        //Return the finally consrcuted User object
        public BuilderPattern   build() {
        	BuilderPattern  user =  new BuilderPattern (this);
            validateUserObject(user);
            return user;
        }
        private void validateUserObject(BuilderPattern  user) {
            //Do some basic validations to check 
            //if user object does not break any assumption of system
        }
    }
public static void main(String[] args) {
	BuilderPattern  user1 = new BuilderPattern .UserBuilder("Rupa", "Mallempati")
    .age(20)
    .phone("1234567")
    .address("Fake address 1234")
    .build();
 
    System.out.println(user1);
 
    BuilderPattern  user2 = new BuilderPattern .UserBuilder("Sai", "Tumu")
    .age(40)
    .phone("5655")
    //no address
    .build();
 
    System.out.println(user2);
 
    BuilderPattern  user3 = new BuilderPattern .UserBuilder("Prathima", "Yarasani")
    //No age
    //No phone
    //no address
    .build();
 
    System.out.println(user3);
}
}