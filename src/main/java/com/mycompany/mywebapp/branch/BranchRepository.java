package com.mycompany.mywebapp.branch;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BranchRepository extends CrudRepository<Branch,Integer> {
}
