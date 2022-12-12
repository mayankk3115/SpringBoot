package com.myRestApi.restApi.service;

import com.myRestApi.restApi.model.Question;
import com.myRestApi.restApi.model.Survey;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Service
public class SurveyService {

    private static List<Survey> surveys = new ArrayList<>();

    static {
        Question question1 = new Question("Question1",
                "Most Popular Cloud Platform Today", Arrays.asList(
                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
        Question question2 = new Question("Question2",
                "Fastest Growing Cloud Platform", Arrays.asList(
                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
        Question question3 = new Question("Question3",
                "Most Popular DevOps Tool", Arrays.asList(
                "Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");

        List<Question> questions = new ArrayList<>(Arrays.asList(question1,
                question2, question3));

        Survey survey = new Survey("Survey1", "My Favorite Survey",
                "Description of the Survey", questions);

        surveys.add(survey);

    }

    public List<Survey> returnSurvey() {
        return surveys;
    }

    public Survey returnSurveyById(String surveyId) {
        return surveys.stream().filter(survey -> survey.getId().equals(surveyId)).findFirst().get();
    }

    public List<Question> returnSurveyQuestions(String surveyId) {
        Survey survey = returnSurveyById(surveyId);
        return survey.getQuestions();
    }

    public Question returnSurveyQuestionsById(String surveyId, String questionId) {
        List<Question> questions = returnSurveyQuestions(surveyId);
        return questions.stream().filter(question -> question.getId()
                .equals(questionId)).findFirst().get();
    }

    public String addNewSurveyQuestion(String surveyId, Question question) {
        List<Question> questions = returnSurveyQuestions(surveyId);
        question.setId(generateRandomId());
        questions.add(question);
        return question.getId();
    }

    private static String generateRandomId() {
        SecureRandom secureRandom = new SecureRandom();
        String randomId = new BigInteger(32, secureRandom).toString();
        return randomId;
    }

    public String deleteSurveyQuestion(String surveyId, String questionId) {
        List<Question> questions = returnSurveyQuestions(surveyId);
        if(questions == null){
            return null;
        }

        Predicate<Question> questionPredicate = question -> question.getId().equalsIgnoreCase(questionId);
        boolean removed = questions.removeIf(questionPredicate);

        if(!removed) return null;
        return questionId;
    }

    public void updateSurveyQuestion(String surveyId, String questionId, Question question) {
        List<Question> questions = returnSurveyQuestions(surveyId);
        questions.removeIf(q -> q.getId().equals(questionId));
        questions.add(question);
    }
}
