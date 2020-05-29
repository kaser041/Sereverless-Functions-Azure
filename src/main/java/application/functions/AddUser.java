package application.functions;

import application.DocumentClientFactiory;
import application.entities.User;
import com.google.gson.Gson;
import com.microsoft.azure.documentdb.Document;
import com.microsoft.azure.documentdb.DocumentClient;
import com.microsoft.azure.documentdb.DocumentClientException;
import java.util.function.Consumer;

public class AddUser implements Consumer<User> {
    private static final String DATABASE_ID = "ServerlessDB";
    private static final String COLLECTION_ID = "Users";
    private static Gson gson = new Gson();

    @Override
    public void accept(User user) {
        DocumentClient documentClient = DocumentClientFactiory.getDocumentClient();
        Document document = new Document(gson.toJson(user));
        try {
            documentClient.createDocument(
                "dbs/" + DATABASE_ID + "/colls/" + COLLECTION_ID, document, null, false)
                .getResource();
        } catch (DocumentClientException e) {
            e.printStackTrace();
        }
    }
}
