# SpringMidterm

Final Project initial summary
Library management system
Functionalities
In this project I will demonstrate how work librarian management system. My project will include for classes like book, library, client and order. Also there have User and Role classes. If say about each this domains:
Book:
public class Book extends AuditModel { @Column(name = "author")
private String author;

@Column(name = "genre") private String genre;

@Column(name = "name") private String name;

@Column(name = "price") private int price;

@ManyToOne
private Library library;
}

Library:
public class Library extends AuditModel{ @Column(name = "name")
private String name;

@Column(name = "address") private String address;

@Column(name = "phone_number") private String phoneNumber;

@Column(name = "city") private String city;

@Column(name = "state") private String state;
}
Client:
public class Client extends AuditModel {

@Column(name = "name") private String name;

@Column(name = "address") private String address;

@Column(name = "phone_number") private int phoneNumber;
}

Order:
public class Order extends AuditModel { @Column(name = "passed_date")
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Almaty")
private Date passedDate;

@Column(name = "passing_date")
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Almaty")
private Date passingDate;

@ManyToOne
private Book book;

@ManyToOne
private Client client;

@ManyToOne
private Library library;

}

DAOUser:
public class DAOUser extends AuditModel{
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    @JsonIgnore
    private String password;
    @Column(name = "role")
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}





UserDTO:

public class UserDTO {
    private String username;
    private String password;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


In this project we will can find some books by id, by Author, by Genre, by Name, by Price and so on. Also we add or find books in many libraries by this information,
Moreover, we can add, delete, update, or find some information about Clients, Libraries and Orders. To take this information I will use API for methods, and it will be checked by Postman or Swagger.
Also there have registration and authorization which work with spring Security, it is gives us JWT Token to authorize the project. 


