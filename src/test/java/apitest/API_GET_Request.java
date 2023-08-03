package apitest;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.testng.annotations.DataProvider;

import static io.restassured.RestAssured.given;

public class API_GET_Request {
    @Test
    public void get01(){

        String url = "https://jsonplaceholder.typicode.com/posts/44";
        JSONObject expbody = new JSONObject();

        expbody.put("userId", 5 );
        expbody.put("title", "optio dolor molestias sit");

        Response response = given().when().get(url);
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON);

        JsonPath actBody = response.jsonPath();

        Assert.assertEquals(expbody.get("userId"),actBody.get("userId"));
        Assert.assertEquals(expbody.get("title"),actBody.get("title"));




    }
    @Test
    public void get02(){
        String url = "https://reqres.in/api/users?page=2";
        JSONObject expbody = new JSONObject();
        Response response = given().when().get(url);

        response.prettyPrint();
        response.then().statusCode(200);

        JsonPath actbody = response.jsonPath();



    }



}
