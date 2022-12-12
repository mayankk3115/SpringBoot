package com.myRestApi.restApi.controller;

import com.myRestApi.restApi.model.Question;
import com.myRestApi.restApi.model.Survey;
import com.myRestApi.restApi.service.SurveyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SurveyController {

    private SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @RequestMapping(value="/surveys", method = RequestMethod.GET)
    public List<Survey> getAllSurvey() {
        return surveyService.returnSurvey();
    }

    @RequestMapping(value="/surveys/{surveyId}", method = RequestMethod.GET)
    public Survey getSurveyById(@PathVariable String surveyId) {
        Survey survey = surveyService.returnSurveyById(surveyId);
        if(survey==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return survey;
    }

    @RequestMapping(value="/surveys/{surveyId}/questions", method = RequestMethod.GET)
    public  List<Question> getSurveyQuestion(@PathVariable String surveyId) {
        List<Question> questions = surveyService.returnSurveyQuestions(surveyId);
        if(questions==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return questions;
    }

    @RequestMapping(value="/surveys/{surveyId}/questions/{questionId}", method = RequestMethod.GET)
    public Question getSurveyQuestionById(@PathVariable String surveyId,
                                        @PathVariable String questionId) {
        Question question = surveyService.returnSurveyQuestionsById(surveyId,questionId);
        if(question==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return question;
    }


    @RequestMapping(value="/surveys/{surveyId}/questions", method = RequestMethod.POST)
    public ResponseEntity<Object> addNewSurveyQuestion(@PathVariable String surveyId,
                                                       @RequestBody Question question) {
        String questionId = surveyService.addNewSurveyQuestion(surveyId, question);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{questionId}")
                .buildAndExpand(questionId).toUri();
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(value="/surveys/{surveyId}/questions/{questionId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSurveyQuestion(@PathVariable String surveyId,
                                                       @PathVariable String questionId) {
        String deleteId = surveyService.deleteSurveyQuestion(surveyId, questionId);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/surveys/{surveyId}/questions/{questionId}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateSurveyQuestion(@PathVariable String surveyId,
                                                       @PathVariable String questionId,
                                                       @RequestBody Question question) {
        surveyService.updateSurveyQuestion(surveyId, questionId, question);
        return ResponseEntity.noContent().build();
    }
}
