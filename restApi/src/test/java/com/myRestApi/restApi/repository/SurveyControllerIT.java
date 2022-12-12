package com.myRestApi.restApi.repository;

import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerIT {

    @Autowired
    private TestRestTemplate template;

    private String SPECIFIC_URL="/surveys/Survey1/questions/Question1";
    private String GENERIC_URL="/surveys/Survey1/questions";


    String str = """
            {
                id: "Question1",
                description: "Most Popular Cloud Platform Today",
                options: [
                    "AWS",
                    "Azure",
                    "Google Cloud",
                    "Oracle Cloud"
                    ],
                correctAnswer: "AWS"
            }
            """;

    @Test
    void getSurveyQuestionById_basedScenerio() throws JSONException {
        ResponseEntity<String> responseEntity = template.getForEntity(SPECIFIC_URL, String.class);
        String expectedResponse= """
                {"id":"Question1",
                "description":"Most Popular Cloud Platform Today"
                }
                """;

        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        Assertions.assertEquals("application/json",responseEntity.getHeaders().get("Content-Type").get(0));
        JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);
    }

    @Test
    void getSurveyQuestion_basedScenerio() throws JSONException {
        ResponseEntity<String> responseEntity = template.getForEntity(GENERIC_URL, String.class);
        String expectedResponse= """
                [
                    {
                        id: "Question1"
                    },
                    {
                        id: "Question2"
                    },
                    {
                        id: "Question3"
                    }
                ]
                """;

        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        Assertions.assertEquals("application/json",responseEntity.getHeaders().get("Content-Type").get(0));
        JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);
    }

    @Test
    void addNewSurveyQuestion_basedScenerio() throws JSONException {

        String requestBody= """
                {
                    "description": "My favorite Deployment",
                    "options": [
                        "AWS",
                        "Harness",
                        "Jenkins",
                        "Kubernetes"
                    ],
                    "correctAnswer": "Jenkins"
                }
                """;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type","application/json");

        HttpEntity<String> httpEntity = new HttpEntity<String>(requestBody, httpHeaders);
        ResponseEntity<String> responseEntity = template.exchange(GENERIC_URL, HttpMethod.POST, httpEntity,String.class);

        System.out.println(responseEntity.getHeaders());

        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        Assertions.assertEquals("application/json",responseEntity.getHeaders().get("Content-Type").get(0));
    }

}