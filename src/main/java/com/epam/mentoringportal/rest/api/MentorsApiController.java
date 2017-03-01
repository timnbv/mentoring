package com.epam.mentoringportal.rest.api;

import com.epam.mentoringportal.rest.dto.*;
import com.epam.mentoringportal.service.ApplicationException;
import com.epam.mentoringportal.service.MentorService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-25T18:51:55.918Z")

@Controller
public class MentorsApiController implements MentorsApi {

    @Autowired
    MentorService mentorService;


    public ResponseEntity<Mentor> addMentor(@ApiParam(value = "Mentor to add", required = true) @RequestBody NewPerson mentor) throws ApplicationException {
        Mentor newMentor = mentorService.save(mentor);
        return new ResponseEntity<Mentor>(newMentor, HttpStatus.CREATED);
    }

    public ResponseEntity<Void> deleteMentor(@ApiParam(value = "ID of mentee to delete", required = true) @PathVariable("id") Integer id) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Mentor> findMentorById(@ApiParam(value = "ID of mentor to fetch", required = true) @PathVariable("id") Integer id) {
        Mentor byId = mentorService.findById(id);
        return new ResponseEntity<Mentor>(byId, HttpStatus.OK);
    }

    public ResponseEntity<Mentor> linkMenteeToMentor(@ApiParam(value = "ID of mentor to add mentee", required = true) @PathVariable("id") Integer id,
                                                     @ApiParam(value = "Mentee to add", required = true) @RequestBody AddMentee mentee) throws ApplicationException {
        mentorService.addMentee(id, mentee.getId());
        Mentor byId = mentorService.findById(id);
        return new ResponseEntity<Mentor>(byId, HttpStatus.OK);
    }

    public ResponseEntity<List<Mentor>> mentorsGet(@ApiParam(value = "Size of array") @RequestParam(value = "size", required = false) Double size) {
        // do some magic!
        return new ResponseEntity<List<Mentor>>(HttpStatus.OK);
    }

    public ResponseEntity<Void> unlinkMenteeFromMentor(@ApiParam(value = "ID of mentor to unlink", required = true) @PathVariable("id") Integer id,
                                                       @ApiParam(value = "ID of mentee to unlink", required = true) @PathVariable("menteeId") Integer menteeId) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Mentor> updateMentor(@ApiParam(value = "Mentor to update", required = true) @RequestBody UpdatePerson mentor) {
        // do some magic!
        return new ResponseEntity<Mentor>(HttpStatus.OK);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST,
            reason = "Bad Request")  // 400
    @ExceptionHandler(ApplicationException.class)
    @ResponseBody
    public ErrorModel badRequest(HttpServletRequest req, Exception ex) {
        ErrorModel messageModel = new ErrorModel().message(ex.getMessage());
        messageModel.setCode(HttpStatus.BAD_REQUEST.value());
        return messageModel ;
    }

}
