package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private TagInterface tag;
    private String label;

    public LabelTag(String label, TagInterface tag) {
        this.tag = tag;
        this.label = label;
    }

    @Override
    public String render() {
        return String.format("<label>%s%s</label>", label, tag.render());
    }
}
// END
