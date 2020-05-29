package application.functions;

import application.DocumentClientFactiory;
import application.entities.User;

import com.google.gson.Gson;
import com.microsoft.azure.documentdb.DocumentClient;
import com.microsoft.azure.documentdb.FeedOptions;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Users implements Function<User, List<User>> {

  // Define an id for your database and collection
  private static final String DATABASE_ID = "ServerlessDB";
  private static final String COLLECTION_ID = "Users";
  private static Gson gson = new Gson();

  @Override
  public List<User> apply(User user) {
    DocumentClient documentClient = DocumentClientFactiory.getDocumentClient();
    FeedOptions queryOptions = new FeedOptions();
    queryOptions.setEnableCrossPartitionQuery(true);
    // Query documents
    return documentClient.queryDocuments(
            "dbs/" + DATABASE_ID + "/colls/" + COLLECTION_ID,
            "SELECT * FROM Users",
        queryOptions).getQueryIterable().toList().stream().map(document -> gson.fromJson(document.toJson(),User.class)).collect(
        Collectors.toList());
  }
}
