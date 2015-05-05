#nessie-android
##Synopsis
Capital One Nessie API wrapper written in Java.
Can be easily embeddded in both java apps and android apps. Uses Retrofit to make the http requests
##Installation for Java App
Download the jar file and add to module as a library.
##Installation for Android
1. Download the jar file.
2. Check to see if there is a libs directory in the app directory of your Android project. If there is no libs directory, create one within the app directory. If there is already one there, this is where you will add the jar file to.
3. Place the jar file in the libs directory.
4. Right click the jar file and click "add as library"
5. If you are using gradle, please make sure to add that jar file as a dependency. In Android Studio, it should already add the dependency line in your file. If it didn't please add it to the gradle file.

```java
dependencies {
    compile files('libs/nessie-java-wrapper.jar')
}
```
Resync your gradle file if needed and your'e good to go.

##Usage
Create a Nessie Client instance. *The client instance will be a singleton*
```java
NessieClient nessieClient = NessieClient.getInstance();
```
Set the api key
```java
nessieClient.setAPIKey("YOUR-API-KEY");
```
With the api key set, you're ready to use to client to get any data that you need.

All nessie client methods are asynchronous so you will need to pass in a callback as a parameter.
```java
nessieClient.getCustomers(new NessieResultsListener(){
  @Override
  public void onSuccess(Object result, NessieException e){
    if(e == null){
      //There is no error, do whatever you need here.
      // Cast the result object to the type that you are requesting and you are good to go
      ArrayList<Customer> customers = (ArrayList<Customer>) result;
    } else {
      //There was an error. Handle it here
      Log.e("Error", e.toString())
    }
  }
});
```
