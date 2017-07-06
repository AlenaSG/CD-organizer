import org.junit.*;
import static org.junit.Assert.*;

public class CDTest {

  @Test
  public void CD_instantiatesCorrectly_true() {
    CD myCD = new CD("Lemonade");
    assertEquals(true, myCD instanceof CD);
  }

  @Test
  public void CD_instantiatesWithDescription_String() {
    CD myCD = new CD("Lemonade");
    assertEquals("Lemonade", myCD.getDescription());
  }

  @Test
  public void all_returnsAllInstancesOfCD_true() {
    CD firstCD = new CD("Lemonade");
    CD secondCD = new CD("I am ...Sasha Fierce");
    assertEquals(true, CD.all().contains(firstCD));
    assertEquals(true, CD.all().contains(secondCD));
  }

  @Test
  public void clear_emptiesAllCDFromArrayList_0() {
    CD myCD = new CD("Lemonade");
    CD.clear();
    assertEquals(0, CD.all().size());
  }


  @Test
  public void getID_tasksInstantiateWithAnID_1() {
    CD.clear();
    CD myCD = new CD("Lemonade");
    assertEquals(1, myCD.getId());
  }

  @Test
  public void find_returnsCDWithSameId_secondCD() {
    CD firstCD = new CD("Lemonade");
    CD secondCD = new CD("I am ...Sasha Fierce");
    assertEquals(CD.find(secondCD.getId()), secondCD);
  }


}
