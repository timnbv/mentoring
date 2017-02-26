package com.epam.mentoringportal.restapi;

import com.epam.mentoringportal.model.AddMentee;
import com.epam.mentoringportal.model.Mentor;
import com.epam.mentoringportal.model.NewPerson;
import com.epam.mentoringportal.model.UpdatePerson;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-25T18:51:55.918Z")

@Controller
public class MentorsApiController implements MentorsApi {

    public ResponseEntity<Mentor> addMentor(@ApiParam(value = "Mentor to add" ,required=true ) @RequestBody NewPerson mentor) {
        // do some magic!
        return new ResponseEntity<Mentor>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteMentor(@ApiParam(value = "ID of mentee to delete",required=true ) @PathVariable("id") Integer id) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Mentor> findMentorById(@ApiParam(value = "ID of mentor to fetch",required=true ) @PathVariable("id") Integer id) {
        // do some magic!
        return new ResponseEntity<Mentor>(HttpStatus.OK);
    }

    public ResponseEntity<Mentor> linkMenteeToMentor(@ApiParam(value = "ID of mentor to add mentee",required=true ) @PathVariable("id") Integer id,
        @ApiParam(value = "Mentee to add" ,required=true ) @RequestBody AddMentee mentee) {
        // do some magic!
        return new ResponseEntity<Mentor>(HttpStatus.OK);
    }

    public ResponseEntity<List<Mentor>> mentorsGet(@ApiParam(value = "Size of array") @RequestParam(value = "size", required = false) Double size) {
        // do some magic!
        return new ResponseEntity<List<Mentor>>(HttpStatus.OK);
    }

    public ResponseEntity<Void> unlinkMenteeFromMentor(@ApiParam(value = "ID of mentor to unlink",required=true ) @PathVariable("id") Integer id,
        @ApiParam(value = "ID of mentee to unlink",required=true ) @PathVariable("menteeId") Integer menteeId) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Mentor> updateMentor(@ApiParam(value = "Mentor to update" ,required=true ) @RequestBody UpdatePerson mentor) {
        // do some magic!
        return new ResponseEntity<Mentor>(HttpStatus.OK);
    }

}
