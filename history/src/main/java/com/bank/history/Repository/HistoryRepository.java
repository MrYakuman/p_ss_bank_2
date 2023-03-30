package com.bank.history.Repository;

import com.bank.history.Entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;


public interface HistoryRepository extends JpaRepository<History, BigInteger> {

}
