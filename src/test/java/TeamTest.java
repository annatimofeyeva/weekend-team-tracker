import org.junit.*;
import static org.junit.Assert.*;

public class TeamTest {

  @Test
  public void team_instantiatesCorrectly_true() {
    Team myTeam = new Team("Hulugans");
    assertEquals(true, myTeam instanceof Team);
  }

  @Test
  public void getName_teamInstantiatesWithName_Hulugans() {
    Team myTeam = new Team("Hulugans");
    assertEquals("Hulugans", myTeam.getName());
  }

  @Test
  public void all_returnsAllInstancesOfTeam_true() {
    Team firstTeam = new Team("Hulugans");
    Team secondTeam = new Team("Epicodus");
    assertEquals(true, Team.all().contains(firstTeam));
    assertEquals(true, Team.all().contains(secondTeam));
  }

  @Test
  public void clear_emptiesAllTeamsFromList_0() {
    Team myTeam = new Team("Hulugans");
    Team.clear();
    assertEquals(Team.all().size(), 0);
  }

  @Test
  public void getId_teamsInstantiateWithAnId_1() {
    Team.clear();
    Team myTeam = new Team("HHulugans");
    assertEquals(1, myTeam.getId());
  }

  @Test
  public void find_returnsTeamsWithSameId_secondTeam() {
    Team.clear();
    Team firstTeam = new Team("Hulugans");
    Team secondTeam = new Team("Epicodus");
    assertEquals(Team.find(secondTeam.getId()), secondTeam);
  }

  @Test
  public void getNumbers_initiallyReturnsEmptyList_ArrayList() {
    Team.clear();
    Team myTeam = new Team("Hulugans");
    assertEquals(0, myTeam.getMembers().size());
  }

  @Test
  public void addMember_addsMemberToList_true() {
    Team myTeam = new Team("Hulugans");
    Member myMember = new Member("Anna Timofeeva");
    myTeam.addMember(myMember);
    assertTrue(myTeam.getMembers().contains(myMember));
  }
}
