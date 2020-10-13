package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {
        public static RequestSpecification requestspec; //making static will not make it null.
        public RequestSpecification requestSpecifictaion () throws IOException {
            if (requestspec == null)
            { //loop to update all records in the log
        PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
        requestspec = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURL")).addQueryParam("key", "qaclick123")
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON).build();
        return requestspec;
    }
        return requestspec;
    }
public static String getGlobalValue(String key) throws IOException {
    Properties prop = new Properties();
    FileInputStream fis = new FileInputStream("/Users/gowri/APIFramework/src/test/java/resources/global.properties");
    prop.load(fis);
    return prop.getProperty(key);
}
//        RestAssured.baseURI="https://rahulshettyacademy.com";

    public String getJsonPath(Response response, String key)
    {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }
}
