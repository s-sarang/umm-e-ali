package com.ummeali.herbal.session;

import jakarta.persistence.Entity;
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
    private Integer sessionId;
    private Integer userId;
    private String status;

    public Session(Integer sessionId, Integer userId, String status) {
        this.sessionId = sessionId;
        this.userId = userId;
        this.status = status;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        return Objects.equals(sessionId, session.sessionId) && Objects.equals(userId, session.userId) && Objects.equals(status, session.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId, userId, status);
    }

    @Override
    public String toString() {
        return "Session{" +
                "sessionId=" + sessionId +
                ", userId=" + userId +
                ", status='" + status + '\'' +
                '}';
    }
}
