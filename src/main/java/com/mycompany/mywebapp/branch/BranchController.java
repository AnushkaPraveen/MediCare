package com.mycompany.mywebapp.branch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BranchController {
    @Autowired
    BranchService service;

    @GetMapping("/branchers")
    public String showBranchList(Model model){
     List<Branch> listBranchers =service.listAll();
        model.addAttribute("listBranchers",listBranchers);

        return "branch";
    }


    @GetMapping("/branchers/new")
    public String showNewForm(Model model){
        model.addAttribute("branch",new Branch());
        model.addAttribute("pageTitle","Add New branch");
        return "branch_form";
    }

    @PostMapping("/branchers/save")
    public String saveBranch(Branch branch, RedirectAttributes ra){
        service.save(branch);
        ra.addFlashAttribute("message","The New Branch added");
        return "redirect:/branchers";
    }

    @GetMapping("/branchers/edit/{bid}")
    public String showEditForm(@PathVariable("bid")Integer bid, Model model, RedirectAttributes ra){
        try{
            Branch branch=service.get(bid);
            model.addAttribute("branch",branch);
            model.addAttribute("pageTitle","Edit Branch (ID:"+bid+")");

            return "branch_form";
        }catch(BranchNotFoundException e){
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/branchers";
        }
    }

    @GetMapping("/branchers/delete/{bid}")
    public String deleteBranch(@PathVariable("bid")Integer bid,RedirectAttributes ra){
        try{
            service.delete(bid);
            ra.addFlashAttribute("message","the Customer ID "+bid+" has been deleted");

        }catch(BranchNotFoundException e){
            ra.addFlashAttribute("message",e.getMessage());

        }
        return "redirect:/branchers";
    }




}
