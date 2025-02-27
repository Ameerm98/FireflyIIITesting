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
    String personalToken ="eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiMWFiYjBlYzYwNzkwMWE4MmI3MmM1YWMzZTY5NDBkZGFiNjlmMGJmYjQ0M2MyOTNlODdjYTYxM2JjYmMzNDc2YjAwM2MzYTE5ZGUyZmRhOWMiLCJpYXQiOjE3NDA0OTQ2NjEuODUwNDk4LCJuYmYiOjE3NDA0OTQ2NjEuODUwNSwiZXhwIjoxNzcyMDMwNjYxLjY3MzQ0Niwic3ViIjoiMSIsInNjb3BlcyI6W119.V_nZI-IyE6onifgZW3kxo61bxSQ8nx7pVLUCb7OtdGQzS3Bf99gBn3TF0c30CsIVju_FwsaM7_RKfYeJjo9CrG0PXbCYpgRRgSL9wHVKX16kcOgB_N9ibAP7DZNc4blgoIXYcLJgXe4Mdc5wspP-wzRlg4mMMwsQkSoM7tYxxJXsTIjtvljWap1YH5YsGLN4cofNCFclxFlXWlRA1faHelDa5ZHzka49AqjYI77q4kKefuXx1BwShSwDtZIfR3f9oBG0kEK0-Nl68eMKw--vsdjPZoozrEv52S2HFgxGT_znHdVr8zH_J4bEOg_spfzS9JUSqHr1DgiA7HDraYXvplK8p2v_ZM8SuhgQtqDHOnJDFIjY-NJTXtm7MEywj-cFLXqSf8F17V6iyLZ-qVWMaFZfdsO0i2cTyTeK5EdFXKx6UUef0-bYjUK01YjoptIpS-P69PDpSXOt_wKJKv8E9JRO7ZWczEuBQMxIu0sjJamnKAz_yl95bShAktI_phgWf7MsYW_kZDsKx_AxuTp8w1Fp2Mzrt_o3bLYqwj73-WZfyNNrAlg1WwYLKzIz7nKS8gzbK5vC4Fc5MZZYbp0ms9sLwcLOjKu7n5uto0dFzppVknOx3UBFPUs32EWCpiO3Swgz6d5shb62BKg4OA6b_dNTNkydkMaRvVjtvLhnMck";
    @BeforeEach
    public void setup() {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = "https://ac49-2a06-c701-497e-fb00-f902-1d42-f6fb-f91a.ngrok-free.app/api";
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
       assertEquals("transfer to delete",jsonFile.getString("data[0].attributes.transactions[0].description"));
       assertEquals("MainAccount",jsonFile.getString("data[0].attributes.transactions[0].source_name"));
        assertEquals("mercantel",jsonFile.getString("data[0].attributes.transactions[0].destination_name"));


    }
}

