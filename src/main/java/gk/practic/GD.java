package gk.practic;
public class GD {

    public static String simulate(String events) {
        StringBuilder result = new StringBuilder();

        int position = 0;          // 0 = fully closed, 5 = fully open
        int direction = 0;         // 0 = stopped, 1 = opening, -1 = closing
        boolean paused = false;

        for (char event : events.toCharArray()) {
            if (event == 'O') {
                // Always reverse direction immediately if moving
                if (direction != 0) {
                    direction = -direction;
                }
            } else if (event == 'P') {
                if (paused) {
                    // Resume movement in same direction
                    paused = false;
                } else if (direction == 0) {
                    // Door is stopped
                    if (position == 0) {
                        direction = 1; // closed -> start opening
                    } else if (position == 5) {
                        direction = -1; // open -> start closing
                    } else {
                        // stopped mid-way -> pause
                        paused = true;
                    }
                } else {
                    // Moving -> pause
                    paused = true;
                    direction = 0;
                }
            }

            // Move if not paused
            if (!paused && direction != 0) {
                position += direction;
                if (position == 0 || position == 5) {
                    direction = 0; // stop at limits
                }
            }

            result.append(position);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "..P...O.....";
        String output = simulate(input);
        System.out.println("Input:    " + input);
        System.out.println("Expected: 001234321000");
        System.out.println("Output:   " + output);
    }
}

//
//Time: 2316ms Passed: 6Failed: 8Exit Code: 1
//Test Results:
//consumeDoorEvents
//submission tests
//should work on random tests
//expected: <001111111233333444> but was: <001111111111111111>
//Stack Trace
//Completed in 32ms
//should open completely, then close completely
//should work when there are no pushes
//should work when opening begins
//should work with a pause right after an obstacle
//expected: <1232222100> but was: <1234444444>
//Stack Trace
//Completed in 1ms
//should work on an empty string
//should work when open completely
//should handle an obstacle just before opening
//expected: <001234321000> but was: <001234555555>
//Stack Trace
//should handle a single obstacle
//expected: <1210000> but was: <1234555>
//Stack Trace
//should pause while opening
//should open when paused and resumed later
//expected: <000001222222222234555> but was: <000001222222222222222>
//Stack Trace
//should open when paused and resumed
//expected: <122234555> but was: <122222222>
//Stack Trace
//should handle multiple obstacles
//expected: <001234321001012345> but was: <001234555554333333>
//Stack Trace
//Completed in 1ms
//should pause and resume multiple times
//expected: <0000012345554333321000> but was: <0000012345554333333333>
//Stack Trace
//Completed in 1ms
//Completed in 103ms
//Completed in 110ms