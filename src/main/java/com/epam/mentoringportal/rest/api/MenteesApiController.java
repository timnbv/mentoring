package com.epam.mentoringportal.rest.api;

import com.epam.mentoringportal.rest.dto.ErrorModel;
import com.epam.mentoringportal.rest.dto.Mentee;
import com.epam.mentoringportal.rest.dto.NewPerson;
import com.epam.mentoringportal.rest.dto.UpdatePerson;
import com.epam.mentoringportal.service.ApplicationException;
import com.epam.mentoringportal.service.MenteeService;
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
public class MenteesApiController implements MenteesApi {

    @Autowired
    private MenteeService menteeService;

    public ResponseEntity<Mentee> addMentee(@ApiParam(value = "Mentee to add", required = true) @RequestBody NewPerson mentee) throws ApplicationException {

        Mentee newMentee = menteeService.save(mentee);
        return new ResponseEntity<Mentee>(newMentee, HttpStatus.CREATED);
    }

    public ResponseEntity<Void> deleteMentee(@ApiParam(value = "ID of mentee to delete", required = true) @PathVariable("id") Integer id) throws ApplicationException {
        Mentee byId = menteeService.findById(id);
        if (byId != null) {
            menteeService.delete(id);
        } else {
            throw new ApplicationException("Mentee not found, not deleted");
        }
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Mentee> findMenteeById(@ApiParam(value = "ID of mentee to fetch", required = true) @PathVariable("id") Integer id) {
        // do some magic!
        return new ResponseEntity<Mentee>(HttpStatus.OK);
    }

    public ResponseEntity<List<Mentee>> menteesGet(@ApiParam(value = "Size of array") @RequestParam(value = "size", required = false) Double size) {
        return new ResponseEntity<List<Mentee>>(menteeService.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Mentee> updateMentee(@ApiParam(value = "Mentee to update", required = true) @RequestBody UpdatePerson mentor) {
        // do some magic!
        return new ResponseEntity<Mentee>(HttpStatus.OK);
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
