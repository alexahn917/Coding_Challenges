package facebook;

public class map {
	/*
    Hello etc...

    So basically the question is:

    Given a "map" that represents land and ocean, design a method that would find the number of distint islands on a 
    given "map".

    So for example, the map would be given as "페북서
    인터뷰할때 example 까지 다 줘요"

    So let's say we have

    0 0 0 0 1
    0 1 1 0 1
    0 0 0 0 1
    0 1 0 0 0

    We would want to return 3

    Is it clear?
    Is it a question you saw before?

    You can assume that, Yes
    You could start giving your solution and we'll go from there
    As big as it can fit in memory
    You can assume int
    2 islands   

    Runtime? for that?
    n?m? what are they?
    Okay 

    I think during the actual interview that was enough explanation
    and would probably rather jump into coding

    What did you say in terms of the memory? n?
    okay
    you can start implementing the method w/o main
    -1 sounds goodl
	 */

	public int numIslands(int[][] map) {
		if (map.length < 1 || map[0].length < 1) {
			return 0;
		}
		int largest_size = 0;
		int count = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j=0; j < map[0].length; j++) {
				if (map[i][j] == 1) {
					map[i][j] = -1;
					largest_size = Math.max(checkoff(map, i, j, largest_size), largest_size);
				}
			}
		}
		return count;
	}

	/* What if i-1 < 0 or on those lines, okay */
	/* Is memory O(nm)? Stack?Heap? Let's go ahead for now 

    1 0
    0 1 -> one island like you asked 
    just in talk okay, good.

    What if we wanted to get the largest island size instead?

    Sounds good.
    What if the 2d array given were immutable? FINAL yep
    checkoff
    okay I think thats it for now

    It was great imo
    Like maybe in the beginning exaplnation could have been a lil shorter and going into implementation a few mins earlier
    might be better since the interviewer often doesn't stop your explanation and you run out of time

    Yeah use intuition! :)
    right right
    some interviewers allow paper
    did you use pen n paper?
    yeah you should probably ask yepyep
    thats what joonhyuck hyung todl me
    but appart from that great!
    TWO thumbs up

    & recursion haha
    Yep
    But interms of stack I'm confused I think it may be O(n+m) method calls-> okay 
    Nope hyung :)!

    Yeah def ask me qs if any

    Glad to help!

    GL !

    BYE!

    YepYep let's do that
    bye!
    Any questions?

	 */

	public static int checkoff(int[][] map, int i, int j, int size) {
		// top-neighbor
		if (i > 0 && map[i-1][j] == 1) {
			map[i-1][j] = -1;
			size = checkoff(map, i-1, j, ++size);
		}
		if (j > 0 && map[i][j-1] == 1) {
			map[i][j-1] = -1;
			size++;
			size = checkoff(map, i, j-1, ++size);
		}
		if (i < map.length - 2 && map[i+1][j] == 1) {
			map[i+1][j] = -1;			
			size = checkoff(map, i+1, j, ++size); 
		}
		if (j < map.length - 2 && map[i][j+1] == 1) {
			map[i][j+1] = -1;
			size = checkoff(map, i, j+1, ++size);
		}
		return size;
	}



}
