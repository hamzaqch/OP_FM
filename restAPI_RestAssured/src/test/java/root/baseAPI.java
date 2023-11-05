package root;

import org.openqa.selenium.WebElement;

public class baseAPI {

        private String uri;
        private String path;
        private String quaryKey;
        private String quaryValue;

        public baseAPI(String uri) {
            this.uri = uri;
        }

        public baseAPI(String uri, String path){
            this.uri = uri;
            this.path = path;
        }

        public baseAPI(String uri, String path, String quaryKey, String quaryValue) {
            this.uri = uri;
            this.path = path;
            this.quaryKey = quaryKey;
            this.quaryValue = quaryValue;

        }

        public String getPayLoad() {
            return "{\n" +
                    "    \"name\": \"morpheus\",\n" +
                    "    \"job\": \"leader\"\n" +
                    "}";
        }

        public String putPayload() {
            return "{\n" +
                    "    \"name\": \"morpheus\",\n" +
                    "    \"job\": \"zion resident\"\n" +
                    "}";
        }

    public String CoursePrice()
    {

        WebElement element = null;

        return "{\r\n" +
                "  \"dashboard\": {\r\n" +
                "    \"purchaseAmount\": 1162,\r\n" +
                "    \"website\": \"rahulshettyacademy.com\"\r\n" +
                "  },\r\n" +
                "  \"courses\": [\r\n" +
                "    {\r\n" +
                "      \"title\": \"Selenium Python\",\r\n" +
                "      \"price\": 50,\r\n" +
                "      \"copies\": 6\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"title\": \"Cypress\",\r\n" +
                "      \"price\": 40,\r\n" +
                "      \"copies\": 4\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"title\": \"RPA\",\r\n" +
                "      \"price\": 45,\r\n" +
                "      \"copies\": 10\r\n" +
                "    },\r\n" +
                "     {\r\n" +
                "      \"title\": \"Appium\",\r\n" +
                "      \"price\": 36,\r\n" +
                "      \"copies\": 7\r\n" +
                "    }\r\n" +
                "    \r\n" +
                "    \r\n" +
                "    \r\n" +
                "  ]\r\n" +
                "}\r\n" +
                "";



    }

    public String getPath() {
        return path;
    }

    public String getQuaryKey() {
        return quaryKey;
    }

    public String getQuaryValue() {
        return quaryValue;
    }

    public String getUri() {
        return uri;
    }
}
