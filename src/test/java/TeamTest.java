import org.junit.*;
import static org.junit.Assert.*;

public class MemberTest {
  @Test
  public void _instantiatesCorrectly_true() {
    Member testMember = new Member("Anna Timofeeva");
    assertEquals(true, testTeam instanceof Member);
  }
}
