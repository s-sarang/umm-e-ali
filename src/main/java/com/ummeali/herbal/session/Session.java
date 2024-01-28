package com.ummeali.herbal.session;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

import java.util.Objects;

@Table(name = "SESSION")
@Entity
@Builder
public class Session {

    public Session(){
        // NO-OPS - required for Spring JPA.
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer sessionId;
    @Column(unique = true)
    private Integer customerId;
    private String status;

    public Session(Integer sessionId, Integer customerId, String status) {
        this.sessionId = sessionId;
        this.customerId = customerId;
        this.status = status;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer userId) {
        this.customerId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(sessionId, session.sessionId) && Objects.equals(customerId, session.customerId) && Objects.equals(status, session.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId, customerId, status);
    }

    @Override
    public String toString() {
        return "Session{" +
                "sessionId=" + sessionId +
                ", customerId=" + customerId +
                ", status='" + status + '\'' +
                '}';
    }
}
