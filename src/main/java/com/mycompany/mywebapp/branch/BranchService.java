package com.mycompany.mywebapp.branch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchService {
    @Autowired
    BranchRepository repo;

    public List<Branch> listAll() {
        return (List<Branch>) repo.findAll();
    }

    public void save(Branch branch) {
        repo.save(branch);
    }

    public Branch get(Integer bid) throws BranchNotFoundException {
        Optional<Branch> result = repo.findById(bid);
        if (result.isPresent()) {
            return result.get();
        }
        throw new BranchNotFoundException("Could not find any users with ID " + bid);
    }

    public void delete(Integer bid) throws BranchNotFoundException {
        Optional<Branch> count = repo.findById(bid);
        if (count.isEmpty()) throw new BranchNotFoundException("Could not find any users with ID " + bid);
        repo.deleteById(bid);
    }
}
