package persistence;

import org.json.JSONObject;

// Source: JsonSerializationDemo from CPSC 210
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
