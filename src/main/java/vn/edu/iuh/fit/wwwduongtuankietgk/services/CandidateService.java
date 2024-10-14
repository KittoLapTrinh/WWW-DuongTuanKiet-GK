package vn.edu.iuh.fit.wwwduongtuankietgk.services;

import vn.edu.iuh.fit.wwwduongtuankietgk.models.Candidate;

import java.util.List;

public interface CandidateService {
    List<Candidate> getAllCandidate();
    Candidate getCandidateDetail(long id) throws Exception;
    boolean insert(Candidate candidate);
    List<Candidate> findCandidateByRole(int role);
    List<Candidate> findCandidateHasEmail();
}
