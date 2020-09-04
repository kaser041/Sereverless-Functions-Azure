# Sereverless-Functions-Azure

## Prerequisites

This project is for packaging the application's functions to be deployed on Azure Cloud Functions so first make sure you have an Azure account: 

https://azure.microsoft.com/en-us/free/

In the pom.xml several configuration must be set first in the properties tag, here the start-class must be defined which is the Application class that runs our Spring App.

The functions app name, region, resource group must as well all be set based on our Azure configuration after creating an azure cloud functions instance.

The Azure maven plugin must be as well imported to the project and configured porperly:

https://mvnrepository.com/artifact/com.microsoft.azure/azure-functions-maven-plugin

A CosmoDB instance must be created from the Azure console and its maven dependency must imported to the project:

https://mvnrepository.com/artifact/com.microsoft.azure/azure-documentdb


## Configuration

Each function has a handler class which extends the AzureSpringBootRequestHandler class. Here, the input and output of the function must be defined as well as how to trigger the function and what is the output content type.

The HOST and MASTER_KEY must be defined for the connection with CosmoDB (They must be defined in the DocumentClientFactory class)

The function can be deployed via the Maven plugin after packaging and creating a single jar for the whole application including all functions.

https://docs.microsoft.com/en-us/learn/modules/develop-azure-functions-app-with-maven-plugin/
