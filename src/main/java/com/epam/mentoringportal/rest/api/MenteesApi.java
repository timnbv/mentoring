package com.epam.mentoringportal.rest.api;

import com.epam.mentoringportal.rest.dto.Mentee;
import com.epam.mentoringportal.rest.dto.NewPerson;
import com.epam.mentoringportal.rest.dto.UpdatePerson;
import com.epam.mentoringportal.service.ApplicationException;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-25T18:51:55.918Z")

@Api(value = "mentees", description = "the mentees API")
public interface MenteesApi {

    @ApiOperation(value = "", notes = "Creates a new mentee. Email should be unique", response = Mentee.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Mentee created", response = Mentee.class)})
    @RequestMapping(value = "/mentees",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Mentee> addMentee(@ApiParam(value = "Mentee to add", required = true) @RequestBody NewPerson mentee) throws ApplicationException;


    @ApiOperation(value = "", notes = "deletes a single mentee based on the ID supplied", response = Void.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "mentee deleted", response = Void.class)})
    @RequestMapping(value = "/mentees/{id}",
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteMentee(@ApiParam(value = "ID of mentee to delete", required = true) @PathVariable("id") Integer id) throws ApplicationException;


    @ApiOperation(value = "", notes = "Returns a mentee based on a single ID", response = Mentee.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "mentee response", response = Mentee.class)})
    @RequestMapping(value = "/mentees/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Mentee> findMenteeById(@ApiParam(value = "ID of mentee to fetch", required = true) @PathVariable("id") Integer id);


    @ApiOperation(value = "", notes = "Gets `Mentee` objects. Optional query param of **size** determines size of returned array ", response = Mentee.class, responseContainer = "List", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = Mentee.class)})
    @RequestMapping(value = "/mentees",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<Mentee>> menteesGet(@ApiParam(value = "Size of array") @RequestParam(value = "size", required = false) Double size);


    @ApiOperation(value = "", notes = "Updates mentee.", response = Mentee.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Mentee updated", response = Mentee.class)})
    @RequestMapping(value = "/mentees",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<Mentee> updateMentee(@ApiParam(value = "Mentee to update", required = true) @RequestBody UpdatePerson mentor);

}
