package exercise;

import java.util.Map;

// BEGIN
public class Tag {
    public String tagName;
    public Map<String, String> attributesTag;

    public Tag(String tagName, Map<String, String> attributesTag) {
        this.tagName = tagName;
        this.attributesTag = attributesTag;
    }

    public String toString() {
        StringBuilder string = new StringBuilder("<").append(tagName);
        for (Map.Entry<String, String> attribute: attributesTag.entrySet()) {
            string.append(" ").append(attribute.getKey()).append("=\"").append(attribute.getValue()).append("\"");
        }
        return string.append(">").toString();
    }
}
// END
