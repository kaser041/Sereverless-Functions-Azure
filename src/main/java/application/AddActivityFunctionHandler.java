package application;

import application.entities.Activity;
import application.entities.User;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import java.util.List;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;

public class AddActivityFunctionHandler extends AzureSpringBootRequestHandler<Activity, List<Activity>> {
    @FunctionName("addActivity")
    public HttpResponseMessage activities(
        @HttpTrigger(name = "request", methods = {HttpMethod.GET, HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Activity> request,
        ExecutionContext context) {

        context.getLogger().info("Activity For User: " + request.getBody());
        return request
            .createResponseBuilder(HttpStatus.OK)
            .body(handleRequest(request.getBody(), context))
            .header("Content-Type", "application/json")
            .build();
    }

    }
