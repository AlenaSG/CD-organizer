import java.util.ArrayList;
import java.util.List;


public class CD {
  private String mDescription;
  private static List<CD> instances = new ArrayList<CD>();
  private int mId;

  public CD(String description) {
    mDescription = description;
    instances.add(this);
    mId = instances.size();

  }

  public String getDescription() {
    return mDescription;
  }

  public static List<CD> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static CD find(int id) {
    return instances.get(id - 1);
  }
}
