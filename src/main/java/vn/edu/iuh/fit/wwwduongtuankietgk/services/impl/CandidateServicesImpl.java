package vn.edu.iuh.fit.wwwduongtuankietgk.services.Impl;


import vn.edu.iuh.fit.wwwduongtuankietgk.models.Candidate;
import vn.edu.iuh.fit.wwwduongtuankietgk.repositories.CandidateRepository;
import vn.edu.iuh.fit.wwwduongtuankietgk.services.CandidateService;

import java.util.List;
import java.util.Optional;

public class CandidateServicesImpl implements CandidateService {
    private final CandidateRepository repository;
    public CandidateServicesImpl(){
        repository = new CandidateRepository();
    }
    @Override
    public List<Candidate> getAllCandidate() {
        return repository.getAll(Candidate.class);
    }

    @Override
    public Candidate getCandidateDetail(long id) throws Exception {
        Optional<Candidate> candidate = repository.get(Candidate.class,id);
        if (candidate.isEmpty())
                throw new Exception("Not fund");
        return candidate.get();
    }

    @Override
    public boolean insert(Candidate candidate) {
        return repository.insert(candidate);
    }

    @Override
    public List<Candidate> findCandidateByRole(int role) {
        return repository.findCandidateByRole(role);
    }

    @Override
    public List<Candidate> findCandidateHasEmail() {
        return repository.findCandidateHasEmail();
    }
}
