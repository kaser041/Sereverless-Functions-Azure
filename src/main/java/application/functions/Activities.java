package application.functions;

import application.DocumentClientFactiory;
import application.entities.Activity;
import application.entities.User;
import com.google.gson.Gson;
import com.microsoft.azure.documentdb.DocumentClient;
import com.microsoft.azure.documentdb.FeedOptions;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Activities implements Function<User, List<Activity>> {
    // Define an id for your database and collection
    private static final String DATABASE_ID = "ServerlessDB";
    private static final String COLLECTION_ID = "Activities";
    private static Gson gson = new Gson();

    @Override
    public List<Activity> apply(User user) {
        DocumentClient documentClient = DocumentClientFactiory.getDocumentClient();
        FeedOptions queryOptions = new FeedOptions();
        queryOptions.setEnableCrossPartitionQuery(true);
        // Query documents
        return documentClient.queryDocuments(
            "dbs/" + DATABASE_ID + "/colls/" + COLLECTION_ID,
            "SELECT * FROM Activities WHERE Activities.user = '"+user.getUsername()+"'",
            queryOptions).getQueryIterable().toList().stream().map(document -> gson.fromJson(document.toJson(),Activity.class)).collect(
            Collectors.toList());
    }
}
