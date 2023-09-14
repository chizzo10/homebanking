package com.mindhub.homebanking.services.implement;

import com.mindhub.homebanking.dtos.LoanDto;
import com.mindhub.homebanking.models.Loan;
import com.mindhub.homebanking.repositories.LoanRepository;
import com.mindhub.homebanking.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanServiceImplement implements LoanService {

    @Autowired
    LoanRepository loanRepository;
    @Override
    public List<LoanDto> getLoans() {
        return loanRepository.findAll().stream()
                .map(LoanDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public Loan findLoanById(Long id) {
        return loanRepository.findById(id).orElse(null);
    }
}
