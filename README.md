# sample-client

This is the client for consuming customer entity JSON.

The client is built on jersey client. All the required jersey classes are kept on the /lib folder in the root.


This client also uses the GSON google library to convert JSON to Object and vice-versa for some entity operations.
This also has a copy of the customer entity(DTO) for client side operations.

The main class is CustomerClient.java.

The entire project can be imported into Anypoint IDE (or Eclipse) and run independently.

If you are running this client and the server (producer) in different servers, you need to edit the "baseURL" final String varaible to the appropriate path.

All the Test cases were tested and found to be running properly.
