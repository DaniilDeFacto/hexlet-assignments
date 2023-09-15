package exercise;

import java.util.List;
import java.util.Map;

// BEGIN
public class PairedTag extends Tag {
    public String tagBody;
    public List<Tag> children;

    public PairedTag(String tagName, Map<String, String> attributesTag, String tagBody, List<Tag> children) {
        super(tagName, attributesTag);
        this.tagBody = tagBody;
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("<").append(tagName);
        for (Map.Entry<String, String> attribute: attributesTag.entrySet()) {
            string.append(" ").append(attribute.getKey()).append("=\"").append(attribute.getValue()).append("\"");
        }
        string.append(">");
        for (var child : children) {
            string.append(child.toString());
        }
        string.append(tagBody).append("</").append(tagName).append(">");
        return string.toString();
    }
}
// END
