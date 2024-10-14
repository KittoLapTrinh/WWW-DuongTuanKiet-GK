package vn.edu.iuh.fit.wwwduongtuankietgk.data;

import vn.edu.iuh.fit.wwwduongtuankietgk.enums.Roles;
import vn.edu.iuh.fit.wwwduongtuankietgk.models.Candidate;
import vn.edu.iuh.fit.wwwduongtuankietgk.models.Experience;
import vn.edu.iuh.fit.wwwduongtuankietgk.repositories.CandidateRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddData {
    public static void main(String[] args) {
        Candidate candidate1 = new Candidate("kiet@gmail.com", "Duong Tuan Kiet", "0348333253", null);
        Experience ex1 = new Experience(LocalDate.of(2024, 1, 1), "Intern Front End", Roles.STAFF, "FPT", LocalDate.of(2024, 10, 1), candidate1);
        Experience ex2 = new Experience(LocalDate.of(2023, 1, 10), "Intern Back End", Roles.STAFF, "DXC", LocalDate.of(2024, 6, 10), candidate1);
        Experience ex3 = new Experience(LocalDate.of(2022, 1, 20), "Intern QA", Roles.STAFF, "Viettel", LocalDate.of(2024, 6, 20), candidate1);
        List<Experience> experiences = List.of(ex1, ex2, ex3);
        candidate1.setExperiences(experiences);

        CandidateRepository repository = new CandidateRepository();
        repository.insert(candidate1);
    }
}
