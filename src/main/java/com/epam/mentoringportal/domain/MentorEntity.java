package com.epam.mentoringportal.domain;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.List;

/**
 * @author Tim Ryzhov
 */
@Entity
@Table(name="mentor")
public class MentorEntity {
    private static final long serialVersionUID = 1325343L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id = null;

    @Column(name = "fullname")
    String fullname = null;

    @Column(name = "email", unique = true)
    String email = null;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="mentor")
    List<MenteeEntity> mentees;


    public List<MenteeEntity> getMentees() {
        return mentees;
    }

    public void setMentees(List<MenteeEntity> mentees) {
        this.mentees = mentees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(DateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Column(name = "crated_at")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    DateTime createdAt = null;

    @Column(name = "updated_at")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    DateTime updatedAt = null;

    // private List<Mentee> mentees = new ArrayList<Mentee>();
}
