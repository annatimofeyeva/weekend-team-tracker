import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Team {
  private String mDescription;
  private LocalDateTime mCreatedAt;
  private static List<Team> instances = new ArrayList<Team>();
  private int mId;

  public Team(String description) {
    mDescription = description;
    mCreatedAt = LocalDateTime.now();
    instances.add(this);
  }

  public String getDescription() {
    return mDescription;
  }

  public static List<Team> all() {
    return instances;
  }

  public LocalDateTime getCreatedAt() {
    return mCreatedAt;
  }

  public static void clear() {
  instances.clear();
  }

  public int getID(){
    return mId;
  }
}
