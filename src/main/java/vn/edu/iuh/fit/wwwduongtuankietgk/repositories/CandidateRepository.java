package vn.edu.iuh.fit.wwwduongtuankietgk.repositories;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import vn.edu.iuh.fit.wwwduongtuankietgk.enums.Roles;
import vn.edu.iuh.fit.wwwduongtuankietgk.models.Candidate;
import vn.edu.iuh.fit.wwwduongtuankietgk.repositories.instance.ConnectDB;

import java.util.ArrayList;
import java.util.List;

public class CandidateRepository extends CRUDRepository<Candidate>{
    private ExperienceRepository repository;
    public CandidateRepository(){
        EntityManager manager = ConnectDB.getInstance().getEntityManager();
    }

    public List<Candidate> findCandidateByRole(int role) {
        List<Candidate> candidates = new ArrayList<>();
        try {
            transaction.begin();
            Query query = entityManager.createNamedQuery("candidate.findCandidateByRole")
                    .setParameter("role", Roles.values()[role]);
            candidates = query.getResultList();
            transaction.commit();

        } catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        return candidates;

    }

    public List<Candidate> findCandidateHasEmail() {
        List<Candidate> candidates = new ArrayList<>();
        try {
            transaction.begin();
            Query query = entityManager.createNamedQuery("candidates.findCandidateHasEmail");
            candidates = query.getResultList();
            transaction.commit();

        } catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        return candidates;
    }
}
