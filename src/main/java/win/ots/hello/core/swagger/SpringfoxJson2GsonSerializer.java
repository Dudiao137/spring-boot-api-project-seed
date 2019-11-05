package win.ots.hello.core.swagger;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import springfox.documentation.spring.web.json.Json;

import java.lang.reflect.Type;

/**
 * @author : sy.wang
 * @date : 2019-11-05
 */
public class SpringfoxJson2GsonSerializer implements JsonSerializer<Json> {
    @Override
    public JsonElement serialize(Json json, Type type, JsonSerializationContext jsonSerializationContext) {
        final JsonParser parser = new JsonParser();
        return parser.parse(json.value());
    }
}
