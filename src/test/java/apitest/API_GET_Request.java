package apitest;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

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

    }
    @Test
    public void get02(){
        String url = "https://jsonplaceholder.typicode.com/posts/44";
        JSONObject expbody = new JSONObject();
        Response response = given().when().get(url);

        response.prettyPrint();
        response.then().statusCode(204);

        JsonPath actbody = response.jsonPath();


    }



}
