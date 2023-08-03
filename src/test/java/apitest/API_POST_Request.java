package apitest;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class API_POST_Request {
    @Test
    public void post01(){
        // 1 - Request URL and body should be created
        String url = "https://reqres.in/api/users";

        JSONObject reqBody = new JSONObject();
        reqBody.put("name", "API");
        reqBody.put("job", "Tester");
        reqBody.put("id", "11");

        // 2- Expected data should be created

        JSONObject expBody = new JSONObject();
        expBody.put("name", "API");
        expBody.put("job", "Tester");
        expBody.put("id", "11");

        // 3- Response

        Response response = given().
                contentType(ContentType.JSON).
                when().
                body(reqBody.toString()).post(url);

        JsonPath actBody = response.jsonPath();

        // 4- Assertions

        response.then().assertThat().contentType(ContentType.JSON).statusCode(201);

        Assert.assertEquals(expBody.get("name"), actBody.get("name"));
        Assert.assertEquals(expBody.get("job"), actBody.get("job"));
        Assert.assertEquals(expBody.get("id"), actBody.get("id"));

        //response.
        response.prettyPrint();




    }
}
