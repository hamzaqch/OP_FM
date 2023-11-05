package root.JIRA;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.apache.http.cookie.Cookie;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

public class AddComment {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080/";
    }

    static String payload() {
        return "{\n" +
                "    \"fields\" : {\n" +
                "        \"project\" : {\"key\" : \"SCRUM\"},\n" +
                "\n" +
                "    \"summary\" : \"Create an issue with ppostman\",\n" +
                "    \"description\" : \"just a test from  restassured\",\n" +
                "    \"issuetype\" : {\n" +
                "        \"name\" : \"Bug\"\n" +
                "    }\n" +
                "    }\n" +
                "}";
    }

    static String seesion() {
        return "{\n" +
                "    \"username\" : \"qchili.hamza95\",\n" +
                "    \"password\" : \"KATphcom2017\"\n" +
                "}";
    }
    @Test
    public void addComment() {
        // Create a session
        String x = given().contentType(ContentType.JSON).body(seesion()).when()
                        .post("rest/auth/1/session").then().extract().response().andReturn().jsonPath().getString("session.value");

        System.out.println(x);

        // Update a record
        given().contentType(ContentType.JSON)
                .header("Cookie", "JSESSIONID=" + x).pathParam("key", "10006")
                .body(payload()).put("rest/api/2/issue/{key}").then().log().status();

        // Get a record
        String id = given().header("Cookie", "JSESSIONID=" + x).contentType(ContentType.JSON).when().pathParam("key", "10006")
                .queryParam("fields", "issuetype")
                .get("rest/api/2/issue/{key}")
                .then().log().all().extract().response().andReturn().jsonPath().getString("id");

        System.out.println(id);
    }




}
