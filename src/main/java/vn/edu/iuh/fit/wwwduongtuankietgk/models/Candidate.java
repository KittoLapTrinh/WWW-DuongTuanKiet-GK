package vn.edu.iuh.fit.wwwduongtuankietgk.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "candidate")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@NamedQueries({

        @NamedQuery(name = "candidate.findCandidateByRole",
                query = "SELECT c FROM Candidate c JOIN c.experiences e WHERE e.role = :role"),
        @NamedQuery(name = "candidate.findCandidateHasEmail",
                query = "SELECT c FROM Candidate c WHERE c.email IS NOT NULL"),


})
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id")
    private long id;
    private String phone;
    private String email;
    @Column(name = "full_name")
    private String fullName;

    @OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Experience> experiences;

    public Candidate(String email, String fullName, String phone, List<Experience> experiences) {
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.experiences = experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public Candidate() {

    }

    public Candidate(long id, String phone, String email, String fullName, List<Experience> experiences) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.fullName = fullName;
        this.experiences = experiences;
    }
}
