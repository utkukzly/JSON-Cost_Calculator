import org.json.*;

public class App {
    public static void main(String[] args) throws Exception {
        try{
            System.out.println("Please type in the URL");
            String url = System.console().readLine();
            JsonReader jsonReader = new JsonReader();       
            JSONObject json = jsonReader.readJsonFromUrl(url);
            if(json!=null){
                int result = recursiveClc(json);
                System.out.println("The total cost is: "+ result);
            }  
            
        }
        catch(Exception e){
            System.err.println(e);
        }
                  
    }

    private static int recursiveClc(JSONObject jsonObject){
        if(jsonObject.opt("items") != null ){ //items are available
            
                int accumulator= 0;
                JSONArray items = jsonObject.getJSONArray("items");
                for (int i = 0; i < items.length(); i++) {  
                    accumulator += recursiveClc(items.getJSONObject(i));
                }

                return accumulator * jsonObject.getInt("count");
        }
        else {
            return jsonObject.getInt("price") * jsonObject.getInt("count");
        }

    }
}
