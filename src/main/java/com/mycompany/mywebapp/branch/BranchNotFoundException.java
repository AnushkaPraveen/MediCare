package com.mycompany.mywebapp.branch;

public class BranchNotFoundException extends Throwable {
    public BranchNotFoundException(String message) {
        super(message);
    }
}
