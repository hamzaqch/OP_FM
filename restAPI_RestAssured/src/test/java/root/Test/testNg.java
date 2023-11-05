package root.Test;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.*;

import static io.restassured.RestAssured.given;

public class testNg {
    base bb = new base();
    SoftAssert softAssert = new SoftAssert();
    @BeforeClass
    public void setUp() {

        bb.setUri("http://216.10.245.166/");
        bb.setPath("Library/Addbook.php");
        RestAssured.baseURI = bb.getUri();
    }

    @Test
    public void post() {
        Response response = bb.postResponse(bb.postPayload(), bb.getPath());
        softAssert.assertEquals(response.header("Connection"), "Keep-Alive");
        softAssert.assertEquals(response.getContentType(), "application/json;charset=UTF-8");
        softAssert.assertEquals(response.getStatusCode(), 200);


        System.out.println(bb.jsonPath(response.asPrettyString()).getString("ID"));

        softAssert.assertAll();
    }

    @Test
    public void postAuth() {

        RestAssured.baseURI = "https://dummyjson.com/users";

        Response response = given().when().get();

        response.then().log().status().extract().response().andReturn().statusCode();
        ArrayList<HashMap<String,?>> id = response.then().and().extract().response().jsonPath().get("users");

        for (HashMap<String,?> s : id ) {
            if (s.get("firstName").equals("Terry")) {
                System.out.println(s);
            }

        }

        //System.out.println(id);




    }



}
