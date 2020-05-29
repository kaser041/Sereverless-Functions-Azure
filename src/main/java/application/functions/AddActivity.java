package application.functions;

import application.DocumentClientFactiory;
import application.entities.Activity;
import com.google.gson.Gson;
import com.microsoft.azure.documentdb.Document;
import com.microsoft.azure.documentdb.DocumentClient;
import com.microsoft.azure.documentdb.DocumentClientException;
import java.util.function.Consumer;

public class AddActivity implements Consumer<Activity> {
    private static final String DATABASE_ID = "ServerlessDB";
    private static final String COLLECTION_ID = "Activities";
    private static Gson gson = new Gson();

    @Override
    public void accept(Activity activity) {
        DocumentClient documentClient = DocumentClientFactiory.getDocumentClient();
        Document document = new Document(gson.toJson(activity));
        try {
            documentClient.createDocument(
                "dbs/" + DATABASE_ID + "/colls/" + COLLECTION_ID, document, null, false)
                .getResource();
        } catch (DocumentClientException e) {
            e.printStackTrace();
        }
    }
}
