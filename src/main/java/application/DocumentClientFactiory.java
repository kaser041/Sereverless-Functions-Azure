package application;

import com.microsoft.azure.documentdb.ConnectionPolicy;
import com.microsoft.azure.documentdb.ConsistencyLevel;
import com.microsoft.azure.documentdb.DocumentClient;

public class DocumentClientFactiory {

  private static final String HOST = "HOST";
  private static final String MASTER_KEY = "MASTER_KEY";

  private static DocumentClient documentClient = new DocumentClient(HOST, MASTER_KEY,
      ConnectionPolicy.GetDefault(), ConsistencyLevel.Session);

  public static DocumentClient getDocumentClient() {
    return documentClient;
  }

}
