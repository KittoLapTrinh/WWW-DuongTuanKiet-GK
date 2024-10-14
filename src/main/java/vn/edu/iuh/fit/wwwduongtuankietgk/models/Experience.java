package vn.edu.iuh.fit.wwwduongtuankietgk.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.wwwduongtuankietgk.enums.Roles;

import java.time.LocalDate;

@Entity
@Table(name = "experience")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id")
    private long id;
    @Column(name = "from_date")
    private LocalDate fromDate;
    @Column(name = "work_desc")
    private String workDescription;
    @Enumerated(value = EnumType.ORDINAL)
    private Roles role;
    private String companyName;
    @Column(name = "to_date")
    private LocalDate toDate;

    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    public Experience(LocalDate fromDate, String workDescription, Roles role, String companyName, LocalDate toDate, Candidate candidate) {
        this.fromDate = fromDate;
        this.workDescription = workDescription;
        this.role = role;
        this.companyName = companyName;
        this.toDate = toDate;
        this.candidate = candidate;
    }
}
