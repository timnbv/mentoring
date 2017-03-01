package com.epam.mentoringportal.rest.api;

import com.epam.mentoringportal.service.ApplicationException;
import io.swagger.annotations.*;
import com.epam.mentoringportal.rest.dto.AddMentee;
import com.epam.mentoringportal.rest.dto.Mentor;
import com.epam.mentoringportal.rest.dto.NewPerson;
import com.epam.mentoringportal.rest.dto.UpdatePerson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-25T18:51:55.918Z")

@Api(value = "mentors", description = "the mentors API")
public interface MentorsApi {

    @ApiOperation(value = "", notes = "Creates a new mentor. Email should be unique", response = Mentor.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Mentor created", response = Mentor.class)})
    @RequestMapping(value = "/mentors",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Mentor> addMentor(@ApiParam(value = "Mentor to add", required = true) @RequestBody NewPerson mentor) throws ApplicationException;


    @ApiOperation(value = "", notes = "deletes a single mentor based on the ID supplied", response = Void.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "mentor deleted", response = Void.class)})
    @RequestMapping(value = "/mentors/{id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteMentor(@ApiParam(value = "ID of mentee to delete", required = true) @PathVariable("id") Integer id);


    @ApiOperation(value = "", notes = "Returns a mentor based on a single ID", response = Mentor.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "mentor response", response = Mentor.class)})
    @RequestMapping(value = "/mentors/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Mentor> findMentorById(@ApiParam(value = "ID of mentor to fetch", required = true) @PathVariable("id") Integer id);


    @ApiOperation(value = "", notes = "Links a mentee to a mentor.", response = Mentor.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Mentee added to mentor", response = Mentor.class)})
    @RequestMapping(value = "/mentors/{id}/mentee",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Mentor> linkMenteeToMentor(@ApiParam(value = "ID of mentor to add mentee", required = true) @PathVariable("id") Integer id,
                                              @ApiParam(value = "Mentee to add", required = true) @RequestBody AddMentee mentee) throws ApplicationException;


    @ApiOperation(value = "", notes = "Gets `Mentor` objects. Optional query param of **size** determines size of returned array ", response = Mentor.class, responseContainer = "List", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = Mentor.class)})
    @RequestMapping(value = "/mentors",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<Mentor>> mentorsGet(@ApiParam(value = "Size of array") @RequestParam(value = "size", required = false) Double size);


    @ApiOperation(value = "", notes = "unlinks mentee from mentor", response = Void.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "mentee unlinked", response = Void.class)})
    @RequestMapping(value = "/mentors/{id}/mentee/{menteeId}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> unlinkMenteeFromMentor(@ApiParam(value = "ID of mentor to unlink", required = true) @PathVariable("id") Integer id,
                                                @ApiParam(value = "ID of mentee to unlink", required = true) @PathVariable("menteeId") Integer menteeId);


    @ApiOperation(value = "", notes = "Updates mentor.", response = Mentor.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Mentor updated", response = Mentor.class)})
    @RequestMapping(value = "/mentors",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<Mentor> updateMentor(@ApiParam(value = "Mentor to update", required = true) @RequestBody UpdatePerson mentor);

}
