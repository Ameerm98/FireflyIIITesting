package API;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v129.network.model.Request;


public class TransferDeleteAPITest {
    String personalToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiYjRlYzQxNzhiNTc1ZWYzZjE3NzdmMWJmYjFkZGRjNDIwMDk4Y2E4ZDRhNWMxNjI1YjM3NzdiMDZiNzIxYmJmNDlmZmQ4ODg5ZmZmMTdiNDkiLCJpYXQiOjE3MzcwMzY5NDIuNTQxODMzLCJuYmYiOjE3MzcwMzY5NDIuNTQxODM2LCJleHAiOjE3Njg1NzI5NDIuMjE4NzU5LCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.Up_bEzrOPxPk8txc3Kr82YDed6i1VBharpFBl8HzVcJkvdLEUb11_l3ZlvngfcZ7SRzBUZxtOfrYQcE6d6n-Z1W_V9GjdzM2HZQcE5duTm949rXLlWLNT7EAq1_gXUCaURm_nAPYGRCna8VIxCltRXh6Wvc91jXM3n-F8dp31URwZVb483lzidZyZ6jTqsARyUwdAeO64eR33ZG1BKDBPtCja-Z_XtmS1sewFJYbG74bvm7tyK15nptnPbSVng2dPhLYp5zZSlipnyB1DzRK05uXQ43j-0mwdz8T2lumDzbiqdJBX6T3nJZ9Yu45hquvKFBJToRYNMWVUsKQglKHYU1km0ZOVtV_-NIr4yBN4hOuSSnzgbD1FZjHW_qLobD9fA-3StPcAbEeQlHng4nCOcvBWszh0pMHLbCkcdy4aVFHjRI9WeUKD6ROvREBVVxtHcdW0-WoFyKzupQKtO2eHwnVkSKoNgdQLyq9LufosxZIHpNTwwNkqkne2nXWiC97o6ju_Yzg89A4iztgefVFYhGm8YwmwTrEkGVvcdoFwX2FkEzT1dFp7SfCfG7tnJ4-QwwCRFctUXeCiOy_NMil6f0fhfx-Xtkir7D770RX3jTOw1zCiYVT99mkdummzOXCgiOXrKrsGRfOplkio05Xi1-2RbxOg4XgEtl4J23udj0";
    String validTransferId = "585";
    String invalidTransferId = "9999";



    @BeforeEach
    public void setup() {

        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = "https://42de-2a06-c701-9ca4-ad00-7981-bb0f-7085-b2e5.ngrok-free.app/api";
        //RestAssured.port = 80; // Adjust port as needed
        RequestSpecification response = given()
                .header("Accept", "application/json")
                .header("Content-Type","application/json")
                .header("Authorization"," Bearer "+personalToken);

    }



    @Test
    public void deleteValidTransfer(){
        Response response = given()
                .header("Accept", "application/json")
                .header("Content-Type","application/json")
                .header("Authorization"," Bearer "+personalToken)
                .when().get("/v1/transactions").then().statusCode(200).extract().response();

        JsonPath jsonFile= response.jsonPath();
        assertEquals(2, jsonFile.getList("data").size());

                 given()
                .header("Accept", "application/json")
                .header("Content-Type","application/json")
                .header("Authorization"," Bearer "+personalToken)
                .when().delete("/v1/transactions/"+validTransferId).then().statusCode(204).extract().response();

         response = given()
                .header("Accept", "application/json")
                .header("Content-Type","application/json")
                .header("Authorization"," Bearer "+personalToken)
                .when().get("/v1/transactions").then().statusCode(200).extract().response();

         jsonFile= response.jsonPath();
        assertEquals(1, jsonFile.getList("data").size());
        assertEquals("Transfer from Source to Destination",jsonFile.getString("data[0].attributes.transactions[0].description"));

    }

    @Test
    public void deleteNonExistentTransfer(){
        RequestSpecification response = given()
                .header("Accept", "application/json")
                .header("Content-Type","application/json")
                .header("Authorization"," Bearer "+personalToken);
        response.when().delete("/v1/transactions/"+invalidTransferId).then().statusCode(404);

    }


}

