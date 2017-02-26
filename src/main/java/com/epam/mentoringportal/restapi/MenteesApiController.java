package com.epam.mentoringportal.restapi;

import com.epam.mentoringportal.model.Mentee;
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
public class MenteesApiController implements MenteesApi {

    public ResponseEntity<Mentee> addMentee(@ApiParam(value = "Mentee to add" ,required=true ) @RequestBody NewPerson mentee) {
        // do some magic!
        return new ResponseEntity<Mentee>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteMentee(@ApiParam(value = "ID of mentee to delete",required=true ) @PathVariable("id") Integer id) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Mentee> findMenteeById(@ApiParam(value = "ID of mentee to fetch",required=true ) @PathVariable("id") Integer id) {
        // do some magic!
        return new ResponseEntity<Mentee>(HttpStatus.OK);
    }

    public ResponseEntity<List<Mentee>> menteesGet(@ApiParam(value = "Size of array") @RequestParam(value = "size", required = false) Double size) {
        // do some magic!
        return new ResponseEntity<List<Mentee>>(HttpStatus.OK);
    }

    public ResponseEntity<Mentee> updateMentee(@ApiParam(value = "Mentee to update" ,required=true ) @RequestBody UpdatePerson mentor) {
        // do some magic!
        return new ResponseEntity<Mentee>(HttpStatus.OK);
    }

}
