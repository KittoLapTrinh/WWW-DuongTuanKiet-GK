package vn.edu.iuh.fit.wwwduongtuankietgk.models;

import jakarta.persistence.*;

import java.util.List;

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

    public Candidate() {
    }

    public Candidate(String email, String fullName, String phone, List<Experience> experiences) {
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.experiences = experiences;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperences(List<Experience> experiences) {
        this.experiences= experiences;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
