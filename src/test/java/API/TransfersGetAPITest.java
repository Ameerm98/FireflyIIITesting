package API;


import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TransfersGetAPITest {
    String personalToken ="eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiN2QwYmM3OTE4OGI0OTU5ODE1MWZmYjdmOGYzMWIxYmYxOTVkZTcwZjA3MDczODliOWE5NjNmY2MxYjQ3MjIxZGU2MTFjNWE3NmNlMzZmNzIiLCJpYXQiOjE3NDA2NDA2OTIuODI4MDYyLCJuYmYiOjE3NDA2NDA2OTIuODI4MDY1LCJleHAiOjE3NzIxNzY2OTIuNjMyMzM1LCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.j9-AljTOuI3Xrz2MEVw7ZSmXdhFljN0Y2LAkko-c7BZ0AxEUZecRxNpRQnFQvEf_6vSzegAN4Tcdd13c4thAyQt7n9DNylIwREPM8xj5qGPVvhnwiuh3EvLxz2B4mcZpzVlMCD_Ir5ritH7KtXnfQqsblaxKfrjxSIOHccfv0sc1cHMlq2Bscq5AG7mOMsgaLVEtIBWO7r1yqdJhuCrn52UyhntVpI0sKV-BVHa_zLBW8H9Q3ChYu0G6SdKQLf4VfQKLrjamNV0Cbsxda4PoCC1TDvz-qpBLLQbJuIM6yYLLXAKSgPPWPpwPh3VmDBCkc_NbRwOTS8SqliBHHssFrfgHx2YqPdnlVUEETpybu6xs_4pw2B0KY5flVng0ujxJo7yxfsAOAlLHX-q7WA-doR_pC_3iU2sBtkfkjXs_g3mddxVZivI3PyMlDJjNkHwNQ5McU5GdLsON13kAwMB0QIdeYGiWOdcFnOvsvRifcZKRemUDjj1b3KMubesA_9cqI-WlAVd47csJwmpOkFigrwW2FaCAK4nffYEaU61tItYouPkWLDRgVUZIhpP6gITpw4Z9FfQm1NxZQ_rZOtWzHRqDyCWv44O1vIBoLVW66TUlZH0-pDmXPKoEHsVrpr1bE4aRwDSQ1E3G8eu0pLBXmgEVDpokAgPVyNZXgjpluvA";

    @BeforeEach
    public void setup() {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = "https://7c5a-2a06-c701-497e-fb00-f902-1d42-f6fb-f91a.ngrok-free.app/api";
        //RestAssured.port = 80; // Adjust port as needed

    }



    @Test
    public void getAllTransfers(){

        Response response = given()
                .header("Accept", "application/json")
                .header("Content-Type","application/json")
                .header("Authorization"," Bearer "+personalToken)
                .when().get("/v1/transactions").then().statusCode(200).extract().response();

        JsonPath jsonFile= response.jsonPath();
      // assertEquals("transfer to delete",jsonFile.getString("data[0].attributes.transactions[0].description"));
      // assertEquals("MainAccount",jsonFile.getString("data[0].attributes.transactions[0].source_name"));
      //  assertEquals("mercantel",jsonFile.getString("data[0].attributes.transactions[0].destination_name"));


    }
}

