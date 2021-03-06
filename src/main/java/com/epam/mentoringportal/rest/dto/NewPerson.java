package com.epam.mentoringportal.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * NewPerson
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-25T18:51:55.918Z")

public class NewPerson {
    @JsonProperty("fullname")
    private String fullname = null;

    @JsonProperty("email")
    private String email = null;

    public NewPerson fullname(String fullname) {
        this.fullname = fullname;
        return this;
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

    public NewPerson email(String email) {
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


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NewPerson newPerson = (NewPerson) o;
        return Objects.equals(this.fullname, newPerson.fullname) &&
                Objects.equals(this.email, newPerson.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullname, email);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NewPerson {\n");

        sb.append("    fullname: ").append(toIndentedString(fullname)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

