// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step04_more_assertions_and_good_tests_ai.challenge03_ai;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * A band's setlist holds its songs, and each song knows its title and length in seconds. {@code longestSong()} returns the title of the longest song. If several are equally long, it returns the first of them, and with no songs it returns an empty String. The test in {@code SetlistTest} finds a longest song in the middle of the list, which even buggy versions get right.
 * <p>Write tests for the edges: the longest song at the end of the list, two songs that are equally long, and a setlist with no songs. {@code assertEquals} compares Strings too. The checks run your tests on the Setlist as it is and on three versions with a bug; one of them is shown: a Setlist that never looks at the last song.
 * Hints
 * 1. Write three new tests, each with a Setlist of its own: one where the last song is the longest, one with two songs of the same length, and one with no songs.
 * 2. For the tie: {@code setlist.add(new Song("Blue", 180));}, {@code setlist.add(new Song("Green", 180));} and {@code assertEquals("Blue", setlist.longestSong());}. For no songs: {@code assertEquals("", setlist.longestSong());}.
 */
public class SetlistTest {
    @Test
    public void longestSongInTheMiddleIsFound() {
        Setlist setlist = new Setlist();
        setlist.add(new Song("Intro", 95));
        setlist.add(new Song("Long Road", 410));
        setlist.add(new Song("Encore", 200));
        assertEquals("Long Road", setlist.longestSong());
    }
}
