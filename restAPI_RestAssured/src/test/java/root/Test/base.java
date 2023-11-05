package root.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class base {

    private String uri;
    private String path;
    private String qValue;
    private String q;

    base(){}

    base(String uri, String path, String q, String qValue) {
        setUri(uri);
        setPath(path);
        setqValue(qValue);
        setQ(q);
    }

    public String getUri() {
        return uri;
    }

    public String getPath() {
        return path;
    }

    public String getQ() {
        return q;
    }

    public String getqValue() {
        return qValue;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setqValue(String qValue) {
        this.qValue = qValue;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public JsonPath jsonPath(String response) {
        return new JsonPath(response);
    }

    public Response getResponse(String Path) {
        Response responr = given()
                .when().get(Path).andReturn();
        return responr;
    }

    public Response postResponse(String payload, String Path) {
        Response responr = given().body(payload).contentType(ContentType.JSON)
                .when().post(Path).andReturn();
        return responr;
    }

    public String postPayload() {
        return "{\n" +
                "\n" +
                "\"name\":\"HAMZA\",\n" +
                "\"isbn\":\"a\",\n" +
                "\"aisle\":\""+ random() + "\",\n" +
                "\"author\":\"yassine\"\n" +
                "}";
    }

    public static int random() {
        Random random = new Random();
        int k = random.nextInt(1000);
        return k;
    }


}
