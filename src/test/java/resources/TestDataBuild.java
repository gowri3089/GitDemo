package resources;

import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public AddPlace addplacePayload(String name, String language, String address)

    {
        AddPlace p = new AddPlace(); //pass this object to body
        p.setAccuracy(50);
        p.setAddress(address);
        p.setName(name);
        p.setPhone_number("+1 (737)-703-9166");
        p.setWebsite("http://google.com");
        p.setLanguage(language);

        List<String> myList= new ArrayList<String>(); //creating an object to access the array list and then pass the object in setter
        myList.add("Ishant");
        myList.add("Shreya");
        p.setTypes(myList);
        Location l = new Location();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        p.setLocation(l);
        return p;
    }

    public String deletePlacePayload(String placeid)
    {
        return "{\r\n    \"place_id\":\""+placeid+"\"\r\n}";
    }
}
