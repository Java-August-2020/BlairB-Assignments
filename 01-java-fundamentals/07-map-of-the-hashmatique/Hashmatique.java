import java.util.HashMap;

public class Hashmatique {
    
    public void trackListMaker() {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Best S0ng", "This is the best song ever...");
        trackList.put("Time Again", "It happens every time...");
        trackList.put("Don't Want", "If I hadn't been to the store...");
        trackList.put("Stencils", "Lines on paper...");

        System.out.println(trackList.get("Time Again"));

        for (HashMap.Entry<String, String> map : trackList.entrySet()) {
            System.out.println(map.getKey() + ": " + map.getValue());
        }
    }

}