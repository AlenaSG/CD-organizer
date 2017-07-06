import org.junit.*;
import static org.junit.Assert.*;

public class PlaceTest {

  @Test
  public void Place_instantiatesCorrectly_true() {
    Place myPlace = new Place("Ebey state park");
    assertEquals(true, myPlace instanceof Place);
  }

  @Test
  public void Place_instantiatesWithDescription_String() {
    Place myPlace = new Place("Ebey state park");
    assertEquals("Ebey state park", myPlace.getDescription());
  }










}
