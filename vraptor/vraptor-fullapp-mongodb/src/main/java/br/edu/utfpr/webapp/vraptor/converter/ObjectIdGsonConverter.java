package br.edu.utfpr.webapp.vraptor.converter;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import javax.enterprise.context.Dependent;
import org.bson.types.ObjectId;

/**
 *
 * @author Sobjak
 */
@Dependent
public class ObjectIdGsonConverter implements JsonSerializer<ObjectId> {

    @Override
    public JsonElement serialize(ObjectId objectId, 
            java.lang.reflect.Type typeOfSrc,
            JsonSerializationContext context) {

        return new JsonPrimitive(objectId.toString());
    }
}
