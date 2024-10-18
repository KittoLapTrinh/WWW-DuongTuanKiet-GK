## Hi I'm Kitto <img src="https://user-images.githubusercontent.com/1303154/88677602-1635ba80-d120-11ea-84d8-d263ba5fc3c0.gif" width="28px" height="28px" alt="hi">

# 💻 Công nghệ và công cụ sử dụng
[![Java Badge](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](#) [![Bootstrap Badge](https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white)](#) [![Mariadb Badge](https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=white)](#) [![IDEA Badge](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)](#) ![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)

### Class diagram
![image](https://github.com/user-attachments/assets/71ba9bf9-a9d9-4e05-9552-e87f7f077ba6)

### Database diagram
![database-diagram](https://github.com/user-attachments/assets/f56276b1-2993-4a5b-86f2-3d67185ef077)

#### 1. Ánh xạ các thực thể vào mô hình trên sử dụng JPA
##### Candidate
```
@Entity(name = "candidates")
@Table(name = "candidates")
@NamedQueries({
        @NamedQuery(name = "candidate.findCandidateByRole", query = "SELECT c from candidates c inner join experiences e on c.id = e.candidate.id where e.role = :role"),
        @NamedQuery(name= "candidates.findCandidateHasEmail" , query = "SELECT c from candidates c where c.email is not null")
})
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id")
    private long id;
    private String email;
    @Column(name = "full_name")
    private String fullName;
    private String phone;
    @OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Experience> experiences;
```

##### Experience
```
@Entity(name = "experiences")
@Table(name = "experiences")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id")
    private long id;
    @Column(name = "from_date")
    private LocalDate fromDate;
    @Column(name = "work_desc")
    private String workDescription;

    @Column(name = "role")
    @Enumerated(value = EnumType.ORDINAL)
    private Roles role;
    @Column(name = "company")
    private String companyName;
    @Column(name = "to_date")
    private LocalDate toDate;
    @ManyToOne
    @JoinColumn(name = "can_id", nullable = false)
    private Candidate candidate;
```
##### Roles
```
public enum Roles {

    ADMINSTRATION(0),
    STAFF(1),
    MANAGER(2),
    EXCUTIVE(3);
    private int value;
    Roles(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
```

#### 2. Viết code thêm vào bảng candidate 3 mẫu tin, mỗi candidate có 3 experience
```
public class AddData {
    public static void main(String[] args) {
        Candidate candidate1 = new Candidate("kiet@gmail.com", "Duong Tuan Kiet", "0348333253", null);
        Experience ex1 = new Experience(LocalDate.of(2024, 1, 1), "Intern Front End", Roles.STAFF, "FPT", LocalDate.of(2024, 10, 1), candidate1);
        Experience ex2 = new Experience(LocalDate.of(2023, 1, 10), "Intern Back End", Roles.STAFF, "DXC", LocalDate.of(2024, 6, 10), candidate1);
        Experience ex3 = new Experience(LocalDate.of(2022, 1, 20), "Intern QA", Roles.STAFF, "Viettel", LocalDate.of(2024, 6, 20), candidate1);
        List<Experience> experiences = List.of(ex1, ex2, ex3);
        candidate1.setExperences(experiences);

        CandidateRepository repository = new CandidateRepository();
        repository.insert(candidate1);
        for(Experience experience: experiences){
            System.out.println(experience);
        }
    }
}
```
#### 3. Thiết kế trang index gồm link đến các câu sau 4, 5, 6
   ![image](https://github.com/user-attachments/assets/f013982c-12a5-4bbc-9828-d320efd219b2)
#### 4. Tạo trang candidates.jsp hiển thị danh sách các candidate theo dạng bảng, một link tên View cuối mỗi dòng candidate để hiển thị thông tin chi tiết của ứng viên đó ở trang khác có candidate_details.jsp
   ![image](https://github.com/user-attachments/assets/55d9f6b9-e3d0-451f-8a6b-db2514c962ea)
   ![image](https://github.com/user-attachments/assets/71b90950-f2eb-42eb-95d2-f2248fc8a213)
#### 5. report1.jsp -> Roles
   ![image](https://github.com/user-attachments/assets/2c3fa5b2-1fbd-41f7-ae4b-eff1c1149bb3)
#### 6. report2.jsp -> Email
   ![image](https://github.com/user-attachments/assets/bef25c40-4575-4f68-855f-fa0fd03b4c4a)







