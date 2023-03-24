package StepDefinition;

import Core.ApiCall;
import Core.FileHandleHelper;
import Core.HeaderFormatHelper;
import com.google.gson.Gson;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import repository.remoteRepo.requestRepo.UserPostRequestRepo;
import repository.remoteRepo.responseRepo.PostApiResponseModel;

import static Core.CoreConstrainHelper.base_url;
import static Core.FilePathHelper.postApiPath;

public class UserPostApi {

    private String requestModel;
    Gson gson = new Gson();
    UserPostRequestRepo postApiRequestModelClass;
    Response postApiResponse;
    String url;
    @Given("user got the api {string}")
    public void userGotTheApiPath(String path) {
        url = base_url + path;
    }

    @When("user hit {string} and {string}")
    public void userHitNameAndJob(String name, String job) {
        JSONObject requestBody = new FileHandleHelper().readJsonFile(postApiPath);
        postApiRequestModelClass = new Gson().fromJson(requestBody.toJSONString(), UserPostRequestRepo.class);
        postApiRequestModelClass.setName(name);
        postApiRequestModelClass.setJob(job);
        requestModel = gson.toJson(postApiRequestModelClass);

    }

    @And("call the api with body")
    public void callTheApiWithBody() {
        postApiResponse = ApiCall.postCall(HeaderFormatHelper.commonHeaders(),requestModel,url);
        System.out.println(postApiResponse);

    }

    @Then("it will return valid response")
    public void itWillReturnValidResponse() {
        PostApiResponseModel postApiResponseModel = gson.fromJson(postApiResponse.getBody().asString(), PostApiResponseModel.class);
        System.out.println(postApiResponseModel.getCreatedAt());

    }
}
