import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class MemberTest{

  @Test
    public void Member_instantiatesCorrectly_true() {
      Member myMember = new Member("Anna");
      assertEquals(true, myMember instanceof Member);
  }

  @Test
    public void Member_instantiatesWithDescription_String() {
      Member myMember = new Member("Anna Timofeeva");
      assertEquals("Anna Timofeeva", myMember.getDescription());
    }

  @Test
    public void all_returnsAllInstancesOfMember_true() {
      Member firstMember = new Member("Anna Timofeeva");
      Member secondMember = new Member("Alena Golovina");
      assertEquals(true, Member.all().contains(firstMember));
      assertEquals(true, Member.all().contains(secondMember));
    }

  @Test
    public void clear_emptiesAllMembersFromArrayList_0() {
      Member myMember = new Member("Anna Timofeeva");
      Member.clear();
      assertEquals(0, Member.all().size());
    }

  @Test
    public void getId_membersInstantiateWithAnID_1() {
      Member.clear();
      Member myMember = new Member("Anna Timofeeva");
      assertEquals(1, myMember.getID());
    }

  @Test
    public void find_returnsMemberWithSameId_secondmember() {
      Member firstMember = new Member("Anna Timofeeva");
      Member secondMember = new Member("Alena Golovina");
      assertEquals(Member.find(secondMember.getID()), secondMember);
    }
}
