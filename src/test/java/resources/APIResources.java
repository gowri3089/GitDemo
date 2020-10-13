package resources;

public enum APIResources { //enum is a special class in JAVA which has collection of constants and methods

    addPlaceAPI("/maps/api/place/add/json"),
    getPlaceAPI("/maps/api/place/get/json"),
    delPlaceAPI("maps/api/place/delete/json");
    private String resource;
    APIResources(String resource) { //resource is local to this constructor where the URL gets stored
        this.resource = resource; // assigning the value to resource global variable which is declared in line 8 so it can be accessed outside
    }
    public String getResource(){
        return resource;
    }
}
