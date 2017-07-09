import org.junit.*;
import static org.junit.Assert.*;

public class TeamTest {
  @Test
  public void Team_instantiatesCorrectly_true() {
    Team testTeam = new Team("Flogging Mollys");
    assertEquals(true, testTeam instanceof Team);
  }
}
