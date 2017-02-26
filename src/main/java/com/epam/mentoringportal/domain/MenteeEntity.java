package com.epam.mentoringportal.domain;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * @author Tim Ryzhov
 */
@Entity
@Table(name="mentee")
public class MenteeEntity {
    private static final long serialVersionUID = 145245L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

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

    @Column(name = "fullname")
    String fullname = null;

    @Column(name = "email", unique = true)
    String email = null;

    @Column(name = "created_at")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    DateTime createdAt = null;

    @Column(name = "updated_at")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    DateTime updatedAt = null;


    public MentorEntity getMentor() {
        return mentor;
    }

    public void setMentor(MentorEntity mentor) {
        this.mentor = mentor;
    }

    @ManyToOne
    @JoinColumn(name="mentor_id")
    MentorEntity mentor;



    public MenteeEntity(String fullname, String email) {
        this.fullname = fullname;
        this.email = email;
    }
    public MenteeEntity(){

    }
}
