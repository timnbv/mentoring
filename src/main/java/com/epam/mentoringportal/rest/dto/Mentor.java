package com.epam.mentoringportal.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Mentor
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-25T18:51:55.918Z")

public class Mentor {
    @JsonProperty("id")
    private Integer id = null;

    @JsonProperty("fullname")
    private String fullname = null;

    @JsonProperty("email")
    private String email = null;

    @JsonProperty("created_at")
    private DateTime createdAt = null;

    @JsonProperty("updated_at")
    private DateTime updatedAt = null;

    @JsonProperty("mentees")
    private List<Mentee> mentees = new ArrayList<Mentee>();

    public Mentor id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @ApiModelProperty(value = "")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Mentor fullname(String fullname) {
        this.fullname = fullname;
        return this;
    }

    public Mentor(){

    }

    /**
     * Get fullname
     *
     * @return fullname
     **/
    @ApiModelProperty(value = "")
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Mentor email(String email) {
        this.email = email;
        return this;
    }

    /**
     * Get email
     *
     * @return email
     **/
    @ApiModelProperty(value = "")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Mentor createdAt(DateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Get createdAt
     *
     * @return createdAt
     **/
    @ApiModelProperty(value = "")
    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Mentor updatedAt(DateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * Get updatedAt
     *
     * @return updatedAt
     **/
    @ApiModelProperty(value = "")
    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(DateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Mentor mentees(List<Mentee> mentees) {
        this.mentees = mentees;
        return this;
    }

    public Mentor addMenteesItem(Mentee menteesItem) {
        this.mentees.add(menteesItem);
        return this;
    }

    /**
     * Get mentees
     *
     * @return mentees
     **/
    @ApiModelProperty(value = "")
    public List<Mentee> getMentees() {
        return mentees;
    }

    public void setMentees(List<Mentee> mentees) {
        this.mentees = mentees;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mentor mentor = (Mentor) o;
        return Objects.equals(this.id, mentor.id) &&
                Objects.equals(this.fullname, mentor.fullname) &&
                Objects.equals(this.email, mentor.email) &&
                Objects.equals(this.createdAt, mentor.createdAt) &&
                Objects.equals(this.updatedAt, mentor.updatedAt) &&
                Objects.equals(this.mentees, mentor.mentees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullname, email, createdAt, updatedAt, mentees);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Mentor {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    fullname: ").append(toIndentedString(fullname)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
        sb.append("    mentees: ").append(toIndentedString(mentees)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

