import org.junit.*;
import static org.junit.Assert.*;

public class ArtistTest {

  @Test
  public void artist_instantiatesCorrectly_true() {
    Artist testArtist = new Artist("Beyonce");
    assertEquals(true, testArtist instanceof Artist);
  }

  @Test
  public void getName_artistInstantiatesWithName_Beyonce() {
    Artist testArtist = new Artist("Beyonce");
    assertEquals("Beyonce", testArtist.getName());
  }

  @Test
  public void all_returnsAllInstancesOfArtist_true() {
    Artist firstArtist = new Artist("Beyonce");
    Artist secondArtist = new Artist("Pink");
    assertEquals(true, Artist.all().contains(firstArtist));
    assertEquals(true, Artist.all().contains(secondArtist));
  }

  @Test
  public void clear_emptiesAllArtistFromList_0() {
    Artist testArtist = new Artist("Beyonce");
    Artist.clear();
    assertEquals(Artist.all().size(), 0);
  }

  @Test
  public void find_returnsArtistWithSameId_secondArtist() {
    Artist.clear();
    Artist firstArtist = new Artist("Beyonce");
    Artist secondArtist = new Artist("Pink");
    assertEquals(Artist.find(secondArtist.getId()), secondArtist);
  }

  @Test
  public void getArtist_initiallyReturnsEmptyList_ArrayList() {
    Artist.clear();
    Artist testArtist = new Artist("Beyonce");
    assertEquals(0, testArtist.getCDs().size());
  }

  @Test
  public void addArtist_addsCDToList_true() {
    Artist testArtist = new Artist("Beyonce");
    CD testCD = new CD("Lemonade");
    testArtist.addCD(testCD);
    assertTrue(testArtist.getCDs().contains(testCD));
  }


}
