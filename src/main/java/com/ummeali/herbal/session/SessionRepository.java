package com.ummeali.herbal.session;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {
    Session findByCustomerId(Integer customerId);
    void deleteByCustomerId(Integer customerId);
}
