import org.junit.*;
import static org.junit.Assert.*;

public class TeamTest {


//@Before

  @Test
  public void Tem_instantiatesCorrectly_true() {
    Team myTeam = new Team("Hulugans");
    assertEquals(true, myTeam instanceof Team);
  }
  @Test
  public void clear_emptiesAllTeamsFromArrayList_0() {
    Team myTeam = new Team("Hulugans");
    Team.clear();
    assertEquals(0, Team.all().size());
  }

}
